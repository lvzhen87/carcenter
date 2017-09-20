<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>退订规则查询页面</title>
    
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
.toright{
	text-align: right;
}
tr{
	height: 25px;
}
#manageordertab td{
	text-align: center;
}

#trans td{
font-size: 12px;
}
input{
	width: 120px;
	border:1px solid #36D;
}
h4{
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color: #222;
}
li{
	
}
</style>


  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchUnRuleForm" name="searchUnRuleForm" action="./searchunRuleAction?time=new Date().getTime()" method="post">
			<div>
				是否生效：<select id="isEffect" name="isEffect" class="easyui-combobox">
							<option value="-1" >请选择</option>
	  						<option value="1" <c:if test="${isEffect == 1 }">selected="selected" </c:if>>生效</option>
	  						<option value="0" <c:if test="${isEffect == 0 }">selected="selected" </c:if>>无效</option>
  						</select>
				违约比例：<input type="text" id="breakPromiseDeduction_i" name="breakPromiseDeduction_i" value="${breakPromiseDeduction_i}"  />
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img id="" onclick="addUnrule()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			if($("#breakPromiseDeduction_i").val() != ""){
				var str=$("#breakPromiseDeduction_i").val();
				 reg=/^[-+]?\d*$/;     
		        if(!reg.test(str)){   
		        	$.messager.alert('Error','对不起，【违约比例】输入的整数类型格式不正确!');
		         	//$("#breakPromiseDeduction_i").css("border","solid 1px #E33");
					return false;
		        }
			}
			document.getElementById("searchUnRuleForm").submit();
		}
		
		function addUnrule(){
			var winPar=window.showModalDialog("./prepareUnruleAction?isUpdate=0", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchUnRuleForm").submit();
			}
		}
		
	</script>
	

	<table  title="退订规则" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="15%">编号</td>
				<td width="15%">大于  ( 小时 )</td>
				<td width="20%">小于  ( 小时 )</td>
				<td width="20%">违约比例  (%)</td>
				<td width="15%">是否生效</td>
				<td width="11%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty unrulelist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${unrulelist}" var="unrulelist" varStatus="unrulelistStatus">
			<c:set var="statusIndex" value="${unrulelistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${unrulelist.eventNumber_s}</td>
				<td>${unrulelist.greaterHourNumber_i}</td>
				<td>${unrulelist.lessHourNumber_i}</td>
				<td>${unrulelist.breakPromiseDeduction_i}</td>
				<td>
					<c:if test="${unrulelist.isEffect==0}">无效</c:if>
					<c:if test="${unrulelist.isEffect==1}">生效</c:if>
				</td>
				<td>
					<a title="修改" onclick="updateRule('${unrulelist.eventNumber_s}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleteUnrule('${unrulelist.eventNumber_s}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
					<input type="hidden" value="${unrulelist.eventNumber_s}"/>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	<script type="text/javascript">
		function updateRule(s){
		   var winPar=window.showModalDialog("./prepareUnruleAction?eventNumber_s="+s, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
		 	//alert(winPar);
		   if(winPar=="refresh"){
			document.getElementById("searchUnRuleForm").submit();
			}
		}
		
		function deleteUnrule(s){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
				    	$.post(
				  				"./deleteUnruleAction",
				  				{
				  					eventNumber_s:s,
				  					time:new Date().getTime()
				  				},function(msg){
									
			  						//$.messager.alert('删除','操作成功!');
			  						document.getElementById("searchUnRuleForm").submit();
				  				}
				  			);
				    }
				});
		}
	</script>
	
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px"
			id="trans"  border="0" width="95%" >
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchunRuleAction?currentPage=0&&breakPromiseDeduction_i=${breakPromiseDeduction_i}&&isEffect=${isEffect}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchunRuleAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&breakPromiseDeduction_i=${breakPromiseDeduction_i}&&isEffect=${isEffect}">前一页</a>&nbsp;
							<a href="./searchunRuleAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&breakPromiseDeduction_i=${breakPromiseDeduction_i}&&isEffect=${isEffect}">后一页</a>&nbsp;
							<a href="./searchunRuleAction?currentPage=${maxPage-1}&&breakPromiseDeduction_i=${breakPromiseDeduction_i}&&isEffect=${isEffect}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchUnRuleForm" method="post">
							转到第<c:if test="${maxPage==0}">1</c:if>
							<c:if test="${maxPage>0}">
						<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
							<c:forEach begin="1" end="${maxPage}" step="1" var="item" >
							<option value="${item-1}" <c:if test="${currentPage+1 == item}">selected="selected" </c:if>>${item }</option>
							</c:forEach>
						</select>
						</c:if>页
						</form>
						<script type="text/javascript">
							$(document).ready(function(){
						        $('#currentPage').combobox({
						            onChange:function(){
						                //alert("准备翻页");
										document.getElementById("changepage").submit();
						            }
						        });
						    });
						</script>
						</div>
					</td>
				</tr>
			</table>
	</div>
  </body>
</html>
