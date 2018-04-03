<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>Add a New Car</title>
    </head>

    <body>
        <div class="addinfo" style="text-aligh:center">

            <h2>Add a New Car</h2>

            <form name="addForm" action="addCar" method="get">
                <table>
                    <tbody>
                        <tr>
                            <td>Car ID: </td>
                            <td><input type="text" name="id" value="" /></td>
                        </tr>

                        <tr>
                            <td>Car Name: </td>
                            <td><input type="text" name="name" value="" /></td>                        
                        </tr>

                        <tr>
                            <td>Year: </td>
                            <td><input type="text" name="year" value="" /></td>                        
                        </tr>

                        <tr>
                            <td>Car Model: </td>
                            <td><input type="text" name="model" value="" /></td>                        
                        </tr>

                        <tr>
                            <td>Car Color: </td>
                            <td><input type="text" name="color" value="" /></td>                        
                        </tr>

                    </tbody>
                </table>
                <input type="submit" name="submit" value="Submit" />

            </form>
        </div>
        <a href="read">Back to List</a>

    </body>
</html>
