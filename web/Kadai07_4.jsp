<%-- 
    Document   : Kadai07_4
    Created on : 2017/11/16, 15:29:42
    Author     : merarli
--%>

<%@page import="java.lang.String"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Kadai07_4.jsp</h1>
        <% 
            Date date = new Date();
            SimpleDateFormat d1 = new SimpleDateFormat("yyyy年MM月dd日");
            String q1 = d1.format(date);
            out.print("誕生日:1994/10/31<br/>"+q1+"現在で" + getAge(1994,10,4) + "歳です<br/>");%>
    </body>
</html>

<%!
    int getAge(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date dateTo = null;
        Date dateFrom = null;

        try {
            dateFrom = sdf.parse(String.valueOf(year) +"/"+ String.valueOf(month) +"/"+ String.valueOf(day));
            dateTo = sdf.parse("2017/11/09");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long dateTimeTo = dateTo.getTime();
        long dateTimeFrom = dateFrom.getTime();
        
        long dayDiff = ( dateTimeTo - dateTimeFrom  ) / (1000 * 60 * 60 * 24 );
        
        return (int)(dayDiff)/365;
    }


%>