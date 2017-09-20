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
    
    <title>订单详情查询页面</title>
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
  
  <body>
   <div class="content-box"><!-- Start Content Box -->
				
		<div class="content-box-header">
			<div style="padding-top: 10px;padding-left: 10px;margin: 0px;font-size: 12px;">
				<input type="button"  value="【打开道路占用详情】" onclick="openRoadAccupy()" />
				&nbsp;
				<input type="button"  value="【打开车间占用详情】" onclick="openRoadAccupy()" />
				<script type="text/javascript">
					function openRoadAccupy(){
						window.open("./roadOccupationAction", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
					}
				</script>
				
			</div>
			<ul class="content-box-tabs" >
				<li><a href="#tab1" <c:if test="${currentTab==0 }">class="default-tab"</c:if>>试验共享测试道路详情</a></li> <!-- href must be unique and match the id of target div -->
				<!-- s2014-5-26 <li><a href="#tab2" <c:if test="${currentTab==1 }">class="default-tab"</c:if>>安全信息详情</a></li>-->
				<li><a href="#tab2" <c:if test="${currentTab==2 }">class="default-tab"</c:if> >办公车间预订详情</a></li>
				<li><a href="#tab3" <c:if test="${currentTab==3 }">class="default-tab"</c:if>>酒店及其他服务预订详情</a></li>
				<li><a href="#tab4" <c:if test="${currentTab==4 }">class="default-tab"</c:if> >单台车辆信息预订详情</a></li>
				<li><a href="#tab5" <c:if test="${currentTab==5 }">class="default-tab"</c:if>>到访人员信息详情</a></li>
			</ul>
			<div class="clear"></div>
		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div <c:choose>
		<c:when test="${currentTab==0}">class="tab-content default-tab"  </c:when><c:otherwise>class="tab-content"</c:otherwise>
	</c:choose>	        id="tab1"> <!-- This is the target div. id must match the href of this div's tab -->
	<form action="./checkRoadOrderAction" method="post" name="checkRoadForm" id="checkRoadForm">
	<table class="dbgrid">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="10%">订单子编号</th>
			   <th width="10%">道路名称</th>
			   <th width="5%">测试车辆数</th>
			   <th width="5%">是否危险</th>
			   <th width="5%">摄影/摄像</th>
			   <th width="7%">计费方式</th>
			   <th width="8%">车辆CPG</th>
			   <th width="10%">预订时间</th>
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
        <c:forEach items="${roadsList}" var="roadlist" varStatus="rows" >
        <tr class="row${rows.count%2}"  <c:if test="${roadlist.statusI==2}"> bgcolor="red" </c:if>     >
           <td>${roadlist.orderroadidS}</td>
 		   <td>
 		   		<c:if test="${roadlist.typeS==0}">共享</c:if>
 		   		<c:if test="${roadlist.typeS==1}">专用</c:if>
 		   </td>
 		   <td>${roadlist.roadExperimentTypeModel.experimentTypeName_s}</td>
		   <td>${roadlist.roadnameS}</td>
		   <td>${roadlist.hoursnumberS}</td>
		   <td>${roadlist.carnumberI}</td>
		   <td>${roadlist.maxCapacity_i }</td>
		   <td>${roadlist.occupy_s}</td>
		   <td>
		   		<c:if test="${roadlist.billingMode_i==1 }">按时计费</c:if>
		   		<c:if test="${roadlist.billingMode_i==2 }">按里程计费</c:if>
		   </td>
		   <td>${roadlist.carCPG_s }</td>
		   <td>${roadlist.dateTStr }</td>
		   <td>
		   		<c:if test="${roadlist.statusI==0}"><input type="checkbox" name="selRoadItem" checked="true" value="${roadlist.orderroadidS},${roadlist.dateTStr}"></c:if>
		  		<c:if test="${roadlist.statusI==1}"><img src="images/icons/tick_circle.png"  alt="已确认" /></c:if>
		  		<c:if test="${roadlist.statusI==2}"><img src="images/icons/cross_circle.png"   alt="冲突" /></c:if>
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
			alert("确认审核");
			document.getElementById("checkRoadForm").submit();
		}
	</script>
	<div class="dbgrid" style="border: 1px solid #ddd; height: 40px;vertical-align: bottom; display: inline;">
		<!-- 分页 -->
			<div style="display: inline; width: 280px; padding-left: 10px; float: left;" >
				共有记录${roadMaxItem }条，分${roadMaxPage}页，当前第${roadCurrentPage+1 }页
			</div>
			<div style="display: inline;width: 240px;float:right;padding-right: 5px;">
				<a href="./searchALLOrderAction?roadCurrentPage=0&orderid=${orderid}" >首页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadCurrentPage-1<=0?0:roadCurrentPage-1}&orderid=${orderid}">前一页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadCurrentPage+1>=roadMaxPage?roadMaxPage-1:roadCurrentPage+1}&orderid=${orderid}">后一页</a>&nbsp;
				<a href="./searchALLOrderAction?roadCurrentPage=${roadMaxPage-1}&orderid=${orderid}">末页</a>&nbsp;&nbsp;
				<!-- 
				<form style="display: inline;" action="./searchALLOrderAction" method="post">
				转到第<select name="currentPage" onchange="submitPage()">
					<c:forEach begin="1" end="${roadMaxPage}" step="1" var="item" >
					<option value="${item-1}" >第${item }页</option>
					</c:forEach>
				</select>页
				</form>
				-->
				<script type="text/javascript">
					function submitPage(){
						//alert("准备翻页");
					}
				</script>
			</div>
	</div>
