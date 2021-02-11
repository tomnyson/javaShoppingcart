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
        <a class="nav-link" href="../admin/category">Danh sách</a>
    </li>
    <li class="nav-item ">
        <a class="nav-link active" data-toggle="pill" href="#menu1">Edit Danh Mục</a>
    </li>
</ul>

<form action="category" method="post">
    <div class="form-group">
        <label for="name">tên danh mục:</label>
        <input name="name" type="text" value="${currentCat.getName()}" required class="form-control" placeholder="tên danh mục" id="email">
    </div>
    <div class="form-group">
        <label for="pwd">Mô tả</label>
        <textarea name="description"  id="description" class="form-control" placeholder="mô tả danh mục">
            <c:out value="${currentCat.getDescription()}"/>
        </textarea>
    </div>
    <label for="pwd">hình ảnh</label>
    <c:if test="${not empty currentCat.getImage()}">
        <img src="${pageContext.request.contextPath}/upload/${currentCat.getImage()}" width="200" height="100"/>
    </c:if>
    <input type="file" name="image" t class="form-control" placeholder="mô tả danh mục" ></textarea>
    <input type="hidden" name="id" value="${currentCat.getId()}"/>
    <button type="submit" name="action" value="Update"  class="btn btn-success">Cập nhật</button>
</form>
</div>
<script>
   CKEDITOR.replace('description');
</script>

