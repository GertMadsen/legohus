/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.LegohusException;
import FunctionLayer.Bricks;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Pieces is to handle the different tasks when an user
 * wants to see the pieces list associated with an order.
 *
 * @author Gert Lehmann Madsen
 */

public class Pieces extends Command {

    /**
     * From the session this method retrieves the order id and
     * the user object. A Brick object is then created and 
     * in the LogicFacade the method calcBricks is used to 
     * calculate the bricks used.
     * The Bricks object is then stored in the session together
     * with the order id.
     * 
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @return a string used by the FrontController Servlet to link to a jsp page.
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        int oid = Integer.parseInt(request.getParameter("oid"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Bricks bricksUsed = LogicFacade.calcBricks(user, oid);
        session.setAttribute("bricks", bricksUsed);
        session.setAttribute("oid", oid);
        return "WEB-INF/viewpieces";
    }

}
