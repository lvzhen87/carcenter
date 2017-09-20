<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>添加收费信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/common.css" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/verify.js"></script>
<style type="text/css">
.tor {
	text-align: right;;
}

tr {
	height: 30px;
}

input {
	width: 300px;
	border: 1px solid #36D;
	height: 25px;
}
</style>

</head>

<body style="margin: 0px;padding: 0px; width: 1100px">
	<div id="man_zone" style="height: 520px; width: 1080px;">

		<table width="90%" >

			<tr>
				<td class="tor">补贴部门:</td>
				<td>
					<table id="dpttable">
						<c:forEach items="${dlist}" var="department">
							<tr>
								<c:if test="${department.checkstatus!=''}">
									<td><p>
											<input type="checkbox" name="check_name"
												value="${department.dptId}" text="${department.dptName}"
												style="width: 30px; "
												<c:if test="${department.checkstatus == '1'}">checked="checked"</c:if>>${department.dptName}</p></td>
								</c:if>

								<c:if test="${department.checkstatus2!=''}">
									<td><p>
											<input type="checkbox" name="check_name"
												value="${department.dptId2}" text="${department.dptName2}"
												style="width: 30px; "
												<c:if test="${department.checkstatus2 == '1'}">checked="checked"</c:if>>${department.dptName2}</p></td>
								</c:if>

								<c:if test="${department.checkstatus3!=''}">
									<td><p>
											<input type="checkbox" name="check_name"
												value="${department.dptId3}" text="${department.dptName3}"
												style="width: 30px; "
												<c:if test="${department.checkstatus3 == '1'}">checked="checked"</c:if>>${department.dptName3}</p></td>
								</c:if>
							</tr>
						</c:forEach>

						<%--  <s:iterator value="${dlist}" status="department" >  
						 	<tr>
						 	<td>
						 	<input type="text" id="breakfirstMoney"
									name="breakfirstMoney" value="${department.DptName}" />
						 	</td>
						 	</tr>
						 </s:iterator> --%>
					</table>
				</td>
				<td valign="top">
					<table>
						<tr>
							<td class="tor">早餐补贴:</td>
							<td><select id="breakfirstStatsu">
									<option value="1"
										<c:if test="${breakfirstStatus == '1'}">selected="selected" </c:if>>固定金额补贴</option>
									<option value="2"
										<c:if test="${breakfirstStatus == '2'}">selected="selected" </c:if>>动态金额补贴</option>
							</select></td>
							<td><input type="text" id="breakfirstMoney"
								name="breakfirstMoney" value="${breakfirstMoney}" /></td>
						</tr>
						<tr>
							<td class="tor">午餐补贴:</td>
							<td><select id="lanchStatus">
									<option value="1"
										<c:if test="${lanchStatus == '1'}">selected="selected" </c:if>>固定金额补贴</option>
									<option value="2"
										<c:if test="${lanchStatus == '2'}">selected="selected" </c:if>>动态金额补贴</option>
							</select></td>
							<td><input type="text" id="lanchMoney" name="lanchMoney"
								value="${lanchMoney}" /></td>
						</tr>
						<tr>
							<td class="tor">晚餐补贴:</td>
							<td><select id="dinnerStatus">
									<option value="1"
										<c:if test="${dinnerStatus == '1'}">selected="selected" </c:if>>固定金额补贴</option>
									<option value="2"
										<c:if test="${dinnerStatus == '2'}">selected="selected" </c:if>>动态金额补贴</option>
							</select></td>
							<td><input type="text" id="dinnerMoney" name="dinnerMoney"
								value="${dinnerMoney}" /></td>
						</tr>
						<tr>
						<td colspan="3">
						<table>
						<tr>
						<td>
							固定金额补贴:
						</td>
						<td>
							指定时间有消费记录，补贴固定金额。
						</td>
						</tr>
						<tr>
						<td width="110px">
							动态金额补贴:
						</td>
						<td  width="360px">
							指定时间有消费记录，在没有达到配置金额时，按照消费金额补贴，如果超过配置金额，按照配置金额补贴.
						</td>
						</tr>
						</table>
							
						</td>
						</tr>
						

					</table>
				</td>
			</tr>

		</table>

		<center>
			<input type="hidden" id="id_i" name="id_i" value="${chargeinfo.id_i}" />
			<a id="addBt" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">确定</a>
		</center>
		<script type="text/javascript">
  		$("#addBt").click(function (){
	  	/* 	 newwpd = $("#password_s").val()
	 		 if(newwpd.length!=6){
	 		 	
	 		 	alert('密码长度应为6位');
	 		 	 $("#password_s").val("");
	 		 	document.getElementById("password_s").focus();
	 		 	return
	 		 }
	   		 newpwd1 = $("#newpwd1").val()
	   		  */
			//alert(1);
			//alert( $("input:checkbox[name=check_name]:checked"));
			var breakfirstMoney;
			var lanchMoney;
			var dinnerMoney;
			var breakfirstStatsu;
			var lanchStatus;
			var dinnerStatus;
			var status = 0;
			breakfirstMoney =  $("#breakfirstMoney").val();
			lanchMoney =  $("#lanchMoney").val();
			dinnerMoney =  $("#dinnerMoney").val();
			
			breakfirstStatsu = $("#breakfirstStatsu").val();
			lanchStatus = $("#lanchStatus").val();
			dinnerStatus = $("#dinnerStatus").val();

			if(!SubmitCk(breakfirstMoney))
			{
			
			$.messager.alert('Faild','早餐补贴无效，请重新输入！');
				//alert("早餐补贴无效，请重新输入");
				return;
			}
			
			if(!SubmitCk(lanchMoney))
			{
			
			$.messager.alert('Faild','午餐补贴无效，请重新输入！');
				//alert("午餐补贴无效，请重新输入");
				return;
			}
			
			if(!SubmitCk(dinnerMoney))
			{
			$.messager.alert('Faild','晚餐补贴无效，请重新输入！');
				//alert("晚餐补贴无效，请重新输入");
				return;
			}
			
	        $("input:checkbox[name=check_name]:checked").each(function(i){  
	            if(0==i){  
	                adIds = $(this).val();  
	            }else{  
	                adIds += (","+$(this).val());  
	            }  
	        });  
	        //alert(adIds);  
	        
	   		//校验略
	  		var str="提交操作？"
	  		$.messager.confirm('确定', str, function(r){
	  			if (r){
	  			$.post(
	  				"./updatesubsidiesinfoAction",
	  				{
	  					breakfirstMoney:breakfirstMoney,
						lanchMoney:lanchMoney,
						dinnerMoney:dinnerMoney,
						breakfirstStatus:breakfirstStatsu,
						lanchStatus:lanchStatus,
						dinnerStatus:dinnerStatus,
	  					dptList:adIds,  					 
	  					time:new Date().getTime()
	  				},function(){
	  					$.messager.alert('Success','修改成功！');
	  					//window.returnValue="refresh";
	  		  			//window.close();
	  				}
	  			);  			
	  			}
	  			
	  		});
	  		
  			//document.getElementById("addroadinfoform").submit();
  	  	  	//window.returnValue="refresh";
	  	   // window.close();
  			
  		});
  		
			
		function SubmitCk(money) {
			var reg = /^-?\d+$/;
			if (!reg.test(money)) {
			
				return false;
			}
			return true;
		}
  		
  	</script>

	</div>
</body>
</html>