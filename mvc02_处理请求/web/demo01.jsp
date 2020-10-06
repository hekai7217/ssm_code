<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0003
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="/mvc02/req01.do"> req01 访问</a>
    <br>

    <a href="/mvc02/user/req02.do"> req02 访问</a>

    <br>
    请求的限制:
    <form action="/mvc02/req03.do" method="get">
        <input type="submit" value="测试1">
    </form>
    <br>
    请求的限制:
    <form action="/mvc02/req03.do" method="post">
        <input type="submit" value="测试2">
    </form>

    请求参数的限制限制:
    <form action="/mvc02/req04.do" method="post">

       name":<input type="text" name="name" >
        pwd :<input type="text" name="password" >

        <input type="submit" value="测试3">
    </form>
</body>
</html>
