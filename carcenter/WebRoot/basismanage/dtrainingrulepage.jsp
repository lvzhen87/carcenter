<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>驾驶员培训规则查询页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/common.css" type="text/css" />	
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/verify.js"></script>
<style type="text/css">
.toright{
	text-align: right;
}
tr{
	height: 25px;
}
#manageordertab td{
	text-align: center;
}

#trans td{
font-size: 12px;
}
input{
	width: 120px;
	border:1px solid #36D;
}
h4{
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color: #222;
}
li{
	
}
</style>


  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchRuleForm" name="searchRuleForm" action="./searchTrainruleAction?time=new Date().getTime()" method="post">
			
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchRuleForm").submit();
		}
		
		function addrule(){
			var winPar=window.showModalDialog("./prepareTrainruleAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchRuleForm").submit();
			}
		}
		
	</script>
	

	<table  title="驾驶员培训规则" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="40%">培训失效周期（天）</td>
				<td width="13%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty dtrainingrule}">
			<tr>
				<td colspan="4">查无记录！			
				<img id="" onclick="addrule()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				</td>
			</tr>
		</c:when><c:otherwise>
			<tr style="background-color:#EEEEEE">
				<td>1</td>
				<td>${dtrainingrule.day_i}</td>
				<td>
					<a title="修改" onclick="updateRule('${dtrainingrule.id}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleterule('${dtrainingrule.id}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
	
	</c:otherwise>
	
	</c:choose>
</table>
	<script type="text/javascript">
		function updateRule(s){
		   var winPar=window.showModalDialog("./prepareTrainruleAction?id="+s, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
		 	//alert(winPar);
		   if(winPar=="refresh"){
			  // alert(winPar);
			document.getElementById("searchRuleForm").submit();
			}
		}
		
		function deleterule(s){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
				    	$.post(
				  				"./deleteTrainruleAction",
				  				{
				  					id:s,
				  					time:new Date().getTime()
				  				},function(msg){
									
			  						//$.messager.alert('删除','操作成功!');
			  						document.getElementById("searchRuleForm").submit();
				  				}
				  			);
				    }
				});
		}
	</script>
	
		
	</div>
  </body>
</html>