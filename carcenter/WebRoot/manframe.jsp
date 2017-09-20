<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <link rel="stylesheet" href="css/common.css" type="text/css" />
	<title>管理区域</title>
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function fade(){
			$.messager.show({
				title:'任务提醒',
				msg:'您有'+$("#hidMsg").val()+'个试验需要审核.<a href="./searchMyOrderAction">点击此处</a>，可以直接前往审核页面！',
				timeout:0,
				showType:'fade'
			});
		});
	</script>
	
</head>

<body>
	<input type="hidden" id="hidMsg"  name="hidMsg" value="${numExp}" />

</body>
</html>