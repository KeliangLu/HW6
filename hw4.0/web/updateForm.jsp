
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= 'model.Cars' %>
<% Cars cars = (Cars) request.getAttribute("cars") ;%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>Update a Car</title>
    </head>
    <body>
        <h1>Update</h1>

        <form name="updateForm" action="updateCar" method="get">
            <table class = "update">
                <tbody>
                    <tr>
                        <td>Car ID: </td>
                        <td><input type="text" name="id" value="<%=cars.getCARID()%>" /></td>
                    </tr>
                    
                    <tr>
                        <td>Car Name: </td>
                        <td><input type="text" name="name" value="<%=cars.getCARNAME()%>" /></td>                        
                    </tr>
                    
                    <tr>
                        <td>Year: </td>
                        <td><input type="text" name="year" value="<%=cars.getCARYEAR()%>" /></td>                        
                    </tr>
                    
                    <tr>
                        <td>Car Model: </td>
                        <td><input type="text" name="model" value="<%=cars.getCARMODEL()%>" /></td>                        
                    </tr>
                    
                    <tr>
                        <td>Car Color: </td>
                        <td><input type="text" name="color" value="<%=cars.getCARCOLOR()%>" /></td>                        
                    </tr>

                </tbody>
            </table>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Update" />

        </form>
    <a href="read">Back to List</a>
    </body>
</html>
