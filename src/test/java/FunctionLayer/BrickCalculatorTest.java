/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GertLehmann
 */
public class BrickCalculatorTest {

    public BrickCalculatorTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testCalcFromDimensionsWithNoHoles() {
        int length = 7;
        int width = 6;
        int height = 2;
        BrickCalculator instance = new BrickCalculator();
        Bricks result = instance.calcFromDimensions(length, width, height);
        int expResultFour = 4;
        int expResultTwo = 8;
        int expResultOne = 4;
        assertEquals(expResultFour, result.getFour());
        assertEquals(expResultTwo, result.getTwo());
        assertEquals(expResultOne, result.getOne());
        assertFalse(result.isHoles());
    }

    @Test
    public void testCalcFromDimensionsWithWithHoles() {
        int length = 10;
        int width = 6;
        int height = 8;
        BrickCalculator instance = new BrickCalculator();
        Bricks result = instance.calcFromDimensions(length, width, height);
        int expResultFour = 17;
        int expResultTwo = 42;
        int expResultOne = 0;
        assertEquals(expResultFour, result.getFour());
        assertEquals(expResultTwo, result.getTwo());
        assertEquals(expResultOne, result.getOne());
        assertTrue(result.isHoles());
    }

}
