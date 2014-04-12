function toggle(section)
  {
    object = document.getElementById(section);
    if (object.style.display=="none")
      object.style.display="block";
    else
      object.style.display="none";
  }

/* Used to Restrict the Length of TextAreas */
function sh_MaxLength(sh_field, sh_maximum)
{
  if (sh_field.value.length > sh_maximum + 1)
    alert('Your comment must contain fewer than ' + sh_maximum + ' characters.');
  if (sh_field.value.length > sh_maximum)
  {
    sh_field.value = sh_field.value.substring(0, sh_maximum);
  }
}

function sh_windowpopup(file, name, w, h){

	var xPos, yPos;
	var winProp;    

	xPos = (screen.width/2)-(w/2);
	yPos = (screen.height/2)-(h/2);

	winProp = "width=" + w + ",height=" + h + ",left=" + xPos + ",top=" + yPos +",resizable=1,scrollbars=1";     

	win = window.open(file, name, winProp); 
	win.focus();
}


function sh_ShowHide()
{
  groupname=arguments[0];
  rows=arguments[1];
  if(arguments.length > 2)
  {
    if (arguments[2]==1)
    {
      var currRow = document.getElementById(groupname);
  		currRow.style.display="";
  		
	
    }
    else if (arguments[2]==0)
    {
      var currRow = document.getElementById(groupname);
  		currRow.style.display="none";
  		
		
    }
  }
  else
  {
    if (rows == 0) 
    { /* for a single item */
      sh_RowShowHide(groupname);
  	}
    else
    { /* for multiple rows of a table */
      for(i=1; i <= rows; i++)
      {
        var tempRow = groupname + "" + i;
        sh_RowShowHide(tempRow);
      }
    }
  }
}


function sh_RowShowHide(sh_RowID) {
	var currRow = document.getElementById(sh_RowID);
	if (currRow.style.display=="none") {
		currRow.style.display="";
	
	
	} else {
		currRow.style.display="none";
		

	}	
}


function sh_financialsCompareNavigation(quarter1,quarter2,year1,year2,state,period)
{
  if(state==1) /* Current */
  {
    document.getElementById(quarter1).disabled=true;
    document.getElementById(year1).disabled=true;
    document.getElementById(quarter2).disabled=true;
    document.getElementById(year2).disabled=true;
  }
  else /* Compare */
  {
    if(period==1) /* Quarterly */
    {
      document.getElementById(quarter1).disabled=false;
      document.getElementById(quarter2).disabled=false;
    }
    document.getElementById(year1).disabled=false;
    document.getElementById(year2).disabled=false;
  }
}

// if "all ____ " is selected on alerts.cfm, select all alerts of that type.
function sh_selectAll(formName,listName,selectAllName,selectAllArray) 
{ 
  if(document.getElementById(selectAllName).checked == false)
  {
    if(document.getElementById(formName)) 
    { // form ID
      var counter = 0;
      for(i = 0; i < document.getElementById(formName).elements.length; i++) 
      {
        if(document.getElementById(formName).elements[i].name == listName) 
        {
          document.getElementById(formName).elements[i].checked = false;
          selectAllArray[counter] = false;
          counter++;
        }
      }
    } 
    else 
    { // form NAME
      for(i = 0; i < document[formName].elements.length; i++)
      {
        if(document[formName].elements[i].name == listName) 
        {
          document[formName].elements[i].checked = false;
        }
      }
    }
  }
  else
  {
    if(document.getElementById(formName)) 
    { // form ID
      var counter = 0;
      for(i = 0; i < document.getElementById(formName).elements.length; i++) 
      {
        if(document.getElementById(formName).elements[i].name == listName) 
        {
          document.getElementById(formName).elements[i].checked = true;
          selectAllArray[counter] = true;
          counter++;
        }
      }
    } 
    else 
    { // form NAME
      for(i = 0; i < document[formName].elements.length; i++)
      {
        if(document[formName].elements[i].name == listName) 
        {
          document[formName].elements[i].checked = true;
        }
      }
    }
  }
}

// if "all ____ " is selected on alerts.cfm, select all alerts of that type.
function sh_greyAll(formName,listName,selectAllName,selectAllArray) 
{ 
  if(document.getElementById(selectAllName).checked == false)
  {
    if(document.getElementById(formName)) 
    { // form ID
      var counter = 0;
      for(i = 0; i < document.getElementById(formName).elements.length; i++) 
      {
        if(document.getElementById(formName).elements[i].name == listName && document.getElementById(formName).elements[i] != document.getElementById(selectAllName)) 
        {
          document.getElementById(formName).elements[i].disabled = false;
          selectAllArray[counter] = false;
          counter++;
        }
      }
    } 
  }
  else
  {
    if(document.getElementById(formName)) 
    { // form ID
      var counter = 0;
      for(i = 0; i < document.getElementById(formName).elements.length; i++) 
      {
        if(document.getElementById(formName).elements[i].name == listName && document.getElementById(formName).elements[i] != document.getElementById(selectAllName)) 
        {
          document.getElementById(formName).elements[i].disabled = true;
          document.getElementById(formName).elements[i].checked = false;
          selectAllArray[counter] = true;
          counter++;
        }
      }
    } 
  }
}



