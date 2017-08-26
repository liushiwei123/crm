function saveOrUpdateCustomerService(){
	$("#fm").form("submit",{
		url:ctx+"/customerServe/saveOrUpdateCustomerServe",
		onSubmit:function(params){
			params.createPeople=$.cookie("userName");
			return $(this).form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.resultCode==200){
				$.messager.alert("来自crm","服务创建成功!");
				//$("#fm").form("reset");
				clearFormData();
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
		
	})
	
	
}

function clearFormData(){
	$("#serveType").combobox("clear");
	$("#customer").val("");
	$("#overview").val("");
	$("#serviceRequest").val("");
}

function resetValue(){
	//$("#fm").form("reset");
	clearFormData();
}