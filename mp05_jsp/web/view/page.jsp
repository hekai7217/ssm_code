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

    <!-- 最新版本的 Bootstrap 核心 CSS 文件
    网络引入样式
    -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous"></link>

</head>
<body>

    <a href="/mp/view/addStu.jsp" class="btn btn-default" role="button" style="margin-left: 10px;margin-top: 5px"> 添加 </a>

        <table border="1" cellspacing="0" class="table table-bordered" style="width: 500px;margin-left: 10px">

            <tr >
                <td>id</td>
                <td>name</td>
                <td>age</td>
                <td>info</td>
                <td>操作</td>
            </tr>

            <c:forEach var="stu" items="${page.records}">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <td>${stu.info}</td>
                    <td>
                        <a href="">修改</a>
                        <a href="/ssm/delStu.do?id=${stu.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="row">
        <div class="col-lg-12" style="width: 500px">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="index" begin="1" end="${pages}">
<%--                        当前的页面高亮  --%>
                        <c:if test="${page.current == index}">
                            <li class="active">
                            <a href="#">${index}</a>
                            </li>
                        </c:if>
<%--                        其他页面 可以点击 --%>
                        <c:if test="${page.current != index}">
                            <li>
                                <a href="/mp/page.do?current=${index}&pageSize=2">${index}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</body>
</html>
