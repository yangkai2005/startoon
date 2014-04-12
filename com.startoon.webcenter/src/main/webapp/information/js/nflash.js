function $(id) {return document.getElementById(id);}
function $$(tag,id){return (id==undefined?document:this.$(id)).getElementsByTagName(tag);}
function poptit(tsID,n){//˶
	var ts = $$('li',tsID);
	var setway=function(obj,y){obj.style.bottom=y+'px';}
	var getway=function(obj){return parseInt(obj.style.bottom);}
	var up=function(){
		if (ts[n].movement) clearTimeout(ts[n].movement);//Ϊ˼ݱ仯еĵ
		if (y1 == 0) return true;
		y1+=Math.ceil((0 - y1) / 5);
		setway(ts[n],y1);
		if(y1<0) ts[n].movement = setTimeout(up, 1);
	}
	var down=function(){
		if (ts[N].movement) clearTimeout(ts[N].movement);
		if (y2 == -32) return true;
		y2+=Math.floor((-32 - y2) / 5);
		setway(ts[N],y2);
		if(y2>-32) ts[N].movement = setTimeout(down, 1);
	}
	for(var i=0;i<ts.length;i++){
		if (!ts[i].style.bottom) ts[i].style.bottom = "-32px";
		if(ts[i].name=='up') var N=i;
	}
	if(!N&&n==0) {//ʼ...
		ts[n].name='up';
		var y1=getway(ts[n]);
		up();
		return true;
	} 
	if(N==n) return true;//ֹƳĶ
	ts[N].name=''//ǵnameΪ
	ts[n].name='up';
	var y1=getway(ts[n]);
	var y2=getway(ts[N]);
	down();
	up();
}
function opa(pics,n){//ͼƬ뵭
	var pics = $$('img',pics);
	var setfade=function(obj,o){
		if (document.all) obj.style.filter = "alpha(opacity=" + o + ")";
		else obj.style.opacity = (o / 100);
	};
	var getfade=function(obj){
		return (document.all)?((obj.filters.alpha.opacity)?obj.filters.alpha.opacity:false):((obj.style.opacity)?obj.style.opacity*100:false);
	}
	var show=function(){
		if(pics[n].move) clearTimeout(pics[n].move);
		if (o1 == 100) return true;
		o1+=5;
		setfade(pics[n],o1);
		if(o1<100) pics[n].move=setTimeout(show,1);
	};
	var hide=function(){
		if(pics[N].move) clearTimeout(pics[N].move);
		if (o2 == 0) return true;
		o2-=5;
		setfade(pics[N],o2);
		if(o2>0) pics[N].move=setTimeout(hide,1);
	};
	for(var i=0;i<pics.length;i++){
		if(!getfade(pics[i])) setfade(pics[i],0);
		if(pics[i].name=='out') var N=i;
	}
	if(!N&&n==0) {//ʼ...
		pics[n].name='out';
		var o1=getfade(pics[n]);
		show();
		return true;
	}
	if(N==n) return true;
	pics[N].name=''
	pics[n].name='out';
	var o1=getfade(pics[n]);
	var o2=getfade(pics[N]);
	hide();
	show();
}
function classNormal() {//ֱǩʽ
    var focusBtnList = $$('li','btn');
    for (var i = 0; i < focusBtnList.length; i++) {
        focusBtnList[i].className = '';
    }
}
function autoFocusChange() {//Զ
    if (atuokey) return;
    var focusBtnList = $$('li','btn');
    for (var i = 0; i < focusBtnList.length; i++) {
        if (focusBtnList[i].className == 'current') {
            var currentNum = i;
        }
    }
	if(currentNum<focusBtnList.length-1){
		poptit('ts',currentNum+1);
		opa('pics',currentNum+1);
       	classNormal();
       	focusBtnList[currentNum+1].className = 'current';
	}else if(currentNum==focusBtnList.length-1){
		poptit('ts',0);
		opa('pics',0);
       	classNormal();
       	focusBtnList[0].className = 'current';
	}
}
function focusChange() {//л
    var focusBtnList = $$('li','btn');
    for (var i = 0; i < focusBtnList.length; i++) {
		focusBtnList[i].I=i;
		focusBtnList[i].onclick = function(){
        	poptit('ts',this.I);
			opa('pics',this.I);
        	classNormal();
        	focusBtnList[this.I].className = 'current';
		}
		focusBtnList[i].onmouseover = function(){
			this.style.backgroundColor='#f60';
			this.style.cursor='pointer';
		}
		focusBtnList[i].onmouseout = function(){
			this.style.backgroundColor='';
		}
	}
}
var atuokey = '';
function init(){//ʼ
	$('btn_bg').innerHTML=$('btn').innerHTML;
	$('focus_change').removeChild($$('div','focus_change')[0]);
	poptit('ts',0);
	opa('pics',0);
    classNormal();
    $$('li','btn')[0].className = 'current';
	$('focus_change').onmouseover = function() {
        atuokey = true;
		clearInterval(auto);
    }
    $('focus_change').onmouseout = function() {
        atuokey = false;
		auto=setInterval('autoFocusChange()', T);
    }
}
var T=3000;//ÿ֡ͼƬͣʱ䣬1000=1
var auto='';
window.onload=function(){
	init();
	focusChange();
	auto=setInterval('autoFocusChange()', T);
}