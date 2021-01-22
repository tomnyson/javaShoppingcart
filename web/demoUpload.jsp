<!DOCTYPE >
<html>
<head>
<title>Upload files</title>
</head>
<body>
 
    <div style="padding:5px; color:red;font-style:italic;">
       ${errorMessage}
    </div>
    
    <h2>Upload Files</h2>
 
    <form method="post" action="uploadFile"
        enctype="multipart/form-data">
        Select file to upload:
        <input type="file" name="file" />
        <input type="submit" value="Upload" />
        ${request.message}
    </form>
    
</body>
</html>