<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>CPG 道路状态监控系统</title>
    <link href="css/layout.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/selectivizr.js" type="text/javascript"></script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/verify.js"></script>
</head>
<body>
<script type="text/javascript" language="javascript">  
    $(function() {  
      //  startRequest();  
        setInterval("startRequest()", 30000000);  
    });

    function startRequest() {  
   // alert('a1')
    	$.post(
					"./refreshShowAction",
					{						
						time:new Date().getTime()
					},function(msg){
						var m= new Array(); 
						var n= new Array(); 
						//$.messager.alert('删除','操作成功!');
						m = msg.split("!");
						n = m[0].split(",");
					//	alert(n[0])
						
					
						var d10 = document.getElementById("d10");	
						var d11 = document.getElementById("d11");	
						var d20 = document.getElementById("d20");	
						var d21 = document.getElementById("d21");	
						var d30 = document.getElementById("d30");	
						var d31 = document.getElementById("d31");	
						var d40 = document.getElementById("d40");	
						var d41 = document.getElementById("d41");	
						var d50 = document.getElementById("d50");	
						var d51 = document.getElementById("d51");	
						var d60 = document.getElementById("d60");	
						var d61 = document.getElementById("d61");	
						var d70 = document.getElementById("d70");	
						var d71 = document.getElementById("d71");	
					//	alert(d10)
						n = m[0].split(",");
						d10.innerText = n[1];
						d11.innerText = n[0];
						n = m[1].split(",");
						d20.innerText = n[1];
						d21.innerText = n[0];
						n = m[2].split(",");
						d30.innerText = n[1];
						d31.innerText = n[0];
						n = m[3].split(",");
						d40.innerText = n[1];
						d41.innerText = n[0];
						n = m[4].split(",");
						d50.innerText = n[1];
						d51.innerText = n[0];
						n = m[7].split(",");
						d60.innerText = n[1];
						d61.innerText = n[0];
						n = m[8].split(",");
						d70.innerText = n[1];
						d71.innerText = n[0];
						
						
						 
				
						
					}
			   );
    }
d</script>
<div id="header_wrapper">
    <header>
        <div class="container">
            <!--时间开始-->
            <div id="timearea">
                <div class="timearea_a"><img src="images/clock.png"></div>
                <div class="timearea_b" id=localtime>
                    <script type="text/javascript">
                        function showLocale(objD)
                        {
                            var str,colorhead,colorfoot;
                            var yy = objD.getYear();
                            if(yy<1900) yy = yy+1900;
                            var MM = objD.getMonth()+1;
                            if(MM<10) MM = '0' + MM;
                            var dd = objD.getDate();
                            if(dd<10) dd = '0' + dd;
                            var hh = objD.getHours();
                            if(hh<10) hh = '0' + hh;
                            var mm = objD.getMinutes();
                            if(mm<10) mm = '0' + mm;
                            var ss = objD.getSeconds();
                            if(ss<10) ss = '0' + ss;
                            var ww = objD.getDay();
                            if  ( ww==0 )  colorhead="<font color=\"#ffffff\">";
                            if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"#ffffff\">";
                            if  ( ww==6 )  colorhead="<font color=\"#ffffff\">";
                            if  (ww==0)  ww="星期日";
                            if  (ww==1)  ww="星期一";
                            if  (ww==2)  ww="星期二";
                            if  (ww==3)  ww="星期三";
                            if  (ww==4)  ww="星期四";
                            if  (ww==5)  ww="星期五";
                            if  (ww==6)  ww="星期六";
                            colorfoot="</font>"
                            str = colorhead + yy + "/" + MM + "/" + dd + "&nbsp;&nbsp;" + ww + "&nbsp;&nbsp;" + hh + ":" + mm + ":" + ss  + colorfoot;
                            return(str);
                        }
                        function tick()
                        {
                            var today;
                            today = new Date();
                            document.getElementById("localtime").innerHTML = showLocale(today);
                            window.setTimeout("tick()", 1000);
                        }
                        tick();
                    </script>
                </div>
            </div>
            <!--时间结束-->
            <!--标题-->
            <div id="headline">
                <span>CPG 道路状态监控系统</span>
                <div class="line"></div>
            </div>

            <!--标题-->
            <!--天气开始-->
            <div id="weather">
               <div id="weather_a"> <p style="font-size: 12pt;">测试数据</p>23°</div>
                <div id="weather_b"><img src="images/weather_01.png"></div>
                <div id="weather_c">风向：<span>北</span>   风力：<span>2-3级</span></div>
            </div>
            <!--天气结束-->
        </div>
    </header>
