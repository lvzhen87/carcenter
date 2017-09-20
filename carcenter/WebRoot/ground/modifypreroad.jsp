<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>包场预定</title>
    
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
		vertical-align: bottom;
		padding-top: 5px;
		margin-bottom: 5px;
		text-align: center;
	}
	td{
		vertical-align: top;
		font-size: 14px;
		text-align: left;
	}
	#roaddata td{
		vertical-align: bottom;
		text-align:center;
		font-size: 14px;
		border-bottom: 1px solid #636363;
	}
	.tabtitle{
		vertical-align: middle;
		font-size: 15px;
		font-weight:bold;
		background-color: #636363; 
		color: #F3F3F0;
	}
	input{
		width:60px;
		height:25px;
		font-size: 14px;
		border: 1px solid #95B8E7;
	}
	#roadMenu h3{
		display: inline;
		width: 160px;
		padding: 0px;
		margin: 0px;
	}
	textarea {
		border: 1px solid #95B8E7;
		padding: 0px;
		margin:2px;
		overflow:hidden;
		SCROLLBAR-FACE-COLOR: #95B8E7;
		SCROLLBAR-HIGHLIGHT-COLOR: #f6f6f6;
		SCROLLBAR-SHADOW-COLOR: #636363;
	}
	#hourItem{
	text-align: center;
	border: 1px solid #c7c7c7;
	width: 120px;
	padding: 0px;
	margin: 0px;
	}
	#nofull{
		style="background-color:#00CC00;
	}
	#full{
		style="background-color:#CC0000;
	}
	.nofull{
		style="background-color:#00CC00;
		color:#fcfcfc;
	}
	.full{
		style="background-color:#CC0000;
		color:#fcfcfc;
	}
	</style>
	<script type="text/javascript" >
     	function requestExp(){
     		//alert("请求 该条道路上的试验！");
     		$("#prestartdatepicker0").val( $('#prestartdatepicker').datebox('getValue') );
     		$("#preenddatepicker0").val( $('#preenddatepicker').datebox('getValue') );
     		$("#roadform").attr("action","./queryRoadExp?timestamp="+new Date().getTime());
     		//alert( $("#roadform").val() );
     		$("#roadform").submit();
     		return;
     	}
     	function checkNull(box,name){
     		 if( $(box).val()=="" || $(box).val().trim().length<1 ){
     		    	//请将“文本框”改成你需要验证的属性名称!
     		    	$.messager.alert('Error','对不起，【'+name+'】不能为空或者为空格!');
     		    	return false;
     			}
     	}
</script>
  </head>
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" >
	<form action="./savePreRoadAction" id="roadform" name="roadform" method="post" >
	 <table id="orderroadinfo" width="98%" >
        <tr >
            <td width="20%" >
            	包场道路:
        		<input type="hidden" name="roadName_s" id="roadName_s"  />
            	<select style="width:100px;height:25px;padding:0px; border: 1px solid #95B8E7;" id="roadID_s"  name="roadID_s">
            		<option value="-1" selected="selected" >请选择试验道路</option>
            		<c:forEach items="${roadinfolist}" var="roadInfo" >
			        	<option <c:if test="${roadID_s==roadInfo.roadID_s}"> selected="selected"</c:if>  value="${roadInfo.roadID_s}"> ${roadInfo.roadName_s}</option>
            		</c:forEach>
        		</select><font color="red">*</font>
        		<input type="hidden" name="currentRoadMax" id="currentRoadMax" value="${currentRoadMax}" >
        	</td> 
        	<td width="30%"  >
				包场日期：
        		<input type="text" class="easyui-datetimebox" style="width:120px;height: 25px;" id="prestartdatepickerFace"  value="${startDate_t }" ><font color="red">*</font>
	            <input type="hidden" name="startDate_t" id=prestartdatepicker >
        	</td>
        	<td width="15%">
        		车辆数：
				<input type="text" name="carNumber" value="${carNumber }" id="carNumber" /><font color="red">*</font>
        	</td>
        	<td width="30%" style="vertical-align: middle;">
        		
        		<a onclick="return false" href="javascript:void(0);" class="easyui-linkbutton" >
        			<label style="margin: 0px;" id="vehicleInfoButton" onclick="submitRoadform0()">查询时间段信息</label>
        		</a>
        		&nbsp;&nbsp;
        		<a onclick="return false" href="javascript:void(0);" class="easyui-linkbutton" target="mainFrame" >
					<label style="margin: 0px;" id="vehicleInfoButton" onclick="submitRoadform()">添加</label>
				</a>
        		<a href="./preroadAction" class="easyui-linkbutton" >
					返回
				</a>
        	</td>
        </tr>
       </table> 
