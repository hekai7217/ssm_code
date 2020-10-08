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

        // tree 菜单  和 tabs 进行联动
        // 01 拿到 tree 设置onclick 事件
        $("#myTree").tree({
            onClick:function(node){
                // 02 判断 如果菜单是父节点  可以切换 tab 选项卡
                var cs = node.children;
                if (!cs){
                    // 03  判断tabs 是否存在选项卡 如果存在 选中
                    var flag = $("#tabs").tabs('exists',node.text);

                    if (flag){
                        // 设置选中的
                        $("#tabs").tabs('select',node.text);
                    }else{
                        //  如果不存在 添加
                        $("#tabs").tabs('add',{
                            iconCls:'icon-ok',
                            closable:true,
                            title:node.text,
                            content:node.text
                        })
                    }
                }
            }
        });
    });
</script>

<%--综合使用 --%>

<div id="cc" class="easyui-layout" style="width:800px;height:700px;">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true,collapsible:false" style="height:100px;"></div>
    <%--    <div data-options="region:'east',title:'East',split:true" style="width:100px;"></div>--%>
    <div data-options="region:'west',title:'菜单',split:true,collapsible:false,disabled:true" style="width:200px; ">

        <%--声明树状的ul容器--%>
        <ul id="myTree" class="easyui-tree">
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


    </div>
    <div data-options="region:'center',title:'内容区域'" style="padding:5px;background:#eee;">

        <div id="tabs" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
            <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;"> tab2</div>
            <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
                tab3
            </div>
        </div>

    </div>
</div>

</body>
</html>
