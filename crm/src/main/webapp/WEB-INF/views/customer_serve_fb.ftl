<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${ctx}/js/customer.serve.fb.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="服务反馈" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customerServe/queryCustomerServeByState?state=100003" fit="true" toolbar="#tb">
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
        <a href="javascript:openCustomerServeFbDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">分配服务</a>
    </div>
   
</div>

<!--分配信息 对话框-->
<div id="dlg" class="easyui-dialog" title="服务处理" closed="true" style="width:900px;height:450px;padding: 10px 20px"
     buttons="#dlg-buttons">
     
      <form id="fm" method="post">
      <input type="hidden" id="id" name="id" />
        <table >
            <tr>
                <td>服务类型：</td>
                <td>
                    <input type="text" id="serveType" name="serveType" />
                </td>
                <td>&nbsp;&nbsp;</td>
                <td>客户：</td>
                <td><input type="text" id="customer" name="customer" />
            </tr>
            <tr>
                <td>概要：</td>
                <td colspan="4">
                    <input type="text" id="overview" name="overview" style="width: 419px" />
                </td>
            </tr>
            <tr>
                <td>服务请求：</td>
                <td colspan="4">
                    <textarea id="serviceRequest" name="serviceRequest" rows="5" cols="49" ></textarea>&nbsp;<font color="red">*</font>
                </td>     
            </tr>
            <tr>
            	<td>创建人：</td>
                <td >
                    <input id="createPeople" name="createPeople"  ></input>
                </td>
            
             	<td>创建时间：</td>
                <td colspan="4">
                    <input id="createDate" name="createDate"  ></input>
                </td>
            </tr>      
            <tr>
                <td>分配给：</td>
                <td>
                    <input id="assigner" name="assigner" readOnly="readOnly"  ></input>
				</td>
            </tr>
            
             <tr>
                <td>服务处理：</td>
                 <td colspan="4">
                    <textarea id="serviceProce" name="serviceProce" rows="5" cols="49" ></textarea>&nbsp;<font color="red">*</font>
                </td>
            </tr>
             <tr>
                <td>服务处理结果：</td>
                 <td >
                 	 <input id="serviceProceResult" name="serviceProceResult"  ></input>                  
                </td>
                   <td>服务处理满意度：</td>
                 <td >
                    <select id="myd" class="easyui-combobox" name="myd" style="width:200px;" editable="false" panelHeight="auto">      
					    <option value="☆">☆</option>   
					    <option value="☆☆">☆☆</option> 
					    <option value="☆☆☆">☆☆☆</option>
					    <option value="☆☆☆☆">☆☆☆☆</option>
					    <option value="☆☆☆☆☆">☆☆☆☆☆</option>    
					</select>               
                </td>		
            </tr>   
            
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:addCustomerServeFb()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeCustomerFbDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>










</body>
</html>