<c:choose>
	<c:when test="${empty orderPreRoadTimeSquan }">
	<p style="color:red;">请点击【查询时间段信息】，先查询具体时间可订阅信息，然后预定.</p>
	</c:when><c:otherwise>
	       请选择时段：
		<table width="90%">
		<c:forEach begin="0" end="2" step="1" var="num" >
		<tr>
			<c:forEach items="${orderPreRoadTimeSquan}" var="item" varStatus="status" begin="${8*num}" end="${8*num+7 }" >
					<td style="width: 120px;height: 40px;padding: 0px;margin: 0px;">
						<div id="hourItem" onclick="chooseHour(this,'${status.index+1}')" style="cursor: hand;float: left;"  onmouseover="preChooseHour(this)" onmouseout="outChooseHour(this)" >
							<div class="hour" style="text-decoration: underline;font-weight: bold;" >${status.index+1}</div>
							<div id="flag" 
								<c:if test="${item['01']==currentRoadMax}">style="background-color:green;color:#fcfcfc;"</c:if>
								<c:if test="${item['01']<currentRoadMax}">style="background-color:red;color:#fcfcfc;"</c:if>
								<c:if test="${currentRoadMax<1}">style="background-color:gray;color:#fcfcfc;"</c:if>
							   > &nbsp;</div>
						</div>
					</td>
			</c:forEach>
		</tr>			
		</c:forEach>
		</table>
		<div style="width: 960px;position: static;">
		<div style="width: 160px;float: left; ">
		注释：
		<div style="text-align: center;border: 1px solid #c7c7c7;width: 160px;padding: 0px;margin: 0px;">
			<div style="background-color:green;color:#fcfcfc;" >可包场</div>
			<div style="background-color:red;color:#fcfcfc;" >不可包场</div>
		</div>
		</div>
		<div style="width: 680px;float: left;">
		<input type="hidden" name="timeQuantum" id="timeSquer" >
		<label id="choosedHourItem">已选时间段：<span id="chooseNum" style="color: red;"></span> </label>
		<div id="dataArea" ></div>
		</div>
		</div>
		<div style="clear: both;"></div>
	</c:otherwise>
	</c:choose>         
