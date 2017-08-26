function search(){
	$("#dg").datagrid("reload",{
		cusName:$("#s_cusName").val()
	})
	
}

function formatterSum(val){
	return "￥"+val;
	
}