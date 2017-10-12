/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.LegohusException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
public class Home extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegohusException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        return user.getRole() + "page";
    }

}

