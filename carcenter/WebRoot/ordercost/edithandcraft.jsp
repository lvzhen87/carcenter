<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新手工录入费用信息</title>
    
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
	function readCardInfo(box) {
        //alert("111111");
        var demo = document.getElementById("helloBossma");
        //alert(demo);
        var result = demo.GetCardNum();
        //alert(result+"demo");
        //document.getElementById("vehicleCardID").value=result;
        box.value=result;
        if (result == "0") {
            //alert("read card successful!");
        } else {
            //alert("CMCC_ReadTicketInfo failed");
        }
        //document.getElementById("vehicleCardID").value = result;
    }
	
	
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
<form id="handform" method="post" action="./addHandcraftAction?time=new Date().getTime()" enctype="multipart/form-data" >

  	<table width="90%">
  		<tr>
  			<td class="tor" width="15%">订单名称1:</td>
  			<td width="34%">
	  			 		
		  				<select id="orderid" name="orderid"   >
			  				<c:forEach items="${rorderlist}" var="receporder">
			  					<option value="${receporder.orderID_s}" <c:if test="${receporder.orderID_s==handcraft.receptionOrder.orderID_s}">selected="selected"</c:if> >${receporder.orderName_s}</option>
			  				</c:forEach>
		  				</select>
	  					
	  			
  			</td>
  			<td class="tor"></td>
  			<td >  </td>
  		</tr>
  		<tr>
  			<td class="tor">发生时间:</td>
  			<td>
  				<input type="text" class="easyui-datebox" id="occutime"   name="occutime"  data-options="formatter:myformatter,parser:myparser"  value="<fmt:formatDate value="${handcraft.occurdatetimeT}" type="date" pattern="yyyy-MM-dd"/>" />
  			</td>
  			<td class="tor">费用:</td>
  			<td > <input type="text" id="cost" name="cost" value="${handcraft.reckoncostI}"  onblur="Checkfun.IsDouble(this,'费用',20)"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  		</tr>
  		<tr>
  			<td class="tor">CPG牌照号:</td>
  			<td><input type="text" id="cpg" name="cpg" value="${handcraft.receptionVehicleInfo.resaveds2_s}"/> </td>
  			<td class="tor">客户人员卡号:</td>
  			<td><input type="text" name="usercard" id="usercard" style="width:150px"  onclick="readCardInfo(this)" value="${handcraft.customerusercardS}" /></td>
  		</tr>
  		<tr>
  			<td class="tor">确认职员:</td>
  			<td> <input type="text" id="queryemployee" name="queryemployee" value="${handcraft.employeeNameS}" onblur="Checkfun.isNull(this,'确认职员',20)"/>&nbsp;&nbsp;</td>
  		
  			<td class="tor"></td>
  			<td > 
  				<input type="hidden" id="handid" name="handid" value="${handcraft.handcraftserialnumberS}"/>
  			</td>
  			
  		</tr>
  		
		<tr>
  			<td class="tor">备注:</td>
  			<td colspan="3"> 
  			<textarea rows="3" cols="90" id="remarkS" name="remarkS"   onblur="Checkfun.isNull(this,'备注',60)">${handcraft.remarkS}</textarea>
  			  		
  		</tr>
  	</table>
  
  	<center>
  		<a id="addBt" class="easyui-linkbutton"  >确定</a>
  	</center>
  	</form>
  	<script type="text/javascript">
  		$("#addBt").click(function (){
  		 
  		//校验略
  			if($("#occutime").val()==null){
  				$.messager.alert('Error','发生时间不能为空！请填写！');
  				return false;
  			}
  			if($("#cost").val()==''){
  				$.messager.alert('Error','费用不能为空！请填写！');
  				return false;
  			}
  		var v = $('#occutime').datetimebox('getValue');	
  		//var order=$("#orderid").val();
  		order = document.getElementById("orderid").value;
  	 	 
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  			if (r){
  			$.post(
  				"./addHandcraftAction",
  				{
  					id:$("#handid").val(),
  					orderid:order,
  					occutime:v,
  					cost:$("#cost").val(),
  					usercard:$("#usercard").val(),
  					cpg:$("#cpg").val(),
  					remarkS:$("#remarkS").val(),
  					queryemployee:$("#queryemployee").val(),
  					
  					time:new Date().getTime()
  				},function(errmsg){
  					if(errmsg.length>1&&errmsg.length<20){
  						alert(errmsg)
  					}else{
	  					$.messager.alert('Success','手工录入费用信息更新成功！');
	  					window.returnValue="refresh";
	  		  			window.close();
  		  			}
  				}
  			);
  			
  			}
  		});
  			
  		});
  		
  		
  		
  	</script>
 
  </div>
  </body>
</html>