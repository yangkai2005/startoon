//�ϲ� js/js.js   js/sell.js   js/reg.js   js/cookies.js  js/cookies2.js
//	 js/cookieutil.js  js/ajax.js  js/proxy.js  js/adv.js  js/compare.js
//

function showDiv(divID)
{
	if( divID==0 )
	{
		document.all.formForArea.style.visibility = "hidden";
		document.all.formForPage.style.visibility = "hidden";
	}

	var divnamegd = "sortktd" + divID;
	var divnamefd = "sortlayer" + divID;
	
	var e = document.getElementById(divnamegd);
  var x = e.offsetLeft, y = e.offsetTop;     
  while(e = e.offsetParent){   
    x += e.offsetLeft;     
    y += e.offsetTop;  
  }  
	
	var divobjfd = document.getElementById(divnamefd);
	divobjfd.style.left = x + 'px';
	divobjfd.style.top = y + 'px';

	divobjfd.style.display='';
}

function changeTab(index)
{
          for (var i=1;i<=2;i++)
          {
             document.getElementById ("li_"+i).className ="tt2";
             document.getElementById ("li_"+index).className ="tt1";
                
             document.getElementById ("div"+i).style.display  ="none";
           }
          document.getElementById ("div"+index).style.display  ="block";
}

////No need to edit beyond here

var ie4=document.all&&navigator.userAgent.indexOf("Opera")==-1;
var ns6=document.getElementById&&!document.all;
var ns4=document.layers;

function showmenu_ceng( case_num, iCanshuFlag, str_Js_Canshu, productid, username, str_CorpInfo, jingJia ){

var reg=new RegExp("!@#","g"); //��������RegExp����
str_Js_Canshu = str_Js_Canshu.replace( reg, "<br/>" );
str_CorpInfo = str_CorpInfo.replace( reg, "<br/>" );

if( jingJia.length!=0)
	jingJia = "onClick=\"proxyKeyword(this);\" accessType=0 " + jingJia;

var which = "";
if( iCanshuFlag > 0 )
{
which = "<div id=\"tank1\">"
+"		<div class=\"tanktd1\">"
+"				<div class=\"tt1\"  id=\"li_1\" onMouseover=\"changeTab('1')\">������Ϣ"
+"				</div>"
+"				<div class=\"tt0\">&nbsp;"
+"				</div>"
+"				<div class=\"tt2\" id=\"li_2\" onMouseover=\"changeTab('2')\">��˾��Ϣ"
+"				</div>"
+"		</div>"
+"		<div class=\"tanktd2\">"
+"				<div class=\"tancontent\" id=\"div1\" style =\"display:block\">"+str_Js_Canshu
+"					<div class=\"tanbtn\"><a href=\"http://china.makepolo.com/product-detail/"+productid+".html\" "+jingJia+" target=_blank><img src=\"../images/tank6_product.jpg\" alt=\"�鿴��ϵ��ʽ\" border=\"0\" /></a>"
+"					</div>   "
+"				</div>"
+"				<div class=\"tancontent\" id=\"div2\" style =\"display:none\">"+str_CorpInfo
+"					<div class=\"tanbtn\"><a href=\"http://"+username+".cn.makepolo.com/contact_us.html\" "+jingJia+" target=_blank><img src=\"../images/tank6.jpg\" alt=\"�鿴��ϵ��ʽ\" border=\"0\" /></a>"
+"					</div>"
+"				</div>"
+"		</div>"
+"		<div class=\"tanktd3\">&nbsp;"
+"		</div>"
+"</div>";
}
else
{
which = "<div id=\"tank1\">"
+"		<div class=\"tanktd1\">"
+"				<div class=\"tt1\"  id=\"li_1\" onMouseover=\"changeTab('1')\">��˾��Ϣ"
+"				</div>"
+"				<div class=\"tt0\">&nbsp;"
+"				</div>"
+"				<div id=\"li_2\">"
+"				</div>"
+"		</div>"
+"		<div class=\"tanktd2\">"
+"				<div class=\"tancontent\" id=\"div1\" style =\"display:block\">"+str_CorpInfo
+"					<div class=\"tanbtn\"><a href=\"http://"+username+".cn.makepolo.com/contact_us.html\" "+jingJia+" target=_blank><img src=\"http://jic.b2b.makepolo.com/caigou/images/tank6.jpg\" alt=\"�鿴��ϵ��ʽ\" border=\"0\" /></a>"
+"					</div>   "
+"				</div>"
+"				<div id=\"div2\">"
+"				</div>"
+"		</div>"
+"		<div class=\"tanktd3\">&nbsp;"
+"		</div>"
+"</div>";
}
if (!document.all&&!document.getElementById&&!document.layers)
return

clearhidemenu()

menuobj=ie4? document.all.popmenu : ns6? document.getElementById("popmenu") : ns4? document.popmenu : ""
menuobj.thestyle=(ie4||ns6)? menuobj.style : menuobj

if (ie4||ns6)
menuobj.innerHTML=which
else{
menuobj.document.write('<layer name=gui onmouseover="clearhidemenu()" onmouseout="hidemenu()">'+which+'</layer>')
menuobj.document.close()
}

	var divnamegd;
	if( case_num==1 )
		divnamegd = "picture" + productid;
	else
		divnamegd = "param" + productid;

	var e = document.getElementById(divnamegd);
  var x = e.offsetLeft, y = e.offsetTop;
  while(e = e.offsetParent){
    x += e.offsetLeft;
    y += e.offsetTop;
  }  

	if( case_num==1 )
		menuobj.thestyle.left = x + 100 + 'px';
	else
		menuobj.thestyle.left = x - 255 + 'px';
menuobj.thestyle.top = y + 'px';
menuobj.thestyle.visibility="visible";
return false
}

function getStyle(obj,name){
	return obj.currentStyle?obj.currentStyle[name]:(document.defaultView.getComputedStyle(obj,"").getPropertyValue(name))
}

function contains_ns6(a, b) {
//Determines if 1 element in contained in another- by Brainjar.com
while (b.parentNode)
if ((b = b.parentNode) == a)
return true;
return false;
}

function hidemenu(){
if (window.menuobj)
menuobj.thestyle.visibility=(ie4||ns6)? "hidden" : "hide"
}

function dynamichide(e){
if (ie4&&!menuobj.contains(e.toElement))
hidemenu()
else if (ns6&&e.currentTarget!= e.relatedTarget&& !contains_ns6(e.currentTarget, e.relatedTarget))
hidemenu()
}

function delayhidemenu(){
if (ie4||ns6||ns4)
delayhide=setTimeout("hidemenu()",5)
}

function clearhidemenu(){
if (window.delayhide)
clearTimeout(delayhide)
}

if (ie4||ns6)
document.onclick=hidemenu;

