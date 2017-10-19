package PresentationLayer;

import Exceptions.*;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the Command super class.
 * All of its children is used to execute 
 * different tasks for the FrontController
 * Servlet class.
 * 
 *  @author Gert Lehmann Madsen
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    /**
     * The init method is use to specify which
     * Command subclasses ate available.
     */
    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "logout", new Logout() );
        commands.put( "register", new Register() );
        commands.put( "home", new Home() );
        commands.put( "input", new Input() );
        commands.put( "ship", new Ship() );
        commands.put( "view", new ViewOrders() );
        commands.put( "house", new House() );
        commands.put( "pieces", new Pieces() );
    }

    /**
     * This method is used to determine which
     * Command subclass to initialize. It gets
     * the command parameter from the HttpServletRequest
     * and unless this is null it retrieves the command
     * object from the HashMap containing the available 
     * commands. If no command match is found in the HashMap
     * it returns the UnknownCommand object.
     * @param request is the HttpServletRequest.
     * @return a command object from the commands HashMap.
     */
    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
                throws LegohusException, InputException, WritingToSQLException;

}
