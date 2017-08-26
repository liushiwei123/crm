<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/cus.dev.plan.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="客户开发计划管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/saleChance/querySaleChanceByParams?state=1" singleSelect=true fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="chanceSource" width="200" align="center" >机会来源</th>
        <th field="customerName" width="50" align="center">客户名称</th>
        <th field="cgjl" width="50" align="center" >成功几率</th>
        <th field="linkMan" width="100" align="center">联系人</th>
        <th field="linkPhone" width="100" align="center">联系电话</th>
        <th field="description" width="200" align="center" >机会描述</th>
        <th field="createDate" width="100" align="center">创建时间</th>
         <th field="assignMan" width="100" align="center">分配人</th>
          <th field="assignTime" width="100" align="center">分配时间</th>
          <th field="devResult" width="100" align="center" formatter="formatterDevResult">开发状态</th>
          <th field="aa" width="100" align="center" formatter="formatterOption">操作</th>
    </tr>
    </thead>
</table>






</body>