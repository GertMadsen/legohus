/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Gert Lehmann Madsen
 */
public class Bricks {

    public Bricks() {
        this.four = 0;
        this.two = 0;
        this.one = 0;
    }
       
    private int four;
    private int two;
    private int one;
    

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }
    
    public void addBricks(int side) {
        this.four = side/4;
        this.two = (side%4)/2;
        this.one = (side%4)%2;       
    }
    
}
