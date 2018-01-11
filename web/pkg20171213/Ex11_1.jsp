<%-- 
    Document   : Ex11_1
    Created on : 2017/12/19, 11:00:01
    Author     : merarli
--%>
<%@page import="pkg20171213.Exam"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <h1>Ex11_1.jsp</h1>
        <%
            Exam ex=(Exam)request.getAttribute("ex");
            %>
            <%=ex.getName()%>,点数＝<%=ex.getPoint()%>,評価＝<%=ex.getResult()%><br>
                
    </body>
</html>
