<%-- 
    Document   : danhmuc
    Created on : Jan 29, 2021, 5:08:22 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="pill" href="#home">Danh sách</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu1">Thêm Sản phẩm</a>
    </li>
</ul>
<div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
        <div class="table-responsive">
            <table class="table ">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">title</th>
                        <th scope="col">price</th>
                        <th scope="col">description</th>
                        <th scope="col">image</th>
                        <th scope="col">action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listProd}" var="prod">
                        <tr>
                            <td><c:out value="${prod.getId()}"/></td>
                            <td>${prod.getTitle()}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${prod.getPrice()}" /></td>
                            <td class="short-text">${prod.getDescription()}</td>
                            <td>
                                <c:if test="${not empty prod.getImage()}">
                                    <c:choose>
                                        <c:when test = "${fn:contains(prod.getImage(), 'http')}">
                                             <img src="${prod.getImage()}" width="200" height="100"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/upload/${prod.getImage()}" width="200" height="100"/>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </td>
                            <td>
                                <form action="category" method="post">
                                    <input type="hidden" name="id" value="${prod.getId()}"/>
                                    <a href="?id=${prod.getId()}">Edit</a>
                                    <button type="submit" name="action"  value="Delete" class="btn btn-danger">X</button></td>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
        <form action="product" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">tên sản phẩm :</label>
                <input name="title" type="text" required class="form-control" placeholder="tên sản phẩm" id="email">
            </div>
            <div class="form-group">
                <label for="name">giá sản phẩm :</label>
                <input name="price" type="number" required class="form-control" placeholder="giá sản phẩm" id="email">
            </div>
            <div class="form-group">
                <label for="name">danh mục :</label>
                <select name="category" class="custom-select" required>
                    <option selected>Chọn danh mục sản phẩm</option>
                    <c:forEach items="${listCat}" var="cat">
                        <option value="${cat.getId()}">${cat.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="pwd">Mô tả</label>
                <textarea name="description" class="form-control" placeholder="mô tả sản phẩm" id="pwd"></textarea>
            </div>
            <div class="form-group">
                <label for="pwd">Liên Hệ </label>
                <textarea name="contact" class="form-control" placeholder="mô tả liên hệ" id="pwd"></textarea>
            </div>
            <label for="pwd">hình ảnh</label>
            <input type="file" name="image" t class="form-control" placeholder="mô tả danh mục" id="pwd"></textarea>
            <button type="submit" name="action" value="Add"  class="btn btn-success btn-submit">Thêm</button>
        </form>
    </div>
</div>
</div>
<script>
    CKEDITOR.replace('description');
    CKEDITOR.replace('contact');
</script>

