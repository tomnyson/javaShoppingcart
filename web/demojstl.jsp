<%-- 
    Document   : demojstl
    Created on : Jan 19, 2021, 9:08:32 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- cách dùng c set và c  --%>
    <c:set var="bien1" value="hello world"/>
    <h1><c:out value="${bien1}"/></h1>
    <c:set var = "salary" scope = "session" value = "${2000*2}"/>
    <c:out value = "${salary}"/>
    <c:remove var = "salary"/>
    <c:out value = "${salary}"/>
    <%-- cách dùng c c:catch  --%>
    <c:catch var ="catchException">
        <% int x = 5 / 0;%>
    </c:catch>
    <c:if test = "${catchException != null}">
        <p>The exception is : ${catchException} <br />
            There is an exception: ${catchException.message}</p>
    </c:if>
    <%-- cách dùng c c:if  --%>
    <c:set var = "salary" scope = "session" value = "${2000*2}"/>
    <c:if test = "${salary > 2000}">
        <p>My salary is:  <c:out value = "${salary}"/><p>
    </c:if>
    <%-- cách dùng switch  --%>
    <c:choose>

        <c:when test = "${salary <= 0}">
            Salary is very low to survive.
        </c:when>

        <c:when test = "${salary > 1000}">
            Salary is very good.
        </c:when>

        <c:otherwise>
            No comment sir...
        </c:otherwise>
    </c:choose>
    <%-- cách dùng foreach  --%>
    <c:forEach var = "i" begin = "1" end = "10">
        Item <c:out value = "${i}"/><p>
    </c:forEach>
     <%-- cách dùng foreach  --%>
     <%-- <c:redirect url = "http://www.photofuntoos.com"/> --%>
       <a href = "<c:url value = "/login.jsp"/>">Login</a>
      <c:redirect url = "http://www.google.com"/>
</body>
</html>
