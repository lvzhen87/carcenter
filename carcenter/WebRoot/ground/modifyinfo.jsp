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
    
    <title>基础信息</title>
    
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
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">试验名称:</td>
  			<td width="34%"> 
  				<input id="experimentName" name="experimentName" value="${orderdetail.orderName_s}" onblur="Checkfun.isNull(this,'试验名称',80)" style="width:90%;">&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			<td class="tor" width="10%">公司名称:</td>
            <td width="34%">
				<input disabled="true" readonly  id="companyName" name="companyName" style="width:90%;" value="${orderdetail.customer.customerName_s }">
			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="15%">公司所在地:</td>
  			<td width="30%">            
  			<input id="companyAddress" name="companyAddress" style="width:90%;" disabled="true" readonly  value="${orderdetail.customer.customerAddress_s }">
 			</td>
  			<td class="tor">部门:</td>
  			<td > 
				<input id="companyDepartment" name="companyDepartment" style="width:90%;" disabled="true" readonly   value="${orderdetail.customer.department_s }" >
			</td>
  		</tr>
  		<tr>
  			<td class="tor">发票抬头:</td>
  			<td>
  			   <input id="invoice" name="invoice" style="width:90%;" value="${orderdetail.invoiceOrder_s}">
 			</td>
  			<td class="tor">增值税号:</td>
  			<td >
            <input id="taxNum" name="taxNum" style="width:90%;"   value="${orderdetail.addedValueTax_s}">
			 </td>
  		</tr>
  		<tr>
  			<td class="tor">负责人:</td>
  			<td> <select id="contactUserID" name="contactUserID" style="height: 25px;font-size: 12px; width:100px" class="easyui-combobox">    		
        		<c:forEach items="${customeruser}" var="cususer">
        			<option value="${cususer.customerUserID_s }" <c:if test="${cususer.customerUserID_s==orderdetail.customerUserID_s }">selected</c:if> >${cususer.customerUserName_s }</option>
        		</c:forEach>
        	</select>        	
			</td>
  			<td class="tor">发票接收人:</td>
  			<td>  <input id="invoiceUser" name="invoiceUser" style="width:90%;" value="${orderdetail.invoiceUser_s}"  onblur="Checkfun.isNull(this,'发票接收人',80)" >&nbsp;&nbsp;<font color="red">*</font></td>
  		</tr>
  		
  		<tr>
  			<td class="tor">预定使用日期：</td>
  			<td colspan="3" > 
				<input type="text" class="easyui-datebox" id="startdatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${orderdetail.startDate_s}"/>	~
				<input type="text" class="easyui-datebox" id="enddatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${orderdetail.endDate_s}"/>&nbsp;&nbsp;<font color="red">*</font>
			</td>
  		</tr>
  		<tr>
  			<td colspan="4" align="center"">
  				<input type="hidden" id="customerId" name="customerId" value="${orderdetail.customerID_s }"/>
  				<a id="queryBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>
  	<script type="text/javascript">

  	$("#queryBt").click(function (){
  		if(!Checkfun.isNull($("#experimentName"),'试验名称',80)){
  			return false;
  		}
  		
  		if(!Checkfun.isNull($("#invoiceUser"),'发票接收人',80) ){
  			return false;
  		}
  		//if(!Checkfun.IsPhone($("#invoiceUserPhone"),'发票接收人电话') ){
  		//	return false;
  		//}
  		//if(!Checkfun.isNull($("#invoiceAddress"),'发票接收地址')){
  		//	return false;
  		//}
  		if($("#startdatepicker").val() ==null || $("#enddatepicker").val()==null){
  			$.messager.alert('Error','对不起，【预定使用日期】不能为空或者为空格!');
  			return false;
  		}
  		
  			//$("#addcustomeruserform").submit();
  			var str="提交更新操作？"
  				$.messager.confirm('确定', str, function(r){
  				    if (r){
	  				$.post(
	  					"./modifyOrderInfoAction",
	  	  				{
	  						customerId:$("#customerId").val(),
	  						experimentName:$("#experimentName").val(),
	  						companyName:$("#companyName").val(),
	  						companyAddress:$("#companyAddress").val(),
	  						companyDepartment:$("#companyDepartment").val(),
	  						invoice:$("#invoice").val(),
	  						taxNum:	$("#taxNum").val(),
	  						contactUserID:$("#contactUserID option:selected").val(),
	  						invoiceUser:$("#invoiceUser").val(),
	  						//invoiceUserPhone:$("#invoiceUserPhone").val(),
	  						//invoiceAddress:$("#invoiceAddress").val(),
	  						startdatepicker:$("#startdatepicker").datebox("getValue"),
	  						enddatepicker:$("#enddatepicker").datebox("getValue"),
	  	  					time:new Date().getTime()
	  	  				},function(){
	  	  					$.messager.alert('Success',"操作成功！");
		  					window.returnValue="refresh";
		  		  			window.close();
	  	  				}
	  			);
  			}
  				
  			});
  		
  		});
  	</script>
  	
  	</form>
  </div>
  </body>
</html>
