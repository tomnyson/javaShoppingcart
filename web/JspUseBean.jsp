<%-- 
    Document   : JspUseBean
    Created on : Jan 19, 2021, 9:40:30 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="date" class="java.util.Date" /> 
        <jsp:useBean id="students" 
                     class="com.entity.StudentsBean"> 
            <jsp:setProperty name="students" property="firstName"
                             value="Zara"/>
            <jsp:setProperty name="students" property="lastName" 
                             value="Ali"/>
            <jsp:setProperty name="students" property="age" 
                             value="10"/>
            <p>Student First Name: 
                <jsp:getProperty name="students" property="firstName"/>
            </p>
            <p>Student Last Name: 
                <jsp:getProperty name="students" property="lastName"/>
            </p>
            <p>Student Age: 
                <jsp:getProperty name="students" property="age"/>
            </p>

        </jsp:useBean>
        <p>The date/time is <%= date%>
    </body>
</html>
