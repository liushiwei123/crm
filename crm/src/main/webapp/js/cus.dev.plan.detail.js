$(function(){
	var sid=$("#saleChanceId").val();
	
	$("#dg").edatagrid({
		url:ctx+"/cusDevPlan/queryCusDevPlanBySid?sid="+sid,
		saveUrl:ctx+"/cusDevPlan/saveOrUpdateCusDevPlan?saleChanceId="+sid,
		updateUrl:ctx+"/cusDevPlan/saveOrUpdateCusDevPlan?saleChanceId="+sid
		//destroyUrl:ctx+"/cusDevPlan/deleteCusDevPlan"
	})
	
	// 获取开发状态
	var devResult=$("#devResult").val();
	if(devResult==2||devResult==3){
		$("#toolbar").hide();
	}
	
})


function saveCusDevPlan(){
	var sid2=$("#saleChanceId").val();
	$("#dg").edatagrid("saveRow");
	$("#dg").edatagrid("reload",{
		sid:sid2
	});
}

function delCusDevPlan(){
	
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行修改!");
		return;
	}
	
	$.messager.confirm("来自crm","确认删除选择的"+rows.length+"条记录?",function(r){
		if(r){
			$.ajax({
				type:"post",
				url:ctx+"/cusDevPlan/deleteCusDevPlan",
				data:"id="+rows[0].id,
				dataType:"json",
				success:function(data){
					if(data.resultCode==200){
						$.messager.alert("来自crm","记录删除成功!");
						var sid2=$("#saleChanceId").val();
						$("#dg").edatagrid("reload",{
							sid:sid2
						});
					}else{
						$.messager.alert("来自crm",data.msg);
					}
				}
			})	
		}
	})
}


function updateSaleChanceDevResult(devResult){
	$.ajax({
		type:"post",
		url:ctx+"/saleChance/updateDevResult",
		data:"sid="+$("#saleChanceId").val()+"&devResult="+devResult,
		dataType:"json",
		success:function(data){
			if(data.resultCode==200){
				$.messager.alert("来自crm","操作成功");
				$("#toolbar").hide();
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
	})
	
}