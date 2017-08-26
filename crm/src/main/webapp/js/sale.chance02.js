function formateState(value){
	if(value==1){
		return "已分配";
	}else{
		return "未分配";
	}
}

function searchSaleChance(){
	$("#dg").datagrid("reload",{
		customerName:$("#s_customerName").val(),
		createMan:$("#s_createMan").val(),
		state:$("#s_state").combobox("getValue")
	})
}


function openSaleChanceAddDialog(){
	openDlg("dlg", "保存营销机会记录");
}

function closeSaleChanceDialog(){
	closeDlg("dlg", "fm");
}



function saveOrUpdateSaleChance(){
	saveOrUpdateData("fm", ctx+"/saleChance/saveOrUpdateSaleChance", "dlg", searchSaleChance);
}


function openSaleChanceModifyDialog(){
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
	$("#dlg").dialog("open").dialog("setTitle","更新营销机会数据记录");
}

function deleteSaleChance(){
	deleteData("dg", ctx+"/saleChance/deleteSaleChanceBatch", searchSaleChance);
	
}