</div> <!-- End #tab1 -->
<!-- start #tab2 车辆安全 -->	
<%--<div <c:choose>
		<c:when test="${currentTab==1}">class="tab-content default-tab"  </c:when><c:otherwise>class="tab-content"</c:otherwise>
	</c:choose>	 id="tab2">
	<c:choose>
			<c:when test="${empty orderotherList}">
				查无记录！
			</c:when><c:otherwise>
		
				<table class="dbgrid">				
					<thead>
						<tr bgcolor="#E8F0FF">
						   <th width="15%">订单号</th>
						  <th width="15%">CPG牌照号</th>
						   <th width="20%">车辆型号</th>
						   <th width="10%">整备质量</th>
						   <th width="15%">最大总质量</th>
						   <th width="10%">颜色</th>
						   <th width="15%">燃油需求</th>
						</tr>
						
					</thead>
								
				<tbody>
				<!-- 遍历mapSess中存入的相应数据 -->
		        <c:forEach items="${orderotherList}" var="orderotherlist" varStatus="rows" >               
		        <tr class="row${rows.count%2}">
				   <td>${orderotherlist.orderID_s} </td>
		           <td>${orderotherlist.vehicleCPG_s}</td>
				   <td>${orderotherlist.model_s}</td>
				   <td>${orderotherlist.weight_s}</td>
				   <td>${orderotherlist.maxWeight_s}</td>	   
				   <td>${orderotherlist.color_s}</td>	   
				   <td>${orderotherlist.fuelDemand_s}</td>
				</tr>
		       	</c:forEach>	
				</tbody>				
			</table>	
		</c:otherwise>
		</c:choose>
<div class="dbgrid" style="border: 1px solid #ddd; height: 40px;vertical-align: bottom; display: inline;">
		<!-- 分页 -->
			<div style="display: inline; width: 280px; padding-left: 10px; float: left;" >
				共有记录${otherMaxItem }条，分${otherMaxPage}页，当前第${otherCurrentPage+1 }页
			</div>
			<div style="display: inline;width: 240px;float:right;padding-right: 5px;">
				<a href="./searchALLOrderAction?otherCurrentPage=0&orderid=${orderid}" >首页</a>&nbsp;
				<a href="./searchALLOrderAction?otherCurrentPage=${otherCurrentPage-1<=0?0:otherCurrentPage-1}&orderid=${orderid}">前一页</a>&nbsp;
				<a href="./searchALLOrderAction?otherCurrentPage=${otherCurrentPage+1>=otherMaxPage?otherMaxPage-1:otherCurrentPage+1}&orderid=${orderid}">后一页</a>&nbsp;
				<a href="./searchALLOrderAction?otherCurrentPage=${otherMaxPage-1}&orderid=${orderid}">末页</a>&nbsp;&nbsp;
				
				<script type="text/javascript">
					function submitPage(){
						alert("准备翻页");
					}
				</script>
			</div>
	</div>
</div>
--%><!-- end #tab2 -->


<!-- start #tab3 车间办公室详情 -->						
<div <c:choose>
		<c:when test="${currentTab==2 }">class="tab-content default-tab"  </c:when><c:otherwise>class="tab-content"</c:otherwise>
	</c:choose>	 id="tab3">
						
