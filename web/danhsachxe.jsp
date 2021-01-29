<%-- 
    Document   : danhsachxe
    Created on : Jan 21, 2021, 11:06:55 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="container">
            <div class="row">
                <div class="col col-sm-12">
                    <div class="header">
                        <form class="form-inline" action="oto" method="get">
                            <input type="serch" class="form-control" placeholder="tim kiếm xe" id="pwd">
                            <div class="form-check">
                            </div>
                            <button type="submit" class="btn btn-primary">tìm xe</button>
                        </form>
                        <a href= "giohang.jsp">cart
                            <c:if test="${not empty cart}">
                                ${cart.kichThuoc()}
                            </c:if>
                        </a>
                        <c:choose>
                            <c:when test="${not empty username}">
                                <div class="logout">
                                Wellcome: <c:out value="${username}"/>
                               <form  action="AuthController" method="post">
                                    <button type="submit" name="action" value="logout" class="btn btn-link">
                                        logout
                                    </button>
                                </form>
                               </div>
                            </c:when>
                            <c:otherwise>
                                <a href="login.jsp?redirect=giohang.jsp">login</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${lscar}" var="car">

                    <div class="col-sm-4">
                        <div class="card"> <img src="${car.getImage()}" class="card-img-top" height="200px" width="100%">
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
                                    <div class="d-flex flex-column"><small class="text-muted mb-1">Mô Tả</small>
                                        <p>${car.getDescription()}</p>
                                    </div>
                                </div>
                                <div class="d-flex flex-column"><small class="text-muted mb-1">Liên hệ</small>
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
</body>
</html>
