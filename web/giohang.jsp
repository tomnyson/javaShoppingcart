<%-- 
    Document   : giohang.jsp
    Created on : Jan 22, 2021, 12:43:47 AM
    Author     : tomnyson
--%>

<%@page import="com.entity.Car"%>
<%@page import="com.model.CarDao"%>
<%@page import="com.entity.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
        <h1>CHI TIẾT GIỎ HÀNG</h1>
        <a href="oto" class="btn btn-info" role="button">Mua Hàng tiếp</a>
          <a href="checkout.jsp" class="btn btn-success" role="button">Thanh toán</a>
        <table class="table  table-sm" border="1" width="70%">
            <tr><th>Tên Sản phẩm</th>
                <th>Ảnh</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Thêm</th>
                <th>Xoá</th>

            </tr>
            <%
                Cart cart = (Cart) session.getAttribute("cart");
                if (cart != null) {
                    ArrayList<Item> ds = cart.getCart();
                    for (Item mh : ds) {
                        Car sp = CarDao.findProductById(mh.getMaSp());
            %>
             <form action="cart" method="post">
            <tr>
                <td><%= mh.getTitle()%></td>
                <td><img src="<%=mh.getImage()%>" width="100" height="100" /></td>
                <td><%= mh.getSoluong()%></td>
                <td>
                    <fmt:formatNumber type="number" maxFractionDigits="2" value="<%= mh.getDongia()%>" />
                </td>
                <td>
                        <input type="hidden" name="masp" value="<%= mh.getMaSp()%>"/>
                        <button type="submit" name="cart" value="add" class="btn btn-info btn-block">
                            <small>+</small
                        </button>
                </td>
                <td>
                    <input type="hidden" name="masp" value="<%= mh.getMaSp()%>"/>
                        <button type="submit" name="cart" value="remove" class="btn btn-danger btn-block">
                            <small>x</small
                        </button>
                </td>
            </tr>
             </form>
            <%
                }
            %>

        </table>    
        <h2 align="right">Tổng tiền:
            <fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.TotalOrder()}" />
        </h2>
        <%}%>
        </div>
    </body>
</html>
