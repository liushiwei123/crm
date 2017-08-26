<html>
<head>
    <#include "common.ftl" >
    <link rel="stylesheet" href="${ctx}/zTree_v3-3.5.28/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/role.js"></script>
    <script type="text/javascript" src="${ctx}/zTree_v3-3.5.28/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${ctx}/zTree_v3-3.5.28/js/jquery.ztree.excheck.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="角色管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/role/queryRolesByParms" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="roleName" width="200" align="center" >角色名称</th>
        
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openRoleAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加用户</a>
        <a href="javascript:openRoleModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteRole()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:openAddGrantDlg()" class="easyui-linkbutton" iconCls="icon-add" plain="true">授权</a>
    </div>
</div>


<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>角色名称：</td>
                <td><input type="text" id="roleName" name="roleName" class="easyui-validatebox" required="true"/> <font color="red">*</font></td>
               
            </tr>
            
            <input type="hidden" id="id" name="id" />
            <input type="hidden" id="oldRoleName" name="oldRoleName" />
          
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateRole()" id="submit" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeRoleDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>




<div id="grantDlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons02">
   <div>
   <ul id="treeDemo" class="ztree"></ul>
   </div>
   <input type="hidden" id="mIds" name="mIds" />
   <input type="hidden" id="rid" name="rid" />
  <div id="dlg-buttons02">
    <a href="javascript:addGrant()" id="submit" class="easyui-linkbutton" iconCls="icon-ok">授权</a>
    <a href="javascript:closeRoleDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div> 
</div>



</body>
</html>
