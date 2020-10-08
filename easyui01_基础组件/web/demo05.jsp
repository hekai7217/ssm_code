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

<%--accordion组件完成 折叠效果--%>
<div id="aa" class="easyui-accordion"
     data-options="border:false,animate:false,selected:2" style="width:300px;height:200px;">
    <%--折叠区域--%>
    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <h3 style="color:#0099FF;">Accordion for jQuery</h3>
        <p>Accordion is a part of easyui framework for jQuery.
            It lets you define your accordion component on web page more easily.</p>
    </div>
    <%--折叠区域--%>
    <div title="放松休闲区" data-options="iconCls:'icon-reload'" style="padding:10px;">
        <sapn>打麻将</sapn>
        <br>
        <sapn>斗地主</sapn>
        <br>
        <sapn>下象棋</sapn>
        <br>
        <sapn>写代码</sapn>

    </div>
    <%--折叠区域--%>
    <div title="Title3">
        content3
    </div>
</div>

</body>
</html>
