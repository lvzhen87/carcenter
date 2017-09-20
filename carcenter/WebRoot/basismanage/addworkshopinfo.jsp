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
    
    <title>添加车间基础信息</title>
    
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
		width: 300px;
		border:1px solid #36D;
		height: 25px;
	}
	</style>

  </head>
  
   <base target="_self">
  
   <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="width: 960px;">
      <form id="addworkshopform" method="post" action="./addworkshopAction" enctype="multipart/form-data" >
  	<table width="100%">
  		<tr>
  			<td class="tor" width="15%">车间名称:</td>
  			<td width="34%"> <input type="text" id="workShopName" name="workShopName"  value="${workshop.workShopName_s}"  onblur="Checkfun.isNull(this,'车间名称',80)"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">预约车间：</td>
  			<td> 
  				<select id="isSubscribe" name="isSubscribe" class="easyui-combobox">
	  				<option value="0" <c:if test="${workshop.isSubscribe_i == '0'}">  selected="selected" </c:if>>否</option>
	  				<option value="1" <c:if test="${workshop.isSubscribe_i == '1'}">  selected="selected" </c:if>>是</option>
	  				
  				</select> 
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="15%">可否按月预定:</td>
  			<td width="25%"> 
  				<select id="ismonthSubscribe_i" name="ismonthSubscribe_i" class="easyui-combobox">
	  				<option value="0" <c:if test="${workshop.ismonthSubscribe_i == '0'}">  selected="selected" </c:if>>否</option>
	  				<option value="1" <c:if test="${workshop.ismonthSubscribe_i == '1'}">  selected="selected" </c:if>>是</option>
	  				
  				</select> 
  			</td>
  			<td class="tor">可否按天预定：</td>
  			<td> 
  				<select id="isdaysubscribe_i" name="isdaysubscribe_i" class="easyui-combobox">
	  				<option value="0" <c:if test="${workshop.isdaysubscribe_i == '0'}">  selected="selected" </c:if>>否</option>
	  				<option value="1" <c:if test="${workshop.isdaysubscribe_i == '1'}">  selected="selected" </c:if>>是</option>
	  				
  				</select> 
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="15%">最少预定天数:</td>
  			<td width="25%"> 
  				<input type="text" id="beginningday_i" name="beginningday_i" value="${workshop.beginningday_i}" onblur="Checkfun.IsInteger(this,'最少预定天数',20)"/>
  			</td>
  			<td class="tor"></td>
  			<td> 
  				
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="15%">月租金费用单价(万元/月):</td>
  			<td width="25%"> 
  				<input type="text" id="monthUnitPrie_i" name="monthUnitPrie_i" value="${workshop.tBasisWorkshopcost.monthUnitPrie_i}" onblur="Checkfun.IsDouble(this,'月租金费用单价',20)"/>
  			</td>
  			<td class="tor">年租金费用单价(万元/年):</td>
  			<td ><input type="text" id="yearUnitPrie_i" name="yearUnitPrie_i" value="${workshop.tBasisWorkshopcost.yearUnitPrie_i}"  onblur="Checkfun.IsDouble(this,'年租金费用单价',20)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor" width="15%">半年租金费用单价(万元/半年)</td>
  			<td width="25%"> 
  				<input type="text" id="halfUnitPrie_i" name="halfUnitPrie_i" value="${workshop.tBasisWorkshopcost.halfUnitPrie_i}" onblur="Checkfun.IsDouble(this,'半年租金费用单价',20)"/>
  			</td>
  			<td class="tor">服务管理费(元/月*平米):</td>
  			<td ><input type="text" id="serveManageUnitPrie_i" name="serveManageUnitPrie_i" value="${workshop.tBasisWorkshopcost.serveManageUnitPrie_i}"  onblur="Checkfun.IsInteger(this,'服务管理费',20)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor" width="15%">单价费用(元/天)</td>
  			<td width="25%"> 
  				<input type="text" id="unitprieI" name="unitprieI" value="${workshop.tBasisWorkshopcost.unitprieI}"  onblur="Checkfun.IsInteger(this,'单价费用',20)"/>
  			</td>
  			<td class="tor">车间平米数:</td>
  			<td ><input type="text" id="resaveds1" name="resaveds1" value="${workshop.tBasisWorkshopcost.resaveds1S}"  /> </td>
  			
  		</tr>
  		<tr>
  			
  			<td class="tor">备注:</td>
  			<td ><input type="text" id="remark" name="remark" value="${workshop.remark_s}"  /> </td>
  			<td class="tor" width="15%"></td>
  			<td width="25%"> 
  				<input type="hidden" id="workShopID" name="workShopID" value="${workShopID}"/>
  			</td>
  		</tr>
  		
  		<!--<tr>
  			<td colspan="4" align="center"">
  				 <a id="addworkshopBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr> -->
  	</table>
  	
  	
  	
  		<!-- 使用内容
	<table style="width: 100%;">
		<tr>
			<td width="60%" style="vertical-align: top;">
				<div id="p" class="easyui-panel" title="办公车间使用内容" data-options="iconCls:'edit_add'" >
				  	<div id="useinfoDiv" >
				  		<input type="hidden" name="useInfo" id="useInfo" value="">
				  		办公车间使用内容：<input type="text"  name="use" id="use" value="" >
				  	</div>
