/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Command subclass used to go to either
 * customer or employee home page 
 * when 'Home' button is pressed in top menu.
 * 
 * @author Gert Lehmann Madsen
 */
public class Home extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        return "WEB-INF/" + user.getRole() + "page";
    }

}

