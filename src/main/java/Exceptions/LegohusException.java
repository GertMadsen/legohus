package Exceptions;

/**
 * This exception is thrown when errors occur reading
 * data from the database or if the user inputs invalid
 * data trying to login or register.
 * 
 * @author Gert Lehmann Madsen
 */
public class LegohusException extends Exception {

    public LegohusException(String msg) {
        super(msg);
    }
    

}
