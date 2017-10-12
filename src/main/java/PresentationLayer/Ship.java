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
 *
 * @author GertLehmann
 */
public class Ship extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        LogicFacade.shipOrder(user, oid);
        return user.getRole() + "page";
    }

}
