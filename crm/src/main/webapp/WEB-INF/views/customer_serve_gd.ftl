<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/customer.serve.gd.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="服务归档" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customerServe/queryCustomerServeByState?state=100005" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="serveType" width="200" align="center" >服务类型</th>
        <th field="customer" width="50" align="center">客户名称</th>
        <th field="createPeople" width="50" align="center">创建人</th>
        <th field="createDate" width="50" align="center" >创建时间</th>
        <th field="assigner" width="50" align="center">分配人</th>
        <th field="assignTime" width="50" align="center" >分配时间</th>
        <th field="serviceProcePeople" width="50" align="center">处理人</th>
         <th field="serviceProce" width="50" align="center" >处理内容</th>
        <th field="serviceProceTime" width="50" align="center" >处理时间</th>
       
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
      &nbsp;服务类型：&nbsp;
     <input class="easyui-combobox" id="s_type" name="serveType" data-options="panelHeight:'auto',editable:false,valueField:'dataDicValue',textField:'dataDicValue',url:'${ctx}/dataDic/queryDataDicInfoByDicName?dicName=服务类型'"/>
        &nbsp;客户名称：&nbsp;<input type="text" id="s_customer" size="20" onkeydown="if(event.keyCode==13) searchCustomer()"/>
        <a href="javascript:searchGdInfo()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
   
</div>



</body>
</html>