//--------------  js/js.js----------------------
/**
* checkBox��ť�����
*/
function CheckBox(divHeight){
	this.divHeight = divHeight;
	this.clickCount = 0;
	this.checkCount = 0;//��ǰѡ�е�CHECK
	this.checkBoxChilds = new Array();
}
CheckBox.prototype = {
	init:function(checkEl){
	for(var i=0;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].checked==true){
	this.checkCount++;
	
	}
	}
	if(checkEl.checked==true){
	this.checkCount = this.checkCount-1;
	}
	if(checkEl.checked==false){
	this.checkCount = this.checkCount+1;
	}
	},
	/**
	* ��ȡ��ǰcheck��checkBox�е�����
	*/
	getNum:function(checkEl){
	for(var i=0;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].id==checkEl.id){
	return i;
	}
	}
	},
	/**
	* ������checkBox�е����з�����Ӧ��check����
	*/
	getCheck:function(num){
	return this.checkBoxChilds[num];
	},
	/**
	* ����checkbox����checkbox����
	*/
	add:function(checkEl){
	this.checkBoxChilds[this.checkBoxChilds.length] = document.getElementById(checkEl);
	},
	/**
	* ��ȡ�뵱ǰcheckbox�����ѡ�е�checkbox������
	*/
	getNearCheckedNum:function(checkEl){
	var checkElNum = this.getNum(checkEl);
	var upCheckedNum = this.getUpCheckedNum(checkElNum);
	var downCheckedNum = this.getDownCheckedNum(checkElNum);
	if(upCheckedNum!=null&&downCheckedNum!=null){
	if((checkElNum-upCheckedNum)<=(downCheckedNum-checkElNum)){
	return upCheckedNum;
	}else{
	return downCheckedNum;
	}
	}else if(upCheckedNum==null&&downCheckedNum!=null){
	return downCheckedNum;
	}else if(upCheckedNum!=null&&downCheckedNum==null){
	return upCheckedNum;
	}else{
	return checkElNum;
	}
	},
	/**
	* ���ϻ�ȡ�����ѡ�е�checkbox������
	*/
	getUpCheckedNum:function(num){
	for(var i = num-1;i>=0;i--){
	if(this.checkBoxChilds[i].checked){
	return i;
	}
	}
	return null;
	},
	/**
	* ���»�ȡ�����ѡ�е�checkbox������
	*/
	getDownCheckedNum:function(num){
	for(var i = num+1;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].checked){
	return i;
	}
	}
	return null;
	},
	changecheckStat:function(checkEl){
	if(this.clickCount==0){
	this.init(checkEl);
	}
	this.clickCount++;
	if(checkEl.checked){
	this.checkCount++;
	if(this.checkCount>=2){
	this.showFloatDiv(checkEl);
	}else{
	this.hiddenFlaotDiv();
	}
	}else{
	this.checkCount--;
	if(this.checkCount>=2){
	this.showFloatDiv(this.getCheck(this.getNearCheckedNum(checkEl)));
	}else{
	this.hiddenFlaotDiv();
	}
	}
	},
	clearCount:function(){
	this.clickCount = 0;
	this.checkCount = 0;
	this.hiddenFlaotDiv();
	},
	/**
	* ��ʾ����λ��ʾ������
	*/
	showFloatDiv:function(checkEl){
	document.getElementById("tishiDiv").style.display = "block";
	document.getElementById("tishiDiv").style.position = "absolute";
	document.getElementById("tishiDiv").style.top = getXY(checkEl)[1]-this.divHeight+"px";
	document.getElementById("tishiDiv").style.left = getXY(checkEl)[0]-10+"px";
	},
	/**
	* ������ʾ������
	*/
	hiddenFlaotDiv:function(){
	document.getElementById("tishiDiv").style.display = "none";
	}
}
/**
* ��ȡ����el��X,Y����
* @param {Object} el
*/
function getXY(el){
	var pos;
	if(this.getExplorerType()==1){
	var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
	var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
	pos = [el.getBoundingClientRect().left+scrollLeft, el.getBoundingClientRect().top+scrollTop];
	}else{
	pos = [el.offsetLeft, el.offsetTop];
	var parentNode = el.offsetParent;
	if (parentNode != el) {
	while (parentNode) {
	pos[0] += parentNode.offsetLeft;
	pos[1] += parentNode.offsetTop;
	parentNode = parentNode.offsetParent;
	}
	}
	if (el.parentNode) { parentNode = el.parentNode; }
	else { parentNode = null; }
	while (parentNode && parentNode.tagName.toUpperCase() != 'BODY' && parentNode.tagName.toUpperCase() != 'HTML'){
	if (parentNode.style.display != 'inline') {
	pos[0] -= parentNode.scrollLeft;
	pos[1] -= parentNode.scrollTop;
	}
	if (parentNode.parentNode) {
	parentNode = parentNode.parentNode;
	} else { parentNode = null; }
	}
	}
	return pos;
}

function getExplorerType(){
	var ua = navigator.userAgent.toLowerCase();
	if(window.ActiveXObject){
	return 1;
	}else if((ua.indexOf('firefox')>-1)){
	return 2;
	}else if((ua.indexOf('opera')>-1)){
	return 3;
	}
}

//�������
function OnClose(obj){
  return typeof(obj)=="string"?document.getElementById(obj):obj
}

function allt(id){
  e=OnClose(id)
  var et=e.offsetTop;
  var el=e.offsetLeft;
  while(e=e.offsetParent){
  et+=e.offsetTop;
  el+=e.offsetLeft;
  }
  OnClose("reg_div").style.left=(el) + "px";
  OnClose("reg_div").style.top=(et+25) + "px";
  OnClose("reg_div").style.display='';
}
function bllt(id){
  OnClose("input1").value=OnClose(id).innerHTML
  OnClose("reg_div").style.display='none';
}

/*<font color=#003399>����&gt;&gt;</font> <font color=#FF0000>&lt;&lt;�����ʾ</font>*/
function showul(ulclsname,liclsname,showmorename,layername)
{
	if(null == layername)
		layername = "showlayer";
	var showmore = document.getElementById(showmorename);
	var Lshow = document.getElementById(layername);
	if(showmore)
	{
		if(showmore.className == "showmore")
		{
			Lshow.innerHTML = "<A class=tag1 style=cursor:hand onmouseover=this.style.textDecoration='underline'   onmouseout=this.style.textDecoration='underline' onclick=\"showul('"+ulclsname+"','more','"+showmorename+"','"+layername+ 
						"');\"><img alt='' src=\"http://jic.b2b.makepolo.com/caigou/images/jianjie.gif\" /></A>&nbsp;";
			showmore.className = "showless";
			disp = "block";
		}
		else
		{
			Lshow.innerHTML = "<A  style=cursor:hand onmouseover=this.style.textDecoration='underline'   onmouseout=this.style.textDecoration='underline'  onclick=\"showul('"+ulclsname+"','more','"+showmorename+"','"+layername+"');\"><img alt='' src=\"http://jic.b2b.makepolo.com/caigou/images/button_more.gif\" /></A>";
			showmore.className = "showmore";
			disp = "none";
		}
	}
	var es = document.getElementById(ulclsname);
	for (var j = 0; j < es.childNodes.length; j++) {
		var child = es.childNodes.item(j);
		if (child && (child.tagName == 'li' || child.tagName == 'LI') && child.className && child.className == liclsname)child.style.display=disp;
	}
}

function showAttrDiv(showdiv_father,sortktd_more,more_attr,layer_attr)
{
	if(null == layer_attr)
		layer_attr = "layer_attr";
	var showmore = document.getElementById(more_attr);
	var Lshow = document.getElementById(layer_attr);
	if(showmore)
	{
		if(showmore.className == "showmorediv")
		{
			Lshow.innerHTML = "<A style='cursor:hand; WIDTH: 100px' onmouseover=this.style.textDecoration='underline'   onmouseout=this.style.textDecoration='underline' onclick=\"showAttrDiv('"+showdiv_father+"','sortktd_more','"+more_attr+"','"+layer_attr+ 
						"');\"><img alt='' src=\"http://jic.b2b.makepolo.com/caigou/images/ps_sortk_less.gif\" /></A>&nbsp;";
			showmore.className = "showlessdiv";
			disp = "block";
		}
		else
		{
			Lshow.innerHTML = "<A style=cursor:hand onmouseover=this.style.textDecoration='underline'   onmouseout=this.style.textDecoration='underline'  onclick=\"showAttrDiv('"+showdiv_father+"','sortktd_more','"+more_attr+"','"+layer_attr+"');\"><img alt='' src=\"http://jic.b2b.makepolo.com/caigou/images/ps_sortk.gif\" /></A>";
			showmore.className = "showmorediv";
			disp = "none";
		}
	}
	var es = document.getElementById(showdiv_father);
	for (var j = 0; j < es.childNodes.length; j++) {
		var child = es.childNodes.item(j);
		if (child && (child.tagName == 'div' || child.tagName == 'DIV') && child.className && ( child.className==sortktd_more ) )
			child.style.display=disp;
	}
}

/*�����б��*/
function showmenu() 
{ 
document.all("menu1").style.display="block"; 
} 

