
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
 * The purpose of OrderMapper is to transfer the order information from the
 * database to an order object or the other way around.
 *
 * @author Gert Lehmann Madsen
 */
public class OrderMapper {
  
    public static Order createOrder(Order order) throws LegohusException, WritingToSQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (user_id, length, width, height, shipped ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
//            String dateStr = fromJavaToSQLDate(order.getDate());
//            ps.setString(5, dateStr);
            ps.setBoolean(5, order.isShipped());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
            return getOrderDate(order);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new WritingToSQLException(ex.getMessage());
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
                User cust = UserMapper.getUser(cust_id);
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Date date = rs.getDate("date");
                Date shippingDate = rs.getDate("shipping_date");
                boolean shipped = rs.getBoolean("shipped");
                Order order = new Order(id, cust, length, width, height, date, shippingDate, shipped);
                user.putToOrderMap(order);
            }
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }

    public static Order getOrderDate(Order order) throws LegohusException {
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT date FROM orders WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, order.getId());
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                Date date = rs.getDate("date");
                order.setDate(date);
            }
            return order;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }
    
    public static Date getShippingDate(int id) throws LegohusException {
        try {
            Date shippingDate = null;
            Connection con = Connector.connection();
            String SQL = "SELECT shipping_date FROM orders WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                shippingDate = rs.getDate("shipping_date");
            }
            return shippingDate;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }

    
    
    public static void setShipped(int id) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET shipped = 1 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            SQL = "UPDATE orders SET shipping_date = CURRENT_TIMESTAMP WHERE id = ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }


}
