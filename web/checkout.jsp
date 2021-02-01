<%-- 
    Document   : checkout
    Created on : Jan 26, 2021, 1:27:37 PM
    Author     : tomnyson
--%>

<%@page import="com.entity.User"%>
<%@page import="com.entity.Car"%>
<%@page import="com.model.CarDao"%>
<%@page import="com.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
          
        %>
        <div class="container">
            <div class="py-5 text-center">
               
                tomnyson shop
                <h2>Thanh toán sản phẩm</h2>
                <div class="alert alert-success">
                    Đăng nhập để tiếp tục mua hàng <a href="login.jsp">login</a>
                </div>
                <div class="d-block my-3">
                    <div class="custom-control custom-radio">
                        <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
                        <label class="custom-control-label" for="credit">Tạo mới account</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Giỏ hàng</span>
                        <span class="badge badge-secondary badge-pill">3</span>
                    </h4>
                    <ul class="list-group mb-3 sticky-top">
                        <%
                            Cart cart = (Cart) session.getAttribute("cart");
                            if (cart != null) {
                                ArrayList<Item> ds = cart.getCart();
                                for (Item mh : ds) {
                                    Car sp = CarDao.findProductById(mh.getMaSp());
                        %>
                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                            <div>
                                <h6 class="my-0"><%= mh.getTitle()%></h6>
                                <small class="text-muted"><%= mh.getSoluong()%></small>
                            </div>
                            <span class="text-muted">

                        </li>
                        <%
                            }
                        %>
                        <li class="list-group-item d-flex justify-content-between bg-light">
                            <div class="text-success">
                                <h6 class="my-0">Promo code</h6>
                                <small>EXAMPLECODE</small>
                            </div>
                            <span class="text-success">-$5</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Total (USD)</span>
                            <strong>
                                <fmt:formatNumber type="number" maxFractionDigits="2" value="<%= cart.TotalOrder()%>" /></span>
                            </strong>
                        </li>
                    </ul>
                    <% }%>
                    <form class="card p-2">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Promo code">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary">Redeem</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-8 order-md-1">
                    <form action="cart" method="post" class="needs-validation" novalidate="">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="firstName">họ và tên</label>
                                <input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                                <div class="invalid-feedback"> </div>
                            </div>
                            <div class="col-md-6">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="you@example.com">
                                <div class="invalid-feedback">  </div>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="state">tỉnh</label>
                                <select class="custom-select" id="tinh" required="">
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="state">huyện/quận</label>
                                <select class="custom-select" disabled id="huyen" required="">
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="state">xã/thị trấn</label>
                                <select class="custom-select d-block w-100" disabled id="xa" required="">
                                </select>
                            </div>
                            <div class="col-md-12">
                                <label for="address">Address</label>
                                <textarea id="address"  class="form-control" name="address" id="address" placeholder="1234 Main St" required=""></textarea>
                                <div class="invalid-feedback"> </div>
                            </div>
                            <div class="col-md-12">
                                <label for="address">Ghi chú</label>
                                <textarea  class="form-control" id="address" name="note" placeholder="1234 Main St" required=""></textarea>
                                <div class="invalid-feedback"> </div>
                            </div>
                        </div>
                        <h4 class="mb-3">Payment</h4>
                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked="" required="">
                                <label class="custom-control-label" for="credit">COD</label>
                            </div>
                        </div>
                        <hr class="mb-4">
                        <c:choose>
                            <c:when test="${not empty username}">
                                <button type="submit" name="cart" value="checkout" class="btn btn-primary btn-lg btn-block" type="submit">Thanh toán</button>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-success">
                                    Đăng nhập để tiếp tục mua hàng <a href="login.jsp?redirect=checkout.jsp">login</a>
                                </div>
                            </c:otherwise>
                        </c:choose>


                    </form>
                </div>
            </div>
            <footer class="my-5 pt-5 text-muted text-center text-small">
                <p class="mb-1">© 2020 java4 lập trình </p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Privacy</a></li>
                    <li class="list-inline-item"><a href="#">Terms</a></li>
                    <li class="list-inline-item"><a href="#">Support</a></li>
                </ul>web
            </footer>
        </div>
        <script>
            $(document).ready(function () {
                $.ajax({
                    url: "ajax/city",
                    success: function (data) {
                        data.map((item, index) => {
                            $("#tinh").append(new Option(item.name, item.matp));
                        })
                        $.ajax({
                            url: "ajax/district?matp=1",
                            success: function (data) {
                                $("#huyen").html('');
                                data.map((item, index) => {
                                    $("#huyen").append(new Option(item.name, item.xaid));
                                })
                            }

                        });
                        $("#huyen").prop('disabled', false);
                    }

                });
                $('#tinh').change(function (e) {
                    const matp = $('#tinh').children("option:selected").val()
                    const textTinh = $('#tinh').children("option:selected").text()
                    $.ajax({
                        url: "ajax/district?matp=" + matp,
                        success: function (data) {
                            $("#huyen").html('');
                            data.map((item, index) => {
                                $("#huyen").append(new Option(item.name, item.maqh));
                            })
                            $("#huyen").prop('disabled', false);
                        }

                    });
                    $('#address').append(textTinh);
                })
                $('#huyen').change(function (e) {
                    const mah = $('#huyen').children("option:selected").val()
                    const textHuyen = $('#huyen').children("option:selected").text()
                    $.ajax({
                        url: "ajax/village?mah=" + mah,
                        success: function (data) {
                            $("#xa").html('');
                            data.map((item, index) => {
                                $("#xa").append(new Option(item.name, item.xaid));
                            })
                            $("#xa").prop('disabled', false);
                        }

                    });
                })
            });

        </script>
    </body>
</html>
