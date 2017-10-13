/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Gert Lehmann Madsen
 */
public class Render {

    public static String viewAllOrders(User user) {

        String output = "<tbody>";
        HashMap<String, Order> orderMap = user.getOrderMap();

        for (Order order : orderMap.values()) {

            output += "<tr>"
                    + "<td>" + order.getId() + "</td>"
                    + "<td>" + order.getUser().getEmail() + "</td>"
                    + "<td>" + order.getLength() + "</td>"
                    + "<td>" + order.getWidth() + "</td>"
                    + "<td>" + order.getHeight() + "</td>"
                    + "<td>" + order.getDate() + "</td>";

            if (order.isShipped()) {
                output += "<td>Shipped : "+ order.getShippingDate() +"</td>";
            } else {
                output += "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">";
                output += "<input type=\"hidden\" name=\"command\" value=\"ship\">";
                output += "<input type=\"hidden\" name=\"oid\" value=\"" + order.getId() + "\">";
                output += "<input type=\"submit\" value=\"Ship\">";
                output += "</form></td>";
            }

            output += "</tr>";
        }

        output += "</tbody>";
        return output;
    }

    public static String viewUserOrders(User user) {

        String output = "<tbody>";
        HashMap<String, Order> orderMap = user.getOrderMap();

        for (Order order : orderMap.values()) {
            output += "<tr>"
                    + "<td>" + order.getId() + "</td>"
                    + "<td>" + order.getLength() + "</td>"
                    + "<td>" + order.getWidth() + "</td>"
                    + "<td>" + order.getHeight() + "</td>"
                    + "<td>" + order.getDate() + "</td>";
         if (order.isShipped()) {
                output += "<td>Shipped : "+ order.getShippingDate() +"</td>";
            } else {   
                output += "<td>Not Shipped Yet</td>";
         }        
            output += "</tr>";
        }

        output += "</tbody>";
        return output;
    }


}
