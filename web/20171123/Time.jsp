<%-- 
    Document   : Ex82
    Created on : 2017/11/21, 11:44:13
    Author     : merarli
--%>


<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>

        
<%
 Date date = new Date();
 GregorianCalendar cal = new GregorianCalendar();
      SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日 (E) HH:MM:mm");
      String datestr = format.format(cal.getTime());
      out.println("送信時間:" + datestr);

   
%>
