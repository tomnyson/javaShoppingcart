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
       <link rel="stylesheet" href="./style/styles.css">
    </head>
    <body>
        
       	<form class="dangnhap" action="AuthController" method="post">
              <h1>Đăng Nhập</h1>
            <input type="text" name="username" placeholder="nhập tài khoản"/> </br>
	<input type="password" name="password" placeholder="nhập mật "/><br>
        <p class="error">${message}</p>
	<input type="submit" name="dangnhap" value="đăng nhập"/>
       
 	</form>
    </body>
</html>
