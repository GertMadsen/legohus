<%-- 
    Document   : viewcustomerorders
    Created on : 12-10-2017, 16:17:28
    Author     : GertLehmann
--%>

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
        <title>Show Customer Orders</title>
        
                <style>
            body {
                background-image: url(Pictures/pattern.png)
            }
            
            .frames {
                border: solid 2px;
                border-color: goldenrod;
                background-color: #FFFFFF;
                margin-left: auto; 
                margin-right: auto;
                padding-top: 20px;

            }
            
            #login {
                height: 250px; 
                width: 420px; 
                margin-top: 40px;
                padding-left: 30px;
            }
            
            #error {
                height: 150px; 
                width: 420px; 
                margin-top: 40px;
                text-align: center;
            }

        </style>
        
    </head>
    <body> 
        <%@ include file = "topmenu.jsp" %>
        <div style="border: solid 1px; width: 80%; margin-bottom: 40px; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">

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
                    <th>Pieces used</th>
                </tr>
            </thead>
            <%=Render.viewUserOrders(user)%>
        </table>
        </div>

    </body>
</html>
