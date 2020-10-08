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
<%-- 项目访问的根路径 --%>
<%= basePath%>

<%--
        easyui的使用步骤:
        01  导入 easy的资源 /js/css
        02  引入 easy的组件

        面板:
          class  组件的选择都是统一easy的css 选择组件
          title  头部的标题
          style   样式
          data-options: 数据设置  可以给他设置 基本的样式
                iconCls  面板的图标
                closable  是否关闭 面板的按钮 true 有 false 没有关闭按钮
                collapsible  可折叠  true 可以折叠
                minimizable   最小
                maximizable   最大

        easy的组件都可以用 html 进行初始化  也可以使用 js 代码进行初始化

--%>

<script>

    $(function () {

        // js 实现组件的初始化
        // 拿到 标签
        $("#p2").panel({
            width: 300,
            height: 100,
            title: '我的面板2',
            iconCls: 'icon-remove',
            border: true
        });

    });

</script>


<div id="p1" class="easyui-panel" title="我的面板"
     style="width:300px;height:140px;padding:10px;background:yellow;"
     data-options="iconCls:'icon-ok',closable:false,
        collapsible:false,minimizable:false,maximizable:false">
    <p>panel content.</p>
    <p>panel content.</p>
</div>

<div id="p2" class="easyui-panel">
    <p>panel content.</p>
    <p>panel content.</p>
</div>

</body>
</html>
