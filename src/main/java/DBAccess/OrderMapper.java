/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegohusException;
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
  
    public static void createOrder(Order order) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (user_id, length, width, height, date, shipped ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser_id());
            ps.setInt(2, order.getLenght());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            String dateStr = fromJavaToSQLDate(order.getDate());
            ps.setString(5, dateStr);
            ps.setBoolean(6, order.isShipped());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
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
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Date date = rs.getDate("date");
                boolean shipped = rs.getBoolean("shipped");
                Order order = new Order(id, cust_id, length, width, height, date, shipped);
                user.putToOrderMap(order);
            }
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }

    
    /**
     * This method is used when an employee wants to change the shipping status
     * of an order from false into true.
     * 
     * @param user is needed in order to update the order in the
     * orderMap contained in the user entity
     * @param id the order id for the order where the field shipped is to be set
     * as true in the database
     * @throws LegohusException
     */
    
    public static void setShipped(User user, int id) throws LegohusException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET shipped = 1 WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            user.updateOrderStatusInMap(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegohusException(ex.getMessage());
        }
    }

    
    /**
     * This method is needed in order to convert a date from Java date format
     * into SQL datetime format
     * 
     * @param date is the java date to be converted
     * @return a string with the date in a format suitable for
     * being stored as a SQL datetime field 
     */
    
    private static String fromJavaToSQLDate(Date date) {
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        return currentTime;
    }




//    public static void main(String[] args) {
//        Order order = new Order(1, 11, 7, 3);
//
//        try {
//            createOrder(order);
//        } catch (LegohusException ex) {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        User user = null;
//        try {
//            user = UserMapper.login("robin@somewhere.com", "batman");
//        } catch (LegohusException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            getOrders(user);
//        } catch (LegohusException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("");
//        System.out.println("");
//
//        try {
//            setShipped(user, 2);
//        } catch (LegohusException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            user = UserMapper.login("robin@somewhere.com", "batman");
//        } catch (LegohusException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            getOrders(user);
//        } catch (LegohusException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
