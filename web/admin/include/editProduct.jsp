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

<form action="product" method="post" enctype='multipart/form-data'>
    <div class="form-group">
        <label for="name">tên danh mục:</label>
        <input name="title" type="text" value="${currentProd.getTitle()}" required class="form-control" placeholder="tên sản phẩm" id="email">
    </div>
     <div class="form-group">
        <label for="name">gía sản phẩm:</label>
        <input name="price" type="number" value="${currentProd.getPrice()}" required class="form-control" placeholder="gía sản phẩm" id="email">
    </div>
     <div class="form-group">
        <label for="name">danh mục :</label>
        <select name="categoryCar" class="custom-select" required>
            <option>Chọn danh mục sản phẩm</option>
            <c:forEach items="${listCat}" var="cat">
                <option value="${cat.getId()}" ${cat.getId() == currentProd.getCategoryId() ? 'selected="selected"' : ''} >${cat.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="pwd">Mô tả</label>
        <textarea name="description"  id="description" class="form-control" placeholder="mô tả danh mục">
            <c:out value="${currentProd.getDescription()}"/>
        </textarea>
    </div>
   
    <div class="form-group">
        <label for="pwd">contact</label>
        <textarea name="contact"  id="description" class="form-control" placeholder="mô tả danh mục">
            <c:out value="${currentProd.getContact()}"/>
        </textarea>
    </div>
    <label for="pwd">hình ảnh</label>
    <c:if test="${not empty currentProd.getImage()}">
        <img src="${pageContext.request.contextPath}/upload/${currentProd.getImage()}" width="200" height="100"/>
    </c:if>
    <input type="file" name="image" t class="form-control" placeholder="mô tả danh mục" ></textarea>
    <input type="hidden" name="id" value="${currentProd.getId()}"/>
    <button type="submit" name="action" value="Update"  class="btn btn-success">Cập nhật</button>
</form>
</div>
<script>
    CKEDITOR.replace('description');
    CKEDITOR.replace('contact');
</script>

