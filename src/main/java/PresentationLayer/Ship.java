/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.LegohusException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Ship command subclass is used when 
 * the 'Ship' button is pressed in the order list.
 * This is only possible if you are an employee.
 * 
 * @author Gert Lehmann Madsen
 */
public class Ship extends Command {

    /**
     * First the order id for the order to be shipped is 
     * retrieved from the request and the user object is
     * retrieved from the session. The shipping status on
     * the order is then change using the shiporder method
     * in the LogicFacade class.
     * 
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @return a string that combines the user tole with 'order' to 
     * be used as link to an jsp order page in the FrontController Servlet.
     * @throws LegohusException if an error occurs while changing a orders shipping status.
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        LogicFacade.shipOrder(user, oid);
        return "WEB-INF/view" + user.getRole() + "orders";
    }

}
