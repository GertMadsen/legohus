<%-- 
    Document   : topmenu
    Created on : 12-10-2017, 18:51:01
    Author     : Gert Lehmann Madsen
--%>

<%@page import="FunctionLayer.User"%>
<!DOCTYPE html>

<%User user = (User) session.getAttribute("user");%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
            
<% if (user == null) { %>
        
        <ul class="nav navbar-nav">
            <li style="font-size: 28px; color: goldenrod;" class="navbar-text">Lego House</li>
        </ul>
        

    </div>
</nav>

<% } else { %>

        <ul class="nav navbar-nav">
            <li style="font-size: 28px; color: goldenrod;" class="navbar-text">Lego House</li>

            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="home">
                    <input style="font-weight: bold" type="submit" value="Home">
                </form>
            </li>
            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="view">
                    <input style="font-weight: bold" type="submit" value="View Orders">
                </form>
            </li>

<% if (user.getRole().equals("customer")) { %>

            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="house">
                    <input style="font-weight: bold" type="submit" value="New House">
                </form>
            </li>

<% } %>

        </ul>
       
        <ul class="nav navbar-nav navbar-right">
            <li style="font-size: 16px; color: goldenrod;" class="navbar-text"><%=user.getRole()%> : <%=user.getEmail()%> </li>
            <li class="navbar-text">
                <form name="choice" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="logout">
                    <input style="font-weight: bold" type="submit" value="Logout">
                </form>
            </li>
        </ul>

    </div>
</nav>

<% }%>
