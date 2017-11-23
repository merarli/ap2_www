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
        <h1>BMI判定結果</h1>
        あなたのBMIは
        <hr>
        <%
        String ta = request.getParameter("ta");
        String si = request.getParameter("si");
        out.print(calBMI(ta,si));
        double BMI = calBMI(ta,si);
        out.print("<hr>");
        out.print(hantei(BMI));
        out.print("<hr>");
        
        
        %>
        

    </body>
</html>
<%!
    double calBMI(String weight, String height) {

        return Integer.parseInt(weight) / Integer.parseInt(height) * Integer.parseInt(height);
    }
    
    String hantei(double BMI){
    String ans = "";
    
    if(BMI<18.5){
        ans = "痩せ気味";
    }else if(BMI>=25){
        ans = "太り気味";
    }else{
        ans = "標準";
    }
    
    return ans;
    }
%>