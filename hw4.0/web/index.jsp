<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>Cars information</title>
    </head>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main">
                <h1>Cars Database</h1>

                <a href="read">View All Cars</a>
                <br>
                <a href="search.jsp">Search cars</a>

            </div>

            <%@ include file="includes/footer.jsp" %>   

        </div>
    </body>
</html>
