function openCustomerServeProceDialog(){
	
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行处理!");
		return;
	}
	if(rows.length>1){
		$.messager.alert("来自crm","只能选择一条记录进行处理!");
		return;
	}
	
	$("#fm").form("load",rows[0]);
	$("#dlg").dialog("open");
}


function freashDataGrid(){
	$("#dg").datagrid("reload",{
		state:10002
	})
}


function addCustomerServeProce(){
	$("#fm").form("submit",{
		url:ctx+"/customerServe/saveOrUpdateCustomerServe",
		onSubmit:function(params){
			params.state=100003;
			params.serviceProcePeople=$.cookie("userName");
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
