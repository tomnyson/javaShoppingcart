<%-- 
    Document   : chitietxe.jsp
    Created on : Jan 29, 2021, 4:09:29 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.entity.Cart" %>
<!DOCTYPE html>
<html>
    <head>
        <title>chi tiet san pham</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="./style/styles.css">
    </head>
    <!------ Include the above in your HEAD tag ---------->
    <body>
          <c:import  url="include/header.jsp"/>
        <div class="container">
           
            <div class="card">
                <div class="row">
                    <aside class="col-sm-5 border-right">
                        <article class="gallery-wrap"> 
                            <div class="img-big-wrap">
                                <div> <a href="#"><img src="${carDetail.getImage()}" width="300px"/></a></div>
                            </div> <!-- slider-product.// -->
                            <div class="img-small-wrap">
                                <div class="item-gallery"> <img src="${carDetail.getImage()}"> </div>
                                <div class="item-gallery"> <img src="${carDetail.getImage()}"> </div>
                            </div> <!-- slider-nav.// -->
                        </article> <!-- gallery-wrap .end// -->
                    </aside>
                    <aside class="col-sm-7">
                        <article class="card-body p-5">
                            <h3 class="title mb-3">${carDetail.getTitle()}</h3>

                            <p class="price-detail-wrap"> 
                                <span class="price h3 text-warning"> 
                                    <span class="currency">VNĐ</span><span class="num">
                                         <fmt:formatNumber type="number" maxFractionDigits="2" value="${carDetail.getPrice()}" /> VNĐ
                                    </span>
                                </span> 
                            </p> <!-- price-detail-wrap .// -->
                            <dl class="item-property">
                                <dt>Description</dt>
                                <dd><p>${carDetail.getDescription()}</p></dd>
                            </dl>
                             <dl class="item-property">
                                <dt>contact</dt>
                                <dd><p>${carDetail.getContact()}</p></dd>
                            </dl>
                            <dl class="param param-feature">
                                <dt>Model#</dt>
                                <dd>12345611</dd>
                            </dl>  <!-- item-property-hor .// -->
                            <dl class="param param-feature">
                                <dt>Color</dt>
                                <dd>Black and white</dd>
                            </dl>  <!-- item-property-hor .// -->
                            <dl class="param param-feature">
                                <dt>Delivery</dt>
                                <dd>Russia, USA, and Europe</dd>
                            </dl>  <!-- item-property-hor .// -->
                            <hr>
                            <a href="#" class="btn btn-lg btn-primary text-uppercase"> Mua Ngay</a>
                            </div> <!-- row.// -->
                            <hr>
                           
                        </article> <!-- card-body.// -->
                    </aside> <!-- col.// -->
                </div> <!-- row.// -->
            </div> <!-- card.// -->


        </div>
    </body>
     <c:import  url="include/footer.jsp"/>
</html>