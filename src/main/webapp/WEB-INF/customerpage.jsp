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
            <div class="col-sm-12">
                <h1>Lego House</h1><br>
            </div>
            <div class="col-sm-6">
                <p>
                    You can order lego bricks to build your own
                    Lego house. The lenght and width of the house
                    needs to be at least 4 dots or else it is  not 
                    possible to construct the house<br><br>
                    The house will be build by Lego bricks that 
                    are either 4x2 dots, 2x2 dots or 2x1 dots and it 
                    will be constructed so that the Lego bricks are 
                    bonding.<br><br>
                    If one of the sides in the house is 10 or more
                    dots wide and the house is more than 6 bricks high
                    a hole for a door (4 dots wide and 6 brick high) 
                    and also a hole for a window (4 dots wide and 4 bricks high)
                    will be added centered at the middle opposite to each other
                    on the longest side of the house.
                </p>
            </div>
            <div class="col-sm-6">
                <br><img src="Pictures/bricks.jpg" alt=""/>
            </div>
            <div class="col-sm-12">
                <br>Press <b>'New House'</b> in the menu to order new house.
                - Choose <b>'View Orders'</b> to view list of your previous orders
            </div>

        </div>

    </body>
</html>
