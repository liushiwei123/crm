function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){
        $("#tabs").tabs("select",text);
    }else{
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
    }
}


function logout(){
	// 移除cookie
	// 跳转到登录页面
	$.messager.confirm("来自crm","确认退出?",function(r){
		if(r){
			tempLogOut();
		}
	})
}


function tempLogOut(){
	$.removeCookie("userIdStr");
	$.removeCookie("userName");
	$.removeCookie("roleName");
	window.location.href=ctx+"/index";
}


function openPasswordModifyDialog(){
	$("#dlg").dialog("open");
}

function modifyPassword(){
	// 表单提交  更新用户密码
	$("#fm").form("submit",{
		url:ctx+"/user/updateUserPassword",
		onSubmit:function(){
			return $(this).form("validate");
		},
		success:function(data){
			data=JSON.parse(data);
			if(data.resultCode==200){
				$.messager.alert("来自crm","密码更新成功,2秒后即将退出。。。");
				setTimeout(function(){
					tempLogOut();
				}, 2000);
				
			}else{
				$.messager.alert("来自crm",data.msg);
			}
			
		}
		
		
	})
	
}

