<%-- 
    Document   : Kadai07_1
    Created on : 2017/11/16, 15:00:27
    Author     : merarli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kadai07_1.jsp</h1>
        <%
            for (int i = 50; i < 100; i++) {
                if (i % 7 == 0 && i % 4 != 0) {
                    out.print(i+"<br/>");
                }
            }
        %>
    </body>
</html>
