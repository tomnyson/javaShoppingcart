<%-- 
    Document   : danhmuc
    Created on : Jan 29, 2021, 5:08:22 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="pill" href="#home">Danh sách</a>
    </li>
</ul>
<div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">orderId</th>
                    <th scope="col">productId</th>
                    <th scope="col">total</th>
                    <th scope="col">price</th>
                    <th scope="col">action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listOder}" var="order">
                    <tr>
                        <td><c:out value="${order.getId()}"/></td>
                        <td>${order.getId_customer()}</td>
                        <td class="short-text"><fmt:formatNumber type="number" maxFractionDigits="2" value="${order.getTotal()}" /></td>
                        <td class="short-text">${order.getNote()}</td>
                        <td class="short-text">${order.getAddressShipping()}</td>
                        <td class="short-text">${order.getStatus()}</td>
                        <td>
                            <form action="category" method="post">
                                <input type="hidden" name="id" value="${order.getId()}"/>
                                <a href="?id=${order.getId()}">View Detail</a> |
                                <a href="?email=${order.getId()}">Edit</a>
                                <button type="submit" name="action"  value="Delete" class="btn btn-danger">X</button></td>
                        </form>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
    </div>
</div>
</div>
