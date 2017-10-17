
package Exceptions;

/**
 * This exception is thrown when errors occur
 * when writing data to the database.
 * 
 * @author Gert Lehmann Madsen
 */
public class WritingToSQLException extends Exception {

    public WritingToSQLException(String msg) {
        super(msg);
    }
    

}