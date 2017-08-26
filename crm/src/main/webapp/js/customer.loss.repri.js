$(function(){
	var lossId=$("#lossId").val();
	$("#dg").edatagrid({
		url:ctx+"/customerLossRepri/queryCustomerLossRepriByLossId?lossId="+lossId,
		saveUrl:ctx+"/customerLossRepri/saveOrUpdateCustomerRepri?lossId="+lossId,
		updateUrl:ctx+"/customerLossRepri/saveOrUpdateCustomerRepri?lossId="+lossId
		//destroyUrl:ctx+"/cusDevPlan/deleteCusDevPlan"
	})
	
	var state=$("#state").val();
	if(state==1){
		$("#toolbar").hide();
	}
	
})


function saveCusLossRepri(){
	//var sid2=$("#saleChanceId").val();
	$("#dg").edatagrid("saveRow");
	search();
}

function search(){
	$("#dg").edatagrid("reload",{
		sid:$("#lossId").val()
	});
}

function delCusLossRepri(){
	deleteData("dg", ctx+"/customerLossRepri/deleteCustomerRepri", search);
	
}


function updateCusLossRepri(){
	$.messager.confirm("来自crm","确认流失?",function(r){
		if(r){
			$.messager.prompt("来自crm","请输入流失原因",function(reason){
				if(reason){
					$.ajax({
						type:"post",
						url:ctx+"/customerLoss/updateCustomerLoss",
						data:"reason="+reason+"&id="+$("#lossId").val(),
						dataType:"json",
						success:function(data){
							if(data.resultCode==200){
								$.messager.alert("来自crm","客户流失确认成功!");
								$("#toolbar").hide();
							}else{
								$.messager.alert("来自crm",data.msg);
							}
						}
					})	
				}
				
				
			})
			
		}
	})
}


