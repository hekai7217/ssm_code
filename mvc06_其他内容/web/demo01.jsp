<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0006
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/mvc06/image" method="post" enctype="multipart/form-data">
    name:<input type="text" name="name"><br>
    img:<input type="file" name="img"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
