function formatterState(val){
	if(val==0){
		return "暂缓流失";
	}else{
		return "确认流失";
	}
}

function formatterOp(val,rowData){
	if(rowData.state==0){
		return "<a href='javascript:openCustomerRepriTab("+rowData.id+")'>添加暂缓处理</a>";// 打开暂缓处理选项卡
	}else{
		return "确认流失";
	}
}

function openCustomerRepriTab(id){
	window.parent.openTab("暂缓措施管理",ctx+"/customerLoss/queryCustomerLossById?id="+id);
}

