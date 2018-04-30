<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/stylesheet.css">
        <title>Quote</title>
    </head>

    <body>
        
        <div class="1" style="text-aligh:center">
            <h1>Quote Calculation</h1>
            <hr>
            <form name="demoForm" action="results.jsp" method="post">
                <table>
                    <tbody>
                        <tr>
                            <td>Car id:</td>
                            <td><input type="text" name="id" value="" size="50"></td>
                        </tr>
                        
                        <tr>
                            <td>Car price:</td>
                            <td><input type="text" name="price" value="" size="50"></td>
                        </tr>

                        <tr>
                            <td>Tax rate:</td>
                            <td><input type="text" name="tax" value="" size="50"></td>
                        </tr>                     
                    </tbody>
                </table>
                    
                <br> <input type="submit" value="Submit" id="submit">
                     <input type="reset" value="Clear" id="clear">
            </form>
        </div> 
    </body>
</html>