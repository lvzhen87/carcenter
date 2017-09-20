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
    
    <title>更改酒店信息页面</title>
    
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
  			<td class="tor" width="20%">入住日期：</td>
  			<td width="80%"> 
				<input type="text" class="easyui-datebox" id="startdatepicker"   name="startdatepicker"  data-options="formatter:myformatter,parser:myparser" value="${hotel.startDate_t}"/>	~
				<input type="text" class="easyui-datebox" id="enddatepicker"   name="enddatepicker"  data-options="formatter:myformatter,parser:myparser" value="${hotel.endDate_t}"/>
  			</td>
  			
  		</tr>
  		<tr>
  			<td class="tor" width="20%">房间类型：</td>
  			<td>            
				 标准房&nbsp;<select id="type1" name="type1" class="easyui-combobox">
            		<option value="-1" >请选择房间数</option>
                	<option value="1间" 	 <c:if test="${type1 == '1间'}">selected</c:if>>1间</option>
                	<option value="2间"  <c:if test="${type1 == '2间'}">selected</c:if>>2间</option>
                	<option value="3间"  <c:if test="${type1 == '3间'}">selected</c:if>>3间</option>
                	<option value="4间"  <c:if test="${type1 == '4间'}">selected</c:if>>4间</option>
                	<option value="5间"  <c:if test="${type1 == '5间'}">selected</c:if>>5间</option>
                </select>&nbsp;&nbsp;
                大床房&nbsp;<select id="type2" name="type2" class="easyui-combobox" >
                <option value="-1">请选择房间数</option>
                <option value="1间"  <c:if test="${type2 == '1间'}">selected</c:if>>1间</option>
               	<option value="2间"  <c:if test="${type2 == '2间'}">selected</c:if>>2间</option>
               	<option value="3间"  <c:if test="${type2 == '3间'}">selected</c:if>>3间</option>
               	<option value="4间"  <c:if test="${type2 == '4间'}">selected</c:if>>4间</option>
               	<option value="5间"  <c:if test="${type2 == '5间'}">selected</c:if>>5间</option>
                </select>&nbsp;&nbsp;
                豪华套间&nbsp;<select id="type3" name="type3" class="easyui-combobox" >
                <option value="-1">请选择房间数</option>
                <option value="1间"  <c:if test="${type3 == '1间'}">selected</c:if>>1间</option>
               	<option value="2间"  <c:if test="${type3 == '2间'}">selected</c:if>>2间</option>
               	<option value="3间"  <c:if test="${type3 == '3间'}">selected</c:if>>3间</option>
               	<option value="4间"  <c:if test="${type3 == '4间'}">selected</c:if>>4间</option>
               	<option value="5间"  <c:if test="${type3 == '5间'}">selected</c:if>>5间</option>
                </select>&nbsp;&nbsp;
 			</td>
  			
  		</tr>
  		<tr>
  			<td class="tor" width="20%">租车：</td>
  			<td width="80%"> 
				需要<input  type="checkbox" name="rentCar" id="rentCar"  <c:choose><c:when test="${hotel.isRentalCar_i ==1}">checked = "checked" </c:when>
				<c:otherwise>checked = "" </c:otherwise> </c:choose> style="border: 0; padding-left: 0" width="5px"/>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="20%">租驾驶员：</td>
  			<td>
  				<input type="text" name="isRentalDriver" id="isRentalDriver" value="${hotel.isRentalDriver_i }"  style="border: 0; padding-left: 0" width="10px"/>位
  			</td>
  		</tr>
  		 <tr>
        	<td class="tor">备注：</td>
        	<td><input type="text" name="remark_s" id="remark_s" value="${hotel.remark_s }" /> 
        	</td>
        </tr>
        <tr>
        	<td class="tor">其他服务信息:</td>
            <td><textarea cols="80" rows="5" name="otherService" id="otherService">${hotel.otherService_s }</textarea> </td>
        </tr>
  		<tr>
  			<td colspan="2" align="center"">
  			<input type="hidden" id="createDate" value="${hotel.createDate_t }"/>
  			<input type="hidden" id="createUser" value="${hotel.createUser_s }"/>
  			<input type="hidden" id="t1" name="t1" value=""/>
  			<input type="hidden" id="t2" name="t2" value=""/>
  			<input type="hidden" id="t3" name="t3" value=""/>
        	<a id="queryBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
				
  			</td>
  		</tr>
  			
  		
  	</table>	
  	<script type="text/javascript">
  	$("#queryBt").click(function (){
  		if($("#startdatepicker").datebox("getValue") ==null || $("#enddatepicker").datebox("getValue")== null){
  			$.messager.alert('Error',"请选择入住日期！");
  			return false;
  		}
  		
  		$("#t1").val($("#type1").combobox('getValues'));
  		$("#t2").val($("#type2").combobox('getValues'));
  		$("#t3").val($("#type3").combobox('getValues'));
  		var str="提交更新操作？"
			$.messager.confirm('确定', str, function(r){
			    if (r){
 				$.post(
 					"./modifyhotelAction",
 	  				{
 						startdate:$("#startdatepicker").datebox("getValue"),
 						enddate:$("#enddatepicker").datebox("getValue"),
 						type1:$("#t1").val(),
 						type2:$("#t2").val(),
 						type3:$("#t3").val(),
 						rentCar:$("#rentCar").attr("checked"),
 						isRentalDriver:$("#isRentalDriver").val(),
 						rentCarMsg:$("#rentCarMsg").val(),
 						remark_s:$("#remark_s").val(),
 						otherService_s:$("#otherService").val(),
 						createDate:$("#createDate").val(),
 						createUser:$("#createUser").val(),
 	  					time:new Date().getTime()
 	  				},function(msg){	
 	  					//alert("2");
 	  					$.messager.alert('Success','操作成功！');
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
