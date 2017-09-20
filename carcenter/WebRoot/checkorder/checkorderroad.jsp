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
    
    <title>订单道路详情页面</title>
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
		
	<script type="text/javascript" src="js/verify.js"></script>
	<style type="text/css">
		workshopquery{}
		workshopconflict{}
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

  </head>
  
  <body>
   <div class="content-box"><!-- Start Content Box -->
				
		<div class="content-box-header">
			
			<h3>申请试验详情</h3>
			
			<ul class="content-box-tabs">
				<li><a href="#tab1" class="default-tab">路面预订详情</a></li> <!-- href must be unique and match the id of target div -->
				<li><a href="#tab2">安全信息详情</a></li>
				<li><a href="#tab3">办公车间预订详情</a></li>
				<li><a href="#tab4">酒店预订详情</a></li>
			</ul>
			
			<div class="clear"></div>
			
		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->			
	<div class="tab-content default-tab" id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
	<form action="./checkRoadOrderAction" method="post" name="checkRoadForm" id="checkRoadForm">
	<table width="100%">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="12%" >订单号</th>
			   <th width="12%" >订单子编号</th>
			   <th width="5%">类型</th>
			   <th width="10%" >道路名称</th>
			   <th width="8%">每日用时</th>
			   <th width="5%" >数量</th>
			   <th width="8%">最大容量</th>
			   <th width="10">描述</th>
			   <th width="10%">预订时间</th>
			   <th width="15%"> 
			   		<input type="checkbox" name="selAllRoadItem" id="selAllRoadItem" onclick="selectAllRoad()" >
			   		<input type="button"  value="确认" name="submitRoadBt" id="submitRoadBt" onclick="submitCheckRoadForm()" >
			   </th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${roadsList}" var="roadlist" varStatus="rows" >
        <tr class="row${rows.count%2}">
		   <td>${roadlist.orderidS }</td>
           <td>${roadlist.orderroadidS}</td>
 		   <td>${roadlist.typeS  }</td>
		   <td>${roadlist.roadnameS}</td>
		   <td>${roadlist.hoursnumberS}</td>
		   <td>${roadlist.carnumberI}</td>
		   <td>${roadlist.maxCapacity_i }</td>
		   <td>${roadlist.descriptionS}</td>
		   <td>${roadlist.dateTStr }</td>
		   <td>
		   		<input type="hidden" name="roadids" value="${roadlist.orderroadidS}" >
		   		<input type="hidden" name="roaddates" value="${roadlist.dateTStr}" >
		   		<input type="checkbox" name="roadstatus" value="1"> 
		   </td>
		</tr>
       	</c:forEach>	
		</tbody>
	</table>
	</form>
	<script type="text/javascript">
		function selectAllRoad(){
			var selAll=document.getElementById("selAllRoadItem").checked;
  			if(selAll){
				var boxs=document.getElementsByName("roadstatus");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("roadstatus");
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
	<div style="border: 1px solid #ddd; height: 40px;vertical-align: bottom;">
		<!-- 分页 -->
			<div style="display: inline; width: 100px; padding-left: 10px;" >
				共有记录${roadMaxItem }条，分${roadMaxPage}页，当前第${roadCurrentPage+1 }页
			</div>
			<div style="display: inline;width: 340px;float: right;padding-right: 5px;">
				<a href="./searchALLOrderAction?roadCurrentPage=0" >首页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadCurrentPage-1<=0?0:roadCurrentPage-1}">前一页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadCurrentPage+1>=roadMaxPage?roadMaxPage:roadCurrentPage+1}">后一页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadMaxPage}">末页</a>&nbsp;&nbsp;
				<form style="display: inline;" action="./searchALLOrderAction" method="post">
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
<!-- start #tab2 车辆安全 -->	


