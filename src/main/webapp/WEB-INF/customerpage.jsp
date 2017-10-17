<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
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
        <title>Customer home page</title>
        
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
            
            #customer {
                height: 450px; 
                width: 800px; 
                margin-top: 40px;
                padding-left: 20px;
            }
            

        </style>
        
    </head>
    <body> 

        <%@ include file = "topmenu.jsp" %>

        <div class="frames" id="customer">
            <h1>Lego House</h1><br>
            <img src="Pictures/bricks_1.jpg" alt=""/>

        </div>

    </body>
</html>
