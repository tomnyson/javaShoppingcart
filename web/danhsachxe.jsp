<%-- 
    Document   : danhsachxe
    Created on : Jan 21, 2021, 11:06:55 PM
    Author     : tomnyson
--%>

<%@page import="com.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import="com.entity.Cart" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>danh sách xe oto</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./style/styles.css">
    </head>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            String username = (String) session.getAttribute("username");
            User current = (User) session.getAttribute("currentUser");
            try {
                if (cart != null) {
                    System.out.println(cart.kichThuoc());
                } else {
                    System.out.println(cart);
                }
            } catch (Exception e) {
                throw e;
            }


        %>
        <c:import  url="include/header.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col col-sm-2">
                    <h5>Danh mục</h5>
                    <ul class="list-group">
                        <c:forEach items="${catCar}" var="cat">
                            <a href="danhmuc?id=${cat.getId()}" class="list-group-item list-group-item-action">
                                ${cat.getName()}
                            </a>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col col-sm-10">
                    <div class="row">
                        <c:forEach items="${lscar}" var="car">

                            <div class="col-sm-4">
                                <div class="card"> 
                                    <a href="oto?id=${car.getId()}">
                                        <c:if test="${not empty car.getImage()}">
                                            <c:choose>
                                                <c:when test = "${fn:contains(car.getImage(), 'http')}">
                                                    <img  src="${car.getImage()}" width="100%" height="200px"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <img src="${pageContext.request.contextPath}/upload/${car.getImage()}" width="100%" height="200"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </a>
                                    <div class="card-body pt-0 px-0">
                                        <div class="d-flex flex-row justify-content-between mb-0 px-3"> <small class="text-muted mt-1">Giá Bán</small>
                                            <h6>
                                                <fmt:formatNumber type="number" maxFractionDigits="2" value="${car.getPrice()}" /> VNĐ
                                            </h6>                                </div>
                                        <hr class="mt-2 mx-3">
                                        <div class="d-flex flex-row justify-content-between px-3 pb-4">
                                            <div class="d-flex flex-column"><span class="text-muted"> ${car.getTitle()}</span></div>
                                        </div>
                                        <div class="d-flex flex-row justify-content-between p-3 mid">
                                            <div class="d-flex flex-column"><small class="text-muted mb-1 short-text">Mô Tả</small>
                                                <p>${car.getDescription()}</p>
                                            </div>
                                        </div>
                                        <div class="d-flex flex-column"><small class="text-muted mb-1 short-text">Liên hệ</small>
                                            <p>${car.getContact()}</p>
                                        </div>
                                    </div> 
                                    <div class="mx-3 mt-3 mb-2">
                                        <form action="cart" method="post">
                                            <input type="hidden" name="masp" value="${car.getId()}"/>
                                            <button type="submit" name="cart" value="add" class="btn btn-danger btn-block">
                                                <small>MUA</small
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <c:forEach var="i" begin="1" end="28">
                        <li class="page-item ${i == active ? "active" : ""  }"><a class="page-link" href="oto?page=${i}">${i}</a></li>
                        </c:forEach>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </div>
        </div>
        <c:import  url="include/footer.jsp"/>
    </body>
</html>
