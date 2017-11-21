<%-- 
    Document   : Ex81
    Created on : 2017/11/21, 11:17:27
    Author     : merarli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ex81.jsp</h1>
         <div>
            年：<%=request.getParameter("year")%>
        </div>

        <div>
            月：<%=request.getParameter("month")%>
        </div>

        <div>
            日：<%=request.getParameter("day")%>
        </div>
    </body>
</html>
