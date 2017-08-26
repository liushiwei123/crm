function openCustomerServeAssignDialog(){
	
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行分配!");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条记录进行分配!");
		return;
	}
	
	$("#fm").form("load",rows[0]);
	$("#dlg").dialog("open");
}


function freashDataGrid(){
	$("#dg").datagrid("reload",{
		state:10001
	})
}


function addCustomerServeAssign(){
	$("#fm").form("submit",{
		url:ctx+"/customerServe/saveOrUpdateCustomerServe",
		onSubmit:function(params){
			params.state=100002;
			return $(this).form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.resultCode==200){
				$("#dlg").dialog("close");
				freashDataGrid();
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
	})
}
