$(function(){
	// 失去焦点
	$("#userName").blur(function(){
		var userName=$("#userName").val();
		var oldUserName=$("#oldUserName").val();
		
		if(userName !=oldUserName){
			// 发送ajax 执行用户名唯一校验
			$.ajax({
				type:"post",
				url:ctx+"/user/checkUserUniqueByUserName",
				data:"userName="+userName,
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
	
	
	
	$("#userName").focus(function(){
		$("#submit").linkbutton("enable");
	})
	
	
})


function searchUser(){
	$("#dg").datagrid("reload",{
		userName:$("#s_userName").val(),
		email:$("#s_email").val(),
		phone:$("#s_phone").val()
	})
}

function openUserAddDialog(){
	openDlg("dlg", "保存用户");
}

function closeUserDialog(){
	closeDlg("dlg", "fm");
}

function saveOrUpdateUser(){
	saveOrUpdateData("fm", ctx+"/user/saveOrUpdateUser", "dlg", searchUser);
}



function openUserModifyDialog(){
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
	$("#oldUserName").val(rows[0].userName);
	openDlg("dlg", "更新用户");
}


function deleteUser(){
	deleteData("dg", ctx+"/user/deleteUserBatch", searchUser);
}