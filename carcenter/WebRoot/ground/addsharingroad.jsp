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
    
    <title>共享道路信息</title>
    
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
	.tor{
		text-align: right;
	}
	input{
		width: 300px;
		border:1px solid #36D;
		height: 25px;
	}
	</style>
<script type="text/javascript">
		function myformatter(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
			+ (d < 10 ? ('0' + d) : d);
		}
		function myparser(s) {
			if (!s)
			return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0], 10);
			var m = parseInt(ss[1], 10);
			var d = parseInt(ss[2], 10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
			} else {
			return new Date();
			}
		}
	</script>
  </head>
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">试验道路:</td>
  			<td width="30%"> 
				<select  id="roadID_s"  name="roadID_s" class="easyui-combobox">
            		<option value="-1" selected="selected" >请选择试验道路</option>
            		<c:forEach items="${roadinfolist}" var="roadInfo" >
			        	<option value="${roadInfo.roadID_s}"> ${roadInfo.roadName_s}</option>
            		</c:forEach>
        		</select>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			<td class="tor" width="10%">总车时数：</td>
            <td width="30%">
				<input type="text" name="hoursNumber" id="hoursNumber" value="${sharingroad.hoursNumber_s}"  />
			</td>
  		</tr>
  		<tr>
  			<td class="tor" >最高车速：</td>
  			<td >            
				<input type="text" name="maxSpeed" value="${sharingroad.maxSpeed_s }" id="maxSpeed" />&nbsp;&nbsp;<font color="red">*</font>
 			</td>
  			<td class="tor">测试车辆数：</td>
  			<td > 
				<input type="text" name="carNumber" value="${sharingroad.carNumber_i }" id="carNumber" />&nbsp;&nbsp;<font color="red">*</font>
			</td>
  		</tr>
  		<tr>
  			<td class="tor">是否高危：</td>
  			<td>              	 
				<select id="isHightRiskTest" name="isHightRiskTest" class="easyui-combobox" >
					<option value="0" <c:if test="${sharingroad.isHighRiskTest_i==0}"> selected="selected"</c:if>>否</option>
					<option value="1" <c:if test="${sharingroad.isHighRiskTest_i==1}"> selected="selected"</c:if>>是</option>
				</select>
 			</td>
  			<td class="tor">摄影摄像：</td>
  			<td >
				<select id="isCamera" class="easyui-combobox">
					<option value="0" <c:if test="${sharingroad.isCamera_i==0}"> selected="selected"</c:if>>否</option>
					<option value="1" <c:if test="${sharingroad.isCamera_i==0}"> selected="selected"</c:if>>是</option>
				</select>	
			 </td>
  		</tr>
  		<tr>
  			<td class="tor">预定日期：</td>
  			<td colspan="3"> <input type="text" class="easyui-datebox" id="startdatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${sharingroad.startDate_t}"/>	~
				<input type="text" class="easyui-datebox" id="enddatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${sharingroad.endDate_t}"/>&nbsp;&nbsp;<font color="red">*</font>
			</td>
  		</tr>
  		<tr>
  			<td class="tor">测试描述：</td>
        	<td colspan="3">
        		<textarea rows="4" style="width: 90%"  name="description"  id="description">${sharingroad.description_s }</textarea>&nbsp;&nbsp;<font color="red">*</font>
        	</td>
        </tr>
        <tr>
        	<td class="tor">危险性描述：</td>
        	<td colspan="3">
        		<textarea rows="4" style="width: 90%"  name="hightRiskTestDescription" id="hightRiskTestDescription" >${sharingroad.highRiskTestDescription_s }</textarea>
        	</td>
  		</tr>
  		<tr>
  			<td class="tor">安全措施：</td>
        	<td colspan="3">
        		<textarea rows="3" style="width: 90%"  id="accidentPrevention" name="accidentPrevention" >${sharingroad.accidentPrevention_s}</textarea>
        	</td>
  		</tr>
  		<tr>
  			<td colspan="4" align="center">
  				<input type="hidden" id="roadID" name="roadID" />
  				<a id="queryBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>	
  	<script type="text/javascript">
  		$("#queryBt").click(function (){
  			//alert($("#roadID_s").combobox('getValues'))
  			if($("#roadID_s").combobox('getValues') == null || $("#roadID_s").combobox('getValues') == -1){
  	  			$.messager.alert('Error','请选择试验道路！');
  	  			return false;
  	  		}
  			if ($("#startdatepicker").datebox('getValue').length<1    ){
  	  			$.messager.alert('Error','请确定开始日期');
  	  			return false;
  	  		}
  	  		if ($("#enddatepicker").datebox('getValue').length<1    ){
  	  			$.messager.alert('Error','请确定结束日期');
  	  			return false;
  	  		}
  	  		$("#roadID").val($("#roadID_s").combobox('getValues'));
 			$.post(
 				"./saveSharingRoadAction",
 				{
 					roadID_s:$("#roadID").val(),
 					roadName:$("#roadID_s").combobox('getText'),
 					hoursNumber:$("#hoursNumber").val(),
 					maxSpeed:$("#maxSpeed").val(),
 					carNumber:$("#carNumber").val(),
 					isHightRiskTest:$("#isHightRiskTest").combobox('getValues'),
 					isCamera:$("#isCamera").combobox('getValues'),
 					startdatepicker:$("#startdatepicker").datebox('getValue'),
 					enddatepicker:$("#enddatepicker").datebox('getValue'),
 					description:$("#description").val(),
 					hightRiskTestDescription:$("#hightRiskTestDescription").val(),
 					accidentPrevention:$("#accidentPrevention").val(),
 					time:new Date().getTime()
 				},function(){
 					$.messager.alert('Success',"操作成功！");
 					window.returnValue="refresh";
 		  			window.close();
 				}
 			);
  			//document.getElementById("barrierForm").submit();
  		});
  	</script>
  	
  </div>
  </body>
</html>
