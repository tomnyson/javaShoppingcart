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
    <li class="nav-item">
        <a class="nav-link" data-toggle="pill" href="#menu1">Thêm Danh Mục</a>
    </li>
</ul>
<div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">name</th>
                    <th scope="col">description</th>
                    <th scope="col">image</th>
                    <th scope="col">action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listCat}" var="cat">
                    <tr>
                        <td><c:out value="${cat.getId()}"/></td>
                        <td>${cat.getName()}</td>
                        <td class="short-text">${cat.getDescription()}</td>
                        <td>
                            <c:if test="${not empty cat.getImage()}">
                                <img src="${pageContext.request.contextPath}/upload/${cat.getImage()}" width="200" height="100"/>
                            </c:if>
                        </td>
                        <td>
                            <form action="category" method="post">
                                <input type="hidden" name="id" value="${cat.getId()}"/>
                                <a href="?id=${cat.getId()}">Edit</a>
                                <button type="submit" name="action"  value="Delete" class="btn btn-danger">X</button></td>
                        </form>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
        <form action="category" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">tên danh mục:</label>
                <input name="name" type="text" required class="form-control" placeholder="tên danh mục" id="email">
            </div>
            <div class="form-group">
                <label for="pwd">Mô tả</label>
                <textarea name="description" class="form-control" placeholder="mô tả danh mục" id="pwd"></textarea>
            </div>
            <label for="pwd">hình ảnh</label>
            <input type="file" name="image" t class="form-control" placeholder="mô tả danh mục" id="pwd"></textarea>
            <button type="submit" name="action" value="Add"  class="btn btn-success">Thêm</button>
        </form>
    </div>
</div>
</div>
<script>
    CKEDITOR.replace('description');
    
</script>

