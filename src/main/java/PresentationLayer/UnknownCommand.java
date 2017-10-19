package PresentationLayer;

import Exceptions.LegohusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command subclass used when no command
 * was matched in the commands HashMap.
 * 
 * @author Gert Lehmann Madsen
 */
public class UnknownCommand extends Command {

    /**
     * Provides an error message for the user.
     * @throws LegohusException to be catched in FrontController Servlet. 
     */
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException {
        String msg = "Unknown command. Contact IT";
        throw new LegohusException( msg );
    }

}
