<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Upload Page</title>
</head>
<body>
<h2>Upload Page</h2>
<p>Upload the <b>ZIP</b> file and save only the <b>.png</b> image file contained within it</p>
<c:if test="${not empty messages}">
    <ul style="color: green;"><li>${messages}</li>
    </ul>
</c:if>

<form action="zip-upload" method="post" enctype="multipart/form-data">
    Select file to upload: <input type="file" name="file" required>
    <input type="submit" value="Upload">
</form>
<hr>
<h2>Uploaded Files</h2>
<ul>
    <c:forEach var="fileName" items="${uploadedFiles}">
        <li><a href="view?fileName=${fileName}">${fileName}</a></li>
    </c:forEach>
</ul>
</body>
</html>