<script type="text/javascript">
$("#use").keydown(function(){
	if(event.keyCode==13){
		$(this).after("<br/>办公车间使用内容：<input type='text' id='use'  name='use' value='"+$(this).val()+"'  > ");
		$(this).val("");
	}
});
</script>				  	
				 
			  
			  	</div>
			</td>
			<td width="40%" style="vertical-align: top;">
				<div id="p" class="easyui-panel" title="已设置使用内容" style="padding:10px;width: 280px;height: 250px;">
					<c:choose>
						<c:when test="${empty useInfoList}">
						</c:when><c:otherwise>
						
							<c:forEach items="${useInfoList}" var="useinfolist">
							<p id="${useinfolist}">${useinfolist}
							<a title="删除" onClick="deleteuseinfo('${workShopID}','${useinfolist}')" >
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
  		<input type="hidden" id="subscribe" name="subscribe" value=""/>
  		<input type="hidden" id="monthsubscribe" name="monthsubscribe" value=""/>
  		<input type="hidden" id="daysubscribe" name="daysubscribe" value=""/>
  		<input type="hidden" id="manageunitprie" name="manageunitprie" value=""/>
  		<a  class="easyui-linkbutton" data-options="iconCls:'icon-add'"><label id="addworkshopBt" onClick="addworkshop()">确定</label></a>
  		</center>
  	</form>
  	
  	<script type="text/javascript">
  		function addworkshop(){
			//校验略
  			if($("#workShopName").val()==""){
  				$.messager.alert('Error','车间名称不能为空！');
  				return false;
  			}
			
			//alert($("#unitprieI").val());
  			var reg= /^([-]){0,1}([0-9]){1,}([.]){0,1}([0-9]){0,}$/;     
  	        if(!reg.test($("#unitprieI").val())){    
  	            $.messager.alert('Error','对不起，【单价费用】输入的整数类型格式不正确!');
  	          	$("#unitprieI").css("border","solid 1px #E33");
  	        	return false;
  	        }
			
			//var useform="";
			//var els =document.getElementsByName("use");
			//for (var i = 0, j = els.length; i < j; i++){
			//	alert(els[i].value);
			//	useform += els[i].value+"vv";
			//}
			//$("#useInfo").val(useform);
  			//alert($("#useInfo").val());
  			$("#subscribe").val($("#isSubscribe option:selected").val());
  			$("#monthsubscribe").val($("#ismonthSubscribe_i option:selected").val());
  			$("#daysubscribe").val($("#isdaysubscribe_i option:selected").val());
  			var str="提交操作？"
  			$.messager.confirm('确定', str, function(r){
  			if (r){
  				$.post(
  				"./addworkshopAction",
  				{
  					workShopName:$("#workShopName").val(),
  					isSubscribe:$("#subscribe").val(),
  					ismonthSubscribe_i:$("#monthsubscribe").val(),
  					isdaysubscribe_i:$("#daysubscribe").val(),
  					beginningday_i:$("#beginningday_i").val(),
  					unitprieI:$("#unitprieI").val(),
  					remark:$("#remark").val(),
  					workShopID:$("#workShopID").val(),
  					monthUnitPrie_i:$("#monthUnitPrie_i").val(),
  					yearUnitPrie_i:$("#yearUnitPrie_i").val(),
  					serveManageUnitPrie_i:$("#serveManageUnitPrie_i").val(),
  					halfUnitPrie_i:$("#halfUnitPrie_i").val(),
  					//useInfo:$("#useInfo").val(),
  					resaveds1:$("#resaveds1").val(),
  					time:new Date().getTime()
  					
  				},function(){
  					$.messager.alert('Success','车间信息操作成功！');
  					window.returnValue="refresh";
  		  	  	    window.close();
  				}
  	  				
  	  			);
  			//document.getElementById("addworkshopform").submit();
  			}
  			});
  			//window.returnValue="refresh";
	  	    //window.close();
  		}
  		
  		function deleteuseinfo(s,t){
  			var str="确定删除？"
  			$.messager.confirm('删除', str, function(r){
  			if (r){
	  			$.post(
	  				"./deluseinfoAction",
	  				{
	  					workShopID:s,
	  					deluseinfo:t,
	  					time:new Date().getTime()
	  					
	  				},function(){
	  					$.messager.alert('Success','操作成功！');
	  					document.getElementById(t).style.display="none";
	  				}
	  	  	  				
	  	  	  	);
		    }
		    })
  		}
  	
  		
  	</script>
  	
  	
  </div>
  </body>
</html>