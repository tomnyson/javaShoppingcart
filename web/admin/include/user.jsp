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
        <a class="nav-link" data-toggle="pill" href="#menu1">Thêm User</a>
    </li>
</ul>
<div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">email</th>
                    <th scope="col">role</th>
                    <th scope="col">action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listUser}" var="user">
                    <tr>
                        <td><c:out value="${user.getId()}"/></td>
                        <td>${user.getUsername()}</td>
                        <td class="short-text">${user.getRole()}</td>
                        <td>
                            <form action="category" method="post">
                                <input type="hidden" name="id" value="${cat.getId()}"/>
                                <a href="?email=${user.getUsername()}">Edit</a>
                                <button type="submit" name="action"  value="Delete" class="btn btn-danger">X</button></td>
                        </form>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
        <form action="user" method="post">
            <div class="form-group">
                <label for="name">email:</label>
                <input name="email" type="email" required class="form-control" placeholder="username" id="email">
            </div>
            <div class="form-group">
                <label for="pwd">password</label>
                <input name="password" type="password" required class="form-control" placeholder="password" id="email">
            </div>
            <div class="form-group">
                <label for="pwd">confirm password</label>
                <input name="passwordconfirm" type="password" required class="form-control" placeholder="repeat password" id="email">
            </div>
            <div class="form-group">
                <label for="name">Role :</label>
                <select name="role" class="custom-select" required>
                    <option selected>Chọn quyền user</option>
                    <option value="admin">admin</option>
                    <option value="user">user</option>
                </select>
            </div>
            <button type="submit" name="action" value="Add"  class="btn btn-success">Thêm</button>
        </form>
    </div>
</div>
</div>
