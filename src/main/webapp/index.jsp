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
                
            }

            #login {
                height: 350px; 
                width: 570px; 
                margin-top: 40px;
                margin-bottom: 40px;
                padding-left: 30px;
                padding-right: 30px;
            }

            #error {
                height: 100px; 
                width: 420px; 
                margin-bottom: 40px;
                text-align: center;
            }
            
            h1 {
                text-align: center;
            }
        </style>

    </head>

    <body>
        <%@ include file = "/WEB-INF/topmenu.jsp" %>

        <div class="frames" id="login" >

            <div class="col-sm-12">
                <h1>Login or Registration:</h1><br>
            </div>
       
            <div class="col-sm-12">
                <table>
                    <thead>
                        <tr>
                            <th>Login</th>
                            <th></th>
                            <th>Register</th>

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
                            <img src="Pictures/spacer.png" alt=""/>
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
            <div class="col-sm-12">
                <br><b>Login</b> to enter site or <b>register</b> as customer with your email and a password.
            </div>
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
