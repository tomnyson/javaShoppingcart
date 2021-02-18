<%-- 
    Document   : dashboard
    Created on : Jan 29, 2021, 5:01:09 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="../style/admin.css">
        <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">ADMIN</a>
            <div>
                <span  href="#">Wellcome: admin</span> |
                <a href="#">logout</a>
            </div>

        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col col-md-2">
                    <ul class="list-group">
                        <li class="list-group-item ${tabSelected == 'danhmuc' ? 'active-tab' : ''}"><a href="${pageContext.request.contextPath}/admin/category"> Danh Mục</a></li>
                        <li class="list-group-item ${tabSelected == 'sanpham' ? 'active-tab' : ''}"><a href="${pageContext.request.contextPath}/admin/product">Sản phẩm</a></li>
                        <li class="list-group-item ${tabSelected == 'user' ? 'active-tab' : ''}"><a href="${pageContext.request.contextPath}/admin/user">Users</a></li>
                        <li class="list-group-item ${tabSelected == 'order' ? 'active-tab' : ''}"><a href="${pageContext.request.contextPath}/admin/order">Orders</a></li>
                    </ul>
                </div>
                <div class="col col-md-8">
                    <c:if test="${sessionScope.message != null}">
                        <div class="alert alert-success alert-dismissible" id="myAlert">
                            <button type="button" class="close">&times;</button>
                            <c:out value="${sessionScope.message}"/>
                        </div>
                    </c:if>
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                            <c:choose>
                                <c:when test="${sessionScope.view != null}">
                                    <c:import url="${sessionScope.view}"/>
                                </c:when>
                                <c:otherwise>
                                    <c:import url="include/danhmuc.jsp"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <c:import url="../include/footer.jsp"/>
            </div>
            <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
            <script>
                $(document).ready(function () {
                    $(".close").click(function () {
                        $("#myAlert").alert("close");
                <c:remove var="message"/>
                    });
                });
            </script>
    </body>
</html>
