/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Exceptions.*;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Input command class is used to handle the different 
 * tasks when an user submits house dimensions.
 *
 * @author Gert Lehmann Madsen
 */
public class Input extends Command {

    /**
     * The length, width and height of the house ordered is retrieved
     * from the request and parsed into integers if possible.
     * The input is then validated using the validateDimensions method
     * in the LogicFacade class.
     * If the dimensions are valid and order is created and stored in
     * the database using the createOrder method in the LogicFacade class.
     * 
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @return a string use to create a link in the FrontController Servlet
     * @throws LegohusException if an error occurs creating an order.
     * @throws InputException if the input dimensions is not in a valid format.
     * @throws WritingToSQLException if an error occur trying to write the order to the database.
     */
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegohusException, InputException, WritingToSQLException {
        int length, width, height;
        try {
        length = Integer.parseInt(request.getParameter( "length" ));
        width = Integer.parseInt(request.getParameter( "width" ));
        height = Integer.parseInt(request.getParameter( "height" ));
        } catch (NumberFormatException ex){
            throw new InputException( "Use Integers as input" );
        }
        boolean valid = LogicFacade.validateDimensions(length, width, height);
        if ( valid ) {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            Order order = LogicFacade.createOrder( user, length, width, height);
            session.setAttribute( "order", order );
            return "WEB-INF/view"+ user.getRole() + "orders";
        } else {
            throw new InputException( "Not a valid input." );
        }
    }
      
}
