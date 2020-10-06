<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0003
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/demo01" method="get">
   birth:<input type="date" name="birth">
    <button type="submit">提交</button>
</form>

<form action="${pageContext.request.contextPath}/demo02" method="get">
    birth:<input type="date" name="birth">
    <button type="submit">提交</button>
</form>

<form action="${pageContext.request.contextPath}/demo03" method="get">
    birth:<input type="date" name="birth">
    <button type="submit">提交</button>
</form>

<a href="/mvc03/rest/1500761.html"> restful风格 </a>

<br>
springmvc 乱码问题

<%--
        get不会乱码
        post才会乱码

        乱码解决方案和 javaweb的解决方案一样
--%>

<form action="${pageContext.request.contextPath}/code" method="post">
    username: <input  type="text" name="name"><br>
    <button type="submit">提交</button>
</form>
</body>
</html>
