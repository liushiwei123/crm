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
	$("#dlg").dialog("open").dialog("setTitle","保存营销机会数据");
}

function closeSaleChanceDialog(){
	$("#dlg").dialog("close");
	initData();
}

function initData(){
	$("#fm").form("clear");
}


function saveOrUpdateSaleChance(){
	$("#fm").form("submit",{
		url:ctx+"/saleChance/saveOrUpdateSaleChance",
		onSubmit:function(){
			return $("#fm").form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.resultCode==200){
				$.messager.alert("来自crm","操作成功!");
				closeSaleChanceDialog();
				searchSaleChance();
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
		
	})
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
	var rows=$("#dg").datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行修改!");
		return;
	}
	
	
	var ids="ids=";
	
	for(var i=0;i<rows.length;i++){
		if(i<=rows.length-2){
			ids=ids+rows[i].id+"&ids=";
		}else{
			ids=ids+rows[i].id;
		}
	}
	
	
	$.messager.confirm("来自crm","确认删除选择的"+rows.length+"条记录?",function(r){
		if(r){
			
			$.ajax({
				type:"post",
				url:ctx+"/saleChance/deleteSaleChanceBatch",
				data:ids,
				dataType:"json",
				success:function(data){
					if(data.resultCode==200){
						$.messager.alert("来自crm","记录删除成功!");
						searchSaleChance();
					}else{
						$.messager.alert("来自crm",data.msg);
					}
				}
			})
			
			
		}
		
		
	})
	
	
}
