<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>道路单周状态信息管理</title>
    
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
form{
	margin: 0px;
	padding: 0px;
}
</style>
  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone">
   <!-- 条件查询div -->
	 
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("roadSearchForm").submit();
		}
		
		function addRoadinfo(){
			var winPar=window.showModalDialog("./prepareroadAction", "", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("roadSearchForm").submit();
			}
		}
	</script>
	 
	<table title="道路信息" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<!--  <td width="10%">道路编号</td>-->
				<td width="4%">序号</td>
				<td width="10%">道路名称</td>
				<td width="10%">周一${w1}</td>
				<td width="10%">周二${w2}</td>
				<td width="10%">周三${w3}</td>
				<td width="10%">周四${w4}</td>
				<td width="10%">周五${w5}</td>				 
			</tr>
			<form id="addroadinfoform" method="post" action="./addroadAction?time=new Date().getTime()" enctype="multipart/form-data" >
		<c:choose>
		<c:when test="${empty roadweeklist}">
			<tr><td colspan="11">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${roadweeklist}" var="roadlist" varStatus="roadStatus">
			<c:set var="statusIndex" value="${roadStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
	
				<td>${statusIndex+1 }</td>
				<td>${roadlist.roadname}</td>
				<td>				 				 
					<select id="status1${roadlist.roadidS}" name="status1${roadlist.roadidS}" class="easyui-combobox">
  						<option value="1" <c:if test="${roadlist.s1 == '1'}">  selected="selected" </c:if> >道路空闲</option>
  						<option value="2" <c:if test="${roadlist.s1 == '2'}">  selected="selected" </c:if> >道路畅通</option>
  						<option value="3" <c:if test="${roadlist.s1 == '3'}">  selected="selected" </c:if> >道路拥堵</option>
  					</select>					
				</td>
				<td>
					<select id="status2${roadlist.roadidS}" name="status2${roadlist.roadidS}" class="easyui-combobox">
  						<option value="1" <c:if test="${roadlist.s2 == '1'}">  selected="selected" </c:if> >道路空闲</option>
  						<option value="2" <c:if test="${roadlist.s2 == '2'}">  selected="selected" </c:if> >道路畅通</option>
  						<option value="3" <c:if test="${roadlist.s2 == '3'}">  selected="selected" </c:if> >道路拥堵</option>
  					</select>
					 
				</td>
				<td>
					<select id="status3${roadlist.roadidS}" name="status3${roadlist.roadidS}" class="easyui-combobox">
  						<option value="1" <c:if test="${roadlist.s3 == '1'}">  selected="selected" </c:if> >道路空闲</option>
  						<option value="2" <c:if test="${roadlist.s3 == '2'}">  selected="selected" </c:if> >道路畅通</option>
  						<option value="3" <c:if test="${roadlist.s3 == '3'}">  selected="selected" </c:if> >道路拥堵</option>
  					</select>
					 
				</td>
				<td>
					<select id="status4${roadlist.roadidS}" name="status4${roadlist.roadidS}" class="easyui-combobox">
  						<option value="1" <c:if test="${roadlist.s4 == '1'}">  selected="selected" </c:if> >道路空闲</option>
  						<option value="2" <c:if test="${roadlist.s4 == '2'}">  selected="selected" </c:if> >道路畅通</option>
  						<option value="3" <c:if test="${roadlist.s4 == '3'}">  selected="selected" </c:if> >道路拥堵</option>
  					</select>
					 
				</td>
				<td>
					<select id="status5${roadlist.roadidS}" name="status5${roadlist.roadidS}" class="easyui-combobox">
  						<option value="1" <c:if test="${roadlist.s5 == '1'}">  selected="selected" </c:if> >道路空闲</option>
  						<option value="2" <c:if test="${roadlist.s5 == '2'}">  selected="selected" </c:if> >道路畅通</option>
  						<option value="3" <c:if test="${roadlist.s5 == '3'}">  selected="selected" </c:if> >道路拥堵</option>
  					</select>
					 
				</td>				 
			</tr>
			 
	</c:forEach>
	</c:otherwise>
</c:choose>
	<tr>
		<td></td><td></td><td></td><td></td><td></td><td></td>
		<td>
			<center>
  				<a id="addRoadBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</center>
		</td>
	</tr>

</form>			
	</table>
	<script type="text/javascript">
  		$("#addRoadBt").click(function (){
  		id = ${roadidS}.split(",");
  		alert(id);
	  	
  		$("#types").val($("#roadType").combobox('getValues'));
  		$("#statuesi").val($("#state").combobox('getValues'));
  		$("#resaveds2_s").val($("#wash").combobox('getValues'));
  		$("#resaveds4_s").val($("#statusing").combobox('getValues'));
  		alert($("#resaveds4_s").val())
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  			if (r){
  			$.post(
  				"./addroadAction",
  				{
  					roadName:$("#roadName").val(),
  					roadType:$("#types").val(),
  					technicalParameters:$("#technicalParameters").val(),
  					maxCapacity:$("#maxCapacity").val(),
  					inputDate_t:$("#startdatepicker").datebox("getValue"),
  					state:$("#statuesi").val(),
  					remark:$("#remark").val(),
  					roadID:$("#roadID").val(),
  					coefficient_i:$("#coefficient_i").val(),
  					unitPrie_i:$("#unitPrie_i").val(),
  					wholeUnitPrie_i:$("#wholeUnitPrie_i").val(),
  					activityUnitPrie_i:$("#activityUnitPrie_i").val(),
  					minuteUnitPrie_i:$("#minuteUnitPrie_i").val(),
  					//experimentTypeName:$("#experimentTypeName").val(),
  					beginningDay_i:$("#beginningDay_i").val(),
  					resaveds1_s:$("#resaveds1_s").val(),
  					resaveds1:$("#resaveds1").val(),
  					resaveds2:$("#resaveds2").val(),
  					resaveds2_s:$("#resaveds2_s").val(),
  					resaveds4:$("#resaveds4_s").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','道路信息添加成功！');
  					window.returnValue="refresh";
  		  			window.close();
  				}
  			);
  			
  			}
  		});
  			//document.getElementById("addroadinfoform").submit();
  	  	  	//window.returnValue="refresh";
	  	   // window.close();
  			
  		});
	
		function updateroad(s){
			var winPar=window.showModalDialog("./prepareroadAction?roadID="+s,"","dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//window.showModalDialog('WMS_Material.aspx', '', "dialogWidth=310px;dialogHeight=600px;status=no;help=no;scrollbars=no;")
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("roadSearchForm").submit();
			}
		}
		
		function deleteroad(s){
			var str="确定要删除？"
			$.messager.confirm('删除', str, function(r){
			    if (r){
				
					$.post(
		  				"./deleteroadAction",
		  				{
		  					roadID:s,
		  					time:new Date().getTime()
		  				},function(msg){
		  					//alert(msg);
		  					if(msg.length > 4){
		  						$.messager.alert("Error",msg);
		  					}else{
		  						//$.messager.alert("删除","操作成功！");
		  						document.getElementById("roadSearchForm").submit();
		  					}
		  				}
		  			);
				}
		    });
		}
	</script>
		 
	</div>
  </body>
</html>
