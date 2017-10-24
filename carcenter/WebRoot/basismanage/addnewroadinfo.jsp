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
    
    <title>添加道路信息</title>
    
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
		text-align: right;;
	}
	tr{
		height: 30px;
	}
	input{
		width: 280px;
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
  
 <body style="margin: 0px;padding: 0px; width: 1100px">
 <div id="man_zone" style="height: 520px; width: 1080px;">
<form id="addroadinfoform" method="post" action="./addroadAction?time=new Date().getTime()" enctype="multipart/form-data" >

  	<table width="90%">
  		<tr>
  			<td class="tor" width="15%">道路名称:</td>
  			<td width="34%"> <input type="text" id="roadName" name="roadName"  value="${roadinfo.roadName_s }"  onblur="Checkfun.isNull(this,'道路名称',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
  			<td class="tor">道路类型:</td>
  			<td > <select id="roadType" name="roadType" class="easyui-combobox">
  				<option value="1" <c:if test="${roadinfo.roadType_s == '1'}">  selected="selected" </c:if>>共享专用道路</option>
  				<option value="2" <c:if test="${roadinfo.roadType_s == '2'}">  selected="selected" </c:if>>共享／精确道路</option>
  			</select> </td>
  		</tr>
  		<tr>
  			<!--  <td class="tor">技术参数:</td>
  			<td> <input type="text" id="technicalParameters" name="technicalParameters"  value="${roadinfo.technicalParameters_s }" /> </td>
  			-->
  			<td class="tor">投入使用时间:</td>
  			<td>
  				<input type="text" class="easyui-datebox" id="startdatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${roadinfo.inputDate_t}"/>
  			</td>
  			<td class="tor">最大容量:</td>
  			<td > <input type="text" id="maxCapacity" name="maxCapacity" value="${roadinfo.maxCapacity_i }"  onblur="Checkfun.IsInteger(this,'最大容量',20)"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  		</tr>
  		<tr>
  			<td class="tor">道路分组:</td>
  			<td><input type="text" id="resaveds1_s" name="resaveds1_s" value="${roadinfo.resaveds1_s }"/></td>
  			<td class="tor">状态:</td>
  			<td > <select id="state" name="state" class="easyui-combobox">
  				<option value="0" <c:if test="${roadinfo.state_i == '0'}">  selected="selected" </c:if> >未投入使用</option>
  				<option value="1" <c:if test="${roadinfo.state_i == '1'}">  selected="selected" </c:if> >已投入使用</option>
  			</select> </td>
  		</tr>
  		<tr>
  			<td class="tor">包场费用单价(万元/小时):</td>
  			<td> <input type="text" id="wholeUnitPrie_i" name="wholeUnitPrie_i" value="${roadinfo.roadCost.wholeUnitPrie_i }" onblur="Checkfun.IsDouble(this,'包场费用',20)"/> </td>
  		
  			<td class="tor">费用单价(元/半小时):</td>
  			<td > <input type="text" id="unitPrie_i" name="unitPrie_i" value="${roadinfo.roadCost.unitPrie_i}" onblur="Checkfun.IsDouble(this,'费用单价',20)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">费用系数:</td>
  			<td> <input type="text" id="coefficient_i" name="coefficient_i" value="${roadinfo.roadCost.coefficient_i }" onblur="Checkfun.IsDouble(this,'费用系数',20)"/> </td>
  		
  			<td class="tor">活动包场费用(万元/半天):</td>
  			<td > <input type="text" id="activityUnitPrie_i" name="activityUnitPrie_i" value="${roadinfo.roadCost.activityUnitPrie_i}" onblur="Checkfun.IsDouble(this,'活动包场费用',20)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">费用单价(元/分钟):</td>
  			<td> <input type="text" id="minuteUnitPrie_i" name="minuteUnitPrie_i" value="${roadinfo.roadCost.minuteUnitPrie_i }" onblur="Checkfun.IsDouble(this,'费用单价',20)"/> </td>
  		
  			<td class="tor">最少预订天数(共享道路)</td>
  			<td > <input type="text" id="beginningDay_i" name="beginningDay_i" value="${roadinfo.beginningDay_i }" onblur="Checkfun.IsInteger(this,'最少预订天数(共享道路)',20)"/>   </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">起步分钟:</td>
  			<td> <input type="text" id="resaveds2" name="resaveds1" value="${roadinfo.roadCost.resaveds2_s}" onblur="Checkfun.IsInteger(this,'起步分钟',10)"/> </td>
  		
  			<td class="tor">起步价(元/分钟):</td>
  			<td > <input type="text" id="resaveds1" name="resaveds2" value="${roadinfo.roadCost.resaveds1_s}"  onblur="Checkfun.IsDouble(this,'起步价(元/分钟)',10)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">是否为洗车机用:</td>
  			<td>
  				<select id="wash" name="wash" class="easyui-combobox">
	  				<option value="0" <c:if test="${roadinfo.resaveds2_s == '0'}">  selected="selected" </c:if> >否</option>
	  				<option value="1" <c:if test="${roadinfo.resaveds2_s == '1'}">  selected="selected" </c:if> >是</option>
  				</select>
  			</td>
  			<td class="tor">道路当前状态:</td>
  			<td>
  				<select id="statusing" name="wash" class="easyui-combobox">
	  				<option value="1" <c:if test="${roadinfo.resaveds4_s == '1'}">  selected="selected" </c:if> >道路正常</option>
	  				<option value="2" <c:if test="${roadinfo.resaveds4_s == '2'}">  selected="selected" </c:if> >道路维修 </option>
	  				<option value="3" <c:if test="${roadinfo.resaveds4_s == '3'}">  selected="selected" </c:if> >道路包场 </option>
	  				<option value="4" <c:if test="${roadinfo.resaveds4_s == '4'}">  selected="selected" </c:if> >道路关闭 </option>  				
  				</select>
  			</td>
  		</tr>
  		<!--  
  		<tr>
  			<td class="tor">包场费用大于3.5 吨&两轴(时):</td>
  			<td> <input type="text" id="wholeOverproofUnitPrie_i" name="wholeOverproofUnitPrie_i" value="${roadinfo.roadCost.wholeOverproofUnitPrie_i }" onblur="Checkfun.IsDouble(this,'包场费用')"/> </td>
  		
  			<td class="tor">包场费用小于3.5 吨&两轴(时):</td>
  			<td > <input type="text" id="wholeUnitPrie_i" name="wholeUnitPrie_i" value="${roadinfo.roadCost.wholeUnitPrie_i }"  onblur="Checkfun.IsDouble(this,'包场费用')"/> </td>
  			
  		</tr>-->
  		<tr>
  		<td class="tor">备注:</td>
  			<td> <input type="text" id="remark" name="remark" value="${roadinfo.remark_s}" /> </td>
  			<td class="tor">使用时间</td>
  			<td >
  			<input type="text" id="usefultime" name="usefultime" value="${roadinfo.usefultime_s}" />
  			<input type="hidden" id="roadID" name="roadID" value="${roadID}"/> 
  			<input type="hidden" id="types" name="types" value=""/> 
  			<input type="hidden" id="statuesi" name="statuesi" value=""/> 
  			<input type="hidden" id="resaveds2_s" name="resaveds2_s" value=""/>
  			<input type="hidden" id="resaveds4_s" name="resaveds4_s" value=""/>
  			</td>
  			
  		</tr>
  		
  		<!--  <tr>
  			<td colspan="4" align="center">
  				<input type="hidden" id="types" name="types" value=""/> 
  			<input type="hidden" id="statuesi" name="statuesi" value=""/> 
  			<input type="hidden" id="resaveds2_s" name="resaveds2_s" value=""/>
  			<input type="hidden" id="resaveds4_s" name="resaveds4_s" value=""/>
  			</td>
  		</tr>-->
  	</table>
  	<!-- 使用内容
	<table style="border:0px #FFF;width: 90%;height: 200px;">
		<tr>
			<td width="60%" style="vertical-align: top;">
				<div id="p" class="easyui-panel" title="试验类型" data-options="iconCls:'edit_add'" style="padding:10px;width: 680px;height: 250px;">
				  	<div id="experimenttypeDiv" >
				  		<input type="hidden"  name="experimentTypeName" id="experimentTypeName"  >
				  		试验类型名称：<input type="text"  name="TypeName" id="TypeName"  >
				  	</div>
<script type="text/javascript">
$(function(){   
	var curr_time = new Date();  
	var strDate = curr_time.getFullYear()+"-";   
	strDate += curr_time.getMonth()+1+"-";   
	strDate += curr_time.getDate();  
	if($("#startdatepicker").val()== '')
	{
		$("#startdatepicker").datebox("setValue", strDate); 
	} 
});

$("#TypeName").keydown(function(){
	if(event.keyCode==13){
		$(this).after("<br/>试验类型名称：<input type='text'  name='TypeName' id='TypeName' value='"+$(this).val()+"'  > ");
		$(this).val("");
	}
});
</script>		
  	</td>
			<td width="30%" style="vertical-align: top;">
				<div id="p" class="easyui-panel" title="已设置试验类型" style="padding:10px;width: 200px;height: 250px;">
					<c:choose>
						<c:when test="${empty roadexptypeList}">
						</c:when><c:otherwise>
							<c:forEach items="${roadexptypeList}" var="exptype">
							<p>${exptype.experimentTypeName_s}<input type="hidden" value="${exptype.experimentTypeID_s}"/>
							<a title="删除" href="./delroadexptypeAction?roadID=${workShopID}&&exptypeID=${exptype.experimentTypeID_s}">
								<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
							</a></p>
							</c:forEach>
							
						</c:otherwise>
					</c:choose>
				</div>
			</td>
		</tr>
	</table>
  	 -->
  	<center>
  		<a id="addRoadBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  	</center>
  	</form>
  	<script type="text/javascript">
  		$("#addRoadBt").click(function (){
  		
  		//校验略
  			if($("#roadName").val()==null){
  				$.messager.alert('Error','道路名称不能为空！请填写！');
  				return false;
  			}
  			if($("#maxCapacity").val()==null || $("#maxCapacity").val()==""){
  				$.messager.alert('Error','最大容量不能为空！请填写！');
  				return false;
  			}
  			
  			if($("#roadType option:selected").val()==1)//共享道路有分钟费用单价
  			{
  				if($("#minuteUnitPrie_i").val()==null){
  					$.messager.alert('Error','共享道路需要填写费用单价(每分钟)！');
  					return false;
  				}
  			}
  			if(!isInteger($("#usefultime").val()))
  			{
  				$.messager.alert('Error','使用时间请填写数字！');
  					return false;
  			}
  			//alert($("#usefultime").val());
  			
  			//if($("#overproofUnitPrie_i").val()==null){
  			//	alert("收费标准不能为空！请填写！");
  			//	return false;
  			//}
  			//if($("#unitPrie_i").val()==null){
  			//	alert("收费标准不能为空！请填写！");
  			//	return false;
  			//}
  			//if($("#wholeUnitPrie_i").val()==null){
  			//	alert("包场收费标准不能为空！请填写！");
  			//	return false;
  			//}
  			//if($("#wholeOverproofUnitPrie_i").val()==null){
  			//	alert("包场收费标准不能为空！请填写！");
  			//	return false;
  			//}
  		
  			//var TypeNameform="";
			//var els =document.getElementsByName("TypeName");
			//for (var i = 0, j = els.length; i < j; i++){
			//	alert(els[i].value);
			//	TypeNameform += els[i].value+"vv";
			//}
			//$("#experimentTypeName").val(TypeNameform);
  			//alert($("#experimentTypeName").val());
  		//校验略
  		$("#types").val($("#roadType").combobox('getValues'));
  		$("#statuesi").val($("#state").combobox('getValues'));
  		$("#resaveds2_s").val($("#wash").combobox('getValues'));
  		$("#resaveds4_s").val($("#statusing").combobox('getValues'));
  		//alert($("#resaveds4_s").val())
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
  					usefultime:$("#usefultime").val(),
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
  		
  		function isInteger(obj) {  
	  		//alert(parseInt(obj, 10));
	  		//alert(typeof(obj));
	  		//alert(parseInt(obj, 10) === obj );
	  		return String(parseInt(obj, 10)) === obj ;
  		} 
  	</script>
 
  </div>
  </body>
</html>