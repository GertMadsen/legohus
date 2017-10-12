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
    </head>

    <body style="background-image: url(Pictures/pattern.jpg)" >
        <%@ include file = "/WEB-INF/topmenu.jsp" %>

        <div style="border: solid 1px; height: 250px; width: 80%; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">

            <table>
                <tr><td>Login</td>
                    <td>
                        <form name="login" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="login">
                            Email:<br>
                            <input type="text" name="email" value="someone@nowhere.com">
                            <br>
                            Password:<br>
                            <input type="password" name="password" value="sesam">
                            <br>
                            <input type="submit" value="Submit">
                        </form>
                    </td>
                    <td>Or Register</td>
                    <td>
                        <form name="register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="register">
                            Email:<br>
                            <input type="text" name="email" value="someone@nowhere.com">
                            <br>
                            Password:<br>
                            <input type="password" name="password1" value="sesam">
                            <br>
                            Retype Password:<br>
                            <input type="password" name="password2" value="sesam">
                            <br>
                            <input type="submit" value="Submit">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
        <div style="border: solid 1px; height: 200px; width: 80%; margin-top: 40px; margin-left: auto; margin-right: auto; background-color: #FFFFFF">


            <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
            <H2>Error!!</h2>
            <p><%= error%>
                <% }
                %>

        </div>


    </body>
</html>
