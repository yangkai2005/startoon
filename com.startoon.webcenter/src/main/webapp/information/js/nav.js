// JavaScript Document


//<!CDATA[
function g(o){return document.getElementById(o);}
function HoverLi(n){
//如果有N个标签,就将i<=N;
//本功能非常OK,兼容IE7,FF,IE6;
	for(var i=1;i<=6;i++)
	{
		g('tb_'+i).className='normaltab';
		g('tbc_0'+i).className='undis';
		g('navImg_'+i).src='images/nav'+i+'.jpg';
	}
	g('tbc_0'+n).className='dis';
	g('tb_'+n).className='hovertab';
	g('navImg_'+n).src='images/navh'+n+'.jpg';
}
//如果要做成点击后再转到请将<li>中的onmouseover 改成 onclick;
//]]>

function HoverLiOut(n){
//如果有N个标签,就将i<=N;
//本功能非常OK,兼容IE7,FF,IE6;
	for(var i=1;i<=6;i++)
	{
		
		
		g('navImg_'+i).src='images/nav'+i+'.jpg';
	}

	g('navImg_'+n).src='images/navh'+n+'.jpg';
}



  function setTab(name,cursel,n){
   for(i=1;i<=n;i++){
    var menu=document.getElementById(name+i);
    var con=document.getElementById("con_"+name+"_"+i);
    menu.className=i==cursel?"hover":"";
    con.style.display=i==cursel?"block":"none";
   }
  }

    function setTabout(name,cursel){

  var menu=document.getElementById(name+cursel);
    menu.className="";
    var con=document.getElementById("con_"+name+"_"+cursel);

    con.style.display="none"; 
  }
  
  
function choose(tabMess,conMess,cursel,n){
	for(i=0;i<n;i++){
    g(tabMess+i).className=i==cursel?"lsve":"";
    g(conMess+i).style.display=i==cursel?"block":"none";
   }
}