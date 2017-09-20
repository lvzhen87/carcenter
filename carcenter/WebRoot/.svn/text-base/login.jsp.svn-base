<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <link rel="icon" href="images/set01.ico" >
     <link rel="shortcut icon" href="images/set01.ico"  />
    <title>试验场管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  </head>
 <body style="text-align: center;" onload="setFocus()">

    <div id="login">
	
	     <div id="top">
		      <div id="top_left"><img src="images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			  
			  <form id="loginForm" name="loginForm" action="./loginAction.action" method="post">
			       <div id="user" style="margin-top:5px;">账户：
			         <input type="text" name="loginName" id="loginName" style="height: 25px;" />
			       </div>
				   <div id="password" style="margin-top:5px;">密码：
				     <input type="password" name="loginPwd" id="loginPwd" style="height: 25px;" />
				   </div>
				   <!-- 
				   <div id="password" style="margin-top:5px;">角色：
				     <select style="width:120px;" name="loginRole">
				     	<option value="001">试验助理</option>
				     	<option value="002">接待专员</option>
				     	<option value="003">控制塔专员</option>
				     	<option value="004">结算专员</option>
				     	<option value="005">试验主管</option>
				     </select>
				   </div>
				    -->
				   <div align="center" id="loginbtn" style="margin-top:30px; vertical-align:middle;text-align: center;">
                   	<label onclick="loginFormSubmit()" style="" >
                   	<a href="#" id="loginFormBt" onclick="return false" class="easyui-linkbutton"  data-options="iconCls:'icon-remove'">
                   		登录 </a></label>&nbsp;&nbsp;
                   	<a href="#" id="loginFormCls" class="easyui-linkbutton" onclick="loginFormClear()"  data-options="iconCls:'icon-reload'">清空</a>
                   	<!-- 
                   	<input style="width:180px; " type="submit" value="登录"/>
                     -->
                    </div>
			  </form>
			  <font color="red">${msg }</font>
			  <script type="text/javascript">
			  	function loginFormSubmit(){
			  		document.getElementById("loginForm").submit();
			  	}
			  	function loginFormClear(){
			  		$("#loginName").val("");
			  		$("#loginPwd").val("");
			  		return false;
			  	}
			  	$("#loginPwd").keydown(function(){
			  		if(event.keyCode==13){
			  			loginFormSubmit();
			  		}
			  	});
			  	function setFocus(){
			  		document.getElementById("loginName").focus();
			  	}
			  </script>
			  </div>
			  <div id="center_right"></div>		 
		
		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">试验场管理系统</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>
</body>
</html>