/*�б���Ч��*/
 cookieName = "offerId";
  domainName = ".makepolo.com";
  prefix = "";
  defaultClassName = "plistk";
  checkedClassName = "plistk1";
  defaultClassName1 = "picBlock";
  checkedClassName1 = "picBlock1";
  
  
  var categoryId = 100115;
  
  var c = getCookie("categoryId");
  if (c == null || c == "null" ){
	  addCookie("categoryId",categoryId); 
	  if (categoryId !=null && categoryId!=""){
		clearCookie_js(cookieName);	
	  }
  }else if(c !=categoryId){
	  clearCookie_js("categoryId");  
	  clearCookie_js(cookieName);
  }
	 
   function addCookie(name,value) {
	 value = value+prefix;
	if(categoryId =="")
		return;
	document.cookie = name + "=" + value +";path=/;"+ "domain="+domainName;;
   }
   
  function clearCookie_js(name) {
	  var value = "null";
	  cookieValue= name + "=" + value + ";path=/;" + "domain="+domainName;
	  document.cookie = cookieValue;
  }
	
  function addOfferId(arg) {
	arg  = arg + prefix;
	
	if(hasOfferId(arg)) {
		return;
	}
	if(arg == "") {
		return;
	}
	value = getCookie(cookieName);
	if(value == null || value == "null" ) {
		value = arg ;
	} else {
	   value=value+"x"+ arg;
	}
	cookieValue = cookieName + "=" + value + ";path=/;" + "domain="+domainName;
	document.cookie = cookieValue;
	//alert(document.cookie);
  }

  function delOfferId(arg) {
	arg = arg + prefix;

	if(!hasOfferId(arg)) {
	   return;
	}

	value = getCookie(cookieName);
	var offerIds = stringToArray(value);
	var len = offerIds.length;
	var result = "";
	var counter = 0;
	for(var i=0;i<len;i++) {
	  if(offerIds[i] != arg) {
			if(counter == 0) {
			  result = offerIds[i];
			} else {
			  result = result + "x" + offerIds[i];
			}
			counter++;
	  }
	}
	cookieValue = cookieName + "=" + result + ";path=/;" + "domain="+domainName;
	document.cookie = cookieValue;
  }
  //]]>

  //<![CDATA[
	function getCookie(name) {
	  var arg = name + "=";
	  var alen = arg.length;
	  var clen = document.cookie.length;
	  var i=0;
	  while(i<clen) {
		var j=i+alen;
		if(document.cookie.substring(i,j)==arg)
			return www_helpor_net(j);
		i=document.cookie.indexOf(" ",i)+1;if(i==0)
			break;
	  }
	  return null;
	}
	function www_helpor_net(offset) {
	  var endstr=document.cookie.indexOf(";",offset);
	  if(endstr==-1)
	  endstr=document.cookie.length;
	  return unescape(document.cookie.substring(offset,endstr));
	}
  //]]>

  //<![CDATA[
  function hasOfferId(arg) {
	var value = getCookie(cookieName);
	if(value == null || value == "null" || value.indexOf(arg) == -1 ) {
		return false;
	} else {
		return true;
	}
  }

  function getOfferIdCount() {

	value = getCookie(cookieName);
	
	if(value == null || value == 'null') {
	  return 0;
	}
	
	var count = 1;
	while(value.indexOf("x") != -1) {
	   var position = value.indexOf("x");
	   var len = value.length;
	   value =  value.substring(position+1,len);
	   count++;
	}
	return count;
  }

//-------------js/sell.js--------------------------
/**
* checkBox��ť�����
*/
function CheckBox(divHeight){
	this.divHeight = divHeight;
	this.clickCount = 0;
	this.checkCount = 0;//��ǰѡ�е�CHECK
	this.checkBoxChilds = new Array();
}
CheckBox.prototype = {
	init:function(checkEl){
	for(var i=0;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].checked==true){
	this.checkCount++;
	
	}
	}
	if(checkEl.checked==true){
	this.checkCount = this.checkCount-1;
	}
	if(checkEl.checked==false){
	this.checkCount = this.checkCount+1;
	}
	},
	/**
	* ��ȡ��ǰcheck��checkBox�е�����
	*/
	getNum:function(checkEl){
	for(var i=0;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].id==checkEl.id){
	return i;
	}
	}
	},
	/**
	* ������checkBox�е����з�����Ӧ��check����
	*/
	getCheck:function(num){
	return this.checkBoxChilds[num];
	},
	/**
	* ����checkbox����checkbox����
	*/
	add:function(checkEl){
	this.checkBoxChilds[this.checkBoxChilds.length] = document.getElementById(checkEl);
	},
	/**
	* ��ȡ�뵱ǰcheckbox�����ѡ�е�checkbox������
	*/
	getNearCheckedNum:function(checkEl){
	var checkElNum = this.getNum(checkEl);
	var upCheckedNum = this.getUpCheckedNum(checkElNum);
	var downCheckedNum = this.getDownCheckedNum(checkElNum);
	if(upCheckedNum!=null&&downCheckedNum!=null){
	if((checkElNum-upCheckedNum)<=(downCheckedNum-checkElNum)){
	return upCheckedNum;
	}else{
	return downCheckedNum;
	}
	}else if(upCheckedNum==null&&downCheckedNum!=null){
	return downCheckedNum;
	}else if(upCheckedNum!=null&&downCheckedNum==null){
	return upCheckedNum;
	}else{
	return checkElNum;
	}
	},
	/**
	* ���ϻ�ȡ�����ѡ�е�checkbox������
	*/
	getUpCheckedNum:function(num){
	for(var i = num-1;i>=0;i--){
	if(this.checkBoxChilds[i].checked){
	return i;
	}
	}
	return null;
	},
	/**
	* ���»�ȡ�����ѡ�е�checkbox������
	*/
	getDownCheckedNum:function(num){
	for(var i = num+1;i<this.checkBoxChilds.length;i++){
	if(this.checkBoxChilds[i].checked){
	return i;
	}
	}
	return null;
	},
	changecheckStat:function(checkEl){
	if(this.clickCount==0){
	this.init(checkEl);
	}
	this.clickCount++;
	if(checkEl.checked){
	this.checkCount++;
	if(this.checkCount>=1){
	this.showFloatDiv(checkEl);
	}else{
	this.hiddenFlaotDiv();
	}
	}else{
	this.checkCount--;
	if(this.checkCount>=1){
	this.showFloatDiv(this.getCheck(this.getNearCheckedNum(checkEl)));
	}else{
	this.hiddenFlaotDiv();
	}
	}
	},
	clearCount:function(){
	this.clickCount = 0;
	this.checkCount = 0;
	this.hiddenFlaotDiv();
	},
	/**
	* ��ʾ����λ��ʾ������
	*/
	showFloatDiv:function(checkEl){
	document.getElementById("tishiDiv").style.display = "block";
	document.getElementById("tishiDiv").style.position = "absolute";
	document.getElementById("tishiDiv").style.top = getXY(checkEl)[1]-this.divHeight+"px";
	document.getElementById("tishiDiv").style.left = getXY(checkEl)[0]-10+"px";
	},
	/**
	* ������ʾ������
	*/
	hiddenFlaotDiv:function(){
	document.getElementById("tishiDiv").style.display = "none";
	}
}
/**
* ��ȡ����el��X,Y����
* @param {Object} el
*/
function getXY(el){
	var pos;
	if(this.getExplorerType()==1){
	var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
	var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
	pos = [el.getBoundingClientRect().left+scrollLeft, el.getBoundingClientRect().top+scrollTop];
	}else{
	pos = [el.offsetLeft, el.offsetTop];
	var parentNode = el.offsetParent;
	if (parentNode != el) {
	while (parentNode) {
	pos[0] += parentNode.offsetLeft;
	pos[1] += parentNode.offsetTop;
	parentNode = parentNode.offsetParent;
	}
	}
	if (el.parentNode) { parentNode = el.parentNode; }
	else { parentNode = null; }
	while (parentNode && parentNode.tagName.toUpperCase() != 'BODY' && parentNode.tagName.toUpperCase() != 'HTML'){
	if (parentNode.style.display != 'inline') {
	pos[0] -= parentNode.scrollLeft;
	pos[1] -= parentNode.scrollTop;
	}
	if (parentNode.parentNode) {
	parentNode = parentNode.parentNode;
	} else { parentNode = null; }
	}
	}
	return pos;
}

function getExplorerType(){
	var ua = navigator.userAgent.toLowerCase();
	if(window.ActiveXObject){
	return 1;
	}else if((ua.indexOf('firefox')>-1)){
	return 2;
	}else if((ua.indexOf('opera')>-1)){
	return 3;
	}
}

//-------------js/reg.js--------------------------

function oo(obj){
  return typeof(obj)=="string"?document.getElementById(obj):obj
}


function allt(id){


  e=oo(id)
  var et=e.offsetTop;
  var el=e.offsetLeft;
  while(e=e.offsetParent){
  et+=e.offsetTop;
  el+=e.offsetLeft;
  }


  oo("reg_div").style.left=(el) + "px";
  oo("reg_div").style.top=(et+25) + "px";
  oo("reg_div").style.display='';
//  oo("reg_div2").innerHTML=id;  //  �����ʾ��Ϣ(����id�ж�)


  //  oo("reg_div").style.display='none';


}
function bllt(id){


  oo("input_01").value=oo(id).innerHTML
  oo("reg_div").style.display='none';
}

//-------------js/cookies.js--------------------------


