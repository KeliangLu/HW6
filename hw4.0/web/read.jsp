<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% String table=(String) request.getAttribute("table");%>
    <body>
        <h1>Car Information!</h1>
        <%=table %>
        
        <br><br>
        <a href ="add">Add a new Car</a>
        
    </body>
</html>
