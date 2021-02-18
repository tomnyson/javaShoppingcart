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
        <a class="nav-link active" data-toggle="pill" href="#menu1">Edit User</a>
    </li>
</ul>

<form action="user" method="post">
    <div class="form-group">
        <label for="name">UserName:</label>
        <input name="email" readonly type="text" value="${currentUser.getUsername()}" required class="form-control" placeholder="tên danh mục" id="email">
    </div>
    <div class="form-group">
        <label for="name">password:</label>
        <input name="password:" type="password" value="${currentUser.getPassword()}" required class="form-control" placeholder="tên danh mục" id="email">
    </div>
      <div class="form-group">
        <label for="name">Role:</label>
        <select name="role" class="custom-select" required>
            <option>Chọn quyền</option>
                <option value="admin" ${"admin" == currentUser.getRole() ? 'selected="selected"' : ''} >admin</option>
                <option value="user" ${"user" == currentUser.getRole() ? 'selected="selected"' : ''} >user</option>
        </select>
    </div>
    <input type="hidden" name="id" value="${currentUser.getId()}"/>
    <button type="submit" name="action" value="Update"  class="btn btn-success">Cập nhật</button>
</form>
</div>
<script>
   CKEDITOR.replace('description');
</script>

