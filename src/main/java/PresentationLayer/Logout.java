/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The logout class is used when a user wants 
 * to logout of the system.
 *
 * @author Gert Lehmann Madsen
 */
public class Logout extends Command {

    /**
     * In the HttpSession the user attribute is set to null.
     * @return the tring 'index' to be used in the Servlet as a link
     * to the 'index.jsp' page.
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        return "index";
    }

}