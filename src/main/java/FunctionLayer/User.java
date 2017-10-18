package FunctionLayer;

import java.util.Date;
import java.util.TreeMap;

/**
 * The purpose of User is to store information about
 * the user logged in.
 * 
 * @author Gert Lehmann Madsen
 */
public class User {

    private int id; 
    private final String email;
    private final String password; // Should be hashed and all
    private final String role;
    private TreeMap<String, Order> orderMap; 

    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.orderMap = new TreeMap();
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public TreeMap<String, Order> getOrderMap() {
        return orderMap;
    }

    /**
     * This method adds a new other to the TreeMap
     * using the order id as key.
     * @param order is the order added to the TreeMap.
     */
    public void putToOrderMap(Order order) {
        String key = ""+order.getId();
        this.orderMap.put(key, order);
    }

    /**
     * Returns an order from the TreeMap.
     * @param id the order id for the order to be returned.
     * @return 
     */
    public Order getOrderFromMap(int id) {
        String key = ""+id;
        return this.orderMap.get(key);
    }
    
    /**
     * Finds an order in the TreeMap and updates the boolean
     * shipped in this order to be the value true. 
     * @param id the order id for the order to be updated
     */
    public void updateOrderStatusInMap(int id, Date shippingDate) {
        String key = ""+id;
        Order order = this.orderMap.get(key);
        order.setShipped(true);
        order.setShippingDate(shippingDate);
    }
   
    
    
}
