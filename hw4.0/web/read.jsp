<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/Stylesheet.css">
        <title>JSP Page</title>
    </head>
    <% String table = (String) request.getAttribute("table");%>
    <body>
        <div class="wrap">

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %>

            <div class="main">        
                <div class="readtable" style="text-aligh:center">
                    <h1>Car Information</h1>


                    <%= table%>


                </div>

                <br>
                <a href ="add">Add a new Car</a>
                <br><br>
                <a href ="search.jsp">Search Cars</a>
                <br>
            </div>

            <%@ include file="includes/footer.jsp" %>   

        </div>        
    </body>
</html>
