// JavaScript Document

function $i(id){return document.getElementById(id);}

function simpleSideScroll(c,ul,config,direction){
    this.config = config ? config : {start_delay:3000, speed: 23, delay:3000, scrollItemCount:1};
	this.c = $i(c);
	this.ul = $i(ul);
	this.direction = direction ? direction : "left";
	this.pause = false;
	this.buttonlist= new Object();
	this.delayTimeId=null;
	
	var _this = this;



	this.c.onmouseover=function(){_this.pause = true;}
	this.c.onmouseout=function(){_this.pause = false;}
	
	this.init = function() {
		_this.scrollTimeId = null;
		setTimeout(_this.start,_this.config.start_delay);
	}
	
	this.start = function() {
		var d = _this.c;
		var width = d.getElementsByTagName('li')[0].offsetWidth;
		if(d.scrollWidth-d.offsetLeft>=width) _this.scrollTimeId = setInterval(_this.scroll,_this.config.speed)
	};
	
	this.scroll = function() {
		if(_this.pause)return;
		var ul= _this.ul;
		var d = _this.c;
		var width = d.getElementsByTagName('li')[0].offsetWidth;
		if(_this.direction == 'left'){
	        d.scrollLeft += 2;
	        if(d.scrollLeft%(width*_this.config.scrollItemCount)<=1){
		        if(_this.config.movecount != undefined)
			        for(var i=0;i<_this.config.movecount;i++){ul.appendChild(ul.getElementsByTagName('li')[0]);}
		        else for(var i=0;i<_this.config.scrollItemCount;i++){ul.appendChild(ul.getElementsByTagName('li')[0]);}
		        d.scrollLeft=0;
		        clearInterval(_this.scrollTimeId);
		        
		        _this.delayTimeId=setTimeout(_this.start,_this.config.delay);
	        }
		}
		else {
		    if(d.scrollLeft==0)
		    {
		        var lis=ul.getElementsByTagName('li');
		        for(var i=0;i<_this.config.scrollItemCount;i++){
		            ul.insertBefore(lis[lis.length-1],lis[0]);
		        }
		        d.scrollLeft = width;
		    }
		    d.scrollLeft -= 2;
		    if(d.scrollLeft%(width*_this.config.scrollItemCount)<=1){
		        d.scrollLeft=0;
		        clearInterval(_this.scrollTimeId);
		        _this.delayTimeId=setTimeout(_this.start,_this.config.delay);
		    }
		}
	}
	
	this.setButton=function(id,direction){
	    if($i(id)){
	        var c=$i(id);
	        var buttonlist =_this.buttonlist;
	        if(buttonlist[id] == undefined){
	            buttonlist[id] =new Object();
	            _this.buttonlist[id][0]=c;
	            _this.buttonlist[id][1]=direction;
	            
	            c.onclick=function(){
	                 clearInterval(_this.scrollTimeId);
	                 
	                var dir=_this.buttonlist[this.id][1];
	                var d = _this.c;
	                var ul= _this.ul;
	                d.scrollLeft=0;
	                if(dir =="left")
	                {
	                    for(var i=0;i<_this.config.scrollItemCount;i++){ul.appendChild(ul.getElementsByTagName('li')[0]);}
	                }
	                else{
	                    var lis=ul.getElementsByTagName('li');
		                for(var i=0;i<_this.config.scrollItemCount;i++){
		                    ul.insertBefore(lis[lis.length-1],lis[0]);
		                }
	                }
	                    
	                _this.direction= dir;
	                clearTimeout(_this.delayTimeId);
	                _this.delayTimeId=setTimeout(_this.start,_this.config.delay);
	                return false;
	            }
	        }
	    }
	}
}

var products_run;
function init_load(){
    if($i('products_scroll')){
	    products_run=new simpleSideScroll('products_scroll','products_scroll_ul',{start_delay:3000, speed: 23, delay:3000, scrollItemCount:1},'left')
	    products_run.setButton('products_scroll_left','left');
	    products_run.setButton('products_scroll_right','right');
	    products_run.init();
	}
}

if(window.attachEvent){
    window.attachEvent("onload",init_load);
}else if(window.addEventListener){
    window.addEventListener("load",init_load,false);
}

