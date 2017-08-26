function searchMenu(){
	$("#dg").datagrid("reload",{
		menuName:$("#s_menuName").val()
	})
}

function formatterOp(val,rowData){
	return "<a href='javascript:openSubMenuTab("+rowData.id+")'>查看子级菜单</a>";
	
}

function openSubMenuTab(mid){
	window.parent.openTab("子菜单维护",ctx+"/menu/index?flag=2&mid="+mid);
}





function openMenuAddDialog(){
	openDlg("dlg", "保存父级菜单");
}


function closeMenuDialog(){
	closeDlg("dlg", "fm");
}


function saveOrUpdateMenu(){
	saveOrUpdateData("fm", ctx+"/menu/saveOrUpdateMenu", "dlg", searchMenu);
}


$(function(){
	$("#menuName").blur(function(){
		var pid=$("#pid").val();
		var menuName=$("#menuName").val();
		var oldMenuName=$("#oldMenuName").val();
		if(menuName!=oldMenuName){
			$.ajax({
				type:"post",
				url:ctx+"/menu/queryMenuByMenuNameAndPid",
				data:"pid="+pid+"&menuName="+menuName,
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
	
	
	$("#menuName").focus(function(){
		$("#submit").linkbutton("enable");
	})
	
	
})


function openMenuModifyDialog(){
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
	$("#oldMenuName").val(rows[0].menuName);
	openDlg("dlg", "更新菜单");
}


function deleteMenu(){
	deleteData("dg", ctx+"/menu/deleteMenu",searchMenu );
}

