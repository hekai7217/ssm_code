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
<%--
--%>

<script>

</script>

<%--
    easyui-textbox 文本框
    data-options 数据的设置
        iconCls   图标

    总结:
      01  easy 的组件都是可以通过标签( html ) 和js 进行初始化

      02  easy 组件的的操作
          2.1  如果设置值  $('id').组件的名称({设置属性 })
                  $("#pb").passwordbox({
                    width:200,
                    height:40,
                    //组件的事件操作
                    onChange:function (newValue,oldValue) {
                        console.log(newValue + ":" + oldValue);
                    }
                  }
                  $("#p2").panel({
                      width: 300,
                      height: 100
                  }
         2.2  组件的方法的操作
               // 如有只有方法名称 获取值
               $('id').组件的名称('方法名称')
               设置值
               $('id').组件的名称('方法名称',设置值)
               方法必须是存在的 需要查询api
               $("#nameId").textbox('setText','hello');
--%>

<script>
    $(function () {
        $("#pb").passwordbox({
            width:200,
            height:40,
            prompt:'银行卡密码',
            label:'密码:',
            labelWidth:50,
            labelPosition:'before'
        });

        $("#nameId").textbox({
            // 事件   onchange 事件
            // onChange:function (newValue,oldValue) {
            //     console.log(newValue + ":" + oldValue);
            // }
        });
        // 方法
        $("#nameId").textbox('setText','hello');
    })
</script>

<input id="nameId" class="easyui-textbox" name="xxx" data-options="iconCls:'icon-search',width:300,height:40,
prompt:'输入你搜索的内容',label:'用户名:',labelWidth:60,labelPosition:'before'">

<br>

<%-- 密码框 --%>
<input id="pb" type="text" class="easyui-passwordbox">



</body>
</html>
