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
    
    <title>添加客户人员</title>
    
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
		width: 300px;
		border:1px solid #36D;
		height: 25px;
	}
	</style>

  </head>
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
      <form id="addcustomeruserform" method="post" action="./addCustomerUserAction" enctype="multipart/form-data" >
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">公司名称:</td>
  			<td width="30%"> 
  					<select id="customer" class="easyui-combobox">  				
	  						<option value="${customer.customerID_s }">${customer.customerName_s}</option>
  					</select>
  			</td>
  			<td class="tor" width="10%">人员类别:</td>
                <td>
                	<select id="userType_i" name="userType_i" class="easyui-combobox">
                		<option value="1">客户负责人</option>
                		<option value="2">陪同人员</option>
                		<option value="3">驾驶员</option>
                	</select>	
				</td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">部门名称:</td>
  			<td width="30%"> <input type="text" id="department_s" name="department_s" value="${vcustomeruser.department_s}" onblur="Checkfun.isNull(this,'部门',80)"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">联系人职务:</td>
  			<td > <input type="text" id="position_s" name="position_s" value="${vcustomeruser.position_s}" /> </td>

  		</tr>
  		<tr>
  			<td class="tor">客户姓名:</td>
  			<td> <input type="text" id="customerUserName_s" name="customerUserName_s" value="${vcustomeruser.customerusername_s}" onblur="Checkfun.isNull(this,'客户联系人',80)"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">身份证号:</td>
  			<td > <input type="text" id="identityCard_s" name="identityCard" value="${vcustomeruser.identitycard_s}" onblur="Checkfun.IsIDCard(this,'身份证号')"/> &nbsp;&nbsp;<font color="red">*</font></td>
  		</tr>
  		<tr>
  			<td class="tor">手机号码:</td>
  			<td> <input type="text" id="telephone_s" name="telephone_s" value="${vcustomeruser.telephone_s}" onblur="Checkfun.IsPhone(this,'手机号码')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">联系人传真:</td>
  			<td> <input type="text" id="facsimile_s" name="facsimile_s" value="${vcustomeruser.facsimile_s}" /> </td>
  		</tr>
  		<tr>
  			<td class="tor">联系人邮箱:</td>
  			<td > <input type="text" id="email_s" name="email_s" value="${vcustomeruser.email_s}" onblur="Checkfun.IsEmail(this,'联系人邮箱')"/>&nbsp;&nbsp;<font color="red">*</font></td>
  			<td></td><td><input type="hidden" id="customerUserID" name="customerUserID" value="${vcustomeruser.customeruserid_s}"/></td>
  		</tr>
  		
  		<tr>
  			<td class="tor">驾照号：</td>
  			<td > <input type="text" id="drivingLicenceCPG_s " name="drivingLicenceCPG_s " value="${vcustomeruser.drivingLicenceCPG_s }"  /> </td>
  			<td ></td><td ></td>
  		</tr>
  		<tr>
  			<td colspan="4" align="center"">
  				<input type="hidden" id="companyid" name="companyid"  value=""/>
  				<input type="hidden" id="companyname" name="companyname"  value=""/>
  				<input type="hidden" id="uType" name="uType"  value=""/>
  				
  				<a id="addUserBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>
  	</form>
  	<script type="text/javascript">
  		$("#addUserBt").click(function (){
  			//alert("${vcustomeruser.drivingLicenceCPG_s }");
  			if($("#userType_i option:selected").val()==3){
  				//alert($("#userType_i option:selected").val()+"--"+$("#drivingLicenceCPG_s").val());
  				if($("#drivingLicenceCPG_s").val()==""){
  					$.messager.alert('Error','新增驾驶员需要填写驾驶证号！');
  					return false;
  				}
  			}
  			if(!Checkfun.isNull($("#customerUserName_s"),'客户联系人',80)){
  				return false;
  			}
  			if(!Checkfun.isNull($("#department_s"),'部门',80)){
  				return false;
  			}
  			if(!Checkfun.IsIDCard($("#identityCard_s"),'身份证')){
  				return false;
  			}
  			if(!Checkfun.IsPhone($("#telephone_s"),'手机号码')){
  				return false;
  			}	
  			if(!Checkfun.IsEmail($("#email_s"),'联系人邮箱')){
  				return false;
  			}
  			$("#companyid").val($("#customer").combobox('getValue'));
  			$("#companyname").val($("#customer").combobox('getText'));
  			$("#uType").val($("#userType_i").combobox('getValue'));
  			alert($("#uType").val());
  			//校验略
  			//$("#addcustomeruserform").submit();
  			var str="提交操作？"
  				$.messager.confirm('确定', str, function(r){
  				    if (r){
	  				$.post(
	  					"./addExuser",
	  	  				{
	  	  					customerId:$("#companyid").val(),
	  	  					customerName:$("#companyname").val(),
	  	  					department:$("#department_s").val(),
	  	  					//customerUserID:$("#customerUserID").val(),
	  	  					UserName:$("#customerUserName_s").val(),
	  	  					identityCard:$("#identityCard_s").val(),
	  	  					telephone:$("#telephone_s").val(),
	  	  					position:$("#position_s").val(),
	  	  					facsimile:$("#facsimile_s").val(),
	  	  					email:$("#email_s").val(),
	  	  					type:$("#uType").val(),
	  	  					drivingLicenceCPG_s:"${vcustomeruser.drivingLicenceCPG_s }",
	  	  					time:new Date().getTime()
	  	  				},function(resultid){
	  	  					//alert(resultid);
	  	  					$.messager.alert('Success','客户人员信息操作成功！');
		  					window.returnValue=resultid+","+$("#customerUserName_s").val()+","+$("#uType").val();
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
