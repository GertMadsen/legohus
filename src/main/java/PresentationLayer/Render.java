/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Bricks;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.text.SimpleDateFormat;
import java.util.TreeMap;

/**
 *
 * @author Gert Lehmann Madsen
 */
public class Render {

    private static SimpleDateFormat dt = new SimpleDateFormat("d. MMM yyyy - HH:mm");

    public static String viewAllOrders(User user) {

        String output = "<tbody>";
        TreeMap<String, Order> orderMap = user.getOrderMap();

        for (Order order : orderMap.values()) {
            output += "<tr>"
                    + "<td>" + order.getId() + "</td>"
                    + "<td>" + order.getUser().getEmail() + "</td>"
                    + "<td>" + order.getLength() + "</td>"
                    + "<td>" + order.getWidth() + "</td>"
                    + "<td>" + order.getHeight() + "</td>"
                    + "<td>" + dt.format(order.getDate()) + "</td>";

            if (order.isShipped()) {
                output += "<td>Shipped : " + dt.format(order.getShippingDate()) + "</td>";
            } else {
                output += "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">";
                output += "<input type=\"hidden\" name=\"command\" value=\"ship\">";
                output += "<input type=\"hidden\" name=\"oid\" value=\"" + order.getId() + "\">";
                output += "<input type=\"submit\" value=\"Ship\">";
                output += "</form></td>";
            }

            output += "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">";
            output += "<input type=\"hidden\" name=\"command\" value=\"pieces\">";
            output += "<input type=\"hidden\" name=\"oid\" value=\"" + order.getId() + "\">";
            output += "<input type=\"submit\" value=\"Show Brick List\">";
            output += "</form></td>";
            
            output += "</tr>";
        }

        output += "</tbody>";
        return output;
    }

    public static String viewUserOrders(User user) {

        String output = "<tbody>";
        TreeMap<String, Order> orderMap = user.getOrderMap();

        for (Order order : orderMap.values()) {
            output += "<tr>"
                    + "<td>" + order.getId() + "</td>"
                    + "<td>" + order.getLength() + "</td>"
                    + "<td>" + order.getWidth() + "</td>"
                    + "<td>" + order.getHeight() + "</td>"
                    + "<td>" + dt.format(order.getDate()) + "</td>";
            if (order.isShipped()) {
                output += "<td>Shipped : " + dt.format(order.getShippingDate()) + "</td>";
            } else {
                output += "<td>Not Shipped Yet</td>";
            }

            output += "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">";
            output += "<input type=\"hidden\" name=\"command\" value=\"pieces\">";
            output += "<input type=\"hidden\" name=\"oid\" value=\"" + order.getId() + "\">";
            output += "<input type=\"submit\" value=\"Show Brick List\">";
            output += "</form></td>";

            output += "</tr>";
        }

        output += "</tbody>";
        return output;
    }

    public static String viewPieces(Bricks bricksUsed, Order order) {

        String output = "<tbody>";
            output += "<tr>"
                    + "<td>" + order.getLength() + "</td>"
                    + "<td>" + order.getWidth() + "</td>"
                    + "<td>" + order.getHeight() + "</td>"
                    + "<td>" + bricksUsed.getFour() + "</td>"
                    + "<td>" + bricksUsed.getTwo() + "</td>"
                    + "<td>" + bricksUsed.getOne() + "</td>";
            if (bricksUsed.isHoles()) {
                output += "<td>Yes</td>";
            } else {
                output += "<td>No</td>";
            }
            output += "</tr>";
        output += "</tbody>";
        return output;
    }


}
