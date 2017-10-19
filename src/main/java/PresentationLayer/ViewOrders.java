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
 * This Command subclass is used to forward the
 * customer or employee to the view page for orders made
 * when 'Show Orders' button is pressed in top menu.
 * 
 * @author Gert Lehmann Madsen
 */
public class ViewOrders  extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            return "WEB-INF/view"+ user.getRole() + "orders";
    }
        
}
