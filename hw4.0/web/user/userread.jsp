<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>User Car Page</title>
    </head>
    <% String table1 = (String) request.getAttribute("table1");%>
    <body>
        <div class="wrap">
            <div class="main">        
                <div class="readtable" style="text-aligh:center">
                    <h1>Car Information</h1>
                    <%= table1%>
                </div>
            </div>
        </div>        
    </body>
</html>