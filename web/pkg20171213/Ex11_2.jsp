<%-- 
    Document   : Ex11_1
    Created on : 2017/12/19, 11:00:01
    Author     : merarli
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pkg20171213.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ex11_2.jsp</h1>
        <%
            List<Student> slist = (ArrayList<Student>) request.getAttribute("slist");
            for (Student s : slist) {
        %>
        <div><%=s.getSID()%></div>
        <div><%=s.getName()%></div>
        <div><%=s.getGakubu()%></div>
        <div><%=s.getGrade()%></div>
        
        
        <hr>
        <%
            }
        %>

    </body>
</html>
