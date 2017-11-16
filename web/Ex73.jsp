<%-- 
    Document   : Ex73
    Created on : 2017/11/14, 11:36:29
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
        <h1>Hello World!</h1>
        <%
            String str = "いっちー,配達,ピザ";
            String tango[] = str.split(",");
            
            for (int i = 0; i < 5; i++) {
               out.print(i+"<br/>");
            }
            
            for(String date:tango){
                out.print(date + "</br>");
            }
        %>
    </body>
</html>
