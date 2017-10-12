<%-- 
    Document   : viewemployeeorders
    Created on : 12-10-2017, 16:17:57
    Author     : GertLehmann
--%>

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
        <title>Show All Orders</title>
    </head>
    <body style="background-image: url(Pictures/pattern.jpg)" > 
        <%@ include file = "topmenu.jsp" %>
        <div style="border: solid 1px; height: 450px; width: 80%; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">

        <h1>All Orders</h1>

        <table class="table table-center table-striped" id="ordertable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Customer</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>Date</th>
                    <th>Shipped</th>
                </tr>
            </thead>
            <%=Render.viewAllOrders(user)%>
        </table>
        </div>

    </body>
</html>
