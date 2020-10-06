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

<fieldset>

<%--
        pageContext  jsp 中的域对象
        request     通过 pageContext 获取req对象
        contextPath  访问项目的路径  /mvc03
   ${pageContext.request.contextPath} 动态 获取 项目访问路径 /mvc03
--%>


    <legend> 原始方式request.getParameter()</legend>
    <form action="${pageContext.request.contextPath}/data01" method="get">
        账号: <input name="username"><br>
        年龄: <input name="age"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>

    <legend> 直接参数绑定</legend>
    <form action="${pageContext.request.contextPath}/data02" method="get">
        账号: <input name="username"><br>
        年龄: <input name="age"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>


<fieldset>

    <legend> 直接参数绑定2</legend>
    <form action="${pageContext.request.contextPath}/data03" method="get">
        账号: <input name="name"><br>
        年龄: <input name="ages"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>接收数组或集合</legend>
    <form action="${pageContext.request.contextPath}/data04" method="post">
        账号: <input name="name"><br>
        年龄: <input name="age"><br>
        爱好: <input type="checkbox" name="hobbys" value="java">java
        <input type="checkbox" name="hobbys" value="html">html<br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>直接把表单绑定对象</legend>
    <form action="${pageContext.request.contextPath}/data05" method="post">
        username: <input  type="text" name="username"><br>
        password: <input type="password" name="password"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>

<fieldset>
    <legend>接受参数封装成Map集合</legend>
    <form action="${pageContext.request.contextPath}/data06" method="post">
        账号: <input type="text" name="username"><br>
        密码: <input  type="password" name="password"><br>
        <button type="submit">提交</button>
    </form>
</fieldset>
</body>
</html>
