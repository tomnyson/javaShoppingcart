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
                    <h1> Quên mật khẩu</h1>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="email" class="form-control" placeholder="Nhập email của bạn" required="true" id="email"> 
                    </div>
                    <button type="submit"  class="btn btn-primary">Gửi email</button>
                    <a href="register.jsp" class="dangky">Đăng ký tài khoản</a>
                    <a href="reset-password.jsp" class="quenmk">quên mật khẩu</a>

                </form>
            </div>
        </div>
    </body>
</html>
