package PresentationLayer;

import FunctionLayer.Bricks;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.text.SimpleDateFormat;
import java.util.TreeMap;

/**
 * The Render class is used to render different view 
 * to be shown in the jsp files.
 *
 * @author Gert Lehmann Madsen
 */
public class Render {
    /**
     * Date format to be used in order views.
     */
    private static SimpleDateFormat dt = new SimpleDateFormat("d. MMM yyyy - HH:mm");

    /**
     * This method is used to show all orders made by customers and
     * is only available from the employee page.
     * 
     * @param user the user will in this case be an employee and the 
     * user object will contain a TreeMap with all orders made by all customers. 
     * @return a string vith view of all orders.
     */
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
    
    /**
     * This method is used to show orders made by a specific customer and
     * is only available from the customer page.
     * 
     * @param user the user will in this case be a customer and the 
     * user object will contain a TreeMap with all orders made by this specific customer. 
     * @return a string vith view of all orders by this customer.
     */
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

    /**
     * This methos is used to render the view needed to show the amount of 
     * bricks used in a specific order.
     * 
     * @param bricksUsed is the Bricks object with the calculated amount of bricks used in this order.
     * @param order is used to retrieve the dimensions of the house in this order and if this house has
     * holes for a door and a window.
     * @return a string with the view of dimensions and bricks.
     */
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
