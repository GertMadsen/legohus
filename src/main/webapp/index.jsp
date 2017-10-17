<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

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
        <title>Welcome page</title>

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
        <%@ include file = "/WEB-INF/topmenu.jsp" %>

        <div class="frames" id="login" >

            <table>
                <thead>
                    <tr>
                        <th>Login</th>
                        <th>Or Register</th>

                    </tr>
                </thead>

                <tr>
                    <td>
                        <form name="login" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="login">
                            Email:<br>
                            <input type="email" name="email" value="john@doe.com">
                            <br>
                            Password:<br>
                            <input type="password" name="password" value="sesam">
                            <br><br>
                            <input type="submit" value="Submit">
                        </form>
                    </td>
                    <td>
                        <form name="register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="register">
                            Email:<br>
                            <input type="email" name="email" value="john@doe.com">
                            <br>
                            Password:<br>
                            <input type="password" name="password1" value="sesam">
                            <br>
                            Retype Password:<br>
                            <input type="password" name="password2" value="sesam">
                            <br><br>
                            <input type="submit" value="Submit">
                        </form>
                    </td>
                </tr>
            </table>
        </div>

        <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
        <div class="frames" id="error" >
            <H2>Error!!</h2>
            <p><%= error%>
        </div>
        <% }
        %>
    </body>
</html>
