<html>
<head>
	<#include "common.ftl" >
	 <script type="text/javascript" >
	   $(function(){
			alert("${errorMsg}");
			if("${uri}"=="/main"){
			   window.location.href=ctx+"/index";
			}else{
			   window.parent.location.href=ctx+"/index";
			}
	    })
	 </script>
	

	
</head>
	
	


