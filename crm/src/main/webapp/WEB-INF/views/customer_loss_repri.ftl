<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.loss.repri.js" ></script>
    <script type="text/javascript" src="${ctx}/jquery-easyui-1.3.3/jquery.edatagrid.js" ></script>
</head>
<body style="margin: 15px">
<#--客户流失信息-->
<div id="p" class="easyui-panel" title="流失客户信息" style="width: 700px;height: 350px;padding: 10px">
    <table cellspacing="8px">
        <input type="hidden" id="lossId" name="lossId" value="${customerLoss.id}"/>
        <input type="hidden" id="state" name="state" value="${customerLoss.state}"/>
        <tr>
            <td>客户名称：</td>
            <td><input type="text" id="customerName" name="cusName" readonly="readonly" value="${customerLoss.cusName?if_exists}" /></td>
            <td>    </td>
            <td>客户编号</td>
            <td><input type="text" id="chanceSource" name="cusNo" readonly="readonly" value="${customerLoss.cusNo?if_exists}"/></td>
        </tr>
      
    </table>
</div>
<br/>

<#--暂缓处理数据展示-->
<table id="dg" title="暂缓处理数据" style="width:700px;height:250px"
       toolbar="#toolbar" idField="id" pagination="true" rownumbers="true" fitColumns="true" >
    <thead>
    <tr>
        <th checkbox="true" align="center"></th>
        <th field="id" width="50">编号</th>
        <th field="measure" width="100" editor="{type:'validatebox',options:{required:true}}">处理措施</th>
    </tr>
    </thead>
</table>

<div id="toolbar">
        <a href="javascript:$('#dg').edatagrid('addRow')" class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加暂缓处理</a>
        <a href="javascript:delCusLossRepri()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除暂缓处理</a>
        <a href="javascript:saveCusLossRepri()" class="easyui-linkbutton" iconCls="icon-save" plain="true" >保存暂缓处理措施</a>
        <a href="javascript:$('#dg').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >撤销行</a>
        <a href="javascript:updateCusLossRepri()" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true" >确认流失</a>
</div>


</body>