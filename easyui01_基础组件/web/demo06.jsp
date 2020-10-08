<%--
  Created by IntelliJ IDEA.
  User: scott
  Date: 0008
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>

    <title>Title</title>


    <%--
            导入资源的路径解决方案:
             01  直接从项目的 访问路径开始
                    /easy/static/资源
                         /easy/static/themes/default/easyui.css
                         /easy/static/js/jquery.min.js
             02 设置根路径
                  2.1  拿到项目访问的根目录
                  2.2 设置项目的访问的根目录
                        <base href="<%=basePath %>"/>
                       直接冲项目的根目录开始: http://localhost:8080/easy/
    --%>
    <base href="<%=basePath%>"/>
    <%--引入easyUI的资源--%>
    <%--  引入 easyui的css   --%>
    <link rel="stylesheet" type="text/css" href="static/themes/default/easyui.css">
    <%--  引入 easyui的icon 的图标样式    --%>
    <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
    <%--   引入 jq的js文件   --%>
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <%--   引入 easy 的js文件  一定要先导入 jq     --%>
    <script type="text/javascript" src="static/js/jquery.easyui.min.js"></script>

</head>
<body>

<script>

    $(function () {

        // 拿到节点
        // $("#myTree").tree({
        //     // 点击事件
        //     onClick:function (node) {
        //         // 节点
        //         console.log(node);
        //     }
        // })


        $("#btn").click(function () {

            // 获取选中的节点
            var nodes =$("#myTree").tree('getChecked', ['checked','indeterminate']);
            console.log(nodes);
        });

    });

</script>

<%--声明树状的ul容器--%>
<ul id="myTree" class="easyui-tree" data-options="checkbox:true,lines:true">
    <%--声明一级菜单--%>
    <li>
        <span>超市购物网站</span>
        <%--声明二级菜单细信息--%>
        <ul>
            <li>天猫超市</li>
            <li>京东超市</li>
            <li>永辉超市</li>
        </ul>
    </li>
    <%--声明一级菜单信息--%>
    <li>
        <span>电器购物网站</span>
        <%--声明二级菜单信息--%>
        <ul>
            <li>京东</li>
            <li>苏宁</li>
            <li>国美</li>
        </ul>
    </li>
    <%--普通一级菜单--%>
    <li><span>淘宝网</span></li>
</ul>

<button id="btn">获取选中的节点</button>

</body>
</html>
