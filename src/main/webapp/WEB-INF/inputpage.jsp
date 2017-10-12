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
        <title>Input Lego House Dimensions</title>
    </head>
    <body style="background-image: url(Pictures/pattern.jpg)" > 
        <%@ include file = "topmenu.jsp" %>
        <div style="border: solid 1px; height: 320px; width: 70%; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">
        
        <div class="col-sm-1">
        </div>
        <div class="col-sm-5">
        <h2>Order Lego House</h2>
        <table>
            <tr>
                <td>
                    <form name="order" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="input">
                        <br>Length:<br>
                        <input type="text" name="length" value="1">
                        <br>
                        Width:<br>
                        <input type="text" name="width" value="1">
                        <br>
                        Height:<br>
                        <input type="text" name="height" value="1">
                        <br><br>
                        <input type="submit" value="Submit">
                    </form>
                </td>

            </tr>
        </table>
        </div>
        <div class="col-sm-5">
        <img src="Pictures/bricks_2.jpg" alt=""/>
        </div>
        <div class="col-sm-1">
        </div>
        
        </div>
        <div style="border: solid 1px; height: 100px; width: 70%; margin-top: 40px; margin-bottom: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
        </div>

    </body>
</html>

