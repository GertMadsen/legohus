/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.InputException;
import FunctionLayer.LegohusException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GertLehmann
 */
public class Input extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException, InputException {
        int length, width, height;
        try {
        length = Integer.parseInt(request.getParameter( "length" ));
        width = Integer.parseInt(request.getParameter( "width" ));
        height = Integer.parseInt(request.getParameter( "height" ));
        } catch (NumberFormatException ex){
            throw new InputException( "Use Integers as input" );
        }
        if ( length > 0 & width > 0 & height > 0) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            Order order = LogicFacade.createOrder( user, length, width, height);
            session.setAttribute( "order", order );
            return user.getRole() + "page";
        } else {
            throw new InputException( "All input needs to be larger than 0" );
        }
    }
    
    
}
