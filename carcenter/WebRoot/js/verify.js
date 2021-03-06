//定义一个静态调用方法的类
function Checkfun(){}
 
 
//判断输入内容是否为空    

Checkfun.isNull=function(box,name,maxlong){    
  
    if( $(box).val()==null || $(box).val().length<1 ){
    	//请将“文本框”改成你需要验证的属性名称!
    	$.messager.alert('Error','对不起，【'+name+'】不能为空或者为空格!');
    	$(box).css("border","solid 1px #E33");
    	//$(box).focus();
		return false;
	}else{
		if(!Checkfun.maxLength($(box).val(),maxlong)){
			$.messager.alert('Error','对不起，【'+name+'】输入内容过多!');
	    	$(box).css("border","solid 1px #E33");
	    	//$(box).focus();
			return false;
		}
		$(box).css("border","1px solid #36D");
		return true;
	}

};  



Checkfun.maxLength=function(str,maxlong) {
    var len = str.length;
    var reLen = 0;
    for (var i = 0; i < len; i++) {        
        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) {
            // 全角    
            reLen += 2;
        } else {
            reLen++;
        }
    }
    if(reLen > maxlong){
    	return false;
    }
    return true; 
}

Checkfun.minLength=function(box,name,minlong) {
	if( $(box).val()==null || $(box).val().length<1 ){
    	//请将“文本框”改成你需要验证的属性名称!
    	$.messager.alert('Error','对不起，【'+name+'】不能为空或者为空格!');
    	$(box).css("border","solid 1px #E33");
    	//$(box).focus();
		return false;
	}
	str = $(box).val()
    var len = str.length;
    var reLen = 0;
    for (var i = 0; i < len; i++) {        
        if (str.charCodeAt(i) < 27 || str.charCodeAt(i) > 126) {
            // 全角    
            reLen += 2;
        } else {
            reLen++;
        }
    }
    if(reLen < minlong){
    	$.messager.alert('Error','对不起，【'+name+'】输入内容需大于'+minlong+'位!');
    	$(box).css("border","solid 1px #E33");
    }
    return false; 
}

//判断日期类型是否为YYYY-MM-DD格式的类型    
Checkfun.isDate=function(box,name){     
    var str = $(box).val();    
    if(str.length!=0){    
        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
        var r = str.match(reg);     
        if(r==null){    
            //请将“日期”改成你需要验证的属性名称! 
        	$.messager.alert('Error','对不起，【'+name+'】输入的日期格式不正确!');
        	$(box).css("border","solid 1px #E33");
        	return false;
        }else{
    		$(box).css("border","1px solid #36D");
    		return true;
    	} 
	}
}; 

//判断输入的字符是否为整数    
Checkfun.IsInteger=function(box,name,maxlong)     
{       
	Checkfun.isNull(box,name);
    var str = $(box).val(); 
    
    if(str.length!=0){    
        reg=/^[-+]?\d*$/;     
        if(!reg.test(str)){    
            $.messager.alert('Error','对不起，【'+name+'】输入的整数类型格式不正确!');
        	$(box).css("border","solid 1px #E33");
        	return false;
        }else{
        	if(!Checkfun.maxLength($(box).val(),maxlong)){
    			$.messager.alert('Error','对不起，【'+name+'】输入内容过多!');
    	    	$(box).css("border","solid 1px #E33");
    	    	//$(box).focus();
    			return false;
    		}
        	$(box).css("border","1px solid #36D");
    		return true;
        }    
    }    
}  ;   

//判断输入的字符是否为整数    
Checkfun.IsIntegerAllowNull=function(box,name,maxlong)     
{       
	//Checkfun.isNull(box,name);
    var str = $(box).val(); 
    
    if(str.length!=0){    
        reg=/^[-+]?\d*$/;     
        if(!reg.test(str)){    
            $.messager.alert('Error','对不起，【'+name+'】输入的整数类型格式不正确!');
        	$(box).css("border","solid 1px #E33");
        	return false;
        }else{
        	if(!Checkfun.maxLength($(box).val(),maxlong)){
    			$.messager.alert('Error','对不起，【'+name+'】输入内容过多!');
    	    	$(box).css("border","solid 1px #E33");
    	    	//$(box).focus();
    			return false;
    		}
        	$(box).css("border","1px solid #36D");
    		return true;
        }    
    }    
}  ; 

Checkfun.IsPhone=function(box,name){
	Checkfun.isNull(box,name);
	var str=$(box).val();
	if(str.length!=0){
		reg=/^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/;
		if(!reg.test(str)){
			 $.messager.alert('Error','对不起，【'+name+'】格式不正确!');
	        	$(box).css("border","solid 1px #E33");
	        	return false;
	        }else{
	        	$(box).css("border","1px solid #36D");
	    		return true;
	        }
	}
};


