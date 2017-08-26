function searchGdInfo(){
	$("#dg").datagrid("reload",{
		serveType:$("#s_type").combobox("getValue"),
		customer:$("#s_customer").val()
	})
}