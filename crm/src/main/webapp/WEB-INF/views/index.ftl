<html>
<head>
	<#include "common.ftl" >
    <meta charset="UTF-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>客户关系管理系统登录</title>
    <link href="${ctx}/css/global.css" rel="stylesheet">
    <script type="text/javascript" src='${ctx}/js/jquery.cookie.js'></script>
    <script type="text/javascript" src='${ctx}/js/common.js'></script>
    <script type="text/javascript" src='${ctx}/js/index.js'></script>
</head>
<body>
    <table style="margin: auto; width: 100%; height: 100%" border=0 cellSpacing=0 cellPadding=0>
        <tr>
            <td height=150>&nbsp;</td>
        </tr>
        <tr style="height: 254px">
            <td>
                <div style="margin: 0px auto; width: 936px"><IMG
                        style="display: block" src="${ctx}/images/body_03.jpg"></div>
                <div style="background-color: #278296">
                    <div style="margin: 0px auto; width: 936px">
                        <div style="background: url(${ctx}/images/body_05.jpg) no-repeat; height: 155px">
                            <div style="text-align: left; width: 265px; float: right; height: 125px; _height: 95px">
                                <table border=0 cellSpacing=0 cellPadding=0 width="100%">
                                    <tbody>
                                    <tr>
                                        <td style="height: 45px"><input type="text" class="input" name="userName" id="userName"></td>
                                    </tr>
                                    <tr>
                                        <td><input type="password" class="input" name="userPwd" id="userPwd"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <select id="roleId" name="roleId" class="input" style="margin-top: 15px;height: 24px">
                                                <option value="">请选择用户类型...</option>
                                                <option value="1" >系统管理员</option>
                                                <option value="2" }>销售主管</option>
                                                <option value="3" >客户经理</option>
                                                <option value="4" >高管</option>
                                            </select>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div style="height: 1px; clear: both"></div>
                            <div style="width: 380px; float: right; CLEAR: both">
                                <table border=0 cellSpacing=0 cellPadding=0 width=300>
                                    <tr>
                                        <td width=100 align=right>
                                            <input style="border-right-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px"
                                                id="btnLogin" src="${ctx}/images/btn1.jpg" type="image" ></td>
                                        <td width=100 align=middle>
                                            <input style="border-RIGHT-width: 0px; border-top-width: 0px; border-bottom-width: 0px; border-left-width: 0px"
                                                id="btnReset" src="${ctx}/images/btn2.jpg" type="image"></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin: 0px auto; width: 936px">
                    <img src="${ctx}/images/body_06.jpg">
                </div>
            </td>
        </tr>
        <tr style="height: 30%">
            <td>&nbsp;</td>
        </tr>
    </table>
</body>
</html>