//SetCookie ("productKW", "����")
//alert(getCookie('productKW'));
function   getStrActualLen(sChars)
{   
	  return   sChars.replace(/[^\x00-\xff]/g,"xx").length;   
}   
//   ��ȡ�̶��������ַ���   
function   getInterceptedStr(sSource,   iLen)
{   
  	if(getStrActualLen(sSource)   <=   iLen)
  	{   
  			return sSource;   
  	}   
  	var   ELIDED   =   "...";   
  	var   str   =   "";   
  	var   l   =   0;   
  	var   schar;   
  	for(var   i=0;   schar=sSource.charAt(i);   i++)
  	{   
  			str   +=   schar;   
  			l   +=   (schar.match(/[^\x00-\xff]/)   !=   null   ?   2   :   1);   
  			if(l   >=   iLen   -   ELIDED.length)
  			{   
  					break;   
  			}   
  	}   
  	str   +=   ELIDED;   
  	return   str;   
}
///������������Ϣ�����
function setProduct(pid,pname,purl)
{
  	var pID=pid;
  	var pName=pname.replace(/\s/g, "").replace(/<[^>]*>/g, "");//ȥ���ո� html ��ǩ��
  	var pUrl=purl;
  	//alert(pName)
  	var cookiePN=pID+'@@'+pName+'@@'+pUrl;
  	var oldCookie=getCookie('productKW');
  	if(oldCookie!=null)
  	{
				if(oldCookie.indexOf(cookiePN)==-1)
				{
		   		  var newCookie=oldCookie+'#'+pID+'@@'+pName+'@@'+pUrl;
				  	SetCookie('productKW',newCookie);
				}
				//alert(oldCookie.indexOf(cookiePN));
  	}
  	else
  	{
				var newCookie=pID+'@@'+pName+'@@'+pUrl;
				SetCookie('productKW',newCookie);
  	}
}
//������������Ϣ��ͳ��
function recentProduct_getCount_Num_ck()
{
		var checkArr=new Array();
  	if(document.all)
  	{
  			//�� document.all.ckForm �滻Ϊ document.getElementById('ck')
  			for(i=0,j=0;i<document.getElementById('ck').all.tags("INPUT").length;i++)
  			{
				 		if(document.getElementById('ck').all.tags("INPUT")[i].type=="checkbox"&&document.getElementById('ck').all.tags("INPUT")[i].checked==true)
						{ 
				  			checkArr[j++]=document.getElementById('ck').all.tags("INPUT")[i].id;
				 		}
  			}
  	}
  	else
  	{
  			for(i=0,j=0;i<document.forms['ckForm'].length;i++)
  			{
				 		if(document.forms['ckForm'][i].type=="checkbox"&&document.forms['ckForm'][i].checked==true)
						{ 
				  			checkArr[j++]=document.forms['ckForm'][i].id;
				 		}
  			}  
  	}
 		//alert(checkArr.length);
  	return checkArr;
}
//������������Ϣ���
function recentProduct_clearCookie(tag)
{
		if(recentProduct_getCount_Num_ck()!=0)
		{
		  	if(tag==1)
				{
		  			//alert(recentProduct_getCount_Num_ck().length);
		 				//delCookie('productKW')
		  			var Pcookie=getCookie('productKW');
						var rp;
		  			var newPcookie2;
		  			for(var i=0;i<recentProduct_getCount_Num_ck().length;i++)
		  			{
								//alert(recentProduct_getCount_Num_ck()[i].substring(2,recentProduct_getCount_Num_ck()[i].length));
								//alert(document.getElementById(recentProduct_getCount_Num_ck()[i]).value);
								rp=document.getElementById(recentProduct_getCount_Num_ck()[i]).value;
								newPcookie2=Pcookie.replace('#'+rp,'').replace(rp+'#','').replace(rp,'');
								Pcookie=newPcookie2;
		  			}
		  			if(Pcookie!=null||Pcookie!='')
		  			{
								SetCookie('productKW',Pcookie);
								recentProduct_viewCookie();
		  			}
		  			else
		  			{
								delCookie('productKW');//ȫ�����
								recentProduct_viewCookie();
		  			}
				}
		  	else if(tag==2)//����
		  	{  
		  			if(recentProduct_getCount_Num_ck().length==1)
				 		{
				 				var cvalue=document.getElementById(recentProduct_getCount_Num_ck()[0]).value;
				 				//alert(cvalue);
								SetCookie('productKW',cvalue);
								recentProduct_viewCookie();
				 		}
				 		else
				 		{  
								var newcookie='';
								for(var i=0;i<recentProduct_getCount_Num_ck().length;i++)
								{  
						  			var cvalue=document.getElementById(recentProduct_getCount_Num_ck()[i]).value;
						  			newcookie+=cvalue+'#';
								}
								//alert(newcookie.substring(0,newcookie.length-1));
								SetCookie('productKW',newcookie.substring(0,newcookie.length-1));
								recentProduct_viewCookie();
				 		}
		  	}
		}
		else
		{}
}
//������������Ϣ�鿴
function recentProduct_viewCookie()
{
  	var Pcookie=getCookie('productKW');
  	if(Pcookie==null||Pcookie=='')
  	{
				document.getElementById('ck').innerHTML='';
  	}
  	else
  	{
				var psplit=Pcookie.split("#");
				if(psplit.length>6)
				{
						var txt="<div id='rightContent'><ul class='title'>������������Ϣ</ul>";
						txt+="<ul class='content gray'>";
						var temp=1;
						for(var i=0;i<=5;i++)
						{
						 	txt+="<li><input type='checkbox' name='checkbox' value='"+psplit[psplit.length-temp]+"' id='ck"+psplit[psplit.length-temp].split('@@')[0]+"'/> <a href='"+psplit[psplit.length-temp].split('@@')[2]+"' target='_black' ";
						 	var subtxt=psplit[psplit.length-temp].split('@@')[1];
		  				txt+="title='"+subtxt+"'>";
		  				subtxt=getInterceptedStr(subtxt,20);
		  				txt+=subtxt;
		  				txt+="</a></li>";
						 	temp++;
						} 
						txt+="</ul>";
						txt+="<ul class='operate'><input type='button' value='���' class='btn1' onclick='recentProduct_clearCookie(1)'/></ul></div>";
						document.getElementById('ck').innerHTML=txt;
				}
				else if(psplit.length>0)
				{
						var txt="<div id='rightContent'><ul class='title'>������������Ϣ</ul>";
						txt+="<ul class='content gray'>";
						var temp=1;
						for(var i=0;i<psplit.length;i++)
						{
						  txt+="<li><input type='checkbox' name='checkbox' value='"+psplit[psplit.length-temp]+"' id='ck"+psplit[psplit.length-temp].split('@@')[0]+"'/> <a href='"+psplit[psplit.length-temp].split('@@')[2]+"' target='_black' ";
						 	var subtxt=psplit[psplit.length-temp].split('@@')[1];
		  				txt+="title='"+subtxt+"'>";
		  				subtxt=getInterceptedStr(subtxt,20);
		  				txt+=subtxt;
		  				txt+="</a></li>";
						  temp++;
						} 
						txt+="</ul>";
						txt+="<ul class='operate'><input type='button' value='���' class='btn1' onclick='recentProduct_clearCookie(1)'/></ul></div>";
						//alert(txt);
						//alert(document.getElementById('ck'));
						document.getElementById('ck').innerHTML=txt;
				}
				else
				{
				 		document.getElementById('ck').innerHTML="";
				}
		} 
}
//-------------js/cookies2.js--------------------------
//��������ؼ����������
function submitCookies(tp,kwords,kurl) //type=1 �����Ʒ type=2 ����˾ type=3������
{
   	var type=tp; //����
   	var kWords=kwords; //�ؼ���
   	var kUrl=kurl; //��Դ
   	var nkC=type+'@@'+kWords+'@@'+kUrl;
   	var oldCookie=getCookie('searchKW');
   	if(oldCookie!=null)
   	{
	  		if(oldCookie.indexOf(nkC)==-1)
	   		{
		  			var nkCookie=oldCookie+'#'+type+'@@'+kWords+'@@'+kUrl;
		   			SetCookie('searchKW',nkCookie);
	   		}
   	}
		else
		{
				var nkCookie=type+'@@'+kWords+'@@'+kUrl;
	 			SetCookie('searchKW',nkCookie);
		} 
}
//��������ؼ�����ͳ��
function getCount_Num_kw()
{
		var checkArr=new Array();
		if(document.all)
		{
				//�� document.all.kwForm �滻Ϊ document.getElementById('kw')
  			for(i=0,j=0;i<document.getElementById('kw').all.tags("INPUT").length;i++)
  			{
		 				if(document.getElementById('kw').all.tags("INPUT")[i].type=="checkbox"&&document.getElementById('kw').all.tags("INPUT")[i].checked==true)
						{
		  					checkArr[j++]=document.getElementById('kw').all.tags("INPUT")[i].id;
		 				}
  			}
  	}
  	else
		{
  			for(i=0,j=0;i<document.forms['kwForm'].length;i++)
  			{
		 				if(document.forms['kwForm'][i].type=="checkbox"&&document.forms['kwForm'][i].checked==true)
						{ 
		  					checkArr[j++]=document.forms['kwForm'][i].id;
		 				}
  			}
 		}
 		//alert(checkArr.length);
  	return checkArr;
}

