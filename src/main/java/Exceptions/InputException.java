
package Exceptions;

/**
 * This exception is thrown when the customers
 * inputs invalid data when ordering a new Lego house.
 * 
 * @author Gert Lehmann Madsen
 */
public class InputException extends Exception {

    public InputException(String msg) {
        super(msg);
    }
    
}
