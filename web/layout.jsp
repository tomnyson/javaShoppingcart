<%-- 
    Document   : layout
    Created on : Jan 18, 2021, 7:23:29 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
             <%@include file ="layout/header.jsp" %>
          <link rel="stylesheet" href="./style/styles.css">
          <link rel="stylesheet" href="./style/css/slick.css">
    </head>
    <body>
       
        <!-- dynamic -->
         
        <%@include file ="home.jsp" %>
       
       <%--<jsp:forward page="layout/view/404.jsp"/>--%>
        </div>
        <%@include file ="layout/footer.jsp" %>
    </body>
</html>
