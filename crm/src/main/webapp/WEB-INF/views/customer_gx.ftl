<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.gx.js"></script>
</head>

<body>
<table id="dg" title="客户贡献数据" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/report/queryCustomerGxData" singleSelect=true fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cusName" width="50" align="center">客户名称</th>
        <th field="sum" width="200" align="center" formatter="formatterSum" >贡献金额</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
         客户名称： <input type="text" id="s_cusName" size="20" onkeydown="if(event.keyCode==13) search()"/>
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>



</body>


