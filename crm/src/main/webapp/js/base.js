/**
 * 打开对话框
 * @param dlgId
 * @param title
 */
function openDlg(dlgId,title){
	$("#"+dlgId).dialog("open").dialog("setTitle",title);
}

/**
 * 关闭对话框
 * @param dlgId
 * @param formId
 */
function closeDlg(dlgId,formId){
	$("#"+dlgId).dialog("close");
	initData(formId);
}

/**
 * 情况表单数据
 * @param formId
 */
function initData(formId){
	$("#"+formId).form("clear");
}

/**
 * 添加与更新 方法
 * @param formId 表单id
 * @param url  提交的url
 * @param dlgId 对话框id
 * @param freshDataGrid  操作成功后刷新方法
 */
function saveOrUpdateData(formId,url,dlgId,freshDataGrid){
	$("#"+formId).form("submit",{
		url:url,
		onSubmit:function(){
			return $(this).form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.resultCode==200){
				$.messager.alert("来自crm","操作成功");
				closeDlg(dlgId,formId);
				if(null!=freshDataGrid&&"undefined"!=freshDataGrid){
					freshDataGrid();// 执行刷新方法
				}
				
			}else{
				$.messager.alert("来自crm",data.msg);
			}
		}
	})
}

/**
 * 
 * @param dataGridId 表格id
 * @param url   删除url
 * @param freshDataGrid  刷新方法
 */
function deleteData(dataGridId,url,freshDataGrid){
	var rows=$("#"+dataGridId).datagrid("getSelections");
	if(rows.length==0){
		$.messager.alert("来自crm","请选择一条记录进行删除!");
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
				url:url,
				data:ids,
				dataType:"json",
				success:function(data){
					if(data.resultCode==200){
						$.messager.alert("来自crm","记录删除成功!");
						if(null!=freshDataGrid&&"undefined"!=freshDataGrid){
							freshDataGrid();// 执行刷新方法
						}
					}else{
						$.messager.alert("来自crm",data.msg);
					}
				}
			})	
		}
	})
}



