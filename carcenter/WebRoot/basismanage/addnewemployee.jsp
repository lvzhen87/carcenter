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
    
    <title>修改职工信息</title>
    
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
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
      <form id="searchEmployeeForm" name="searchEmployeeForm" method="post" action="" enctype="multipart/form-data"  >
  	<table width="90%">
  		
  		<tr>
  			<td class="tor">人员名称:</td>
  			<td> <input readonly="readonly" type="text" id="customerUserName_s" name="customerUserName_s" value="${emp.customerUserName_s }"/> </td>
  			<td class="tor">身份证号:</td>
  			<td > <input readonly="readonly" type="text" id="identityCard_s" name="identityCard_s" value="${emp.identityCard_s }"  /> </td>
  		</tr>
  		<tr>
  			<td class="tor">手机号码:</td>
  			<td> <input type="text" id="telephone_s" name="telephone_s" value="${emp.telephone_s }" /> </td>
  			<td class="tor">联系人传真:</td>
  			<td> <input type="text" id="facsimile_s" name="facsimile_s" value="${emp.facsimile_s }"/> </td>
  		</tr>
  		<tr>
  			<td class="tor">联系人邮箱:</td>
  			<td > <input type="text" id="email_s" name="email_s" value="${emp.email_s }" onblur="Checkfun.IsEmail(this,'联系人邮箱')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td></td><td><input type="hidden" id="employeeID_s" name="employeeID_s" value="${emp.employeeID_s }"/></td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">员工登录名:</td>
  			<td width="30%"> 
  				<input type="text" id="employeeLoginName" name="employeeLoginName" value="${emp.employeeLoginName }" />
  			</td>
  			<td></td>
  			<td></td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">部门名称:</td>
  			<td width="30%">
  				<select  id="organizationDept_s"  name="organizationDept_s" class="easyui-combobox"  >            		 
            		<c:forEach items="${organizationDeptlist}" var="organizationDept" >			        
			        	<option value="${organizationDept.organizationDept_s}" <c:if test="${emp.organizationDept_s == organizationDept.organizationDept_s}">  selected="selected" </c:if> >${organizationDept.deptName_s }</option>
            		</c:forEach>
        		</select>&nbsp;&nbsp;
  			</td>
  			<td class="tor" width="10%">岗位名称:</td>
  			<td width="30%">
  				<select  id="o1"  name="o1" class="easyui-combobox" onchange="ccc()">            		 
            		<c:forEach items="${organizationPostlist}" var="organizationPost" >			        
			        	<option value="${organizationPost.organizationPost_s}" <c:if test="${emp.organizationPost_s == organizationPost.organizationPost_s}">  selected="selected" </c:if> >${organizationPost.postName_s }</option>
            		</c:forEach>
        		</select>&nbsp;&nbsp;
        		<input type="hidden" id="organizationPost_s1" name="organizationPost_s1"  value=""/>
        		<input type="hidden" id="organizationDept_s1" name="organizationDept_s1"  value=""/>
  			</td>
   		</tr>
  		<tr>
  			<td class="tor" width="10%">密码:</td>
  			<td width="30%">
  				<input type="text" id="password_s" name="password_s" value="" />&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			<td class="tor" width="10%">确认密码:</td>
  			<td width="30%">
  				<input type="text" id="password2" name="password2" value="" />&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  		</tr>
  		
  		<tr>
  			<td colspan="4" align="center"">
  				<a id="addUserBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	
  	<script type="text/javascript">
  		 
  		$(document).ready(function(){
	        $('#organizationDept_s').combobox({	        	
	            onChange:function(){	            
	        		document.getElementById("searchEmployeeForm").action="./prepareEmpAction";
					document.getElementById("searchEmployeeForm").submit();
  	            }
	        });
	    });
	     
  		$("#addUserBt").click(function (){
  			//alert("ok");
  			//if(!Checkfun.isNull($("#customerUserName_s"),'人员名称',80)) {
  			//	return;
  			//}
  			//if(!Checkfun.IsIDCard($("#identityCard_s"),'身份证号')){
  			//	return;
  			//}
  			if(!Checkfun.IsEmail($("#email_s"),'联系人邮箱')){
  				return;
  			}
  			//if(!Checkfun.IsPhone($("#telephone_s"),'手机号码')){
  			//	return;
  			//}
  			if($("#password_s").val()!=$("#password2").val() ){
       			$("#password_s").css("border","solid 2px #E33");
       			$("#password2").css("border","solid 2px #E33");		
       			$.messager.alert('Error','对不起，确认密码与密码输入不一致！');
				return;
       		}
  			//if($("#customerUserName_s").val()==""){
  			//	alert("人员名称不能为空！");
  			//	return false;
  			//}

  			//if($("#identityCard_s").val()==""){
  			//	alert("身份证号不能为空！");
  			//	return false;
  			//}
  			//if($("#email_s").val()==""){
  			//	alert("邮箱不能为空！");
  			//	return false;
  			//}
  			//if($("#telephone_s").val()==""){
  			//	alert("电话号码不能为空！");
  			//	return false;
  			//}
  		 $("#organizationPost_s1").val($("#o1").combobox('getValues'));
  		 $("#organizationDept_s1").val($("#organizationDept_s").combobox('getValues'));
  		//校验略
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  		if (r){
  			$.post(
  				"./updateemployeeInfoAction",
  				{
  					customerUserName_s:$("#customerUserName_s").val(),
  					identityCard_s:$("#identityCard_s").val(),
  					telephone_s:$("#telephone_s").val(),
  					facsimile_s:$("#facsimile_s").val(),
  					email_s:$("#email_s").val(),
  					employeeLoginName:$("#employeeLoginName").val(),
  					password_s:$("#password_s").val(),
  					employeeID_s:$("#employeeID_s").val(),  					
  					organizationDept_s:$("#organizationDept_s1").val(),
  					organizationPost_s:$("#organizationPost_s1").val(),
  					time:new Date().getTime()
  				},function(msg){
  					//alert(msg);
  					if(msg.length<20){
  						$.messager.alert('Error','对不起，职员登录名不能重复！');
  					}else{
  						$.messager.alert('Success','员工信息操作成功！');
  	  					window.opener.location.href=window.opener.location.href;
  	  					window.close(); 
  					}
  					
  				}
  			);
  		}
  		});
  			
  		});
  	</script>
  	</form>
  </div>
  </body>
