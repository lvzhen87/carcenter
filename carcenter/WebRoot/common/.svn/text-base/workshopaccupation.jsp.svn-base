<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/common.css" type="text/css" />
    <script src="js/script.js"></script> 

    <script src="js/html5shiv.js"></script>
    <script src="forms.js"></script>
	
	<style type="text/css">
		td{
			text-align: center;
			height: 25px;
			width: 60px;
		}
		table{
			padding: 0px;
			margin: 0px;
		}
		img{
			padding: 0px;
			margin: 0px;
			border: 0px;
		}
	</style>
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<script src="js/calendar.js" type="text/javascript"></script>

  </head>
  <body style="margin: 0px;padding: 0px;">
  <div id="man_zone">
    <div style="heigth:25px;background-color: #DDD;text-align: center;">
    	  ${fn:substring(currentDate,0,7)}月时间安排
    </div>
    <div style="padding: 4px;">
    	<form action="./roadOccupationAction" method="post" >
    	请确认需要查询的月份&nbsp;&nbsp;<!--  <input class="easyui-datebox" name="currentDate" value="${currentDate}" /> -->
    	<input type="text" maxlength="10" id="Txt_Date" onclick="SelectDate(this,'yyyy-MM-dd')" name="currentDate" value="${currentDate}"  />
    	
    	<input type="submit" class="easyui-linkbutton" value="确认查询"  />
    	</form>
	<script type="text/javascript">
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
	</script>
    </div>
    <div style="display: inline;width:850px; ">
    	<!--左边车间名 -->
    	<div style="width:200px;float: left; display: inline; text-align: center;">
    		<table width="200px" border="0px" style="border: solid 1px #0DD;padding: 0px;">
    			<tr >
    			<td width="200px">${fn:substring(currentDate,0,7)}月</td>
    			</tr>
    			<c:forEach begin="0" end="6" step="1" varStatus="i"   >
    			<c:forEach items="${workshopNames}" var="item" >
    				<c:choose>
    					<c:when test="${item=='01'}">
			    			<tr>
    						<td width="150px">&nbsp;</td>
    						</tr>
    					</c:when><c:otherwise>
			    			<tr style="text-align: center;">
		    				<td style="float:none; display: inline;text-align: center;" nowrap="nowrap" width="200px">
		    					<p style="padding: 0px;margin: 0px;width: 180px;">${item.workShopName_s}</p></td>
    						</tr>
    					</c:otherwise>
    				</c:choose>
    			</c:forEach>
    			</c:forEach>
    		</table>
    	</div>
    	<!--右边数据 -->
    	<div style="width:650px;display:inline;float: left;">
    	<table width="650px" border="0px" style="border: solid 1px #0DD;padding: 0px;">
		<tr>
			
			<td>周日</td>
			<td>周一</td>
			<td>周二</td>
			<td>周三</td>
			<td>周四</td>
			<td>周五</td>
			<td>周六</td>
		</tr>
		<c:forEach begin="0" end="6" step="1" varStatus="i"   >
		
		<c:forEach items="${workshopNames}" var="number" >
		<!-- 日期行 -->
		<tr>   	
    	<c:forEach items="${workshopData}" var="item"  begin="${6*i.index}" end="${6*i.index+6 }">
    		<c:choose>
    			<c:when test="${item==null }">
    				<td>
    				&nbsp;
    				</td>
    			</c:when><c:otherwise>
    				<c:choose>
						<c:when test="${number=='01'}">
		    				<td style="background-color: #DDD; font-weight: bold;">
			    				${item[number]}
				    		</td>
						</c:when><c:otherwise>
	    				<td style="text-align: left;" align="left" 
	    					<c:if test="${item[number.workShopID_s]>=50}">style="background-color: #F33;"</c:if>
	    					<c:if test="${item[number.workShopID_s]<50}">style="background-color: #3A3;"</c:if> 	 
	    				>
	    					<!-- 
	    					<img alt="" title="${item[number]}/${item['00']} " src="images/progress.gif" width="${item[number]/item['00']*100}%" height="20px" >
	    					 <c:if test="${occupyRate<1}">
	    					 	<c:set var="occupyRate" value="1" ></c:set>
	    					 </c:if>
	    					 -->
	    					 <div >
	    					 	<font color="#EEE">${item[number.workShopID_s]}/${item['02']}</font> 
		    				</div>
			    		</td>
    				</c:otherwise>    					
    				</c:choose>
    			</c:otherwise>
    		</c:choose>
    		
    	</c:forEach>
    	</tr>
		
		</c:forEach>
    	</c:forEach>
    	
    	</table>
    	</div>
    </div>
    <!-- 占用表格结束 -->
 </div>   
  </body>
</html>
