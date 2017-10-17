
package FunctionLayer;

/**
 * The purpose of Bricks is to store information about
 * how many bricks is needed to build a certain Lego house
 * and if this house has holes for a door and a window.
 * 
 * @author Gert Lehmann Madsen
 */
public class Bricks {
       
    private int four;
    private int two;
    private int one;
    private boolean holes;
    
    public Bricks() {
        this.four = 0;
        this.two = 0;
        this.one = 0;
        this.holes = false;
    }

    public int getFour() {
        return four;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }

    public boolean isHoles() {
        return holes;
    }
    
    /**
     * This method sums the amount of bricks needed for a layer
     * of the lego house to the previous calculated layers.
     * 
     * @param four numbers of 4x2 bricks
     * @param two numbers of 2x2 bricks
     * @param one numbers of 2x1 bricks
     */
    public void addBricks(int four, int two, int one) {
        this.four += four;
        this.two += two;
        this.one += one;       
    }

    /**
     * This methods is used when holes for a door and a window is
     * applied to the house. A door hole substitute nine 4x2 bricks with six
     * 2x2 bricks and a window substitute six 4x2 bricks with four 2x2 bricks.
     */
    public void addDoorAndWindow() {
        this.four -= 15;
        this.two += 10;
        this.holes = true;
    }

   
}
