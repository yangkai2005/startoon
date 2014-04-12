function $$(o){ //获取对象
	if(typeof(o) == "string")
	return document.getElementById(o);
	return o;
}

/*
 * 功能：去掉空格
 */
String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

/*验证Email*/
String.prototype.isEmail = function() {
	return !/^[A-Za-z0-9_-][A-Za-z0-9_-]*@[A-Za-z0-9_-]+\.[A-Za-z0-9_.]+[A-za-z]$/.test(this.trim());
}

/*
 * email验证
 */
function checkEmail(field,fieldName) {
		if (field.value.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1){
			fieldIsNull = 1;
		}
		else{
			alert(fieldName + "格式错误!");
			field.focus();
			return true;
		}
		return false;
}

/* 功能：判断字段值是否为空
 * 参数：field 所要进行判断的字段
 *       fieldName 字段名
 * 返回：true  字段值为空
 *       false 字段值不为空
 */
function isNull(field,fieldName)
{
	selected = 0;
	fieldIsNull = 0;
	if ( field.value.replace(/^(&nbsp;)+|^[\s　]+|(&nbsp;)+$|[\s　]+$/g, "" ).length == 0 )
		fieldIsNull = 1;
	if ( fieldIsNull )
	{
		alert( fieldName + "不能为空！" );
		field.focus();
		return true;
	}
	return false;
}

/* 功能：判断多选框是否为空
 * 参数：fieldObj 所要进行判断的字段
 *       fieldName 字段名
 * 返回：true  字段值为空
 *       false 字段值不为空
 */
function isNullOption (fieldObj,fieldName)
{
	var count = 0;
	for ( var i = 0; i < fieldObj.length ; i ++ )
	{
		count ++;
	}
	if ( count == 0 )
	{
		alert( fieldName + "不能为空！" );
		fieldObj.focus();
		return true;
	}
	else
	{
		return false;
	}
}

/***
 * allowFileExt: 允许上传的扩展名检测
 * field: 检测的表单对象
 * Msg: 提示信息
 * extList: 允许的扩展名集合(如：gif|jpg|rar)
 * @return
 */
function allowFileExt(field,Msg,extList){
	var postfix = getPostfix(field.value);
	if(extList.toLowerCase().indexOf(postfix.toLowerCase())==-1){
		alert(Msg + ": " + "上传的文件格式不对!(允许的格式："+extList+")");
		return false;
	}else{
		return true;
	}
}

