$(function(){
	
	$("#btnLogin").click(function(){
		
		// 登录操作
		
		var userName=$("#userName").val();
		var userPwd=$("#userPwd").val();
		var roleId=$("#roleId").val();
		
		//  参数非空校验
		if(isEmpty(userName)){
			alert("用户名不能为空!");
			return;
		}
		if(isEmpty(userPwd)){
			alert("用户密码不能为空!");
			return;
		}
		
		if(isEmpty(roleId)){
			alert("请选择角色!");
			return;
		}
		
		// ajax 请求后台登录操作
		var params={};
		params.userName=userName;
		params.userPwd=userPwd;
		params.roleId=roleId;
		
		$.ajax({
			type:"post",
			url:ctx+"/user/userLogin",
			data:params,
			dataType:"json",
			success:function(data){
				if(data.resultCode==200){
					// 写入cookie
					// result  idStr userName  roleName
					// 跳转主页
					$.cookie("userIdStr",data.result.userIdStr);
					$.cookie("userName",data.result.userName);
					$.cookie("roleName",data.result.roleName);
					window.location.href=ctx+"/main";	
				}else{
					alert(data.msg);
				}
			}
			
			
		})
		
		
		
		
		
	})
	
	
})


