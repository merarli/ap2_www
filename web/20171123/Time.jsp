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
            <li><%=request.getParameter("te")%></li>
            <li><%=request.getParameter("pa")%></li>
            <li><%=request.getParameter("tA")%></li>
            <li><%=request.getParameter("raji1")%></li>
            
            <!--チェックボックスをfor文で吐き出す-->

            <%
                for (int i = 1; i < 4; i++) {
                    String getStr = request.getParameter("check" + i);
                    if (getStr != null) {
                        out.print("<li>" + getStr + "</li>");
                    }
                }
            %>

            <li><%=request.getParameter("pul")%></li>
        </ul>

        <%
            String str = request.getParameter("te");
            
            if (str.equals("こんにちは")) {
                out.print("<h2>こんにちは</h2>");
            } else {
                out.print("<h2>わかりません</h2>");
            }
        %>
    </body>
</html>
