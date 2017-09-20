<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title></title>
    
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
  
 <body style="padding: 0px;margin: 0px; width: 99%;">
 	 
	
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询该驾驶员信息 -->
		<form id="searchForm" name="searchForm" action="./initHandcraftAction?time=new Date().getTime()" method="post">
			<div>
				订单名称：<input type="text" id="ordername" name="ordername" value="${ordername }"  />
				CPG牌照：<input type="text" id="cpg" name="cpg"  value="${cpg}"  />
				开始时间：<input type="text" class="easyui-datebox" id="start"   name="start" 
				  data-options="formatter:myformatter,parser:myparser" value="${start}"/>
				结束时间：  <input type="text" class="easyui-datebox" id="end" name="end" 
				data-options="formatter:myformatter,parser:myparser"  value="${end}"/>
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="add()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchForm").submit();
		}
		
		function add(){
			var winPar=window.showModalDialog("./prepareHandcraftAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			
			if(winPar=="refresh"){
				document.getElementById("searchForm").submit();
			}
		}
	</script>
	
	<table  title="信息"  id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="10%">订单编号</td>
				<td width="15%">订单名称</td>
				<td width="10%">发生时间</td>
				<td width="10%">费用</td>
				<td width="10%">客户人员</td>
				<td width="10%">CPG牌照号</td>
				<td width="10%">确认职员</td>
				<td width="10%">备注</td>
				<td width="8%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty hclist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${hclist}" var="hclist" varStatus="hclistStatus">
			<c:set var="statusIndex" value="${hclistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${hclist.receptionOrder.orderID_s}</td>
				<td>${hclist.receptionOrder.orderName_s}</td>
				<!--<td>${hclist.occurdatetimeT}</td>
				-->
				<td><fmt:formatDate value="${hclist.occurdatetimeT}" type="date" pattern="yyyy-MM-dd"/></td>
				
				<td>${hclist.reckoncostI}</td>
				<td>${hclist.customerUser.customerusername_s}</td>
				<td>${hclist.receptionVehicleInfo.resaveds2_s}</td>
				<td>${hclist.employeeNameS}</td>
				<td>${hclist.remarkS}</td>
				<td>
					<a title="修改" onclick="update('${hclist.handcraftserialnumberS}')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleteworkshop('${hclist.handcraftserialnumberS}')">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>	
	<script type="text/javascript">
		function update(s){
			var winPar=window.showModalDialog("./prepareHandcraftAction?id="+s, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchForm").submit();
			}
		}
		
		function deleteworkshop(s){
			var str="确定要删除？"
			$.messager.confirm('删除', str, function(r){
			    if (r){
			    	$.post(
			  				"./deleteHandcraftAction",
			  				{
			  					id:s,
			  					time:new Date().getTime()
			  				},function(msg){
								
		  						//$.messager.alert('删除','操作成功!');
		  						document.getElementById("searchForm").submit();
			  				}
			  			);
			    }
			});
		}
		
		
			
	</script>
	</table>
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" 
			  id="trans"  border="0" 
	width="95%">
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./initHandcraftAction?currentPage=0&&ordername=${ordername}&&cpg=${cpg}&&start=${start}&&end=${end}" target="manFrame" >首页</a>&nbsp;
							<a href="./initHandcraftAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&ordername=${ordername}&&cpg=${cpg}&&start=${start}&&end=${end}">前一页</a>&nbsp;
							<a href="./initHandcraftAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&ordername=${ordername}&&cpg=${cpg}&&start=${start}&&end=${end}">后一页</a>&nbsp;
							<a href="./initHandcraftAction?currentPage=${maxPage-1}&&ordername=${ordername}&&cpg=${cpg}&&start=${start}&&end=${end}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./initHandcraftAction?ordername=${ordername}&&cpg=${cpg}&&start=${start}&&end=${end}" method="post">
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