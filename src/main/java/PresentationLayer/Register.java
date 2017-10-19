package PresentationLayer;

import FunctionLayer.LogicFacade;
import Exceptions.LegohusException;
import Exceptions.WritingToSQLException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Register is to handle the different tasks when 
 * a user register as new customer
 *
 * @author Gert Lehmann Madsen
 */
public class Register extends Command {

    /**
     * Gets the email and two password parameters from request.
     * If the two passwords match a user is then created using
     * the createUSer method in the LogicFacade class.
     * The user and the user role is then stores in the session.
     * If the password does not match an exception is thrown.
     * 
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @return a string that combines the user tole with 'page' to 
     * be used as link to a jsp page in the FrontController Servlet.
     * @throws LegohusException if a register related error occurs.
     * @throws WritingToSQLException if a SQL writing error occurs
     */
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException, WritingToSQLException  {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return "WEB-INF/" + user.getRole() + "page";
        } else {
            throw new LegohusException( "the two passwords did not match" );
        }
    }

}
