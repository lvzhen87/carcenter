<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="Content-Type" content="text/html;" />
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<title>管理导航区域</title>
</head>
<script  type="text/javascript">
document.write("<script src=js/nav.js></" + "script>");

	var preClassName = "man_nav_1";
	function list_sub_nav(Id,sortname){
	   if(preClassName != ""){
	      getObject(preClassName).className="bg_image";
	   }
	   if(getObject(Id).className == "bg_image"){
		  // alert(Id);
		   //alert(sortname);
	      getObject(Id).className="bg_image_onclick";
	      preClassName = Id;
		  showInnerText(Id);
		  window.top.frames['leftFrame'].outlookbar.getbytitle(sortname);
		  window.top.frames['leftFrame'].outlookbar.getdefaultnav(sortname);
		  if(sortname=="客户管理"){
			  //window.top.frames['leftFrame'].changeframe('注册客户',sortname,'./checkregister/registCustomer.jsp');
			  window.top.frames['leftFrame'].changeframe('注册客户',sortname,'./default.html');
		  }
		  if(sortname=="预约管理"){
			  //window.top.frames['leftFrame'].changeframe('待分配试验',sortname,'./distrubuteOrderAction');
			  window.top.frames['leftFrame'].changeframe('待分配试验',sortname,'./default.html');
		  }
		  if(sortname=="接待管理"){
			  //window.top.frames['leftFrame'].changeframe('今日接待试验',sortname,'./receptExpAction');
			  window.top.frames['leftFrame'].changeframe('今日接待试验',sortname,'./default.html');
		  }
		  if(sortname=="信息管理"){
			  window.top.frames['leftFrame'].changeframe('道闸信息管理',sortname,'./default.html');
		  }
		  if(sortname=="场内管理"){
			  window.top.frames['leftFrame'].changeframe('场内管理',sortname,'./default.html');
		  }
		// if(sortname=="过程管理"){
		//	  window.top.frames['leftFrame'].changeframe('场内管理',sortname,'./default.html');
		// }
		  if(sortname=="订单核算"){
			  window.top.frames['leftFrame'].changeframe('订单核算',sortname,'./default.html');
		  }

	   }
	}

	

function showInnerText(Id){
    var switchId = parseInt(Id.substring(8));
	var showText = "对不起没有信息！";
	switch(switchId){
		//	yepeng del start
	    //case 1:
		//   showText =  "待审核注册信息";
		//   break;
		//	yepeng del end
	    case 2:
		   showText =  "待审核预订信息!";
		   break;
	    case 3:
		   showText =  "接待管理";
		   break;		   
	    case 4:
		   showText =  "基础信息管理";
		   break;	
	    case 5:
		   showText =  "试验场管理";
		   break;		   		   
//	    case 6:
//		   showText =  "过程管理";
//		   break;
	    case 7:
			   showText =  "订单核算";
			   break;
	}
	getObject('show_text').innerHTML = showText;
}
 //获取对象属性兼容方法
 function getObject(objectId) {
    if(document.getElementById && document.getElementById(objectId)) {
	// W3C DOM
	return document.getElementById(objectId);
    } else if (document.all && document.all(objectId)) {
	// MSIE 4 DOM
	return document.all(objectId);
    } else if (document.layers && document.layers[objectId]) {
	// NN 4 DOM.. note: this won't find nested layers
	return document.layers[objectId];
    } else {
	return false;
    }
}
</script>

<body>
<div id="nav" >
    <ul><!-- <li>中必须是4个字，否则页面显示有问题！ -->
    <li id="man_nav_1" onclick="list_sub_nav(id,'客户管理')"  class="bg_image_onclick">客户管理</li>
    <li id="man_nav_2" onclick="list_sub_nav(id,'预约管理')"  class="bg_image">预约管理</li>
    <li id="man_nav_3" onclick="list_sub_nav(id,'接待管理')"  class="bg_image">接待管理</li>
    <li id="man_nav_4" onclick="list_sub_nav(id,'信息管理')"  class="bg_image">信息管理</li>
    <li id="man_nav_5" onclick="list_sub_nav(id,'场内管理')"  class="bg_image">场内管理</li>
   <!--   <li id="man_nav_6" onclick="list_sub_nav(id,'过程管理')"  class="bg_image">过程管理</li>-->
    <li id="man_nav_7" onclick="list_sub_nav(id,'订单核算')"  class="bg_image">订单核算</li>
    </ul>
 </div>
<div id="sub_info" style="height: 28px">&nbsp;&nbsp;<img src="images/hi.gif" />&nbsp;<span id="show_text">欢迎使用试验中心管理系统!</span></div>
</body>
</html>
