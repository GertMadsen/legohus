<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
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

        <title>Employee home page</title>
    </head>
    <body>
        <%User user = (User) (session.getAttribute("user"));%>
        
        <h1>Hello <%=request.getParameter( "email")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        
               <table class="table table-center table-striped" id="ordertable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User</th>
                        <th>Length</th>
                        <th>Width</th>
                        <th>Height</th>
                        <th>Date</th>
                        <th>Shipped</th>
                    </tr>
                </thead>

                <%=Render.viewAllOrders(user)%>
                
       

            </table>

      
    </body>
</html>
