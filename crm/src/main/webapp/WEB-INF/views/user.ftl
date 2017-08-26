<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/user.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="用户管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/user/queryUserInfoByParams" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="userName" width="200" align="center" >用户名</th>
        <th field="trueName" width="50" align="center">真实名称</th>
        <th field="email" width="50" align="center" >邮箱</th>
        <th field="phone" width="200" align="center">联系电话</th>
        <th field="roleName" width="100" align="center">角色名称</th>
        <th field="createDate" width="100" align="center">创建时间</th>
        <th field="updateDate" width="200" align="center" >更新时间</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加用户</a>
        <a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
         用户名称： <input type="text" id="s_userName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
         邮箱： <input type="text" id="s_email" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
         手机号：<input type="text" id="s_phone" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
        <a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名称：</td>
                <td><input type="text" id="userName" name="userName" class="easyui-validatebox" required="true"/> <font color="red">*</font></td>
                <td>    </td>
                <td>真实名称</td>
                <td><input type="text" id="trueName" name="trueName" /></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input type="text" id="email" name="email" /></td>
                <td>    </td>
                <td>手机号：</td>
                <td><input type="text" id="phone" name="phone" /></td>
            </tr>
            
            <tr>
                <td>角色：</td>
                <td><input class="easyui-combobox" id="roleId" name="roleId" data-options="panelHeight:'auto',editable:false,valueField:'id',textField:'roleName',url:'${ctx}/role/queryRoles'"/></td>
            </tr>
           
            <input type="hidden" id="id" name="id" />
            <input type="hidden" id="oldUserName" name="oldUserName" />
          
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateUser()" id="submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>



</body>
</html>
