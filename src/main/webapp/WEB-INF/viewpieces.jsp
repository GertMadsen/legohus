<%-- 
    Document   : viewpieces
    Created on : 17-10-2017, 13:06:44
    Author     : GertLehmann
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.Bricks"%>
<%@page import="PresentationLayer.Render"%>
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
        <title>View Pieces Used</title>
    </head>
    <body style="background-image: url(Pictures/pattern.jpg)" > 
        <%@ include file = "topmenu.jsp" %>
        <%
            Bricks bricksUsed = (Bricks) session.getAttribute("bricks");
            int oid = (int) session.getAttribute("oid");
            Order order = user.getOrderFromMap(oid);
        %>
        
        <div style="border: solid 1px; width: 80%; margin-bottom: 40px; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">

        <h1>Pieces used to build Lego </h1>

        <table class="table table-center table-striped" id="ordertable">
            <thead>
                <tr>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>4x2</th>
                    <th>2x2</th>
                    <th>1x2</th>
                </tr>
            </thead>
            <%=Render.viewPieces(bricksUsed, order)%>
        </table>
        </div>

    </body>
</html>