</div>
<div id="body_wrapper">
    <article>
        <div class="container">
            <ul>
                <li class="li_blue">
                    <div class="tit">
                        <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">直线性能路</div>
                    </div>
                    <!--道路状况开始-->
                    <span id="status" >
                    	<div id="status_green">道路状况</div>
                    </span>
                    <!--道路状况结束-->
                    <!--当前车辆数开始-->
                    <div id="current">
                        <div class="current_a" id="current_green"><p id="d10">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d11">${s[0][1]}</p> 最大容量数</div>
                    </div>
                    <!--当前车辆数结束-->
                    <!--最大容量开始-->
                    <div id="guild"></div>
                    <!--最大容量结束-->
                </li><li class="li_blue">
                    <div class="tit">
                        <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">小动态坪</div>
                    </div>
                    <span id="status">
                     
                    	 
                    	<div id="status_green">道路状况</div>
                    	 
                    </span>
                    <div id="current">
                        <div class="current_a" id="current_green"><p id="d20">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d21">${s[0][1]}</p> 最大容量数</div>
                    </div>
                    <div id="guild"></div>
                </li><li class="li_blue">
                <div class="tit">
                    <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">外部噪声路</div>
                </div>
                <span id="status" >
                    	<div id="status_green">道路状况</div>
                    </span>
                 <div id="current">
                        <div class="current_a" id="current_green"><p id="d30">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d31">${s[0][1]}</p> 最大容量数</div>
                    </div>
                <div id="guild"></div>
            </li><li class="li_blue">
                <div class="tit">
                    <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">动态广场</div>
                </div>
                <span id="status" >
                    	<div id="status_green">道路状况</div>
                    </span> 
                 <div id="current">
                        <div class="current_a" id="current_green"><p id="d40">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d41">${s[0][1]}</p> 最大容量数</div>
                    </div>
                <div id="guild"></div>
            </li><li class="li_blue">
                <div class="tit">
                    <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">直线制动路</div>
                </div>
                <span id="status" >
                    	<div id="status_green">道路状况</div>
                    </span>
                 
                 <div id="current">
                        <div class="current_a" id="current_green"><p id="d50">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d51">${s[0][1]}</p> 最大容量数</div>
                    </div>
                <div id="guild"></div>
            </li><li class="li_blue">
                <div class="tit">
                    <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">高速环道</div>
                </div>
                <span id="status" >
                    	<div id="status_green">道路状况</div> 
                    </span>
                 <div id="current">
                        <div class="current_a" id="current_green"><p id="d60">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d61">${s[0][1]}</p> 最大容量数</div>
                    </div>
                <div id="guild"></div>
            </li><li class="li_blue">
                <div class="tit">
                    <div class="tit2"><img src="images/icon1.png"></div><div class="tit1">舒适性路</div>
                </div>
                <span id="status" >
                    	<div id="status_green">道路状况</div>
                    </span>
                 <div id="current">
                        <div class="current_a" id="current_green"><p id="d70">${s[0][0]}</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b" id="current_blue"><p id="d71">${s[0][1]}</p> 最大容量数</div>
                    </div>
                <div id="guild"></div>
            </li>
            
           
            <li class="li_gray">
                <div class="tit">
                    <div class="tit2"><img src="images/icon3.png"></div><div class="tit1">未开放道路</div>
                </div>
                <span id="status"><div id="status_gray">道路状况</div></span>
                <div id="current">
                    <div class="current_a"><p id="current_gray">0</p>当前车辆总数</div>
                    <div class="current_c"><img src="images/icon2.jpg"></div>
                    <div class="current_b"><p id="current_gray">0</p> 最大容量数</div>
                </div>
                <div id="guild"></div>
            </li>
            <li class="li_gray">
                <div class="tit">
                    <div class="tit2"><img src="images/icon3.png"></div><div class="tit1">未开放道路</div>
                </div>
                <span id="status"><div id="status_gray">道路状况</div></span>
                <div id="current">
                    <div class="current_a"><p id="current_gray">0</p>当前车辆总数</div>
                    <div class="current_c"><img src="images/icon2.jpg"></div>
                    <div class="current_b"><p id="current_gray">0</p> 最大容量数</div>
                </div>
                <div id="guild"></div>
            </li>
            <li class="li_gray">
                <div class="tit">
                    <div class="tit2"><img src="images/icon3.png"></div><div class="tit1">未开放道路</div>
                </div>
                <span id="status"><div id="status_gray">道路状况</div></span>
                <div id="current">
                    <div class="current_a"><p id="current_gray">0</p>当前车辆总数</div>
                    <div class="current_c"><img src="images/icon2.jpg"></div>
                    <div class="current_b"><p id="current_gray">0</p> 最大容量数</div>
                </div>
                <div id="guild"></div>
            </li>
            <li class="li_gray">
                <div class="tit">
                    <div class="tit2"><img src="images/icon3.png"></div><div class="tit1">未开放道路</div>
                </div>
                <span id="status"><div id="status_gray">道路状况</div></span>
                <div id="current">
                    <div class="current_a"><p id="current_gray">0</p>当前车辆总数</div>
                    <div class="current_c"><img src="images/icon2.jpg"></div>
                    <div class="current_b"><p id="current_gray">0</p> 最大容量数</div>
                </div>
                <div id="guild"></div>
            </li><li class="li_gray">
                    <div class="tit">
                        <div class="tit2"><img src="images/icon3.png"></div><div class="tit1">未开放道路</div>
                    </div>
                    <span id="status"><div id="status_gray">道路状况</div></span>
                    <div id="current">
                        <div class="current_a"><p id="current_gray">0</p>当前车辆总数</div>
                        <div class="current_c"><img src="images/icon2.jpg"> </div>
                        <div class="current_b"><p id="current_gray">0</p> 最大容量数</div>
                    </div>
                    <div id="guild"></div>
                </li>
            </ul>
        </div>
    </article>
</div>
<div id="footer_wrapper">
    <footer>
        <div id="scroll"><span><marquee>欢迎来到中汽中心盐城汽车试验场</marquee></span></div>
    </footer>
</div>
</body>
</html>