<%-- 
    Document   : topmenu
    Created on : 12-10-2017, 18:51:01
    Author     : GertLehmann
--%>

<%@page import="FunctionLayer.User"%>
<!DOCTYPE html>
<%User user = (User) session.getAttribute("user");%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li style="font-size: 24px" class="navbar-text">Lego House</li>
            <% if (user != null) { %>
            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="view">
                    <input type="submit" value="View Orders">
                </form>
            </li>
            <% if (user.getRole().equals("customer")) { %>
            
            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="house">
                    <input type="submit" value="New House">
                </form>
            </li>
            <% }} %>
        </ul>
        <% if (user != null) {%>
        <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text"><%=user.getRole()%> : <%=user.getEmail()%> </li>
            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="logout">
                    <input type="submit" value="Logout">
                </form>
            </li>
        </ul>
        <% }%>

    </div>
</nav>