<!-- end #tab2 -->
<!-- start #tab3 车间办公室详情 -->						
<div class="tab-content" id="tab3">
						
	<table>				
			<thead>
				<tr bgcolor="#E8F0FF">
				  <th width="8%" >订单子编号</th>
				   <th width="6%" >订单号</th>
				   <th width="4%" >状态</th>
				   <th width="5%">车间名称</th>
				   <th width="10%" >使用内容</th>
				   <th width="10%">预订时间</th>
				   <th width="10%">创建人</th>
				   <th width="8%">操作</th>
				</tr>
				
			</thead>
						
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${workshopList}" var="workshoplist" varStatus="rows" >               
        <form method="post" action="./checkWorkShopAction">
        <tr class="row${rows.count%2}">
           <td>${workshoplist.orderWorkShopID_s}</td>
		   <td>${workshoplist.orderID_s} </td>
		   <td>${workshoplist.status_i}</td>
		   <td>${workshoplist.workShopName_s}</td>
		   <td>${workshoplist.useInfo_s}</td>
		   <td>${workshoplist.date_t}</td>	   
		   <td>${workshoplist.createUser_s}</td>
		   <td>
		  <img class="workshopquery" src="images/icons/tick_circle.png" style="cursor:hand;"  alt="已确认" />
		  <img class="workshopconflict" src="images/icons/cross_circle.png" style="cursor:hand;"  alt="冲突" />
		   <%--
			 <a  href="./checkWorkShopAction?workshopstatus=1&workshopdate=${workshoplist.date_t}&workshopid=${workshoplist.orderWorkShopID_s}" class="passcheck" title="已确认" >
            	<img src="images/icons/tick_circle.png" style="cursor:hand;"  alt="已确认" />
            </a>
            <a  href="./checkWorkShopAction?workshopstatus=2&workshopdate=${workshoplist.date_t}&workshopid=${workshoplist.orderWorkShopID_s}" class="passcheck" title="冲突" >
            	<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="冲突" />
            </a>			
            --%></td>
		</tr>
		</form>
       	</c:forEach>	
		</tbody>				
	</table>	
	<script type="text/javascript">
		$("img.workshopquery").click(function(){
			var workshopdate=$(this).parent().parent().children("td").get(5).innerHTML;
			var workshopid=$(this).parent().parent().children("td").get(0).innerHTML;
			$.post(
				"./checkWorkShopAction",
				{
					workshopstatus:1,
					workshopdate:workshopdate,
					workshopid:workshopid
				},function(){
					alert(workshopid+"订单已确认");
			});
		});
		$("img.workshopconflict").click(function(){
			
			var workshopdate=$(this).parent().parent().children("td").get(5).innerHTML;
			var workshopid=$(this).parent().parent().children("td").get(0).innerHTML;
			$.post(
				"./checkWorkShopAction",
				{
					workshopstatus:1,
					workshopdate:workshopdate,
					workshopid:workshopid
				},function(){
					alert(workshopid+"订单冲突");
			});
		});
	</script>						
</div> <!-- End #tab3 -->        
<!-- start #tab4 酒店预订详情 -->	
	<div class="tab-content" id="tab4">
						
	<table>				
			<thead>
				<tr bgcolor="#E8F0FF">
				   <th width="10%" >订单号</th>
				   <th width="10%" >状态</th>
				   <th width="10%">入住日期</th>
				   <th width="10%">离店日期</th>
				   <th width="20%">需要类型</th>
				   <th width="10%">备注</th>
				   <th width="10%">创建人</th>
				</tr>
			</thead>
						
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${workshopList}" var="workshoplist" varStatus="rows" >               
        <form method="post" action="./checkWorkShopAction">
        <tr class="row${rows.count%2}">
           <td>${workshoplist.orderWorkShopID_s}</td>
		   <td>${workshoplist.orderID_s} </td>
		   <td>${workshoplist.status_i}</td>
		   <td>${workshoplist.workShopName_s}</td>
		   <td>${workshoplist.useInfo_s}</td>
		   <td>${workshoplist.date_t}</td>	   
		   <td>${workshoplist.createUser_s}</td>
		   <td>
		  <img class="workshopquery" src="images/icons/tick_circle.png" style="cursor:hand;"  alt="已确认" />
		  <img class="workshopconflict" src="images/icons/cross_circle.png" style="cursor:hand;"  alt="冲突" />
		   <%--
			 <a  href="./checkWorkShopAction?workshopstatus=1&workshopdate=${workshoplist.date_t}&workshopid=${workshoplist.orderWorkShopID_s}" class="passcheck" title="已确认" >
            	<img src="images/icons/tick_circle.png" style="cursor:hand;"  alt="已确认" />
            </a>
            <a  href="./checkWorkShopAction?workshopstatus=2&workshopdate=${workshoplist.date_t}&workshopid=${workshoplist.orderWorkShopID_s}" class="passcheck" title="冲突" >
            	<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="冲突" />
            </a>			
            --%></td>
		</tr>
		</form>
       	</c:forEach>	
		</tbody>				
	</table>	
	<script type="text/javascript">
		$("img.workshopquery").click(function(){
			var workshopdate=$(this).parent().parent().children("td").get(5).innerHTML;
			var workshopid=$(this).parent().parent().children("td").get(0).innerHTML;
			$.post(
				"./checkWorkShopAction",
				{
					workshopstatus:1,
					workshopdate:workshopdate,
					workshopid:workshopid
				},function(){
					alert(workshopid+"订单已确认");
			});
		});
		$("img.workshopconflict").click(function(){
			
			var workshopdate=$(this).parent().parent().children("td").get(5).innerHTML;
			var workshopid=$(this).parent().parent().children("td").get(0).innerHTML;
			$.post(
				"./checkWorkShopAction",
				{
					workshopstatus:1,
					workshopdate:workshopdate,
					workshopid:workshopid
				},function(){
					alert(workshopid+"订单冲突");
			});
		});
	</script>						
</div> 				
<!-- end #tab4 -->	
	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
