/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;


import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
public class ViewOrders  extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            return "view"+ user.getRole() + "orders";
    }
        
}
