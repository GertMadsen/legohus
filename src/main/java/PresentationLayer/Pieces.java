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
 *
 * @author GertLehmann
 */
public class Pieces extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        int oid = Integer.parseInt(request.getParameter("oid"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Bricks bricksUsed = LogicFacade.calcBricks(user, oid);
        session.setAttribute("bricks", bricksUsed);
        session.setAttribute("oid", oid);
        
        return "WEB-INF/viewpieces";
    }

}
