<%-- 
    Document   : login
    Created on : Jan 11, 2021, 8:00:25 AM
    Author     : tomnyson
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="./style/styles.css">
    </head>
    <body>
        <div class="row">
            <div class="container">
                <form class="dangnhap" action="AuthController" method="post">

                    <c:if test="${not empty  message}">
                        <div class="alert alert-danger">
                            ${message}
                        </div>
                    </c:if>
                    <h1> Đăng ký</h1>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="email" required class="form-control" name="username" autocomplete="off" placeholder="username" id="email"> 
                    </div>
                    <div class="form-group">
                        <label for="email">password:</label>
                        <input type="password" required class="form-control" name="password" autocomplete="off" placeholder="password" id="email"> 
                    </div>
                    <button type="submit" name="action" value="dangky" class="btn btn-primary">Đăng ký tài khoản</button>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> ghi nhớ
                        </label>
                    </div>
                    <a href="login.jsp" class="dangky">Đăng </a>
                    <a href="reset-password.jsp" class="quenmk">quên mật khẩu</a>

                </form>
            </div>
        </div>
    </body>
</html>
