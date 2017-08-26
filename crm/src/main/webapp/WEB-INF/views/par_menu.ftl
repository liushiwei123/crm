<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/menu.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="父级菜单管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/menu/queryMenuByParams?pid=10000" fit="true" toolbar="#tb" singleSelect=true>
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="menuName" width="200" align="center" >菜单名称</th>
        <th field="menuTitle" width="50" align="center">菜单标题</th>
        <th field="menuUrl" width="50" align="center" >菜单url</th>
        <th field="createDate" width="100" align="center">创建时间</th>
        <th field="updateDate" width="200" align="center" >更新时间</th>
         <th field="op" width="200" align="center" formatter="formatterOp" >操作</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openMenuAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openMenuModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteMenu()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
         菜单名称： <input type="text" id="s_menuName" size="20" onkeydown="if(event.keyCode==13) searchMenu()"/>
        <a href="javascript:searchMenu()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>菜单名称：</td>
                <td><input type="text" id="menuName" name="menuName" class="easyui-validatebox" required="true"/> <font color="red">*</font></td>
                <td>    </td>
                <td>菜单标题：</td>
                <td><input type="text" id="menuTitle" name="menuTitle" /></td>
            </tr>
            <input type="hidden" id="id" name="id" />
            <input type="hidden" id="menuUrl" name="menuUrl" value="#" />
            <input type="hidden" id="pid" name="pid" value="10000" />
          	<input type="hidden" id="oldMenuName" name="oldMenuName"  />
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateMenu()" id="submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeMenuDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>



</body>
</html>
