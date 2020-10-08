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

</script>

<%--
     closable:true 是可以关闭
     iconCls 图标
--%>

<script>

    $(function () {

        $("#btn").click(function () {


            // 拿到 tabs
            $("#tt").tabs('add',{
                iconCls:'icon-ok',
                closable:true,
                title:'新增面板',
                content:'hello content'
            })

        });


        $("#btnSelect").click(function () {
            // 拿到 tabs
            // 选中一个面板   select方法  通过 title 或者index 选中
            $("#tt").tabs('select','Tab3');
        });

    });

</script>

<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
    <div title="Tab1" style="padding:20px;display:none;"> tab1</div>
    <div title="Tab2" data-options="iconCls:'icon-ok',closable:true" style="overflow:auto;padding:20px;display:none;"> tab2</div>
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;"> tab3</div>
</div>

<button id="btn">添加一个面板</button>
<button id="btnSelect">设置选中的面板</button>

</body>
</html>