</html><!--

	            	var organizationPost_s = document.getElementById("o1");  
		  			 		var e = document.form1.o1; 
		  			 	  
		  			 		alert(organizationPost_s.options.length+'wwwwww')
		  			 
		  			 	 	
		  			 		$nextSelect = $("o1");
 		  			 	  
		  			 		alert(organizationPost_s.options.length+'wwwwww')
		  					for (var i=organizationPost_s.options.length; i>0; i--) {
		  						alert(i)
		  						$nextSelect.remove(i);
		  					}
	            	s = $("#organizationDept_s").combobox('getValues')
	            	 
	            	$.post(
		  				"./getPostListAction",
		  				{
		  					organizationDept_s:$("#organizationDept_s").combobox('getValues'),
		  					time:new Date().getTime()
		  				},function(json){
		  					//alert(msg);
		  				 	var organizationPost_s = document.getElementById("o1");  
		  			 		var e = document.form1.o1; 
		  			 	  
		  			 		alert(organizationPost_s.options.length+'wwwwww')
		  			 	 	$("#o1").html("")
		  			 	 	
		  			 		$nextSelect = $("o1");
 		  			 	  
		  			 		alert(organizationPost_s.options.length+'wwwwww')
		  					for (var i=organizationPost_s.options.length; i>0; i--) {
		  						alert(i)
		  						$nextSelect.remove(i);
		  					}
		  					organizationPost_s.append("<option value='" + 2 + "'>" + 333 + "</option>")
		  					
		  				}
		  			);-->