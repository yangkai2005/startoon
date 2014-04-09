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

    function setTabout(name,cursel,n){
   for(i=1;i<=n;i++){
   
    var con=document.getElementById("con_"+name+"_"+i);

    con.style.display=i==cursel?"none":"none";
   }
  }
  
  
    function setTab22(name,cursel,n){
   for(i=1;i<=n;i++){
    var menu=document.getElementById(name+i);
  
    menu.className=i==cursel?"tablist22":"tablist";

   }
  }
  
  function setTab22out(name,n){

    var menu=document.getElementById(name+n);
  
    menu.className="tablist";

  
  }
  
  
  
    function chkanTab(name,m){

    var menu=document.getElementById(name);
var con=document.getElementById(m);
    menu.className="chankan1";
	    con.style.display="none";
   

  }

    /*选择全部(checkbox)
     * obj1: 全选或全不选checkbox对象
     * obj2: 操作的复选框对象
     * */
    function CheckAll(obj1,obj2)
      {
    	for(var i=0;i<obj2.length;i++){
    		obj2[i].checked = obj1.checked;
    	}
      }
    
  //只能输入数字
    function isNumber(obj)
    {
       event.returnValue = false;
       if(event.keyCode==8 || event.keyCode==46 ||(event.keyCode>=35 && event.keyCode<=39)||(event.keyCode>=96 && event.keyCode<=105)||event.keyCode>=48 && event.keyCode<=57)
    	{
          event.returnValue=true;
    	}
    	else
    	{
    		if(event.keyCode==13)
    			{
    			go();
    			}else
    				{
    				 event.returnValue=false;
    				}

    	}
    }
    