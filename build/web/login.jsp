<%-- 
    Document   : login
    Created on : Jan 11, 2021, 8:00:25 AM
    Author     : tomnyson
--%>

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
                    <h1>Đăng Nhập</h1>
                    <div class="alert alert-danger">
                        <%
                          out.println(session.getAttribute("message"));
                        %>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="text" class="form-control" name="username" placeholder="username" id="email"> 
                    </div>
                    <div class="form-group">
                        <label for="email">password:</label>
                        <input type="password" class="form-control" name="password" placeholder="username" id="email"> 
                    </div>
                    <button type="submit" name="action" value="dangnhap" class="btn btn-primary">Đăng Nhập</button>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> ghi nhớ
                        </label>
                    </div>
                    <a href="register.jsp" class="dangky">Đăng ký tài khoản</a>
                    <a href="reset-password.jsp" class="quenmk">quên mật khẩu</a>
                    <%
                          session.removeAttribute("message");
                        %>
                </form>
            </div>
        </div>
    </body>
</html>
