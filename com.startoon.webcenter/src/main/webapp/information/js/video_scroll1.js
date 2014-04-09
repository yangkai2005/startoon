var Tweener = {
    easeNone: function(t, b, c, d) {
        return c*t/d + b;
    },
	easein: function(t, b, c, d) {
		return c*(t/=d)*t + b; 
	},
	easeinout: function(t, b, c, d) {
		if (t < d/2) return 2*c*t*t/(d*d) + b;
		var ts = t - d/2;
		return -2*c*ts*ts/(d*d) + 2*c*ts/d + c/2 + b;	
	}
};

function g( id ){
  return document.getElementById(id);
}
var list = g('videoList');
var imgs = list.getElementsByTagName('img');
var px = list.clientHeight/imgs.length;
var PLHeight = px*5;
var index = 1;   
var selected = 2;//定位
var run;
if(imgs.length>3){
	g('slideNext').onclick = function (){
	  Nrun();
	};
	
	g('slidePre').onclick = function (){
	  Prun();
	};
}

//上
	function Prun( runc ){
		var b = list.style.marginTop ? parseInt(list.style.marginTop) : 0;
		var c = typeof runc == 'number' ? runc : px ;
		var t=0,ttl=10,d =5;
		clearInterval(run);
		if(b)run = setInterval(function (){
					var top = Tweener.easeinout(t,b,c,d);
					if(top>=0){
					  list.style.marginTop  = '0px';
					  clearInterval(run);
					  return;
					}
					list.style.marginTop  = top+'px';
					if(t<d){
					  t++; 
					}else{
					  clearInterval(run);
					}
				},ttl)
	};
//下
	function Nrun( runc ){
		var b = list.style.marginTop ? -parseInt(list.style.marginTop) : 0;
		var c = typeof runc == 'number' ? runc : px ;
		var d = 5;
		var t=0,ttl=10;
		clearInterval(run);
		run = setInterval(function (){
					var top = Tweener.easeinout(t,b,c,d);
					if(top>=list.clientHeight-PLHeight){
					  list.style.marginTop  = -list.clientHeight+PLHeight+'px';
					  clearInterval(run);
					  return;
					}
					list.style.marginTop  = -top+'px';
					if(t<d){
					  t++; 
					}else{
					  clearInterval(run);
					}
				},ttl)
	};