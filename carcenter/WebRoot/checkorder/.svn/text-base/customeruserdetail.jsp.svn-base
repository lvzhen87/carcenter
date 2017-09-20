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
    
    <title>客户详情查询页面</title>
<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="css/resources/reset.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="css/resources/style.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="css/resources/invalid.css" type="text/css" media="screen" />	
     
     
     <link  rel="stylesheet" media="screen" href="css/style.css">
     <link  rel="stylesheet" href="css/font-awesome.css">
     
     <link href="css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
     <link rel="stylesheet" href="css/jquery.ui.all.css">
     <link rel="stylesheet" href="css/demos.css">
     <link href="css/hover.css" rel="stylesheet" media="all">
    	<!-- jQuery -->
		<script type="text/javascript" src="js/showjs/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="js/showjs/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="js/showjs/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="js/showjs/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="js/showjs/jquery.datePicker.js"></script>
		<script type="text/javascript" src="js/showjs/jquery.date.js"></script>
	<style type="text/css">
		workshopquery{}
		workshopconflict{}
		.dbgrid{
			width: 1040px;
		}
		th{
			text-align: center;
			font-weight: bold;
			font-size: 14px;
			height: 30px;
			vertical-align: middle;
		}
		td{
			text-align: center;
			height: 25px;
			vertical-align: middle;
		}
		.row0{
			background-color: #EEEEEE;
		}
		.row1{
			background-color: #FFFFFF;
		}
	</style>
<script type="text/javascript">
	function unclick(){
		return false;
	}
</script>
  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
   <div class="content-box"><!-- Start Content Box -->
				
		<div class="content-box-header" style="width: 1040px;">
			<!--
			<div style="padding-top: 10px;padding-left: 10px;margin: 0px;font-size: 12px;">
				  
				<input type="button"  value="【打开道路占用详情】" onclick="openRoadAccupy()" />
				&nbsp;
				<input type="button"  value="【打开车间占用详情】" onclick="openRoadAccupy()" />
				<script type="text/javascript">
					function openRoadAccupy(){
						window.open("./roadOccupationAction", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
					}
				</script>
				
			</div>-->
			<ul class="content-box-tabs" >
				<li><a href="./roaddetailAction" >试验共享测试道路详情</a></li> <!-- href must be unique and match the id of target div -->
				<li><a href="./wholeroaddetailAction" >试验包场测试道路详情</a></li>
				<li><a href="./preroaddetailAction" >试验预付费道路详情</a></li>
				<li><a href="./workshopdetailAction" >办公车间预订详情</a></li>
				<!-- <li><a href="./hotelAction" >酒店及其他服务预订详情</a></li> -->
				<li><a href="./vehicleAction"  >单台车辆信息预订详情</a></li>
				<li><a href="./customerUserRegisterAction" class="tab-content default-tab">到访人员信息详情</a></li>
			</ul>
			<div class="clear"></div>
		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div > <!-- This is the target div. id must match the href of this div's tab -->
	<form action="" method="post" name="checkRoadForm" id="checkRoadForm">
	<table class="dbgrid">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="15%">人员编号</th>
			   <th width="20">人员名称</th>
			   <th width="10%">人员类别</th>
			   <th width="15%">联系电话</th>
			   <!-- 
			   <th width="15%">是否需要机场接送</th>
			   <th width="15%">是否入住酒店</th> 
			   -->
			   <th width="10%"> 
			   		<input type="checkbox" title="全选" name="selAllRoadItem" id="selAllRoadItem" onclick="selectAllRoad()" >
			   		<input type="button"  value="确认" name="submitRoadBt" id="submitRoadBt" onclick="submitCheckRoadForm()" >
		   		<input type="hidden" name="orderid" value="${orderid }" >
		   		<input type="hidden" name="currentTab" value="0" >
			   </th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty registerlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${registerlist}" var="rlist" varStatus="rlistStatus">
			<c:set var="statusIndex" value="${rlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
	           <td>${rlist.customerUserID_s}</td>
	           <td>${rlist.vcustomeuser.customerusername_s }</td>
	 		   <td>
	 		   		<c:if test="${rlist.userType_i==1 }">客户负责人</c:if>
	 		   		<c:if test="${rlist.userType_i==2 }">陪同人员</c:if>
	 		   		<c:if test="${rlist.userType_i==3 }">驾驶员</c:if>
	 		   </td>
	 		   <td>
	 		   		${rlist.vcustomeuser.telephone_s}
	 		   </td>
	 		   <!-- 
	 		   <td>
					<c:if test="${rlist.userType_i==1 }">需要</c:if>
	 		   		<c:if test="${rlist.userType_i==0 }">不需要</c:if>
				</td>
			    <td>
					<c:if test="${rlist.userType_i==1 }">需要</c:if>
	 		   		<c:if test="${rlist.userType_i==0 }">不需要</c:if>
				</td>
			    <td>
					<c:if test="${rlist.userType_i==1 }">需要</c:if>
	 		   		<c:if test="${rlist.userType_i==0 }">不需要</c:if>
				</td>
				 -->
			   <td>
			   		<input type="checkbox" name="selRoadItem" checked="true" value="">
			  		
			   </td>
			</tr>
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
		</tbody>
	</table>
	</form>
	<script type="text/javascript">
		function selectAllRoad(){
			var selAll=document.getElementById("selAllRoadItem").checked;
  			if(selAll){
				var boxs=document.getElementsByName("selRoadItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("selRoadItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=false;
				}
  			}
			
		}
		function submitCheckRoadForm(){
			//alert("确认审核");
			document.getElementById("checkRoadForm").submit();
		}
	</script>
	<br/><br/>
	<div class="dbgrid" style="border: 1px solid #ddd; height: 40px;vertical-align: bottom; display: inline;">
		<!-- 分页 -->
			<div style="display: inline; width: 280px; padding-left: 10px; float: left;" >
				共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1 }页
			</div>
			<div style="display: inline;width: 400px;float:right;padding-right: 5px;">
				<a href="./customerUserRegisterAction?currentPage=0&orderid=${orderid}" >首页</a>&nbsp;
				<a href="./customerUserRegisterAction?currentPage=${currentPage-1<=0?0:currentPage-1}&orderid=${orderid}">前一页</a>&nbsp;
				<a href="./customerUserRegisterAction?currentPage=${currentPage+1>=maxPage?maxPage-1:currentPage+1}&orderid=${orderid}">后一页</a>&nbsp;
				<a href="./customerUserRegisterAction?currentPage=${maxPage-1}&orderid=${orderid}">末页</a>&nbsp;&nbsp;
				
				<form style="display: inline;" action="./customerUserRegisterAction" method="post" id="changepage">
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
	</div>
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