//判断输入的字符是否为中文    
Checkfun.IsChinese=function(box,name)     
{     
	Checkfun.isNull(box,name);
     var str = $(box).val();    
     if(str.length!=0){    
        reg=/^[\u0391-\uFFE5]+$/;    
        if(!reg.test(str)){        
            $.messager.alert('Error','对不起，【'+name+'】字符串类型格式不正确!');
        	$(box).css("border","solid 1px #E33");
        	return false;
        }else{
        	$(box).css("border","1px solid #36D");
    		return true;
        }    
     }    
};

//判断输入的EMAIL格式是否正确    
Checkfun.IsEmail=function(box,name)     
{     
	Checkfun.isNull(box,name);
        var str = $(box).val();    
        if(str.length!=0){    
        reg=/^(\w+)([\-+.][\w]+)*@(\w[\-\w]*\.){1,5}([A-Za-z]){2,6}$/;    
        if(!reg.test(str)){    
           //请将“字符串类型”要换成你要验证的那个属性名称！  
            $.messager.alert('Error','对不起，【'+name+'】输入的邮箱格式不正确!');
            $(box).css("border","solid 1px #E33");
            return false;
        }else{
    		$(box).css("border","1px solid #36D");
    		return true;
    	}   
    }    
} ;  



Checkfun.checkDate=function(sTime,eTime){  
	
		alert(sTime);
		alert(eTime);
	   var startTime=sTime; //获得系统日期的文本值  
	   var endTime=eTime; //获得用户选择的日期文本值  
	   var aStart=startTime.split('-'); //转成成数组，分别为年，月，日，下同  
	   var aEnd=endTime.split('-');  
	   var startDate = aStart[0]+"/" + aStart[1]+ "/" + aStart[2];  
	   var endDate = aEnd[0] + "/" + aEnd[1] + "/" + aEnd[2];  
	   if (startDate > endDate) {   
	    $.messager.alert('Error','对不起，开始日期必须小于结束日期!');
	    return false;  
	   }  
	    return true;  
}  ;


Checkfun.IsDouble=function(box,name,maxlong)     
{       
	Checkfun.isNull(box,name);
    var str = $(box).val();    
    if(str.length!=0){    
        reg=/^([-]){0,1}([0-9]){1,}([.]){0,1}([0-9]){0,}$/;     
        if(!reg.test(str)){    
            $.messager.alert('Error','对不起，【'+name+'】输入的类型格式不正确!');
        	$(box).css("border","solid 1px #E33");
        	return false;
        }else{
        	if(!Checkfun.maxLength($(box).val(),maxlong)){
    			$.messager.alert('Error','对不起，【'+name+'】输入内容过多!');
    	    	$(box).css("border","solid 1px #E33");
    	    	//$(box).focus();
    			return false;
    		}
        	$(box).css("border","1px solid #36D");
    		return true;
        }    
    }    
}  ;   


Checkfun.IsIDCard=function(box,name)     
{
	Checkfun.isNull(box,name);
	 num = $(box).val();
     //身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。  
      if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))){
    	  $.messager.alert('Error','输入的身份证号长度不对，或者号码不符合规定!\n15位号码应全为数字，18位号码末位可以为数字或大写X。');
    	  $(box).css("border","solid 1px #E33");
    	  return false;
     }

	//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	//下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15){
	
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);
		
		//检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
		var bGoodDay;	
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));	
		if (!bGoodDay){
		     // alert('输入的身份证号里出生日期不对！');  
		      $.messager.alert('Error','输入的身份证号里出生日期不对!');
	    	  $(box).css("border","solid 1px #E33");
		       return false;		
		}else{
			//将15位身份证转成18位
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;  
	        num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
	        for(i = 0; i < 17; i ++){
	            nTemp += num.substr(i, 1) * arrInt[i];
	        }
	       num += arrCh[nTemp % 11];  
	       $(box).css("border","1px solid #36D");
	        return true;  
	
		}  
	
	}
	
	if (len == 18){
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
	
		//检查生日日期是否正确
	
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay){
			 $.messager.alert('Error','输入的身份证号里出生日期不对!');
	    	 $(box).css("border","solid 1px #E33");
			return false;
	
		}else{
			//检验18位身份证的校验码是否正确。
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			var nTemp = 0, i;
			for(i = 0; i < 17; i ++){
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			
			valnum = arrCh[nTemp % 11];
			if (valnum != num.substr(17, 1)){
				
				 $.messager.alert('Error','18位身份证的校验码不正确!应该为：' + valnum);
		    	 $(box).css("border","solid 1px #E33");
				return false;
			}
			
			 $(box).css("border","1px solid #36D");
		    return true;  
			
			}
			
		}
	
	
	return false;
};


