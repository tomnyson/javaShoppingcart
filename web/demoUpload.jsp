<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form action="home" method="POST" enctype="multipart/form-data">
                <h1>Thêm sản phẩm mới</h1>
                <div class="row">
                    <div class="col col-md-6">
                        <div class="form-group">
                            <label for="email">Tên sản phẩm:</label>
                            <input type="number" class="form-control" placeholder="tên sản phẩm" id="email">
                        </div>
                        <div class="form-group">
                            <label for="pwd">giá bán</label>
                            <input type="" class="form-control" placeholder="giá bán" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Mô tả</label>
                            <textarea name="description" class="form-control" placeholder="giá bán" id="pwd"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Liên hệ</label>
                            <textarea name="contact" class="form-control" placeholder="giá bán" id="pwd"></textarea>
                        </div>
                    </div>
                    <div class="col col-md-6">
                        <div class="form-group">
                            <label for="email">Mình ảnh chính</label>
                            <input type="file" name="mainImage" class="form-control" placeholder="tên sản phẩm" id="email">
                        </div>
                        <div class="form-group">
                            <label for="email">hình 1 </label>
                            <input type="file" name="file" class="form-control" placeholder="tên sản phẩm" id="email">
                        </div>
                        <div class="form-group">
                            <label for="email">hình 2 </label>
                            <input type="file" name="file" class="form-control" placeholder="tên sản phẩm" id="email">
                        </div>
                    </div>
                </div>
                <button name="action" value="addproduct" class="btn btn-success" type="submit">Thêm sản phẩm</button>
            </form>
        </div>
    </div>
    <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
    <script>
        CKEDITOR.replace('description');
        CKEDITOR.replace('contact');
    </script>
</body>
</html>