package PresentationLayer;

import Exceptions.*;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of Command is to...

 @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "logout", new Logout() );
        commands.put( "register", new Register() );
        commands.put( "home", new Home() );
        commands.put( "input", new InputDimensions() );
        commands.put( "ship", new Ship() );
        commands.put( "view", new ViewOrders() );
        commands.put( "house", new House() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
                throws LegohusException, InputException, WritingToSQLException, LogoutException;

}
