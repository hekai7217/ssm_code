<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0006
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous"></link>

</head>
<body>

    <a href="/ssm/view/addStu.jsp" class="btn btn-default" role="button"> 添加 </a>

    <table border="1" cellspacing="0" class="table table-bordered" style="width: 500px">

        <tr >
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>info</td>
            <td>操作</td>
        </tr>

        <c:forEach var="stu" items="${stus}">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
                <td>${stu.info}</td>
                <td>
                    <a href="">修改</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/ssm/delStu.do?id=${stu.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>


<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
