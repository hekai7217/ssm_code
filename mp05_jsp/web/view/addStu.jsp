<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0006
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous"></link>

</head>
<body>
<form action="/mp/addStu.do" method="get">

    <div  class="row">

        <div class="input-group" style="width: 300px;margin-top: 20px;margin-left: 50px">
            <span class="input-group-addon">用户名:</span>
            <input type="text" name="name" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
        </div>

        <div class="input-group" style="width: 300px;margin-top: 20px;margin-left: 50px">
            <span class="input-group-addon">年龄:</span>
            <input type="text" name="age" class="form-control" placeholder="age" aria-describedby="basic-addon1">
        </div>

        <div class="input-group" style="width: 300px;margin-top: 20px;margin-left: 50px">
            <span class="input-group-addon">介绍:</span>
            <input type="text" name="info" class="form-control" placeholder="info" aria-describedby="basic-addon1">
        </div>

    </div>

    <input class="btn btn-default" type="submit" value="添加" style="width: 80px;margin-top: 20px;margin-left: 130px">

</form>
</body>
</html>
