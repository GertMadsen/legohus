<%-- 
    Document   : viewcustomerorders
    Created on : 12-10-2017, 16:17:28
    Author     : GertLehmann
--%>

<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="PresentationLayer.Render"%>
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
        <title>Show Customer Orders</title>
    </head>
    <body>
        <%@ include file = "topmenu.jsp" %>

        <h1>Orders</h1>

        <table class="table table-center table-striped" id="ordertable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Length</th>
                    <th>Width</th>
                    <th>Height</th>
                    <th>Date</th>
                    <th>Shipped</th>
                </tr>
            </thead>
            <%=Render.viewUserOrders(user)%>
        </table>

    </body>
</html>
