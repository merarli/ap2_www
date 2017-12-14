<%-- 
    Document   : Kadai1_1
    Created on : 2017/12/14, 15:35:06
    Author     : merarli
--%>

<%@page import="pkg20171214.Human"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kadai11_2.jsp</h1>
        <%
            Human hito = (Human) request.getAttribute("hito");
        %>

        <%=hito.getName()%>(<%=hito.getAge()%>)<%=hito.getKind()%>
    </body>
</html>
