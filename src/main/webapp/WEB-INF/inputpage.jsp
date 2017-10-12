<%-- 
    Document   : orderpage
    Created on : 12-10-2017, 10:55:45
    Author     : GertLehmann
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <title>Input Lego House Dimensions</title>
    </head>
    <body>
        <%@ include file = "topmenu.jsp" %>
        <h1>Submit new Order</h1>
        <table>
            <tr><td>Order Lego house:</td>
                <td>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="input">
                        Length:<br>
                        <input type="text" name="length" value="1">
                        <br>
                        Width:<br>
                        <input type="text" name="width" value="1">
                        <br>
                        Height:<br>
                        <input type="text" name="height" value="1">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>

            </tr>
        </table>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>

    </body>
</html>

