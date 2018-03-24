<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a New Car</title>
    </head>
    <body>
        <h1>Add a New Car</h1>
        
        <form name="addForm" action="addCar" method="get">
            
            <label>Car ID: </label>
            <input type="text" name="id" value="" />
            <br>
            <label>Car Name: </label>
            <input type="text" name="name" value="" />
            <br>
            <label>Year: </label>
            <input type="text" name="year" value="" />
            <br>
            <label>Car Model: </label>
            <input type="text" name="model" value="" />
            <br>
            <label>Car Color: </label>
            <input type="text" name="color" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />

        </form>
    </body>
</html>
