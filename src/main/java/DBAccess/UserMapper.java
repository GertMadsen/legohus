package DBAccess;

import Exceptions.LegohusException;
import Exceptions.WritingToSQLException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 
 The purpose of UserMapper is to transfer the user information
 * from the database to an user object or the other way around.
 * 
 * @author Gert Lehmann Madsen
 */

public class UserMapper {

    public static void createUser( User user ) throws LegohusException, WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new WritingToSQLException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                getOrders(user);
                return user;
            } else {
                throw new LegohusException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static User getUser( int id ) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT email, password, role FROM users "
                    + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, id );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String email = rs.getString( "email" );
                String password = rs.getString( "password" );
                String role = rs.getString( "role" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LegohusException( "User does not exist" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegohusException(ex.getMessage());
        }
    }   
        
    public static User getOrders(User user) throws LegohusException {
        try {
            Connection con = Connector.connection();
            boolean isCustomer = user.getRole().equals("customer");
            String SQL;
            if (isCustomer) {
                SQL = "SELECT * FROM orders WHERE user_id=?";
            } else {
                SQL = "SELECT * FROM orders";
            }
            PreparedStatement ps = con.prepareStatement(SQL);
            if (isCustomer) { 
                ps.setInt(1, user.getId());
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cust_id = rs.getInt("user_id");
                User customer = UserMapper.getUser(cust_id);
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Date date = rs.getTimestamp("date");
                Date shippingDate = rs.getTimestamp("shipping_date");
                boolean shipped = rs.getBoolean("shipped");
                Order order = new Order(id, customer, length, width, height, date, shippingDate, shipped);
                user.putToOrderMap(order);
            }
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }
    

}
