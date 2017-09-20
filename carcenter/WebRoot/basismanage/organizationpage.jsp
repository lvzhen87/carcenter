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
td{
	text-align:left;
}
input{
	width: 300px;
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
body{
	padding: 0px;
	margin: 0px;
}
</style>
  </head>
<body scroll="no" style="width: 99%">
<div id="man_zone" >
<table style="border:0px #FFF;width: 100%;height: 200px;">
	<tr>
	<td width="30%" style="vertical-align: top;">
		<div class="easyui-panel" style="padding:5px;height: 510px; overflow: scroll;" >
			<ul id= "tree" class="easyui-tree"></ul>
		</div>
		<!-- <div class="easyui-panel" style="padding:5px;height: 510px; overflow: scroll;" id="addRoot" >
			<a id="postbtn" onClick="insertRoot()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >增加根节点</a>
		</div> 
		-->
		<table>
			<tr>
				<td><img src="css/themes/icons/dept.png">：部门</td>
				<td><img src="css/themes/icons/post.png">：岗位</td>
				<td><img src="css/themes/icons/employ.png">：人员</td>
				<td><a id="postbtn" onClick="CopyData()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >数据同步</a></td>
			</tr>
			
		</table>
		
	</td> 
	<td  style="vertical-align: top;">
 <div id ="RadioGroup" align="left">
<!--<input type="radio" name = "radio" id="radioBM" style="width: 3%" onClick="appendDept('this')" checked="true">部门名称-->
<input type="radio" name = "radio" id="radioGW" style="width: 3%" onClick="appendPost('this')" checked="true">岗位名称
<input type="radio" name = "radio" id="radioRY" style="width: 3%" onClick="appendEmployee('this')" >人员姓名
		<!-- <ul id="tt" class="easyui-tree" data-options="url:'limit.json',method:'get',animate:true,checkbox:true"></ul> -->
</div> 
<!-- 右侧表单数据显示区域 -->	
<div id = "dg_div" style="height: 300px;">

		<!-- 岗位显示区域 -->
		 <table id="pb_post" style="width:700px; border: 1px;">
			<tr>
	  			<td class="tor">岗位名称:</td>
	  			<td> <input  type="text" id="postName_s" name="postName_s" value=""  onblur="Checkfun.isNull(this,'岗位名称')"/>&nbsp;&nbsp;<font color="red">*</font>
	  			<input type="hidden" id="superior_s" name="superior_s" value=""  /> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor"><input type="hidden" id="isModify" name="isModify" value=""  /></td>
	  			<td><a id="postbtn" onClick="postbtn()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >新增</a>
	  			<a id="modifybtn" onClick="postmodify()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">修改</a>
	  			<!--  <a id="deletebtn" onClick="removeit()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">删除</a>-->
	  			</td>
	  		</tr>
		</table>
		
		
		<!-- 部门数据显示区域 
	
	 	<table id="pb_depart" style="width:700px" >
		<!--  data-options="singleSelect:true,url:'datagrid_data1.json',method:'get'"> 
			<tr>
		  			<td class="tor">部门名称:</td>
		  			<td> <input type="text" id="deptName_s" name="deptName_s" value=""  onblur="Checkfun.isNull(this,'部门名称')"/> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor"><input type="hidden" id="isModify" name="isModify" value=""  /></td>
	  			<td><a id="deptbtn" onClick="deptbtn()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
	  			<a id="modifybtn" onClick="deptmodify()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">修改</a>
	  			<!--  <a id="deletebtn" onClick="removeit()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">删除</a>
	  			</td>
	  		</tr>
		</table>-->
		
		<!-- 人员数据显示区域 -->
	<div id="employdiv" name="employdiv">
	<form id="employeeform" name="employeeform" action="" method="post">
		
		<table id="pb_employee" name="pb_employee" class="easyui-datagrid" title="" style="width:700px;height:250px">
		    
		</table>
		<center><a id="ebtn" name="ebtn" onClick="employbtn()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a></center>
		
	</form>
	</div>
	
	<!-- 注释说明区域 -->
	<table style="width:700px">
		<tr>
			<td>*添加新部门或者新岗位请点击新增按钮</td>
		</tr>
		<tr>
			<td>*添加人员请勾选无岗人员后点击确认按钮</td>
		</tr>
		<tr>
			<td>*修改部门名称或者岗位名称请点击修改按钮</td>
		</tr>
		<tr>
			<td>*选择要删除的节点右键点击删除</td>
		</tr>
	</table>
	
	
</div>
	</td>
	
</tr>

</table>
	<script type="text/javascript">
	
	var t;
	var nodeSelect;
	var nodeSelectDe;
	$(function() {  
	$('#dg_div').show();
	$('#pb_post').show();
	//$('#pb_depart').show();
	$('#employdiv').hide();
	//$('#radioBM').attr("checked",'checked');
	//alert(1);
		var index = 0;
		 $.ajax({
		        type : "GET",   //提交的方式 
		        url : './drawTreeAction?time=' + new Date().getTime(),   //提交的action 地址
		        //data : timer=new Date().getTime(),//这里是要传的action的 需要的参数 没有可以不需要
		        success : function(msg) {
		        	if(msg.substr(0,5) =="ERROR")
		        	{
		        		$('#dg_div').hide();
		        		$('#addRoot').show();
		        	}
		        	else
		        	{
		        		//$('#dg_div').hide();
		        		$('#addRoot').hide();
			        	 msg = msg.substr(0,msg.length-2);
			        	 //alert(msg);
			        	 try{
			        	 var Obj = eval("(" + msg + ")");
			        	 }
			        	 catch(errore)
			        	 {
			        	 	alert(errore);
			        	 }
			        	 //alert(Obj);
			        	 $('#tree').tree({
			                 data:Obj,
			 				animate: true,
			 				
			 				onClick:function(node){
			 					nodeSelect = node;
			 					
			 					//	Yepeng ADD
			 					if(nodeSelect.id.substr(0,2) != "Po"){
			 						$('#postName_s').attr("disabled",'true');
			 					} else {
			 						$('#postName_s').removeAttr("disabled"); 
			 					}
			 					
			 					//alert(node.id);
			 					if(nodeSelect.id.substr(0,2) =="BM")
			 					{
			 						$('#RadioGroup').show();
			 						$('#dg_div').show();
			 						//$('#radioBM').attr("readonly",'true');
			 						$('#deptbtn').attr("disabled",'true');
			 						
			 						//alert(1);
			 						$('#radioRY').attr("disabled",'true');
			 						$('#radioBM').removeAttr("disabled"); 
			 						$('#radioGW').attr("disabled",'true');
			 						$('#radioBM').trigger("click");
			 						
			 					}
			 					if(nodeSelect.id.substr(0,2) =="De")
			 					{
			 						$('#RadioGroup').show();
			 						$('#dg_div').show();
			 						
			 						$('#radioBM').removeAttr("disabled"); 
			 						$('#radioGW').removeAttr("disabled"); 
			 						$('#radioRY').attr("disabled",'true');
			 						
			 						$('#radioBM').trigger("click");
			 						
			 						
			 					}
			 					if(nodeSelect.id.substr(0,2) =="Po")
			 					{
			 						//$("input[name=radio]:eq(2)").attr("checked",'checked'); 
			 						//	Yepeng ADD
			 						$('#postName_s').val(node.text);
			 						$('#RadioGroup').show();
			 						$('#dg_div').show();
			 						
			 						$('#radioBM').attr("disabled",'true');
			 						$('#radioGW').removeAttr("disabled"); 
			 						$('#radioRY').removeAttr("disabled"); 
			 						$('#radioGW').trigger("click");
			 						
			 					}
			 					if(nodeSelect.id.substr(0,2) =="RY")
			 					{
			 						$("input[name=radio]:eq(2)").attr("checked",'checked');
			 						$('#RadioGroup').show();
			 						$('#dg_div').show();
			 						
			 						$('#employbtn').attr("disabled",'true');
			 						//alert(1);
			 						$('#radioRY').attr("disabled",'true');
			 						$('#radioBM').attr("disabled",'true');
			 						$('#radioGW').attr("disabled",'true');
			 						$('#radioRY').trigger("click");
			 						//alert(nodeSelect.id.substr(0,2));
			 						//appendEmployee();
			 					}
			 					
			 					
			 				},
			 				onContextMenu: function(e,node){
			 					e.preventDefault();
			 					if(node.id.substr(0,2) =="BM" || node.id.substr(0,2)  == "De")
			 					{
			 					}else{
			 						nodeSelectDe = node;
				 					$('#mm').menu('show',{
										left: e.pageX,
										top: e.pageY
									});
			 					}
			 					
			 				}
			        	 	
			            });
		        	}
		        },error: function(msg){
		        	//alert(msg);
		           $.messager.alert("Error","ajax 请求错误！");
		            }
		    });
		 
		}); 
	
	function len(s) { 
		var l = 0; 
		var a = s.split(""); 
		for (var i=0;i<a.length;i++) { 
		if (a[i].charCodeAt(0)<299) { 
		l++; 
		} else { 
		l+=2; 
		} 
		} 
		return l; 
		};
		//点击增加部门方法
		function appendDept(){
			$('#type').val("Dept");
			
			$('#pb_post').hide();
			$('#employdiv').hide();
			
			t = $('#tree');
			//alert(nodeSelect.id+","+nodeSelect.text);
			$('#isModify').val("1");
			$('#pb_depart').show();
	 		$('#dg_div').show();
			
		}
		
		//点击增加岗位方法
		function appendPost(){
			
			$('#pb_depart').hide();
			$('#ebtn').hide();
			$('#employdiv').hide();
			
			//alert(1);
			t = $('#tree');
			//alert(nodeSelect.id+","+nodeSelect.text);
			$('#isModify').val("1");
			$('#pb_post').show();
	    	$('#dg_div').show();
			
			
		}
		
		//点击增加员工方法
		function appendEmployee(){
			if(nodeSelect == null)
			{
				$.messager.alert("Error","请选择岗位！");
				return;
			}
			
			$('#type').val("Employ");
		
			$('#pb_depart').hide();
			$('#pb_post').hide();
			
			
			t = $('#tree');
			//alert(nodeSelect.id+","+nodeSelect.text);
			$('#isModify').val("1");
			$('#employdiv').show();
			$('#ebtn').show();
	 		$('#dg_div').show();
	 		//alert("here");
	 		//alert(nodeSelect.id);
	 		var nodesparent = $('#tree').tree('getParent', nodeSelect.target);
			//alert(nodesparent.id);
	 		
	 		$.ajax({
		        type : "GET",   //提交的方式 
		        url : './searchEmpAction?organizationDept_s=' + nodesparent.id +'&time='+new Date().getTime(),   //提交的action 地址
		       	//queryParams : {time = ,},//这里是要传的action的 需要的参数 没有可以不需要
		        success : function(msg) {
		        	
		        	 try{
			        	 var Obj = eval("(" + msg + ")");
			         }
			         catch(error) {
			        	 	//alert(error);
			        	 $.messager.alert("SUCCESS","该部门下无职员！");
			        }
		        	 //alert(Obj);
		        	 $('#pb_employee').datagrid({
		                 //data: Obj,
		                  columns:[[
		                  { field:'ck',checkbox:true },
						        {field:'employid',title:'员工编号',width:100},
						        {field:'employname',title:'员工姓名',width:100}
						    ]]
						    ,checkbox:true
		 					
		        	 }) ;
		        	 $('#pb_employee').datagrid("loadData",Obj);
			        	 
		        }
	 		});
	 		
	 		
	 		
		}
		
		function addRoot(){
				$.post(
	  				"./addDeptRoot",
	  				{
	  					time:new Date().getTime()
	  				},function(msg){
	  					$.messager.alert("Success",msg);
		  				window.location.reload();
		  			}
			);
		}
		
	function removeit(){
		//alert(nodeSelectDe.id);
		if(nodeSelectDe.id.substr(0,2) =="De"){
			var nodes = "";
			try{
				nodes = $('#tree').tree('getChildren',nodeSelectDe.target);
			}
			catch(e){
				nodes = "";
			}
			
			//alert(nodes);
			if(nodes!= ""){
				$.messager.alert("Error","部门下有岗位存在，不可以删除！");
				return;
			}
		}
		var str = "是否确认删除?";
		if(nodeSelectDe.id.substr(0,2) =="Po"){
			str = "将会删除岗位下员工的岗位职责," + str;
		}
		$.messager.confirm('删除', str, function(r){
		    if (r){
		     //alert('confirmed:'+r);
		     //location.href = 'http://www.google.com';
		     t = $('#tree');
				$.post(
		  				"./deleteNodeAction",
		  				{
		  					organization_s:nodeSelectDe.id,
		  					time:new Date().getTime()
		  				},function(msg){
			  				//alert(msg);
			  				if(msg.indexOf("SUCCESS")>-1)
			  				{
			  					document.getElementById("employeeform").submit();

			  					t.tree('remove', nodeSelectDe.target);
			  				}
			  				else
			  				{
			  					$.messager.alert("Error","操作失败！");
			  				}
			  			}
				);
		    }
		    else{
		    	return;
		    }
		   });
		
  			
		
		
		
	}
	
	
	
	function getSelected(){
		var row = $('#pb_depart').datagrid('getSelected');
		
		//alert(row.workShopID_s +":"+ row.workShopName_s);
	
		t.tree('append', {
			parent: (nodeSelect?nodeSelect.target:null),
			data: [{
			id:row.workShopID_s, text: row.workShopName_s
			}]
		});
		$('#dg_div').css("display","none");
			
	}
	
	function getSelectedPerson(){
		var row = $('#pb_depart').datagrid('getSelected');
		//alert(row.workShopID_s +":"+ row.workShopName_s);
	
		t.tree('append', {
			parent: (nodeSelect?nodeSelect.target:null),
			data: [{
				id:row.workShopID_s, text: row.workShopName_s
			}]
		});
		$('#dg_div').css("display","none");
		
	}
	
	function deptmodify(){
		//alert(nodeSelect.id);
		if(nodeSelect.id.substr(0,2)=="De")
		{
			$('#pb_post').hide();
			$('#employdiv').hide();
			$('#pb_depart').show();
			
		}
		else
		{
			//alert(nodeSelect.id);
			if(nodeSelect.id.substr(0,2)=="Po")
				{
				$('#employdiv').hide();
				$('#pb_depart').hide();
				$('#pb_post').show();
				
				}
			else
				{
					$('#pb_depart').hide();
					$('#post').hide();
					$('#employdiv').show();
					//$('#employee').css("display","none");
				}
			
		}
		$('#isModify').val("2");
 		$('#dg_div').show();
 		//alert($("#deptName_s").val());
 		var str="是否修改部门名称？"
		$.messager.confirm('确定', str, function(r){
		if (r){
	 		$.post(
	 			"./addNodeAction",
	 			{
	 				name_s:$("#deptName_s").val(),
	 				superior_s:nodeSelect.id,
					type_i:2,
					isModify:2,
					time:new Date().getTime()
	 			},function(msg){
	  					if(msg.indexOf("SUCCESS")>-1)
	  	  				{
		  					//document.getElementById("employeeform").submit();
	
	  	  					t = $('#tree');
		  	  			
	  	  					nodeSelect.text = "<span>"+ $("#deptName_s").val() +"<\/span>";
							//nodeSelect.iconCls = "icon-reload";
							t.tree('update', nodeSelect);
	  	  					
	  	  				}else
	  	  				{
	  	  				$.messager.alert("Error","操作失败！");
	  	  				}
	  	  			}
	 		);
		}
		});
		
	}
	
	
	function postmodify(){
		//alert(nodeSelect.id.substr(0,2));
		//alert(nodeSelect.id);
		if(nodeSelect.id.substr(0,2)=="De"){
			$('#pb_post').hide();
			$('#employdiv').hide();
			$('#pb_depart').show();
		} else {
			//alert(nodeSelect.id);
			if(nodeSelect.id.substr(0,2)=="Po"){
				$('#employdiv').hide();
				$('#pb_depart').hide();
				$('#pb_post').show();
			} else {
				$('#pb_depart').hide();
				$('#post').hide();
				$('#employdiv').show();
				//$('#employee').css("display","none");
			}
		}
		$('#isModify').val("2");
 		$('#dg_div').show();
 		//alert($("#postName_s").val());
 		var str="是否修改岗位名称？"
		$.messager.confirm('确定', str, function(r){
		if (r){
	 		$.post(
	 			"./addNodeAction",
	 			{
	 				name_s:$("#postName_s").val(),
	 				superior_s:nodeSelect.id,
					type_i:2,
					isModify:2,
					time:new Date().getTime()
	 			},function(msg){
	  					if(msg.indexOf("SUCCESS")>-1)
	  	  				{
		  					//document.getElementById("employeeform").submit();
	
	  	  					t = $('#tree');
		  	  				//	Yepeng MOD
	  	  					//nodeSelect.text = "<span>"+ $("#postName_s").val() +"<\/span>";
	  	  					nodeSelect.text = $("#postName_s").val();
							//nodeSelect.iconCls = "icon-reload";
							t.tree('update', nodeSelect);
	  	  					
	  	  				}else
	  	  				{
	  	  				$.messager.alert("Error","操作失败！");
	  	  				}
	  	  			}
	 		);
		}
		});
	}
	
	
	function deptbtn(){
		//alert(new Date().getTime());
		//alert(nodeSelect.id);
		$.post(
  				"./addNodeAction",
  				{
  					name_s:$("#deptName_s").val(),
  					superior_s:nodeSelect.id,
  					type_i:1,
  					isModify:2,
  					time:new Date().getTime()
  				},function(msg){
  				//alert(msg);
  				//alert($("#deptName_s").val());
  				//alert(nodeSelect.id);
  				//alert($("#isModify").val());
  				if(msg.indexOf("SUCCESS")>-1)
  				{
  					t = $('#tree');
  					/*if($("#isModify").val() == "1")
  						{
	  					//document.getElementById("employeeform").submit();

	  						var array = [];
	  	  					array = msg.split(":");
	  	  					//alert(array[1]);
	  	  					$.messager.alert("Success","操作成功！");
	  	  					t.tree('append', {
	  						parent: (nodeSelect?nodeSelect.target:null),
	  						data: [{id:array[1],
	  							text: $("#deptName_s").val(),
	  							iconCls:"icon-dept"
	  						}]
	  						});
  						
  						}
  					else
  						{*/
	  						nodeSelect.text = "<span style=\"font-weight:bold\">"+ $("#deptName_s").val() +"<\/span>";
	  						//nodeSelect.iconCls = "icon-reload";
	  						t.tree('update', nodeSelect);
  						//}
  				}
  				else
  				{
  					$.messager.alert("Error","操作失败！");
  				}
  				}
  			);
		
	}
	
	function postbtn(){
		//alert("!");
		//alert(nodeSelect.id);
		if(nodeSelect.id.substr(0,2) == "Po")
		{
			$.messager.alert("Error","岗位下只能修改或删除岗位！");
			return;
		}
		//alert($("#postName_s").val());
		$.post(
  				"./addNodeAction",
  				{
  					name_s:$("#postName_s").val(),
  					superior_s:nodeSelect.id,
  					type_i:2,
  					isModify:1,
  					time:new Date().getTime()
  				},function(msg){
  					if(msg.indexOf("SUCCESS")>-1)
  	  				{
	  					//document.getElementById("employeeform").submit();

  	  					t = $('#tree');
	  	  				//if($("#isModify").val() == "1")
						//{
	  	  					var array = [];
	  	  					array = msg.split(":");
	  	  					//alert(array[1]);
	  	  					$.messager.alert("Success","操作成功！");
	  	  					t.tree('append', {
	  						parent: (nodeSelect?nodeSelect.target:null),
	  						data: [{id:array[1],
	  							text: $("#postName_s").val(),
	  							iconCls:"icon-post"
	  						}]
	  						});
						/*}
	  	  				else
  	  					{
	  	  					nodeSelect.text = "<span style=\"font-weight:bold\">"+ $("#postName_s").val() +"<\/span>";
							//nodeSelect.iconCls = "icon-reload";
							t.tree('update', nodeSelect);
  	  					}*/
  	  				}
  	  				else
  	  				{
  	  					$.messager.alert("Error","操作失败！");
  	  				}
  	  				}
  			);
	}
	
	
	
	function CopyData(){
		//alert("!");
		//alert(nodeSelect.id);

		//alert($("#postName_s").val());
		$.post(
  				"./copyDataAction",
  				{
  					time:new Date().getTime()
  				},function(){
  					document.getElementById("copyform").submit();
  					alert("操作成功！");
  	  			}
  			);
	}
	
	function employbtn(){
		//alert("!");
		//alert(nodeSelect);
		if(nodeSelect == null)
		{
			$.messager.alert("Error","请选择岗位！");
			return;
		}
		//alert(nodeSelect.id);
		var nodesparent = $('#tree').tree('getParent', nodeSelect.target);
		//alert(nodesparent.id);
		//2014-9-23注释
		//var boxs=document.getElementsByName("receptionCustomerUser");
		//if(boxs == "undefinded")
		//{
		//	$.messager.alert("Error","没有需要添加的人员！");
		//	return;
		//}
		//alert(boxs.length);
		//2014-9-23
		var boxs= $('#pb_employee').datagrid('getChecked');
		//alert(boxs[0].employid);
		//alert(boxs[0].employname);
		var emp="";
		for(i=0;i<boxs.length;i++){
			//if(boxs[i].checked == true){
				//alert(boxs[i].value);
				emp += boxs[i].employid +","+boxs[i].employname+"I";
			//}
		}
		//alert(emp);
		if(emp == "")
		{
			$.messager.alert("Error","请选择需要添加的人员！");
			return;
		}
		if(nodeSelect.id.substr(0,2) == "RY")
		{
			$.messager.alert("Error","人员下只能修改或删除人员！");
			return;
		}
		$.post(
  				"./addEmNodeAction",
  				{
  					
  					emplist:emp,
  					organizationPost_s:nodeSelect.id,
  					organizationDept_s:nodesparent.id,//父节点ID
  					//employeeLoginName:$("#employeeLoginName").val(),
  					//identityCard_s:$("#identityCard_s").val(),
  					//telephone_s:$("#telephone_s").val(),
  					//facsimile_s:$("#facsimile_s").val(),
  					//email_s:$("#email_s").val(),
  					type_i:3,
  					isModify:$("#isModify").val(),
  					time:new Date().getTime()
  				},function(msg){
  					if(msg.indexOf("SUCCESS")>-1)
  	  				{
  	  				//alert(1);
  	  					t = $('#tree');
	  	  				if($("#isModify").val() == "1")
						{
		  					document.getElementById("employeeform").submit();

		  					$.messager.alert("Success","操作成功！");
			  	  			for(i=0;i<boxs.length;i++){
			  	  				//if(boxs[i].checked == true){
			  	  				//var array = [];
			  	  				//var temp=boxs[i].value;
		  	  					//array = temp.split(",");
			  	  				t.tree('append', {
			  						parent: (nodeSelect?nodeSelect.target:null),
			  						data: [{
			  							id:boxs[i].employid,
			  							text: boxs[i].employname,
			  							iconCls:"icon-employ"
			  						}]
			  						});
			  	  				//}
			  	  			}
	  	  					
						}
	  	  				else
  	  					{
	  	  					//alert("xiugai");
		  	  				nodeSelect.text = "<span style=\"font-weight:bold\">"+ $("#userName_s").val() +"<\/span>";
							//nodeSelect.iconCls = "icon-reload";
							t.tree('update', nodeSelect);
  	  					}
  	  				}
  	  				else
  	  				{
  	  					$.messager.alert("Error","操作失败！");
  	  				}
  	  				}
  			);
		
	}
	
	//checkbox全选
	$("#selectAllPerson").click(function (){
			var selAll=document.getElementById("selectAllPerson").checked;
			if(selAll){
			var boxs=document.getElementsByName("receptionCustomerUser");
			for(i=0;i<boxs.length;i++){
				boxs[i].checked=true;
			}
			}else {
			var boxs=document.getElementsByName("receptionCustomerUser");
			for(i=0;i<boxs.length;i++){
				boxs[i].checked=false;
			}
			}
		});
	</script>
		
	</div>
		
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div id="delete" onclick="removeit('this')" data-options="iconCls:'icon-remove'">删除</div>
	</div>
	<form action="./initTreeAction?time=new Date().getTime()" id="copyform" name="copyform"></form>
	
</body>
</html>