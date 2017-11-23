<%-- 
    Document   : Ex82
    Created on : 2017/11/21, 11:44:13
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
        <h1>アンケート結果</h1>
            <hr>
            名前：<%=request.getParameter("te")%> <br>
            製品名：<%=request.getParameter("pul")%><br>
            
            評価：<%=request.getParameter("raji1")%><br>
            自由意見：<br>
            <%=request.getParameter("tA")%><br>

    </body>
</html>
