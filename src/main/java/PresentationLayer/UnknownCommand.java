package PresentationLayer;

import Exceptions.LegohusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException {
        String msg = "Unknown command. Contact IT";
        throw new LegohusException( msg );
    }

}
