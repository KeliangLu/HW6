<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/stylesheet.css">
        <title>Result</title>
    </head>
    <%
        double id = Double.parseDouble(request.getParameter("id"));
        double price = Double.parseDouble(request.getParameter("price"));
        double tax = Double.parseDouble(request.getParameter("tax"));
        
        double quote = price + price * tax;
    %>
    <body>
        <div class="result">
            <h1>Quote Information</h1>
        <hr>
            <div class="table2">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>Car id:</td>
                            <td><%=id%></td>
                        </tr>

                        <tr>
                            <td>Car price:</td>
                            <td><%=price%></td>
                        </tr>

                        <tr>
                            <td>Tax rate:</td>
                            <td><%=tax%></td>
                        </tr>

                        <tr>
                            <td>Quote:</td>
                            <td><%=quote%></td>
                        </tr>
            
                    </tbody>
                </table>
            </div>  
        </div>
    </body>
</html>