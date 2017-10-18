<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
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
        <title>Employee home page</title>

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

            #employee {
                height: 450px; 
                width: 800px; 
                margin-top: 40px;
                margin-bottom: 40px;
                padding-left: 20px;
            }

            p {
                text-align: justify;
                font-style: italic;
            }

            h1 {
                text-align: center;
            }
        </style>

    </head>
    <body > 
        <%@ include file = "topmenu.jsp" %>
        <div class="frames" id="employee">



            <div class="col-sm-12">
                <h1>Employee Page</h1>
            </div>
            <div class="col-sm-4">
                <p>
                    As an employee you are able to see all
                    order made by customers.<br><br>
                    You will also be able to see how many
                    bricks and of which type is needed for 
                    each order.<br><br>
                    Finally, you can change the status of 
                    the order from 'Not Shipped' to 'Shipped'
                    when an order has been finished and sent
                    to the customer.<br><br>
                    When shipping an order a shipping date 
                    will be added to the order also available 
                    in the customers view.<br><br>

                </p>
            </div>
            <div class="col-sm-8">
                <img src="Pictures/shipped.jpg" alt=""/>
            </div>
            <div class="col-sm-12">
                Choose <b>'View Orders'</b> to see all orders made by customers 
                and to be able to manage the shipping status on orders.
            </div>



        </div>


    </body>
</html>
