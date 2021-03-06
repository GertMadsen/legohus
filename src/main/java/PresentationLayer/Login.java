package PresentationLayer;

import FunctionLayer.LogicFacade;
import Exceptions.LegohusException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to handle the different tasks when an user
 * submits a user login.
 *
 * @author Gert Lehmann Madsen
 */
public class Login extends Command {

    /**
     * The purpose of the execute method is to create an user object containing
     * the user information if this user exists in the user database and to
     * store this user object in the session together with the role associated
     * with this user.
     *
     * @param request is a HttpServletRequest
     * @param response is a HttpServletResponse
     * @return combines the user role with the string 'page' to be used later 
     * as a link to a jsp page.
     * @throws LegohusException if a login in related error occurs.
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        return "WEB-INF/" + user.getRole() + "page";
    }

}
