var zNodesObj;
$(function(){
	// 失去焦点
	$("#roleName").blur(function(){
		var roleName=$("#roleName").val();
		var oldRoleName=$("#oldRoleName").val();
		
		if(roleName !=oldRoleName){
			// 发送ajax 执行用户名唯一校验
			$.ajax({
				type:"post",
				url:ctx+"/role/queryRoleByRoleName",
				data:"roleName="+roleName,
				dataType:"json",
				success:function(data){
					if(data.resultCode==200){
						$("#submit").linkbutton("enable");
					}else{
						$.messager.alert("来自crm",data.msg);
						$("#submit").linkbutton("disable");
					}
				}
			})
			
		}
	})
	
	
	
	$("#roleName").focus(function(){
		$("#submit").linkbutton("enable");
	})
	
	
	//loadMenuData();//加载资源菜单
	
})


function loadMenuData(){
	$.ajax({
		type:"post",
		url:ctx+"/menu/queryAllMenus02",
		data:"rid="+$("#rid").val(),
		dataType:"json",
		success:function(data){
			if(null!=data&&data.length>0){
				var setting = {
						check: {
							enable: true,
							chkStyle: "checkbox",
							chkboxType: { "Y": "ps", "N": "ps" }
						},
						callback: {
							onCheck: zTreeOnCheck
						},
						/* view: {
							showLine: false
						}, */
						data: {
							simpleData: {
								enable: true
							}
						}
					};
				zNodesObj=$.fn.zTree.init($("#treeDemo"), setting, data);	
				
				
			}
		}
	})
	
}



function openRoleAddDialog(){
	openDlg("dlg", "保存角色");
}

function closeRoleDialog(){
	closeDlg("dlg", "fm");
}

function saveOrUpdateRole(){
	saveOrUpdateData("fm", ctx+"/role/saveOrUpdateRole", "dlg", searchRole);
	$("#dg").datagrid("reload");
}



function openRoleModifyDialog(){
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行修改!");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条记录进行修改!");
		return;
	}
	
	$("#fm").form("load",rows[0]);
	$("#oldRoleName").val(rows[0].roleName);
	openDlg("dlg", "更新角色");
}

function searchRole(){
	$("#dg").datagrid("reload");
}

function deleteRole(){
	deleteData("dg", ctx+"/role/deleteRole", searchRole);
	
}



function openAddGrantDlg(){
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行授权!");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条记录进行授权!");
		return;
	}
	
	$("#rid").val(rows[0].id);
	
	
	loadMenuData();//加载资源菜单
	
	openDlg("grantDlg", "添加授权");
}

function zTreeOnCheck(event, treeId, treeNode) {
	var nodes= zNodesObj.getCheckedNodes(true);
	if(null!=nodes&&nodes.length>0){
		var menuIds="mIds=";
		for(var i=0;i<nodes.length;i++){
			if(i<=nodes.length-2){
				menuIds=menuIds+nodes[i].id+"&mIds=";
			}else{
				menuIds=menuIds+nodes[i].id;
			}
		}
		console.log(menuIds);
		$("#mIds").val(menuIds);
		
		
	}
}


function  addGrant(){
	
	// 执行ajax 提交 完成授权操作
	$.ajax({
		type:"post",
		url:ctx+"/role/updateRoleHasGrant",
		data:"rid="+$("#rid").val()+"&"+$("#mIds").val(),
		dataType:"json",
		success:function(data){
			if(data.resultCode==200){
				$.messager.alert("来自crm","授权成功!");
				$("#grantDlg").dialog("close");
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
		
		
		
	})
	
}

