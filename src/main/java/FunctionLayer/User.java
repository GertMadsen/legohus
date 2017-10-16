package FunctionLayer;

import java.util.TreeMap;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String role ) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.orderMap = new TreeMap();
    }

    private int id; 
    private final String email;
    private final String password; // Should be hashed and all
    private final String role;
    private TreeMap<String, Order> orderMap; 
    
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

    public void putToOrderMap(Order order) {
        String key = ""+order.getId();
        this.orderMap.put(key, order);
    }

    public Order getOrderFromMap(int id) {
        String key = ""+id;
        return this.orderMap.get(key);
    }
    
    public void updateOrderStatusInMap(int id) {
        String key = ""+id;
        Order order = this.orderMap.get(key);
        order.setShipped(true);
    }
   
    
    
}