//��������ؼ������
function actionCookies(tag)
{
		if(getCount_Num_kw()!=0)
		{
		  	if(tag==1)
		  	{
		  			//alert(getCount_Num_kw().length);
		 				//delCookie('searchKW')
		  	 		var Pcookie=getCookie('searchKW');
						var rp;
		  			var newPcookie2;
						var Pcookie;

		  			//alert(Pcookie);
		  			for(var i=0;i<getCount_Num_kw().length;i++)
		  			{
								//alert(getCount_Num_kw()[i].substring(2,getCount_Num_kw()[i].length));
								//alert(document.getElementById(getCount_Num_kw()[i]).value);
								rp=document.getElementById(getCount_Num_kw()[i]).value;
								newPcookie2=Pcookie.replace('#'+rp,'').replace(rp+'#','').replace(rp,'');
								Pcookie=newPcookie2;
		  			}
		  			//alert(Pcookie);

		  			if(Pcookie!=null||Pcookie!='')
		  			{
								SetCookie('searchKW',Pcookie);
								viewCookie();
		  			}
		  			else
		  			{
								delCookie('searchKW');//ȫ�����
								viewCookie();
		  			}
		  	}
		  	else if(tag==2)//����
		  	{
						if(getCount_Num_kw().length==1)
				 		{
				 				var cvalue=document.getElementById(getCount_Num_kw()[0]).value;
								//alert(cvalue);
								SetCookie('searchKW',cvalue);
								viewCookie();
				 		}
				 		else
				 		{  
								var newcookie='';
								for(var i=0;i<getCount_Num_kw().length;i++)
								{  
						  			var cvalue=document.getElementById(getCount_Num_kw()[i]).value;
						  			newcookie+=cvalue+'#';
								}
								//alert(newcookie.substring(0,newcookie.length-1));
								SetCookie('searchKW',newcookie.substring(0,newcookie.length-1));
								viewCookie();
				 		}
				}
		}
		else
		{}
}
//��������ؼ��� cookies  ��Ʒ ��˾  �� 
function viewCookie()
{
  var k_words=getCookie('searchKW');
  if(k_words==null||k_words=='')
  {
		document.getElementById('kw').innerHTML='';
  }
  else
  {
	  var k_split=k_words.split("#");
	  if(k_split.length>6)
	  {
				var txt="<div id='rightContent'><ul class='title'>��������ؼ���</ul>";
	  		txt+="<ul class='content gray'>";
		 		var temp=1;
	   		for(var i=0;i<=5;i++)
	   		{
			  txt+="<li><input type='checkbox' name='checkbox' value='"+k_split[k_split.length-temp]+"' id='kw"+i+"'/> <a href='"+k_split[k_split.length-temp].split('@@')[2]+"?q="+k_split[k_split.length-temp].split('@@')[1]+"' target='_black' ";
			  var subtxt=k_split[k_split.length-temp].split('@@')[1];
			  txt+="title='"+subtxt+"'>";
			  subtxt+="</a> ["+k_split[k_split.length-temp].split('@@')[0]+"]";
			  subtxt=getInterceptedStr(subtxt,20);
			  txt+=subtxt;
			  txt+="</li>";
		  		temp++;
	   		}
				txt+="</ul>";
				txt+="<ul class='operate'><input type='button' value='���' class='btn1' onclick='actionCookies(1)'/></ul></div>";
	   		document.getElementById('kw').innerHTML=txt;
		}
		else if(k_split.length>0)
		{
	   		var txt="<div id='rightContent'><ul class='title'>��������ؼ���</ul>";
	  	txt+="<ul class='content gray'>";
	  	var temp=1;
	   		for(var i=0;i<k_split.length;i++)
	   		{
			  txt+="<li><input type='checkbox' name='checkbox' value='"+k_split[k_split.length-temp]+"' id='kw"+i+"'/> <a href='"+k_split[k_split.length-temp].split('@@')[2]+"?q="+k_split[k_split.length-temp].split('@@')[1]+"' target='_black' ";
			  var subtxt=k_split[k_split.length-temp].split('@@')[1];
			  txt+="title='"+subtxt+"'>";
			  subtxt+="</a> ["+k_split[k_split.length-temp].split('@@')[0]+"]";
			  subtxt=getInterceptedStr(subtxt,20);
			  txt+=subtxt;
			  txt+="</li>";
		  		temp++;
	   		}
				txt+="</ul>";
				txt+="<ul class='operate'><input type='button' value='���' class='btn1' onclick='actionCookies(1)'/></ul></div>";
				//alert(txt);
				//alert(document.getElementById('kw'));
	   		document.getElementById('kw').innerHTML=txt;
		}
		else
		{
			document.getElementById('kw').innerHTML="";
		}
  }
}

//-------------js/cookieutil.js--------------------------


//����������һ����cookie�����ӣ�һ����ֵ
function SetCookie(name,value)
{
	var Days = 30; //�� cookie �������� 30 ��
	var exp  = new Date();	//new Date("December 31, 9998");
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+escape (value)+";expires=" + exp.toGMTString();//path=/;domain=.makepolo.com;
}
//ȡcookies����
function getCookie(name)		
{
	var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
	if(arr != null)
			return unescape(arr[2]);
	return null;
}
//ɾ��cookie
function delCookie(name)
{
		var exp = new Date();
		Exp.setTime(exp.getTime() - 1);
		var cval=getCookie(name);
		if(cval!=null)
  	 		document.cookie= name + "="+cval+";expires=" + exp.toGMTString();//path=/;domain=.makepolo.com;
}

//-------------js/ajax.js--------------------------

/**
*Ajax
*/
function Ajax()
{
this.getClassName=function(){return "Ajax";}
this._XMLHttpReq=this._createXMLHttpRequest();
}

  
Ajax.prototype._ExecuseResponseFunc=null;
Ajax.prototype.url=null;
Ajax.prototype.parameters=null;
Ajax.prototype._XMLHttpReq=null;
Ajax.prototype.isWorking=false;


/**
*����response�������쳣���򷵻�null
*/
Ajax.prototype.getResponse=function(){

if(this._XMLHttpReq!=null&&this._XMLHttpReq.readyState == 4&&this._XMLHttpReq.status == 200)
   {
	 return this._XMLHttpReq.responseText;
   }
else{
   return null;
  }
}
   



