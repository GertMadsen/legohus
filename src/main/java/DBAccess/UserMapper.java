package DBAccess;

import FunctionLayer.LegohusException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 The purpose of UserMapper is to transfer the user information
 * from the database to an user object or the other way around.
 * 
 * @author Gert Lehmann Madsen
 */

public class UserMapper {

    public static void createUser( User user ) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
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
            throw new LegohusException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
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
                return user;
            } else {
                throw new LegohusException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegohusException(ex.getMessage());
        }
    }

}
