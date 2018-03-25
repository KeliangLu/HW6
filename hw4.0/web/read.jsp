<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>JSP Page</title>
    </head>
    <% String table=(String) request.getAttribute("table");%>
    <body>
        <div class="readtable" style="text-aligh:center">
        <h1>Car Information</h1>

        <table id="t1">
            <tr>
                <th>Car ID</th>

                <th>Car Name</th>

                <th>Car Year</th>

                <th>Car Model</th>

                <th>Car Color</th>
                
                <th>Delete it?</th>
            </tr>
        </table>
        
        <%= table %>
   
        </div>
        
        <br>
        <a href ="add">Add a new Car</a>
        
    </body>
</html>