function sh_popup(url,x,y) {
  if(navigator.userAgent.indexOf("MSIE") == -1) {
    newwindow = window.open(url,'sh_pop','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width='+x+',height='+y);
    newwindow.focus();} 
  else {
    window.open(url,'sh_pop','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,width='+x+',height='+y);}
}

 
 
    
    
function sh_checkForCookie(name) {

	if (sh_readCookie(name) == null || sh_readCookie(name) == "") {
		sh_createCookie(name,'');
	} else {
		var oldCookie = sh_readCookie(name);
		sh_createCookie(name,'');
	}
}

function sh_readCookie(name) {

	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function sh_createCookie(name,value,days,domain){

	
	if (days){
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	if (domain){
		
		var thedomain = "; domain="+domain;
	}
	else var thedomain = "";
	
	document.cookie = name+"="+value+expires+"; path=/"+thedomain+";";


}

function sh_unappendCookie(name,value,domain){

	var cookieVals = sh_readCookie(name);

	var docs = cookieVals.split('%2C');
	var cntr = docs.length;
  	var i=0;
	var first = true;

	var newValue = '';
	
	for (i=0;i<cntr;i++) {
		if (docs[i].toLowerCase() != value.toLowerCase()){
			if (docs[i] != 'CHANGED'){
				
				if (first == true) {
					newValue = newValue + '';
				} else {
					newValue = newValue + '%2C';
				}
				newValue = newValue + docs[i];
				if (docs[i] != '') {
					first = false;
				}
			}
		}
	}



	if(newValue=='')
		newValue = newValue + 'CHANGED';
	else
		newValue = newValue + '%2C' + 'CHANGED' ;

	sh_createCookie(name,newValue,365,domain);
}

function sh_appendCookie(name,value,domain) {
	
	var cookieVals = sh_readCookie(name);

	if (cookieVals) {
		var docs = cookieVals.split('%2C');
		var cntr = docs.length;
		docs[cntr++] = value;
	} else {
		var docs = '';
		var cntr = '0';
	}

	var first = true;
	var newValue = '';
	
	if ( cntr > 0 ) {
		for (i=0;i<cntr;i++) {
			
			if (docs[i] != 'CHANGED' && docs[i].toLowerCase() != value.toLowerCase()){
				if (first == true) {
					newValue = newValue + '';
				} else {
					newValue = newValue + '%2C';
				}
				newValue = newValue + docs[i];
				if (docs[i] != '') {
					first = false;
				}
			}
		}
	}
	

	if(first)
		newValue = value + '%2C' + 'CHANGED';
	else
		newValue = newValue + '%2C' + value + '%2C' + 'CHANGED' ;

	sh_createCookie(name,newValue,365,domain);
}

function sh_toggleCase(_obj) {
	
	addStatus = document.getElementById("add"+_obj).style.display;
	delStatus = document.getElementById("del"+_obj).style.display;
	
	if (addStatus == 'none') {
		document.getElementById("add"+_obj).style.display = 'inline';
		document.getElementById("del"+_obj).style.display = 'none';
	} else {
		document.getElementById("add"+_obj).style.display = 'none';
		document.getElementById("del"+_obj).style.display = 'inline';
	}

}



function sh_showHideTransactions(groupname)
{
  i = 0;
  while(currRow = document.getElementById(groupname + '_' + i)) 
  {
    var imgDisplay="plus";
    if (currRow.style.display=="none") 
    {
      currRow.style.display="";
      document.getElementById(groupname+"img").src = sh_HideImg;
	
    } 
    else 
    {
      currRow.style.display="none"
   

    }
    i+=1;
  }
}

function sh_checkFormAll(arrayList,elementId)
{
  var temp = 0;
  for(var i=0;i<arrayList.length;i++)
  {
    if (arrayList[i])
    {
      temp++;
    }
  }
  if(document.getElementById(elementId))
    if (temp==arrayList.length)
      document.getElementById(elementId).checked=true;
    else
      document.getElementById(elementId).checked=false;
}


function sh_checkSingleElement(arrayList,elementId)
{
  var temp = 0;
  for(var i=0;i<arrayList.length;i++)
  {
    if (arrayList[i])
    {
      temp++;
    }
  }
  if(document.getElementById(elementId))
    if (temp==0)
      document.getElementById(elementId).disabled=true;
    else
      document.getElementById(elementId).disabled=false;
}

function wsh_pop(wsh_div) {
  document.getElementById(wsh_div).style.display='block';
  return false;
}

function wsh_hide(wsh_div) {
  document.getElementById(wsh_div).style.display='none';
  return false;
}

      
/*  No Javascript? No problem! We won't display the dynamic content - the below code is used to disable the stylesheet(script_absent). If the Javascript is not enabled, then this stylesheet will apply else it will be disabled by the Jaavscript function */
      
function wsh_NoJS()
{
  var x=document.styleSheets.length;
  var foundstyle=false;
  for (var i=0; i<x; i++)
  {
    var styleLink = document.styleSheets[i].href
    if(styleLink != "" && styleLink != null)
    {
      if(styleLink.search('wsh_script_absent') != -1) //if style sheet is titled "script_absent"
      {
        document.styleSheets[i].disabled = "true"
        break;
      }
    }
  }
  /*add change to JS class*/
}


function sh_Event_add(obj,type,fn) {
  if(obj.addEventListener) {
    obj.addEventListener(type,fn,false);
  }
  else if(obj.attachEvent) {
    obj["e"+type+fn] = fn;
    obj[type+fn] = function() {
      obj["e"+type+fn](window.event)
    };
    obj.attachEvent("on"+type,obj[type+fn]);
  }
  else {
    var oldonload = obj["on"+type];
    obj["on"+type] = function(e) {
      oldonload(e);
      fn(e);
    };
  }
}

function flashCheck() {
  // Version check based upon the values entered above in "Globals"
  var hasReqestedVersion = DetectFlashVer(requiredMajorVersion, requiredMinorVersion, requiredRevision);
           
  // Check to see if the version meets the requirements for playback
  if (hasReqestedVersion) {
    // if we've detected an acceptable version
    // Flash test passed turn flash chart on
    var FlashChartStatus = "on";
  } else {             
    // flash is too old or we can't detect the plugin
    // Flash test failed turn flash chart off
    var FlashChartStatus = "off";
  }
  // if flash chart on, OK to run JS function hiding non flash chart
  if(FlashChartStatus == "on")
  {
    wsh_NoJS();
  }
}

//Estimates Functions


  var wsh_est_def = new Array();
  
  wsh_est_def['EPS']="The default EPS adjusted (non-GAAP) to exclude extraordinary items, but include stock options expenses. Adjustments are typically one-time, nonrecurring items. EPS is calculated as: (Net Profit Adjusted + Stock Option Expense) / Fully Diluted Shares Outstanding. While EPS is the default and preferred value for display, contributing analysts may provide EPS using a different methodology or without specifying their methodology. In the event that EPS is not supplied, the value that the analyst provides will be displayed in this order: 1) Reported (GAAP); 2) Adjusted and excluding stock option expense.";
  wsh_est_def['EPSA']="Fully adjusted (non-GAAP) to exclude both extraordinary items and stock options expense. Adjustments are typically one-time, nonrecurring items. EPSA is collected if the analyst explicitly designates the EPS as adjusted. If EPS is not explicitly designated as adjusted, the EPSA field will be left blank. EPSA is calculated as: Net Profit Adjusted / Fully Diluted Shares Outstanding. For a selection of U.S. companies the difference between EPSA and EPS is stock option expense.";
  wsh_est_def['EPSR']="GAAP EPS for all U.S. companies. EPSR includes exceptions, nonrecurring items, and stock option expense. Since analysts often provide both adjusted and non-adjusted EPS values, the EPSR data item is the non-adjusted value in the Estimates database. EPSR is calculated as: Net Profit Reported (GAAP) / Fully Diluted Shares Outstanding.";
  wsh_est_def['Consensus']="The sum of the analyst's estimates divided by the number of estimates." 
  wsh_est_def['High']="The high of the analyst's estimates.";
  wsh_est_def['Low']="The low of the analyst's estimates.";
  wsh_est_def['PE']="The current share price compared to the per-share earnings.";
  wsh_est_def['YearAgo']="Earnings Per Share Consensus from one year prior to this date.";
  wsh_est_def['Analyst']="The number of analysts applied to the column of data points.";
  wsh_est_def['RevisionUp']="The number of analysts that increased their estimates within 30 days.";
  wsh_est_def['RevisionDown']="The number of analysts that decreased their estimates within 30 days.";
  wsh_est_def['ConsensusRating']="The sum of the analyst's estimates divided by the number of analyst's estimates.<br />BUY: Value=1, Range=1-1.8<br />OUTPERFORM: Value=2, Range=1.8-2.6<br />HOLD: Value=3, Range=2.6-3.4<br />UNDERPERFORM: Value=4, Range=3.4-4.2<br />SELL: Value=5, Range=4.2-5";
  wsh_est_def['CurrentTradingPrice']="The current stock price.<br /><em>Delayed at least 20 minutes.</em><br /><em>Provided by eSignal.</em>";
  wsh_est_def['MeanPrice']="The sum of the target price estimates divided by the number of estimates.";
  wsh_est_def['MedianPrice']="The mid point of range of numbers that are arranged in order of value for the analyst's target price estimates.";
  wsh_est_def['HighPrice']="The high of the analyst's target price estimate.";
  wsh_est_def['LowPrice']="The low of the analyst's target price estimate.";

  var wsh_ns6=document.getElementById && !document.all
  var wsh_timerCheck;
  var wsh_section;
  var wsh_plcholder;
  var wsh_curX;
  var wsh_curY;
  
function wsh_ietruebody()
  {
    return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
  }

function positiontip(e){
    wsh_curX=(wsh_ns6)?e.pageX : event.clientX+wsh_ietruebody().scrollLeft;
    wsh_curY=(wsh_ns6)?e.pageY : event.clientY+wsh_ietruebody().scrollTop;
  }

function wsh_hover_popuphide()
  {
  	document.getElementById('fin_def_bot').style.visibility='hidden';
  	document.getElementById('fin_def').style.visibility='hidden';
    clearTimeout(wsh_timerCheck);
  }
  
function wsh_windowSize() {
    var myWidth = 0, myHeight = 0;
    if( typeof( window.innerWidth ) == 'number' ) {
      //Non-IE
      myWidth = window.innerWidth;
      myHeight = window.innerHeight;
    } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      //IE 6+ in 'standards compliant mode'
      myWidth = document.documentElement.clientWidth;
      myHeight = document.documentElement.clientHeight;
    } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
      //IE 4 compatible
      myWidth = document.body.clientWidth;
      myHeight = document.body.clientHeight;
    }
    return [ myWidth, myHeight ];
  }
  
