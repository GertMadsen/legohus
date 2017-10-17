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

            #input {
                height: 370px; 
                width: 640px; 
                margin-top: 40px;
            }

            #leftside {
                padding-left: 20px;
            }

            #error {
                padding-top: 20px;
                height: 150px; 
                width: 420px; 
                margin-top: 40px;
                text-align: center;
            }

        </style>

    </head>
    <body> 
        <%@ include file = "topmenu.jsp" %>
        <div class="frames" id="input">
            <div class="col-sm-12">
                <h1>Make new Order:</h1>
            </div>

            <div class="col-sm-5" id="leftside">
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
            <div class="col-sm-7">
                <img src="Pictures/bricks_2.jpg" alt=""/>
            </div>
            <div class="col-sm-12">
                <br><b>Remember:</b> Input data <b>need to be integers</b> and length and width has to be <b>at least 4 dots</b>.
            </div>

        </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <div class="frames" id="error">
            <H2>Error!!</h2>
            <p><%= error%>
        </div>
        <% }
        %>

    </body>
</html>

