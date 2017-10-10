/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.Date;


/**
 *
 * @author GertLehmann
 */
public class Order {

    public Order(int user_id, int length, int width, int height) {
        this.user_id = user_id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.date = new Date();
        this.shipped = false;
    }

    public Order(int id, int user_id, int length, int width, int height, Date date, boolean shipped) {
        this.id = id;
        this.user_id = user_id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.date = new Date();
        this.shipped = shipped;
    }

    private int id;
    private final int user_id;
    private final int length;
    private final int width;
    private final int height;
    private final Date date;
    private boolean shipped;

    public int getId() {
        return id;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public int getLenght() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Date getDate() {
        return date;
    }
    
    public boolean isShipped() {
        return shipped;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user_id=" + user_id + ", length=" + length + ", width=" + width + ", height=" + height + ", date=" + date + ", shipped=" + shipped + '}';
    }
    
    
    
    
      
}
