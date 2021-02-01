<%-- 
    Document   : danhmuc
    Created on : Jan 29, 2021, 5:08:22 PM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>
                        <button type="button" class="btn btn-primary">edit</button>
                        <button type="button" class="btn btn-danger">X</button></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
        <form action="">
            <div class="form-group">
                <label for="email">tên danh mục:</label>
                <input type="text" class="form-control" placeholder="tên danh mục" id="email">
            </div>
            <div class="form-group">
                <label for="pwd">Mô tả</label>
                <textarea class="form-control" placeholder="mô tả danh mục" id="pwd"></textarea>
            </div>
                <label for="pwd">hình ảnh</label>
                <input type="file" class="form-control" placeholder="mô tả danh mục" id="pwd"></textarea>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
</div>


