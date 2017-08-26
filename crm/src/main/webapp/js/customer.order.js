function formatterState(val){
	if(val==1){
		return "已付款";
	}else{
		return "未付款";
	}
}

function formatterOp(val,rowData){
	return "<a href='javascript:openOrderDetailDlg("+rowData.id+")'>查看详情</a>";
}


function openOrderDetailDlg(oid){
	
	$.ajax({
		type:"post",
		url:ctx+"/customerOrder/queryOrderInfoById?oid="+oid,
		dataType:"json",
		success:function(data){
			if(data.state==0){
				data.state="未付款";
			}
			if(data.state==1){
				data.state="已付款";
			}
			
			
			
			
			$("#fm").form("load",data);
			
			// 查询订单详情数据数据  根据oid
			$("#dg2").datagrid("reload",{
				oid:oid
			})
		}
	})
	
	
	
	$("#dlg").dialog("open");
}