function wsh_fin_def_display_on(def_holder,message)
  {
  	document.getElementById(def_holder).innerHTML = message;
  	return;
  }
  
function wsh_defStart(obj,def)
  {
    var wsh_offset = new Array();
    var wsh_size = new Array();
    
    wsh_size = wsh_windowSize();
    var halfSize = (wsh_size[1]/3)*2;
    
    if(wsh_curY < halfSize)
    {
      wsh_section = 'fin_def';
      wsh_plcholder = 'wsh_def_placeholder';
    }
    else
    {
      wsh_section = 'fin_def_bot';
      wsh_plcholder = 'wsh_def_bot_placeholder';
    }
    
    wsh_fin_def_display_on(wsh_plcholder,def);
    
    
    var curleft = wsh_curX + 35;
    var curtop = wsh_curY  - 25;
    document.getElementById(wsh_section).style.position = 'absolute';
    document.getElementById(wsh_section).style.left = curleft + 'px';
    document.getElementById(wsh_section).style.top = curtop + 'px';
    document.getElementById(wsh_section).style.visibility='visible';
    
    if(wsh_section == 'fin_def_bot') document.getElementById(wsh_section).style.top = wsh_curY - (document.getElementById(wsh_plcholder).offsetHeight + 5) + 'px';
    return;
  }

  var fundObject = new Object();
  
  function processJSON(feed){ 
    fundObject = feed; 
  } 


  function wsh_processStyleSheets(framename, sourceURL) {
    var style_href = "";
    for(var style_count = 0; style_count < document.styleSheets.length; style_count++)
    {
      if(navigator.appName == "Microsoft Internet Explorer" && navigator.appVersion.indexOf("MSIE 8") == -1)
      {
        style_href = style_href + window.location.protocol + "//" + window.location.hostname + "/" + document.styleSheets[style_count].href + ",";
      }
      else
      {
        style_href = style_href + document.styleSheets[style_count].href + ",";
      }
    }
    document.getElementById(framename).src = sourceURL + "&styles=" + style_href;  
  }



/**/
function sh_ShowHide1()
{
  groupname=arguments[0];
  rows=arguments[1];
  if(arguments.length > 2)
  {
    if (arguments[2]==1)
    {
      var currRow = document.getElementById(groupname);
  		currRow.style.display="";
  	
    }
    else if (arguments[2]==0)
    {
      var currRow = document.getElementById(groupname);
  		currRow.style.display="none";

    }
  }
  else
  {
    if (rows == 0) 
    { /* for a single item */
      sh_RowShowHide1(groupname);
  	}
    else
    { /* for multiple rows of a table */
      for(i=1; i <= rows; i++)
      {
        var tempRow = groupname + "" + i;
        sh_RowShowHide1(tempRow);
      }
    }
  }
}



function sh_RowShowHide1(sh_RowID) {
	var currRow = document.getElementById(sh_RowID);
	if (currRow.style.display=="none") {
		currRow.style.display="";
	
	} else {
		currRow.style.display="none";
		
	}	
}












