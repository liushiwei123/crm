<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'tree01.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="zTree_v3-3.5.28/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="zTree_v3-3.5.28/js/jquery.ztree.core.js"></script>


<SCRIPT LANGUAGE="JavaScript">
<!--
var setting = {	};

var zNodes =[
	{ name:"父节点1 - 展开", open:true,
		children: [
			{ name:"父节点11 - 折叠",
				children: [
					{ name:"叶子节点111"},
					{ name:"叶子节点112"},
					{ name:"叶子节点113"},
					{ name:"叶子节点114"}
				]},
			{ name:"父节点12 - 折叠",
				children: [
					{ name:"叶子节点121"},
					{ name:"叶子节点122"},
					{ name:"叶子节点123"},
					{ name:"叶子节点124"}
				]},
			{ name:"父节点13 - 没有子节点", isParent:true}
		]},
	{ name:"父节点2 - 折叠",
		children: [
			{ name:"父节点21 - 展开", open:true,
				children: [
					{ name:"叶子节点211"},
					{ name:"叶子节点212"},
					{ name:"叶子节点213"},
					{ name:"叶子节点214"}
				]},
			{ name:"父节点22 - 折叠",
				children: [
					{ name:"叶子节点221"},
					{ name:"叶子节点222"},
					{ name:"叶子节点223"},
					{ name:"叶子节点224"}
				]},
			{ name:"父节点23 - 折叠",
				children: [
					{ name:"叶子节点231"},
					{ name:"叶子节点232"},
					{ name:"叶子节点233"},
					{ name:"叶子节点234"}
				]}
		]},
	{ name:"父节点3 - 没有子节点", isParent:true}

];
$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
  </SCRIPT>
</head>

<body>
<div>
   <ul id="treeDemo" class="ztree"></ul>
</div>

</body>
</html>
