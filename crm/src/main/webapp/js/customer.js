function searchCustomer(){
	$("#dg").datagrid("reload",{
		khno:$("#s_khno").val(),
		name:$("#s_name").val()
	})
}


function openCustomerAddDialog(){
	openDlg("dlg", "保存客户信息");
}


function saveOrUpdateCustomer(){
	saveOrUpdateData("fm",ctx+"/customer/saveOrUpdateCustomer", "dlg", searchCustomer);
}


function closeCustomerDialog(){
	closeDlg("dlg", "fm");
}



function openCustomerModifyDialog(){
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
	openDlg("dlg", "更新客户信息");
}

function deleteCustomer(){
	deleteData("dg",ctx+"/customer/deleteCustomerBatch",searchCustomer);
}



function openCustomerOtherInfo(title,state){
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条客户信息!");
		return;
	}
	
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条客户信息!");
		return;
	}
	
	
	window.parent.openTab(title,ctx+"/customer/toOtherInfoPage?state="+state+"&cid="+rows[0].id);
}