//根据路径获取文件扩展名   
function getPostfix(path){   
    return path.substring(path.lastIndexOf("."),path.length);   
}  

 /*
 功能：判断一个字符串是否为合法日期
 参数说明：strDate需要判断的时间
 */
 //日期格式：YYYY-MM-DD
 function isdate(strDate)
 {
 	var strSeparator = "-"; //日期分隔符
 	var strDateArray;
 	var intYear;
 	var intMonth;
 	var intDay;
 	var boolLeapYear;

 	strDateArray = strDate.split(strSeparator);

 	if(strDateArray.length!=3) return false;

 	intYear = parseInt(strDateArray[0],10);
 	intMonth = parseInt(strDateArray[1],10);
 	intDay = parseInt(strDateArray[2],10);

 	if(isNaN(intYear)||isNaN(intMonth)||isNaN(intDay)) return false;

 	if(intMonth>12||intMonth<1) return false;

 	if((intMonth==1||intMonth==3||intMonth==5||intMonth==7||intMonth==8||intMonth==10||intMonth==12)&&(intDay>31||intDay<1)) return false;

 	if((intMonth==4||intMonth==6||intMonth==9||intMonth==11)&&(intDay>30||intDay<1)) return false;

 	if(intMonth==2)
 	{
 		if(intDay<1) return false;

 		boolLeapYear = false;
 		if((intYear%100)==0)
 		{
 			if((intYear%400)==0) boolLeapYear = true;
 		}
 		else
 		{
 			if((intYear%4)==0) boolLeapYear = true;
 		}

 		if(boolLeapYear)
 		{
 			if(intDay>29) return false;
 		}
 		else
 		{
 			if(intDay>28) return false;
 		}
 	}
 	return true;
 }
 
 /*
  *功能：日期比较
  *参数说明：startdate 开始时间，enddate结束时间
  */
 function comptimes(startdate,enddate)
 {
 	if(isdate(startdate)&&isdate(enddate))
 	{
 	var starttime=new Date(startdate.replace(/\-/g, "\/"));
 	var endtime=new Date(enddate.replace(/\-/g, "\/"));
 	var nowtime=new Date();
 		if(starttime>=endtime)
 		{
 			alert("开始时间必须小于结束时间!");
 			return false;
 		}

 	}else
 	{
 		alert("无法识别的时间格式!");
 		return false;
 	}
 	return true;
 }  
 
 /*
 	*功能：验证图片是否存在和大小
  *参数说明：file 文件对象，size 文件大小(单位KB)
  *
  */
 function CheckisImage(file,size){
 	 if(file.value.trim()=="")
      {
     	 return true;
      }
 	 var image=new Image();       
 	 image.dynsrc=file.value;
 	if(image.fileSize<0)
 	{
 		alert("文件不存在！");
 		return false;
 	}
 	if(image.fileSize/1024>size)
 	{
 		alert("文件大小已超过限制,最大为："+size+"KB!");
 		return false;
 	}
 return true;
 }
 
 /*
 	*功能：清除查询条件
  */
 function clearSearch()
 {
 	var inputobj=document.getElementsByTagName("input");
 	var selectobj=document.getElementsByTagName("select");
 	for(var i=0;i<inputobj.length;i++)
 		{
 		if(inputobj[i].type=="text")
 			{
 			inputobj[i].value="";
 			}

 		}
 	for(var i=0;i<selectobj.length;i++)
 	{

 	
 		selectobj[i].options[0].selected="selected";
 		

 	}
 }
 /*
 	*功能：清除单引号
  */
 function clearQuotationMarks()
 {
 	var flag=true;
 	var inputobj=document.getElementsByTagName("input");
 	for(var i=0;i<inputobj.length;i++)
 	{
 	
 		if(inputobj[i].type!="text")continue;
 		if(inputobj[i].value.trim()=="")continue;
 		
 		if(inputobj[i].value.trim()==createQuotationMarks(inputobj[i].value.trim()))
 		{
 		
 			alert("英文单引号不在查询范围内，请重新输入!");
 			flag=false;
 			break;
 		}else{
 		
 				inputobj[i].value=inputobj[i].value.replace(/'/g,"");
 		}
 	}
 	return flag;
 }
//创建与字符长度相同的都是单引号字符，用于判断输入的是否全部为单引号
 function createQuotationMarks(querystring)
 {
 	var string="";
 	for(var i=0;i<querystring.length;i++)
 	{
 		string=string+"'";
 	}
 	return string;
 }
 /*写入cookie
  *参数说明：name cookies的名字，value 需要存放的值，day 存放是时间
  */
 function writeCookie(name,value,day)
 {
 	deleteCookie(name);
 	expire="";
 	expire=new Date();
 	expire.setTime(expire.getTime()+day*24*3600*1000);
 	expire=expire.toGMTString();
 	document.cookie=name+"="+value+";expires="+expire+";path=/";
 }
 /*功能：删除cookie
  *参数说明：name 需要删除cookies名字
  */
 function deleteCookie(name){
 	   var date = new Date();
 	   date.setTime(date.getTime() - 10000);
 	   document.cookie = name + "=; expires=" + date.toGMTString();
 }
 /*功能：读取cookie
  *参数说明：name 需要删除cookies名字
  */
 function readCookie(name)
 {
 	var cookies="";
 	var strCookie=document.cookie;
 	var arrCookie=strCookie.split(";");
 	//遍历cookie数组
 	for(var i=0;i<arrCookie.length;i++){
 	 var arr=arrCookie[i].split("=");
 	 if(name.trim()==arr[0].trim()){
 		 //decodeURIComponent解码，eval转换为JSON
 		 cookies=arr[1];
 		  break;
 		 }

 	}
 	return cookies;
 }

 /*
  * 功能：从一个多选框中选择值添加到另外一个多选框中
  * 参数说明：srcField 源多选框字段名称
  * 	 				aimField 目的多选框字段名称
  */
 function addOptions(srcField,aimField)
 {
 	var flag;
 	for(var x=srcField.length-1;x>=0;x--)
 	{
 		var opt = srcField.options[x];
 		if (opt.selected)
 		{
 			flag = true;
 			for (var y=0;y < aimField.length;y++)
 			{
 				var myopt = aimField.options[y];
       				if (myopt.value == opt.value)
         			{
         				srcField.options[x] = null;
           				flag = false;
         			}
       			}
       			if(flag)
       			{
         			srcField.options[x] = null;
         			aimField.options[aimField.options.length] = new Option(opt.text, opt.value, 1, 1);
       			}
     		}
 	}
 }

 /*
  * 功能：从一个多选框中全部值添加到另外一个多选框中
  * 参数说明：srcField 源多选框字段名称
  * 	 				aimField 目的多选框字段名称
  */
 function addAllOptions(srcField,aimField)
 {
 	var flag;
 	for(var x=srcField.length-1;x>=0;x--)
 	{
 		var opt = srcField.options[x];
       		srcField.options[x] = null;
        		aimField.options[aimField.options.length] = new Option(opt.text, opt.value, 1, 1);
 	}
 }
 
 /*************遮蔽效果 begin of*****************/
 function openBg(state){ //遮照打开关闭控制
 	if(state == 1)
 	{
 		$$("bg").style.display = "block";
 		var h = document.body.offsetHeight > document.documentElement.offsetHeight ? document.body.offsetHeight : document.documentElement.offsetHeight;
 		$$("bg").style.height = h + "px";
 	}
 	else
 	{
 		$$("bg").style.display = "none";
 	}	
 }

 function openDetail(idstr,state){ //选择关闭打开控制
 	openBg(state);
 	if(state == 1)	
 	{
 		$$(idstr).style.display = "block";
 		$$(idstr).style.left = ($$("bg").offsetWidth - $$(idstr).offsetWidth)/2 + "px";
 		$$(idstr).style.top = document.body.scrollTop + 50 + "px";		
 	}
 	else
 	{
 		$$(idstr).style.display = "none";
 	}
 }
 /*************遮蔽效果 begin of*****************/