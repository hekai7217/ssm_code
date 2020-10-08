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
        $("#btn1").click(function () {
             // 获取文本的值
            var text = $("#cc").combobox('getText');
            var value = $("#cc").combobox('getValue');
            console.log(text);
            console.log(value);
        });

        $(function () {
            $("#dd").datebox({
                formatter:function (date) {  // 格式化的方法  显示数据
                    var y = date.getFullYear();
                    var m = date.getMonth()+1;
                    var d = date.getDate();
                    return y+"-"+m+"-"+d;  // 格式化后显示在 输入框中
                },
                parser:function (s) {   // 把 y+"-"+m+"-"+d 转成 date 才可以选择指定时间
                    var t = Date.parse(s);
                    if (!isNaN(t)){
                        return new Date(t);
                    } else {
                        return new Date();
                    }
                }
            })
        })
    })

</script>

<select id="cc" class="easyui-combobox" name="dept" style="width:200px;"
    data-options="panelHeight:'auto'">
    <option value="aa">aitem1</option>
    <option value="bb">bitem2</option>
    <option>bitem3</option>
    <option>ditem4</option>
    <option>eitem5</option>
</select>

<button id="btn1">获取值</button>


<br>
<%--datebox日期框--%>
<input id="dd" type="text" class="easyui-datebox"
       data-options="editable:false,currentText:'今天',closeText:'关闭'">

</body>
</html>