/**
* �ж������������XMLHttpRequest����
*/
Ajax.prototype._createXMLHttpRequest=function()
{

  if(this._XMLHttpReq==null)
  {
   try{
	  if(window.XMLHttpRequest)
	   {
	  // ֱ��ʹ��XMLHttpRequest����������XMLHttpRequest����
	  this._XMLHttpReq = new XMLHttpRequest();
		}
		 // ����IE�����
	 else if (window.ActiveXObject)
	 {
	  try
	  {
		 // ʹ��AcitveXObject�������������
		 this._XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
	  }
	  catch (e)
	  {
		 // ��������쳣���ٴγ��������·�ʽ����_XMLHttpRequest����
		 try
		 {
			this._XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 catch (e)
		 {
		 }
	  }
   }
   }
   catch(e){_throwErr("_createXMLHttpRequest():","���ܴ���XMLHttpRequest����"); }
   }
   
   return this._XMLHttpReq;
}


/**
*@parameters:{parameterName:parameterValue,parameterName:parameterValue},
			   ����Ϊ�����ַ��������磺key1=***&key2=***
*Get����ʱ������Ѿ�ƴ����url�У����null
*/
Ajax.prototype._sendRequest=function(method, url, parameters, execuseResponseFunction)
{
if(!this.isWorking){
try{
   this.isWorking=true;
   this.url=url;
   this._ExecuseResponseFunc=execuseResponseFunction;
   var _ajaxObj=this;
   var paramString="";
   if(parameters!=null&&typeof(parameters)!="string")
   {   
	for(var param in parameters)
	{
	 paramString=paramString+(paramString=="" ? '' : '&')+param+'='+(parameters[param]==null ? "":parameters[param]);
	}
   }
   else
   {
   paramString=(parameters==null?"":parameters);
   }
   paramString=paramString+(paramString=="" ? '' : '&')+'mrtype=1';//�������mrtype=1
   this.parameters=paramString;
   if(method.toLowerCase() == "post")
   {
	  this._XMLHttpReq.open(method, url, true);
	  this._XMLHttpReq.onreadystatechange = function(){_ajaxObj._execuseResponse();}
	  this._XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	  this._XMLHttpReq.send(paramString);
	 
   }
   else
   {
	 paramString!="" ? (url += (url.match(/\?/) ? '&' : '?') + paramString):"";
	 this._XMLHttpReq.open(method, url, true);
	 this._XMLHttpReq.onreadystatechange = function(){_ajaxObj._execuseResponse();}
	 this._XMLHttpReq.send(paramString);
	  }
	}catch(e)
	{
	 alert(e.message);
	}
	finally{ }
   }
}


/**
*���ûص��������ص������޲���
*/
Ajax.prototype._execuseResponse=function()
{
		if (this._XMLHttpReq.readyState == 4)
		{
			 	this.isWorking=false;  
		   	// �ж϶���״̬
		   	if (this._XMLHttpReq.status == 200&&this._ExecuseResponseFunc!=null)
		   	{
			 	 		// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			 			this._ExecuseResponseFunc(this._XMLHttpReq.responseText);
		   	}
		   	else
		   	{
		   			_throwErr("_execuseResponse()","���������ؽ���쳣!����url�ͷ�������");
		   	}
		}
}

/**
*����get����,�ص��������Է���getResponse()
*@param:url ��������ĵ�ַ
*@param:parameters ��������Ĳ���map:{parameterName,parameterValue,parameterName,parameterValue,...}
					  ����Ϊ�����ַ��������磺key1=***&key2=***
*@param:execuseResponseFunc �ص�����
*/
Ajax.prototype.sendGetRequest=function(url,paramters,execuseResponseFunc)
{
this._sendRequest("get", url, paramters, execuseResponseFunc);
}


/**
*����post����,�ص��������Է���getResponse()
*@param:url ��������ĵ�ַ
*@param:parameters ��������Ĳ���map:{parameterName,parameterValue,parameterName,parameterValue,...}
					  ����Ϊ�����ַ��������磺key1=***&key2=***
*@param:execuseResponseFunc �ص�����
*/
Ajax.prototype.sendPostRequest=function(url, parameters, execuseResponseFunc)
{
this._sendRequest("post", url, parameters, execuseResponseFunc);
}

Ajax.prototype.toString=function()
{
 return "[parameters of Ajax:"+this.parameters+",url of Ajax:"+this.url+",xmlHttpRequest of Ajax:"
		+this._XMLHttpReq+",response:"+this.getResponse()+"]";
}

//-------------js/proxy.js--------------------------

	function proxyKeyword(obj){
		var proxy =  window.frames['proxy'];
		proxy.postKeywords(obj);
	}
	
	function proxyCompareProd(boxname){
		var proxy =  window.frames['proxy'];
		proxy.compareProd(boxname);
	}

//-------------js/adv.js--------------------------

function viewAdByKeyword1(keyword, site, divname){
	keyword = encodeURI(keyword);
  var url = "http://bid.b2b.makepolo.com/b2b/mps/my/screen/adinfo,adview.html?func=1&keyword=" + keyword + "&site=" + site;
	var obj = document.createElement( "script" );
	obj.type = "text/javascript";
	obj.setAttribute("src" , url);
	document.getElementById(divname).appendChild(obj);
	if(document.all){ //ie�����
		obj.onreadystatechange = function(){//IE?
			var state = obj.readyState;
			if (state == "loaded" || state == "interactive" || state == "complete") {
				if(adx1!=''){
					document.getElementById(divname).innerHTML = adx1;  
				}
			}
		};
	}
	else{  //��������
		var js_obj = document.createElement( "script" );
		js_obj.type = "text/javascript";
		js_obj.setAttribute( "src" , url);
		document.body.appendChild(js_obj);
		js_obj.onload=function(){
			if(adx1!=''){
				document.getElementById(divname).innerHTML = adx1;
			}
		};
	}
}
 
function viewAdByKeyword2(keyword, site, divname){
	keyword = encodeURI(keyword);
  var url = "http://bid.b2b.makepolo.com/b2b/mps/my/screen/adinfo,adview.html?func=2&keyword=" + keyword + "&site=" + site;
	var obj = document.createElement( "script" );
	obj.type = "text/javascript";
	obj.setAttribute("src" , url);
	document.getElementById(divname).appendChild(obj);
	if(document.all){ //ie�����
		obj.onreadystatechange = function(){//IE?
			var state = obj.readyState;
			if (state == "loaded" || state == "interactive" || state == "complete") {
				if(adx2!=''){
					document.getElementById(divname).innerHTML = adx2;  
				}
			}
		};
	}
	else{  //��������
		var js_obj = document.createElement( "script" );
		js_obj.type = "text/javascript";
		js_obj.setAttribute( "src" , url);
		document.body.appendChild(js_obj);
		js_obj.onload=function(){
			if(adx2!=''){
				document.getElementById(divname).innerHTML = adx2;
			}
		};
	}
}
 
function viewAdByCategoryid1(categoryid, site, divname){
  var url = "http://bid.b2b.makepolo.com/b2b/mps/my/screen/adinfo,adview.html?func=1&categoryid=" + categoryid + "&site=" + site;
	var obj = document.createElement( "script" );
	obj.type = "text/javascript";
	obj.setAttribute("src" , url);
	document.getElementById(divname).appendChild(obj);
	if(document.all){ //ie�����
		obj.onreadystatechange = function(){//IE?
			var state = obj.readyState;
			if (state == "loaded" || state == "interactive" || state == "complete") {
				if(adx1!=''){
					document.getElementById(divname).innerHTML = adx1;  
				}
			}
		};
	}
	else{  //��������
		var js_obj = document.createElement( "script" );
		js_obj.type = "text/javascript";
		js_obj.setAttribute( "src" , url);
		document.body.appendChild(js_obj);
		js_obj.onload=function(){
			if(adx1!=''){
				document.getElementById(divname).innerHTML = adx1;
			}
		};
	}
}
 
function viewAdByCategoryid2(categoryid, site, divname){
  var url = "http://bid.b2b.makepolo.com/b2b/mps/my/screen/adinfo,adview.html?func=2&categoryid=" + categoryid + "&site=" + site;
	var obj = document.createElement( "script" );
	obj.type = "text/javascript";
	obj.setAttribute("src" , url);
	document.getElementById(divname).appendChild(obj);
	if(document.all){ //ie�����
		obj.onreadystatechange = function(){//IE?
			var state = obj.readyState;
			if (state == "loaded" || state == "interactive" || state == "complete") {
				if(adx2!=''){
					document.getElementById(divname).innerHTML = adx2;  
				}
			}
		};
	}
	else{  //��������
		var js_obj = document.createElement( "script" );
		js_obj.type = "text/javascript";
		js_obj.setAttribute( "src" , url);
		document.body.appendChild(js_obj);
		js_obj.onload=function(){
			if(adx2!=''){
				document.getElementById(divname).innerHTML = adx2;
			}
		};
	}
}

//-------------js/compare.js--------------------------

  defaultClassName = "plistk";
  checkedClassName = "plistk1";
  defaultClassName1 = "picBlock";
  checkedClassName1 = "picBlock1";
function getOfferProductIdCount()
{
   if(document.all)//ie mf
   {
		var   checkArr=new   Array()  
		var	   m=document.getElementById("batchForm");
   for(i=0,j=0;i<document.getElementById("batchForm").all.tags("INPUT").length;i++)
  {
	 if(document.getElementById("batchForm").all.tags("INPUT")[i].type=="checkbox"&&document.getElementById("batchForm").all.tags("INPUT")[i].checked==true)
	{ 
	  checkArr[j++]=document.getElementById("batchForm").all.tags("INPUT")[i].id  
	 }
  }
   }else
   {
	 
	 
  var   checkArr=new   Array()  
  for(i=0,j=0;i<document.getElementById("batchForm").length;i++)
  {
	 if(document.getElementById("batchForm")[i].type=="checkbox"&&document.getElementById("batchForm")[i].checked==true)
	{ 
	  checkArr[j++]=document.getElementById("batchForm")[i].id  
	 }
  }
   
   
   }


  return checkArr.length;
}

function clickcompareBox(id, box) 
{
  if(box.checked)
	{	
		 if(getOfferProductIdCount()>6)
	   {
			alert('���Ѿ�ѡ����6����Ϣ����ѡ��Ϣ���ܳ���6��');
			box.checked=false;
		 }
		 else
		 {
				var countId = box.id.substring("compareBox".length,box.id.length);
				if(countId <= 0)
				{
		 		return;
				}
	 			var trTag = document.getElementById("compareColor"+countId);
	 			trTag.className=checkedClassName;
		 }
	}
	else
	{
		var countId = box.id.substring("compareBox".length,box.id.length);
	if(countId <= 0)
	  {
		return;
	}
	var trTag = document.getElementById("compareColor"+countId);
	trTag.className=defaultClassName;
	}
}

function clickcompareBox1(id,box) 
{
  if(box.checked)
	{	
		 if(getOfferProductIdCount()>6)
	   {
			alert('���Ѿ�ѡ����6����Ϣ����ѡ��Ϣ���ܳ���6��');
			box.checked=false;
		 }
		 else
		 {
				var countId = box.id.substring("compareBox".length,box.id.length);
				if(countId <= 0)
				{
		 		return;
	 		}
	 			var trTag = document.getElementById("compareColor"+countId);
	 			trTag.className=checkedClassName1;
		 }
	}
	else
	{
		var countId = box.id.substring("compareBox".length,box.id.length);
	if(countId <= 0)
	  {
		return;
	}
	var trTag = document.getElementById("compareColor"+countId);
	trTag.className=defaultClassName1;
	}
}  
  
  //��Ʒ�Ա�
  function actCheckbox(sign){
  if(keywords == ""){
   keywords = "��Ʒ";
 }
  var count = 0;
  var ids = "";
 // alert('document.getElementById("batchForm").elements='+document.getElementById("batchForm").elements);
 // alert('document.getElementById("batchForm").elements='+document.forms["batchForm"].elements[0].value);
  var obj = document.getElementById("batchForm").elements;
 // var obj = document.getElementById("batchForm").elements;
   
  for(var i = 0;i < obj.length;i++){
	if(obj[i].id.indexOf('compareBox') != -1){
	  if(obj[i].checked){
		count++;
		if(ids == ""){
		 // ids = obj[i].name;
		   ids=obj[i].value;
		}else{
		  //ids = ids + ","+obj[i].name;
		  ids = ids + ","+obj[i].value;
		}
	  }
	}
  } 
  if(count <= 1){
	alert("������ѡ��2����Ϣ���жԱ�!");
	return false;
  }else if(count > 6){
	alert("���Ѿ�ѡ����"+count+"����Ϣ,��ѡ��Ϣ���ܳ���6��");
	return false;
  }
  var url = "";
  if(sign == "inc"){
   // url = "http://my.b2b.makepolo.com/yellow/product/product_contrast.php?pIds=("+ids+")";
   document.getElementById("batchForm").action="http://my.b2b.makepolo.com/yellow/product/product_contrast.php?keyword="+keywords+"&pIds="+ids;
   document.getElementById("batchForm").target="_blank";
   document.getElementById("batchForm").method="post";
   document.getElementById("batchForm").submit();
   proxyCompareProd('comId');
  }
  //window.open(url);
  
}
//��Ʒҳ��˾�Ա�
  function comCheckbox(sign){
  
  if(keywords == ""){
   keywords = "��ҵ";
 }
  var count = 0;
  var ids = "";
  var obj = document.getElementById("batchForm").elements;
 // var obj = document.getElementById("batchForm").elements;
   
  for(var i = 0;i < obj.length;i++){
	if(obj[i].id.indexOf('compareBox') != -1){
	  if(obj[i].checked){
		count++;
		if(ids == ""){
		 // ids = obj[i].name;
		   ids=obj[i].com;
		}else{
		  //ids = ids + ","+obj[i].name;
		  ids = ids + ","+obj[i].com;
		}
	  }
	}
  }
  if(count <= 1){
	alert("������ѡ��2����Ϣ���жԱ�!");
	return false;
  }else if(count > 6){
	alert("���Ѿ�ѡ����"+count+"����Ϣ,��ѡ��Ϣ���ܳ���6��");
	return false;
  }
  var url = "";

  if(sign == "np")//��˾�Ա�
  {
   // url = "http://my.b2b.makepolo.com/yellow/product/product_contrast.php?pIds=("+ids+")";
//document.getElementById("batchForm").action="http://my.b2b.makepolo.com/yellow/corp/corp_contrast.php?corpIds="+ids;

   window.open("http://my.b2b.makepolo.com/yellow/corp/corp_contrast.php?keyword="+keywords+"&corpIds="+ids)
   //document.getElementById("batchForm").target="_blank";
   //document.getElementById("batchForm").method="post";
   //document.getElementById("batchForm").submit();
  }
  //window.open(url);
	proxyCompareProd('comId');
}
//��˾�Ա�
  function comCheckbox_company(sign){
  
  if(keywords == ""){
   keywords = "��ҵ";
 }
  var count = 0;
  var ids = "";
  var obj = document.batchForm.elements;
  for(var i = 0;i < obj.length;i++){
	if(obj[i].id.indexOf('compareBox') != -1){
	  if(obj[i].checked){
		count++;
		if(ids == ""){
		  //ids = obj[i].name;
		  ids = obj[i].value;
		}else{
		//ids = ids + ","+obj[i].name;
		  ids = ids + ","+obj[i].value;
		}
	  }
	}
  }
  if(count <= 1){
	alert("������ѡ��2����Ϣ���жԱ�!");
	return false;
  }else if(count > 6){
	alert("���Ѿ�ѡ����"+count+"����Ϣ,��ѡ��Ϣ���ܳ���6��");
	return false;
  }
  var url = "";

  if(sign == "np")//��˾�Ա�
  {
   // url = "http://my.b2b.makepolo.com/yellow/product/product_contrast.php?pIds=("+ids+")";
//document.getElementById("batchForm").action="http://my.b2b.makepolo.com/yellow/corp/corp_contrast.php?corpIds="+ids;

   window.open("http://my.b2b.makepolo.com/yellow/corp/corp_contrast.php?keyword="+keywords+"&corpIds="+ids)
   //document.getElementById("batchForm").target="_blank";
   //document.getElementById("batchForm").method="post";
   //document.getElementById("batchForm").submit();
  }
  //window.open(url);
	proxyCompareProd('comId');
}
///����ѯ��

  function askCheckbox(sign){
  // if(keywords == ""){
  //  keywords = "%C9%CC%D2%B5%BB%FA%BB%E1";
 // }
  var count = 0;
  var ids = "";
  var obj = document.getElementById("batchForm").elements;
  for(var i = 0;i < obj.length;i++){
	if(obj[i].id.indexOf('compareBox') != -1){
	  if(obj[i].checked){
		count++;
		if(ids == ""){
		  //ids = obj[i].name;
		  ids=obj[i].value;
		}else{
		  //ids = ids + ","+obj[i].name;
		  ids = ids + ","+obj[i].value;
		}
	  }
	}
  } 
  if(count <= 0){
	alert("������ѡ��1����Ϣ����ѯ��!");
	return false;
  }else if(count > 6){
	alert("���Ѿ�ѡ����"+count+"����Ϣ,��ѡ��Ϣ���ܳ���6��");
	return false;
  }
  var url = "";
  if(sign == "inc"){
   // url = "http://my.b2b.makepolo.com/yellow/product/product_contrast.php?pIds=("+ids+")";
   document.getElementById("batchForm").action="http://my.b2b.makepolo.com/yellow/msg/more_inquiry.php?type=2&id="+ids;
   document.getElementById("batchForm").target="_blank";
   document.getElementById("batchForm").method="post";
   document.getElementById("batchForm").submit();
   proxyCompareProd('comId');
  }
  //window.open(url);
}

  //���ѡ��
  function ClearAllChecked()
  {
  	var obj = document.getElementById("batchForm").elements;
  	for(var i = 0;i < obj.length;i++)
  	{
		if(obj[i].id.indexOf('compareBox') != -1)
		{
	  	if(obj[i].checked)
	  	{
	  		var countId = obj[i].id.substring("compareBox".length,obj[i].id.length);
					obj[i].checked = false;
					var trTag = document.getElementById("compareColor"+countId);
	 			trTag.className=defaultClassName;
	  	}
		}
  	} 
  	ids="";
  	checkBox.hiddenFlaotDiv();
	}




function set(str)
{
  if(str==1)
  {
	document.getElementById("jian").style.display="none";
	document.getElementById("full").style.display="";
  }
	if(str==2)
  {
	document.getElementById("jian").style.display="";
	document.getElementById("full").style.display="none";
  }
}

// JavaScript Document
 var xmlHttp;
 var oldhtml;
 var PName;
 var classid;
 var PNamelist="";

function GetXmlHttpObject() 
{ 
var objXMLHttp=null
if (window.XMLHttpRequest)
  {
  objXMLHttp=new XMLHttpRequest()
  }
else if (window.ActiveXObject)
  {
  objXMLHttp=new ActiveXObject("Microsoft.XMLHTTP")
  }
return objXMLHttp
} 
/////////////////////////////////////
  function activeOP(str,className,property)
  { 
  PName=className;
  classid=str;
  //alert(property);
	var keyword=' ';
	
	var url;
   
url="/s/servlet/SelectChildByClassId?keyword="+keyword+"&id="+str+"&property="+property;
	

	
  // alert(url);
  xmlHttp=GetXmlHttpObject()
  if (xmlHttp==null)
  {
  alert ("�������֧�����ǵ�Ajax")
  return
  } 
   xmlHttp.onreadystatechange=stateOK;
   xmlHttp.open("post",url,true);	   
 
//alert(xmlHttp);
 
  
 // alert(document.getElementById("parameter_foot").innerHTML);
  
  xmlHttp.send(null)
  }
/////////////////////
  function stateOK() 
{ 
if(xmlHttp.readyState == 4) 
   {
	  if(xmlHttp.status == 200) 
	 {
	  oldhtml=document.getElementById("parameter_foot").innerHTML;
	  
	  var childtext="<form  onsubmit='return checkparForm();' method='get' action='http://search.makepolo.com/s/sp.html?q= &class="+classid+"' name='parForm'><input type='hidden' name='flag' value='1'/><input type='hidden' name='cn' value='"+PName+"'/><div class='parameter_foot_top'><div class='parameter_foot_top_left'><img src='http://jic.b2b.makepolo.com/caigou/images/list_01.gif' width='6' height='10' /></div><div class='parameter_foot_top_right'><strong>������ɸѡ</strong>��<font color='#FF0000'>"+PName+"</font>��<a href='javascript:goback();'>���ط���ɸѡ����</a></div></div><div class='parameter_foot_top'><div class='parameter_foot_top_left'><img src='http://jic.b2b.makepolo.com/caigou/images/list_01.gif' width='6' height='10' /></div><div class='parameter_foot_top_right'><strong>�鿴��Ʒ����</strong> ������ѡ��4��������</div></div><div class='parameter_foot_content'>"
	  document.getElementById("parameter_foot").innerHTML=childtext+xmlHttp.responseText+"<li><input type='image' width='85' height='21'   src='http://jic.b2b.makepolo.com/caigou/images/a_6.gif' value='' title='�ύ��������'/></li></div></form>";
	 
	 }
	}
} 


  /////////////////////////////////////
  function goback()
  { 

  //alert(className);
	var keyword=' ';
	var url="/s/servlet/SelectCategoryByProduct?keyword="+keyword;
   //alert(url);
  xmlHttp=GetXmlHttpObject()
  if (xmlHttp==null)
  {
  alert ("�������֧�����ǵ�Ajax")
  return
  }
   xmlHttp.onreadystatechange=stateCate;
   xmlHttp.open("post",url,true);	   
   xmlHttp.send(null)
  }
function stateCate() 
{ 
if(xmlHttp.readyState == 4) 
   {
	  if(xmlHttp.status == 200) 
	 {
		 document.getElementById("parameter_foot").innerHTML=xmlHttp.responseText;
	 }
	}
} 
function checkparForm()
{
	if(getclickBoxCount()==0)
	{
			   alert('��ѡ��������ύ!');
			  return false;
	}
	PNamelist="";
	for(i=0,j=0;i<document.all.parForm.all.tags("INPUT").length;i++)
  {
	 if(document.all.parForm.all.tags("INPUT")[i].type=="checkbox"&&document.all.parForm.all.tags("INPUT")[i].checked==true)
	{ 
	  PNamelist=PNamelist+document.all.parForm.all.tags("INPUT")[i].value+"```";
	 }
  }
	document.all.parForm.all.pnl.value=PNamelist;
	return true;
}

function clickBox(id,box)
{
	//alert("checkbox id:"+box.id);
  if(box.checked)
  {
	if(getclickBoxCount()>4)
		{
				   alert('���Ѿ�ѡ����4����Ϣ����ѡ��Ϣ���ܳ���4��');
				   box.checked=false;
		}
  }
}
function four_attr()
{
	alert('ɸѡ��������4��������ͨ��ȥ��һ����ɸѡ�������ٽ�����һ����ɸѡ');
}

function getclickBoxCount()
{
   if(document.all)
   {
	  var   checkArr=new   Array()  
  for(i=0,j=0;i<document.all.parForm.all.tags("INPUT").length;i++)
  {
	 if(document.all.parForm.all.tags("INPUT")[i].type=="checkbox"&&document.all.parForm.all.tags("INPUT")[i].checked==true)
	{ 
	  checkArr[j++]=document.all.parForm.all.tags("INPUT")[i].id;
	 }
  }
   
   }else
   {
	  var   checkArr=new   Array()  
  for(i=0,j=0;i<document.forms['parForm'].length;i++)
  {
	 if(document.forms['parForm'][i].type=="checkbox"&&document.forms['parForm'][i].checked==true)
	{ 
	  checkArr[j++]=document.forms['parForm'][i].id  
	 }
  }
   
   }

	return checkArr.length;
}
function setBox(str)
{
 var boxid="Box"+str;
 //alert("id:"+boxid);
 if(document.getElementById(boxid).checked==false)
 {
   document.getElementById(boxid).checked=true;
	 if(getclickBoxCount()>4)
   {
   	 alert('���Ѿ�ѡ����4����Ϣ����ѡ��Ϣ���ܳ���4��');
	 document.getElementById(boxid).checked=false;
	}
 }else
 {
 document.getElementById(boxid).checked=false;
 }

}

function copMessage(sign){
 var keywords = '{{Q}}';
 // if(keywords == ""){
  //  keywords = "%C9%CC%D2%B5%BB%FA%BB%E1";
 // }
  var count = 0;
  var ids = "";
  var obj = document.batchForm.elements;
  for(var i = 0;i < obj.length;i++){
	if(obj[i].id.indexOf('compareBox') != -1){
	  if(obj[i].checked){
		count++;
		if(ids == ""){
		  //ids = obj[i].name;
		  ids = obj[i].value;
		}else{
		//ids = ids + ","+obj[i].name;
		  ids = ids + ","+obj[i].value;
		}
	  }
	}
  }
  if(count <= 0){
	alert("������ѡ��1����ҵ��������!");
	return false;
  }else if(count > 6){
	alert("���Ѿ�ѡ����"+count+"����ҵ,��ѡ��Ϣ���ܳ���6�ң�");
	return false;
  }
  var url = "";
  if(sign == "inc"){
   // url = "http://my.b2b.makepolo.com/yellow/product/product_contrast.php?pIds=("+ids+")";
   //http://my.b2b.makepolo.com/b2b/mps/my/screen/myfolder,message,message_online.html?receiver_corpid
//http://my.b2b.makepolo.com/b2b/mps/my/screen/myfolder,message,message_online.html?keyword="+keywords

   document.batchForm.action="#";
   document.batchForm.target="_blank";
   document.batchForm.method="post";
   document.batchForm.submit();
   proxyCompareProd('comId');
  }
  //window.open(url);
}

//���������q�ļ�⣬spORscORsq=1��2��3������Ʒ����ҵ���󹺡�
var def="�����������ؼ���";
function searchWordInput_check(int_spORscORsq)
{
	var kw=document.getElementById("q").value;
  if(kw==null||kw==""||kw==def)
  {
		document.getElementById("q").value=def;
		document.getElementById("q").focus();
   return false;
  }
  if( int_spORscORsq==2 )
  	submitCookies('��ҵ',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  else if( int_spORscORsq==3 )
  	submitCookies('��',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  else
  	submitCookies('��Ʒ',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  return true;
}
//���������qq�ļ�⣬spORscORsq=1��2��3������Ʒ����ҵ���󹺡�
function searchWordInput_check_qq(int_spORscORsq)
{
	var kw=document.getElementById("qq").value;
  if(kw==null||kw==""||kw==def)
  {
		document.getElementById("qq").value=def;
		document.getElementById("qq").focus();
   return false;
  }
  if( int_spORscORsq==2 )
  	submitCookies('��ҵ',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  else if( int_spORscORsq==3 )
  	submitCookies('��',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  else
  	submitCookies('��Ʒ',""+kw.replace(/<[^>]*>/g, "")+"",'#');
  return true;
}

//�������������
function searchWordInput_clearT(obj)
{
	if(obj.value==def)
	{
 		obj.value="";
	}
}
//���������ļ�����ʾ var def="�����������ؼ���"
function searchWordInput_add_default(obj)
{
	if(obj.value==''||obj.value==null)
	{
 		obj.value=def;
	}
}
