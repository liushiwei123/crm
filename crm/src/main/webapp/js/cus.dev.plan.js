function formatterDevResult(value){
	if(value==0||value==1){
		return "开发中";
	}
	if(value==2){
		return "开发成功";
	}
	if(value==3){
		return "开发失败";
	}
}


function formatterOption(value,rowData){
	if(rowData.devResult==2||rowData.devResult==3){
		return "<a href='javascript:openCusDevPlanTab("+'"开发计划项详情查看"'+","+rowData.id+")'>查看详情</a>";
	}else{
		return "<a href='javascript:openCusDevPlanTab("+'"开发计划项维护"'+","+rowData.id+")'>开发</a>";
	}
}

function openCusDevPlanTab(title,id){
   window.parent.openTab(title,ctx+"/saleChance/querySaleChanceById?sid="+id);
}

