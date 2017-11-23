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
        <h1>Ex82.jsp</h1>
        <ul>
            <hr>
            名前：<li><%=request.getParameter("te")%></li>
            <hr>
            住所<li><%=request.getParameter("raji1")%></li>
            <hr>
            興味：
            <!--チェックボックスをfor文で吐き出す-->

            <%
                for (int i = 1; i < 7; i++) {
                    String getStr = request.getParameter("check" + i);
                    if (getStr != null) {
                        out.print("<li>" + getStr + "</li>");
                    }
                }
            %>
            <hr>
        </ul>

       
    </body>
</html>
