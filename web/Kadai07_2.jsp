<%-- 
    Document   : Kadai07_2
    Created on : 2017/11/16, 15:03:55
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
        


        <h1>Kadai07_2.jsp</h1>
        
        <% out.print("半径３高さ７の円柱の体積は" + volume(3, 7) + "<br/>");%>
        <% out.print("半径３高さ７の円柱の体積は" + String.format("%.2f",volume(3, 7)));%>


    </body>
</html>
<%!
    double volume(int r, int h) {
        double v = Math.PI * r * r * h;
//        String tmp = String.format("%.2f", String.valueOf(v));
//        return r + Double.parseDouble(tmp);
        return v;
    }
%>