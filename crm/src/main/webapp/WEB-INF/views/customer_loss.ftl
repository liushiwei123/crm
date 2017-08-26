<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/customer.loss.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="客户流失数据管理" class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/customerLoss/queryCustomerLossByParams" fit="true" toolbar="#tb">
     <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center" hidden="true">编号</th>
        <th field="cusNo" width="150" align="center">客户编号</th>
        <th field="cusName" width="200" align="center">客户名称</th>
        <th field="cusManager" width="100" align="center">客户经理</th>
        <th field="lastOrderTime" width="100" align="center">最后下单时间</th>
        <th field="confirmLossTime" width="100" align="center">确认流失时间</th>
        <th field="state" width="100" align="center" formatter="formatterState">状态</th>
         <th field="lossReason" width="100" align="center">流失原因</th>
         <th field="op" width="100" align="center" formatter="formatterOp">操作</th>
    </tr>
    </thead>
   
</table>

</body>
</html>
