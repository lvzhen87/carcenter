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
    
    <title>对讲机查询页面</title>
    
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
		<!-- 根据条件，查询对讲机信息 -->
		<form id="searchInterphoneForm" name="searchInterphoneForm" action="./initinterphoneAction" method="post">
			<div>
				对讲机编号：<input type="text" id="interphoneID" name="interphoneID" value="${interphoneID}"  />
				对讲机型号：<input type="text" id="interphonePast" name="interphonePast" value="${interphonePast}"  />
				对讲机品牌：<input type="text" id="brand" name="brand" value="${brand}"  />
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img id="" onclick="addInterphone()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchInterphoneForm").submit();
		}
		
		function addInterphone(){
			var winPar=window.showModalDialog("./prepareinterphoneAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchInterphoneForm").submit();
			}
		}
		
	</script>
	
	<table title="对讲机基本信息"  id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="23%">对讲机编号</td>
				<td width="25%">对讲机型号</td>
				<td width="25%">对讲机品牌</td>
				<td width="15%">对讲机状态</td>
				<td width="8%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty interphonelist}">
			<tr><td colspan="6">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${interphonelist}" var="interphonelist" varStatus="interphoneStatus">
			<c:set var="statusIndex" value="${interphoneStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${interphonelist.interphoneID_s}</td>
				<td>${interphonelist.interphonePast_s}</td>
				<td>${interphonelist.brand_s}</td>
				<td>
					<c:if test="${interphonelist.state_i==0}">故障</c:if>
					<c:if test="${interphonelist.state_i==1}">使用中</c:if>
					<c:if test="${interphonelist.state_i==2}">闲置</c:if>
					<c:if test="${interphonelist.state_i==3}">停用</c:if>
				</td>
				
				<td>
					<a title="修改" onclick="updateInterphone('${interphonelist.interphoneID_s }')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="停用" onclick="deleteinterphone('${interphonelist.interphoneID_s}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="停用" />
					</a> 
				</td>
				
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>	
	</table>
	<script type="text/javascript">
		function updateInterphone(s){
			var winPar=window.showModalDialog("./prepareinterphoneAction?interphoneID="+s, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchInterphoneForm").submit();
			}
		}
		
		function deleteinterphone(s){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
					
						$.post(
			  				"./deleteinterphoneAction",
			  				{
			  					interphoneID:s,
			  					time:new Date().getTime()
			  				},function(msg){
			  					//alert(msg);
			  					if(msg.length > 4){
			  						$.messager.alert("Error",msg);
			  					}else{
			  						$.messager.alert("Success","操作成功！");
			  						document.getElementById("searchInterphoneForm").submit();
			  					}
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
							<a href="./initinterphoneAction?flag=search&&currentPage=0&&interphoneID=${interphoneID}&&interphonePast=${interphonePast}&&brand=${brand}" target="manFrame" >首页</a>&nbsp;
							<a href="./initinterphoneAction?flag=search&&currentPage=${currentPage-1<=0?0:currentPage-1}&&interphoneID=${interphoneID}&&interphonePast=${interphonePast}&&brand=${brand}">前一页</a>&nbsp;
							<a href="./initinterphoneAction?flag=search&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&interphoneID=${interphoneID}&&interphonePast=${interphonePast}&&brand=${brand}">后一页</a>&nbsp;
							<a href="./initinterphoneAction?flag=search&&currentPage=${maxPage-1}&&interphoneID=${interphoneID}&&interphonePast=${interphonePast}&&brand=${brand}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchinterphoneAction" method="post">
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