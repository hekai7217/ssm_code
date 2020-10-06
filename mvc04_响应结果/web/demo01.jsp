<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0003
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/resp01.do" method="get">
    username: <input  type="text" name="name"><br>
    <button type="submit">提交</button>
</form>
</body>
</html>