</form>
<script type="text/javascript">
var boxs=new Array();
var n=0;
function preChooseHour(box){
	$(box).css("color","#f7f7f7");
	$(box).css("background-color","#636363");
}
function outChooseHour(box){
	$(box).css("color","#373737");
	$(box).css("background-color","#FFFFFF");
}
function chooseHour(cp,index){
										//alert($(cp).children("div.flag").html());
	var chooseItemNum=$("#currentRoadMax").val();
	//alert("该道路 容纳最大值"+$("#currentRoadMax").val());
	
	var carNum=$("#carNumber").val();
	if(parseInt(chooseItemNum) < parseInt(carNum)){
		$.messager.alert('Error',"场地无法容纳"+$("#carNumber").val()+"辆车！");
		return false;
	}
	//检验该 时间段是否已经选中
	for(var i=0;i<boxs.length;i++){
		if(boxs[i]==index){
			$.messager.alert('Error',"该时间段已经选中！");
			return false;
		}
	}
	//检测是否 红色，不可选
	var dflag=$(cp).find("div#flag").css("background-color");
	//alert(dflag);
	if(dflag=="red"){
		$.messager.alert('Error',"请注意，红色时间段不可再选！");
		return false;
	}
	
	var box="<div id='choosedHourItem' onclick='delChooseHour(this)' style='cursor: hand;float: left;width:40px;text-align: center;border: 1px solid #c7c7c7;' >";
	box+=$(cp).html();
	box+="</div>";
	$("#dataArea").after(box);
	boxs[n++]=index;
	$("#chooseNum").html(boxs.length+" 段时间");
}
function delChooseHour(box){
	var cn=$(box).children("div.hour").html();
	for(var i=0;i<boxs.length;i++){
		if(boxs[i]==cn){
			boxs.splice(i,1);
			n-=1;
		}
	}
	$(box).remove();
	$("#chooseNum").html(boxs.length+" 段时间");
	//$(box).css("width","0px");
	//$(box).css("margin","0px");
	//$(box).css("padding","0px");
	//$(cp).css("background-color","#FFFFFF");
}

	function submitRoadform(){
		if( parseInt( $("#carNumber").val())<1 ){
			$.messager.alert('Error','请确认测试车辆数.');
			return false;
		}
		if( parseInt( $("#carNumber").val())>parseInt($("#currentRoadMax"))){
			$.messager.alert('Error','无法容纳试验车辆数.');
			return false;
		}
		//替换
		$("#prestartdatepicker").val( $('#prestartdatepickerFace').datebox('getValue') );
		//$("#preenddatepicker0").val( $('#preenddatepicker').datebox('getValue') );
		$("#roadName_s").val( $("#roadID_s").find("option:selected").text() );
		
		if( $("#prestartdatepicker").val().length<1){
			$.messager.alert('Error','请确认日期.');
			return false;
		}
		//alert("查询包场 时间段信息");
		if( $("#roadID_s").val()=="-1" ){
			$.messager.alert('Error','请确认试验道路.');
			return false;
		}
		
		//时间段校验
		if(boxs.length<1){
			$.messager.alert('Error','请先确认时间段');
			return false;
		}
		var timeStr="";
		for(var i=0;i<boxs.length;i++){
			timeStr+=boxs[i]+"v";
		}
		$("#timeSquer").val(timeStr);
		$("#roadform").submit();
	}
	function submitRoadform0(){
		//替换
		$("#prestartdatepicker").val( $('#prestartdatepickerFace').datebox('getValue') );
		//$("#preenddatepicker0").val( $('#preenddatepicker').datebox('getValue') );
		$("#roadName_s").val( $("#roadID_s").find("option:selected").text() );
	
		//alert($("#prestartdatepicker").val());
		if( $("#prestartdatepicker").val().length<1){
			$.messager.alert('Error','请确认日期.');
			return false;
		}
		//查询包场时间 只能是15日之内
		var sdate= $("#prestartdatepicker").val();
		var ndate=new Date();
		//alert("sdate ="+sdate +"    ndate="+ndate);
		var d1=new Date(sdate);
		var d2=new Date(ndate);
		var ms=d1.getTime()-d2.getTime();	//相差毫秒数
		var ds=parseInt( ms/(1000*60*60*24) )+1;
		//alert("两时间相差 天数"+ds);
		if(ds>15){
			$.messager.alert('Error','您当前只能选择15天之内的包场试验.');
			return false;
		}
		//alert("查询包场 时间段信息");
		if( $("#roadID_s").val()=="-1" ){
			$.messager.alert('Error','请确认试验道路.');
			return false;
		}
		if(parseInt ($("#carNumber"))<1){
			$.messager.alert('Error','请确认测试车辆数.');
			return false;
		}
		
		/*
		$.post(
 				"./orderRoadWholeInfoAction",
 				{
 					roadID_s:$("#roadID_s").find("option:selected").val(),
 					//roadName:$("#roadID_s").find("option:selected").text(),
 					startDate_t:$('#prestartdatepickerFace').datebox('getValue'),
 					carNumber:$("#carNumber").val(),
 					time:new Date().getTime()
 				},function(){
 					//alert("操作成功！");
 					window.location.reload();
					//window.returnValue="refresh";
 		  			//window.close();
 				}
 			);
		*/
		$("#roadform").attr("action","./orderRoadPreInfoAction");
		$("#roadform").submit();
	}
	
</script>
  </div>
  </body>
</html>
