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

    public Order(int id, User user, int lenght, int width, int height) {
        this.id = id;
        this.user = user;
        this.lenght = lenght;
        this.width = width;
        this.height = height;
        this.date = new Date();
        this.shipped = false;
    }



    private final int id;
    private final User user;
    private final int lenght;
    private final int width;
    private final int height;
    private final Date date;
    private boolean shipped;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getLenght() {
        return lenght;
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

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
      
}
