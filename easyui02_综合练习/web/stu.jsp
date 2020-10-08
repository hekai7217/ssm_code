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

    // 初始化
    $(function () {
        // 初始化的的时候
        // dataGrid 会给  queryAll.do 发送请求   参数是  page = 1  rows = 2 初始化发送数据请求

        // 服务器回写数据有严格的要求
        /**
         *  数据条目的总数:  可以进行分页的计算
         *  total:10
         *   {"name":"Name","value":"Bill Smith","group":"ID Settings","editor":"text"},
         *   每一行展示的数据
         *   这个数据格式是json 对象,服务器回写数据一定要是这个格式
         *
         * {"total":10,"rows":[
                {"name":"Name","value":"Bill Smith","group":"ID Settings","editor":"text"},
                {"name":"Address","value":"","group":"ID Settings","editor":"text"},
                {"name":"SSN","value":"123-456-7890","group":"ID Settings","editor":"text"},
             ]
           }
         */
        // datagrid 的初始化
        $("#stuDataGrid").datagrid({
            // 设置属性
            url: 'queryAll.do', // 获取数据 的地址url
            pagination: true, // 分页工具栏
            rownumbers: true, // 显示行号
            pageNumber: 1, // 初始化分页的页面
            pageSize: 2,  // 页面大小
            pageList: [2, 4, 6], // 页面大小的下拉框
            // 设置工具栏
            toolbar: '#toolbar',
            // 初始化的请求
            // 配置数据展示
            // {"id":"6","name":"莫少俊","age":"18","info":"好好学习"}
            columns: [[
                // 一列的数据  列数是服务器返回的 每一行的数据决定
                // title 列的名称
                // field 列的字段名 (一行数据的json 格式的key字段值)
                {field:'aaa',checkbox:true},
                {field: 'id', title: '学生编号', width: 80},
                {field: 'name', title: '姓名', width: 80},
                {field: 'age', title: '年龄', width: 80},
                {field: 'info', title: '说明', width: 80}
            ]]
        })
    });

    // 添加
    $(function () {

        $("#addBtn").click(function () {
            //展示dialog
            $("#addStuDialog").dialog('open');
        });

        // form 提交数据
        $("#addForm").click(function () {

            // 直接表单提交数据
            $("#addStuForm").form(
                // 提交的方法
                'submit',{
                    url:'addStu.do',
                    success:function (data) {
                        // 请求成功
                        // 把json字符串转对象
                        var d = JSON.parse(data);
                        if (d.success){ // 成功
                            // 提示
                            $.messager.alert("提示",d.msg,"info");
                            // dialog 关闭
                            $("#addStuDialog").dialog('close');
                            // datagrid 数据刷新
                            $("#stuDataGrid").datagrid('reload');
                            // 表单的数据清理下
                            // reset  开始的状态
                            // clear  清空
                            $("#addStuForm").form('reset');
                        }

                    }
             })
        });
    });

    // 修改的
    $(function () {

        $("#editBtn").click(function () {

            var trs = $("#stuDataGrid").datagrid('getChecked');
            if (trs.length >1 ){
                $.messager.alert("提示","不能批量删除","info");
            }else if(trs.length == 1){
                // 数据回显
                $("#updateStuDialog").form('load',trs[0]);
                //展示dialog
                $("#updateStuDialog").dialog('open');

            }else{
                $.messager.alert("提示","敢不敢选择一个stu编辑","info");
            }
        });

        // form 更新数据
        $("#updateForm").click(function () {

            // 直接表单提交数据
            $("#updateStuForm").form(
                // 提交的方法
                'submit',{
                    url:'updateStu.do',
                    success:function (data) {
                        // 请求成功
                        // 把json字符串转对象
                        var d = JSON.parse(data);
                        if (d.success){ // 成功
                            // 提示
                            $.messager.alert("提示",d.msg,"info");
                            // dialog 关闭
                            $("#updateStuDialog").dialog('close');
                            // datagrid 数据刷新
                            $("#stuDataGrid").datagrid('reload');
                            // 表单的数据清理下
                            // reset  开始的状态
                            // clear  清空
                            $("#addStuForm").form('reset');
                        }
                    }
                })
        });
    });

    $(function () {

        $("#removeBtn").click(function(){
            // 01 拿到 id
            // 01 判断是否有选中编辑学生
            var trs = $("#stuDataGrid").datagrid('getChecked');
            if (trs.length >1 ){
                $.messager.alert("提示","不能批量删除","info");
            }else if(trs.length == 1){
                // 02 发送ajax 请求
                $.post("delStu.do",{
                    id:trs[0].id
                },
                    function (data) {
                        console.log(data)
                    if (data.success){ // 成功
                        // 03 数据处理
                        // 提示
                        $.messager.alert("提示",data.msg,"info");
                        // datagrid 数据刷新
                        $("#stuDataGrid").datagrid('reload');
                    }
                },"json");

            }else{
                $.messager.alert("提示","敢不敢选择一个stu编辑","info");
            }


        });
    });

</script>

<%-- 修改的学生对话框--%>
<div id="updateStuDialog" class="easyui-dialog" title="修改学生" style="width:400px;height:240px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">

    <form id="updateStuForm" method="post">

<%--        隐藏 id 提交到服务器 --%>
        <input type="hidden" name="id">
        <div style="text-align: center;margin-top: 15px">
            <label for="name">姓名:</label>
            <input class="easyui-textbox" type="text" name="name"/>
        </div>

        <div style="text-align: center;margin-top: 15px">
            <label for="name">年龄:</label>
            <input class="easyui-textbox" type="text" name="age" />
        </div>

        <div style="text-align: center;margin-top: 15px">
            <label for="name">说明:</label>
            <input class="easyui-textbox" type="text" name="info" />
        </div>

        <div style="text-align: center;margin-top: 15px">
            <a  id="updateForm" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">修改学生</a>
        </div>
    </form>

</div>

<%--添加学生的对话框--%>
<div id="addStuDialog" class="easyui-dialog" title="添加学生" style="width:400px;height:240px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">

    <form id="addStuForm" method="post">
        <div style="text-align: center;margin-top: 15px">
            <label for="name">姓名:</label>
            <input class="easyui-textbox" type="text" name="name"/>
        </div>

        <div style="text-align: center;margin-top: 15px">
            <label for="name">年龄:</label>
            <input class="easyui-textbox" type="text" name="age" />
        </div>

        <div style="text-align: center;margin-top: 15px">
            <label for="name">说明:</label>
            <input class="easyui-textbox" type="text" name="info" />
        </div>

        <div style="text-align: center;margin-top: 15px">
            <a  id="addForm" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加学生</a>
        </div>
    </form>
</div>

<div id="p" class="easyui-panel" title="学生管理信息平台"
     style="width:600px;height:340px;padding:10px;background:#fafafa;"
     data-options="closable:false,
    collapsible:false,minimizable:false,maximizable:false">
    <table id="stuDataGrid">
    </table>
</div>

<div id="toolbar" style="padding:5px 0;">
    <a id="addBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加学生</a>
    <a id="editBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
    <a id="removeBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>
</body>
</html>
