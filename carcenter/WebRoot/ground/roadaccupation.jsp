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
		muiltyclick{
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
    	<form action="./groundroadOccupationAction" method="post" >
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
    	<!--左边道路 -->
    	<div style="width:200px;float: left; display: inline; text-align: center;">
    		<table id="roadtable" width="200px" border="0px" style="border: solid 1px #0DD;padding: 0px;">
    			<tr >
    			<td id="ymdate" width="200px">${fn:substring(currentDate,0,7)}</td>
    			</tr>
    			<c:forEach begin="0" end="5" step="1" varStatus="i"   >
    			<c:forEach items="${roadNames}" var="item" >
    				<c:choose>
    					<c:when test="${item=='01'}">
			    			<tr>
    						<td width="150px">&nbsp;</td>
    						</tr>
    					</c:when><c:otherwise>
			    			<tr style="text-align: center;">
		    				<td style="float:none; display: inline;text-align: center;" nowrap="nowrap" width="200px">
		    					<p style="padding: 0px;margin: 0px;width: 180px;">${item.roadName_s}</p></td>
    						</tr>
    					</c:otherwise>
    				</c:choose>
    			</c:forEach>
    			</c:forEach>
    		</table>
    	</div>
    	<!--右边数据 -->
    	
    	<div style="width:650px;display:inline;float: left;">
    	<table id="mytable" name="mytable" width="650px" border="0px" style="border: solid 1px #0DD;padding: 0px;">
		<tr>
			
			<td>周日</td>
			<td>周一</td>
			<td>周二</td>
			<td>周三</td>
			<td>周四</td>
			<td>周五</td>
			<td>周六</td>
		</tr>
		<c:forEach begin="0" end="5" step="1" varStatus="i"   >
		
		<c:forEach items="${roadNames}" var="number" >
		<!-- 日期行 -->
		<tr>   	
    	<c:forEach items="${roadData }" var="item"  begin="${7*i.index}" end="${7*i.index+6 }">
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
						
	    				<td onclick="updatestate(this)" style="text-align: left;" align="left" 
	    					<c:if test="${item[number.roadID_s]>=number.maxCapacity_i}">style="background-color: #F33;"</c:if>
	    					<c:if test="${item[number.roadID_s]<number.maxCapacity_i}">style="background-color: #3A3;"</c:if> 	 
	    				>
	    					<!-- 
	    					<img alt="" title="${item[number]}/${item['00']} " src="images/progress.gif" width="${item[number]/item['00']*100}%" height="20px" >
	    					 <c:if test="${occupyRate<1}">
	    					 	<c:set var="occupyRate" value="1" ></c:set>
	    					 </c:if>
	    					 -->
	    					 <div >
	    					 	<font color="#EEE">${item[number.roadID_s]}/${number.maxCapacity_i}</font> 
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
<script>
	function updatestate(t){
		//alert("当前行:"+(t.parentElement.rowIndex)+" 当前列:"+(t.cellIndex)+" 值:"+ t.innerText);
		var lines=$("#mytable").find("tr").length;
		//alert("行数"+lines);
		
		var j=(lines-1)/6;
		//alert("循环道路数+1："+j);
		
		var row=t.parentElement.rowIndex;
		var dayrow;
		if(row<=j){//说明在第一个循环
			dayrow=0;
		}else if(row>j && row<=j*2){
			dayrow=j;
		}else if(row>j*2 && row<=j*3){
			dayrow=j*2;
		}else if(row>j*3 && row<=j*4){
			dayrow=j*3;
		}else if(row>j*4 && row<=j*5){
			dayrow=j*4;
		}else if(row>j*5 && row<=j*6){
			dayrow=j*5;
		}
		
		
		//alert("日期行："+dayrow);
		var v = $("#mytable tr:gt(0):eq("+dayrow+") td:eq("+t.cellIndex+")").text();
		//alert("要的日期："+v);
		
		var roadName=$("#roadtable tr:gt(1):eq("+(row-2)+") td:eq(0)").text();
		//alert("道路名称："+roadName);
		
		if(v<10){
			v="0"+v.trim();
		}
		var date=$("#ymdate").text();
		//alert("日期："+date);
		
		var finaldate=date+"-"+v;
		
		var winPar=window.showModalDialog("./PrepareUpdatestateAction?roadName="+roadName+"&&appointDate_d="+finaldate, "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
		
	}
</script>
    
 </div>   
  </body>
</html>
