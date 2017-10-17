/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 * The purpose of BrickCalculater is to do the calculation
 * needed when the customer wants to see which bricks
 * is needed for a specific house to be constructed.
 * 
 * @author Gert Lehmann Madsen
 */
public class BrickCalculator {

    /**
     * In odd layers bricks will fill out all the length and
     * hereafter the space between these walls are filled with bricks
     * In even layers bricks will fill out all the width and
     * then fill out the rest of the length side.
     * @param length the length of the house in dots.
     * @param width the width of the house in dots.
     * @param height the height of the house in bricks.
     * @return a brick object containing the summed up bricks.
     */
    public Bricks calcFromDimensions(int length, int width, int height) {
        Bricks bricksCalculated = new Bricks();
        int four, two, one;
        int l,w;
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                l = length;
                w = width-4;
            } else {
                l = length-4;
                w = width;
            }
                four = (l / 4) * 2 + (w / 4) * 2;
                two = ((l % 4) / 2) * 2 + ((w % 4) / 2) * 2;
                one = ((l % 4) % 2) * 2 + ((w % 4) % 2) * 2;
                bricksCalculated.addBricks(four, two, one);
        }
        if ((length > 9 || width > 9) && height>6) {
            bricksCalculated.addDoorAndWindow();
        }
        return bricksCalculated;
    }
    
}