<form method="post" action="./checkWorkShopAction" name="checkWorkshopForm" id="checkWorkshopForm">
	<table class="dbgrid">				
			<thead>
				<tr bgcolor="#E8F0FF">
				   <th width="10%" >订单号</th>
				  <th width="10%" >订单子编号</th>
				   <th width="20%">车间名称</th>
				   <th width="15%" >使用内容</th>
				   <th width="15%">预订日期</th>
				   <th width="10%">创建人</th>
				   <th width="10%">
				   	<input type="checkbox" title="全选" name="selAllWorkshopItem" id="selAllWorkshopItem" onclick="selectAllWorkshop()" >
			   		<input type="button"  value="确认" name="submitWorkshopBt" id="submitWorkshopBt" onclick="submitCheckWorkshopForm()" >
		   			<input type="hidden" name="orderid" value="${orderid }" >
		   			<input type="hidden" name="currentTab" value="2" >
				   </th>
				</tr>
				
			</thead>
						
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${workshopList}" var="workshoplist" varStatus="rows" >               
        <tr class="row${rows.count%2}">
		   <td>${workshoplist.orderID_s} </td>
           <td>${workshoplist.orderWorkShopID_s}</td>
		   <td>${workshoplist.workShopName_s}</td>
		   <td>${workshoplist.useInfo_s}</td>
		   <td>${workshoplist.date_t}</td>	   
		   <td>${workshoplist.createUser_s}</td>
		   <td>
		   		<c:if test="${workshoplist.status_i==0}"><input type="checkbox" checked="true" name="selWorkshopItem" value="${workshoplist.orderWorkShopID_s},${workshoplist.date_t}"></c:if>
		  		<c:if test="${workshoplist.status_i==1}"><img src="images/icons/tick_circle.png"  alt="已确认" /></c:if>
		  		<c:if test="${workshoplist.status_i==2}"><img src="images/icons/cross_circle.png"   alt="冲突" /></c:if>
		  </td>
		</tr>
       	</c:forEach>	
		</tbody>				
	</table>	
</form>
	<script type="text/javascript">
		function selectAllWorkshop(){
			var selAll=document.getElementById("selAllWorkshopItem").checked;
  			if(selAll){
				var boxs=document.getElementsByName("selWorkshopItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("selWorkshopItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=false;
				}
  			}
			
		}
		function submitCheckWorkshopForm(){
			alert("确认审核");
			document.getElementById("checkWorkshopForm").submit();
		}
	</script>	
	<div class="dbgrid" style="border: 1px solid #ddd; height: 40px;vertical-align: bottom; display: inline;">
		<!-- 分页 -->
			<div style="display: inline; width: 280px; padding-left: 10px; float: left;" >
				共有记录${workMaxItem }条，分${workMaxPage}页，当前第${workCurrentPage+1 }页
			</div>
			<div style="display: inline;width: 240px;float:right;padding-right: 5px;">
				<a href="./searchALLOrderAction?workCurrentPage=0&currentTab=2&orderid=${orderid}" >首页</a>&nbsp;
				<a href="./searchALLOrderAction?workCurrentPage=${workCurrentPage-1<=0?0:workCurrentPage-1}&currentTab=2&orderid=${orderid}">前一页</a>&nbsp;
				<a href="./searchALLOrderAction?workCurrentPage=${workCurrentPage+1>=workMaxPage?workMaxPage-1:workCurrentPage+1}&currentTab=2&orderid=${orderid}">后一页</a>&nbsp;
				<a href="./searchALLOrderAction?workCurrentPage=${workMaxPage-1}&currentTab=2&orderid=${orderid}">末页</a>&nbsp;&nbsp;
				<!-- 
				<form style="display: inline;" action="./searchALLOrderAction" method="post">
				转到第<select name="currentPage" onchange="submitPage()">
					<c:forEach begin="1" end="${roadMaxPage}" step="1" var="item" >
					<option value="${item-1}" >第${item }页</option>
					</c:forEach>
				</select>页
				</form>
				-->
				<script type="text/javascript">
					function submitPage(){
						alert("准备翻页");
					}
				</script>
			</div>
	</div>				
</div> <!-- End #tab3 -->        
<!-- start #tab4 酒店预订详情 -->	
	<div class="tab-content" id="tab4">
						
	<table class="dbgrid">				
			<thead>
				<tr bgcolor="E8F0FF">
				   <th width="15%" >订单号</th>
				   <th width="15%" >状态</th>
				   <th width="15%">入住日期</th>
				   <th width="15%">离店日期</th>
				   <th width="25%">需要类型</th>
				   <th width="15%">备注</th>
				   
				</tr>
			</thead>
						
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${orderhotelList}" var="hotellist" varStatus="rows" >        
       <!-- <form method="post" action="./checkWorkShopAction"> --> 
        <tr class="row${rows.count%2}">
           <td>${hotellist.orderID_s}</td>
           <td>
           		<c:if test="${hotellist.status_i==0}">初始</c:if>
           		<c:if test="${hotellist.status_i==1}">已确认</c:if>
           		<c:if test="${hotellist.status_i==2}">已取消</c:if>
           		<c:if test="${hotellist.status_i==3}">冲突</c:if>
           </td>
		   <td>${hotellist.startDate_t} </td>
		   <td>${hotellist.endDate_t}</td>
		   <td>${hotellist.type_s}</td>
		   <td>${hotellist.remark_s}</td>
		  
		</tr>
		<!--</form>  -->
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
