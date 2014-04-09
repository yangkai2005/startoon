/**
 * 通用的JS
 */

function formInit() {
	var jsonform_options = {
    	beforeSubmit: formValidate,
		dataType: 'json',
        success: doResponse,
        error: function(r){alert("ajax错误。\n\n错误信息：" + r.responseText.substring(0, 100));},
		timeout: function(){alert('网络超时，请重试。如果仍有问题，请稍后再试。');}
    };

    function formValidate() {
    	if (!jQuery.formValidator.pageIsValid("1")) {
			return false;
		} else {
			return true;
		}
	}

    if ($.formValidator.initConfig != null)
    {
	    $.formValidator.initConfig({
			formid:"jsonform",
			onerror: function(){return false;},
			onsuccess: function(){return true;}
		});
    }

	$('#jsonform').ajaxForm(jsonform_options);
}

jQuery(document).ready(function() {
	// 验证码的刷新
	$('#a_fresh_vcode').click(function(){return fresh_vchode('img_vcode')});
	$('#img_vcode').click(function(){return fresh_vchode('img_vcode');});
});

function fresh_vchode(id){
	var obj = document.getElementById(id);
	if (obj.src.indexOf("show_vcode.php") > 0)
	{
		obj.src = "/misc/vcode/show_vcode.php?rn=" + (new Date).getTime();
	}
	else
	{
		obj.src = "/misc/vcode/show_captcha.php?rn=" + (new Date).getTime();
	}
	
	return false;
}

// 设置textbox获得/失去焦点的效果
function ui_textbox_event(id) {
	function tb_mouseover() {
		this.style.borderColor = "#B85117";
	}

	function tb_mouseout() {
		if (this.getAttribute("isFocus") != "true") {
			this.style.borderColor = "";
			this.getAttribute("isFocus", "");
		}
	}

	function tb_focus() {
		this.setAttribute("isFocus", "true");
		this.style.backgroundColor = "#FEFBBD";
	}

	function tb_blur() {
		this.style.backgroundColor = "";
		this.style.borderColor = "";
		this.setAttribute("isFocus", "");
	}

	$("#" + id).focus(tb_focus).blur(tb_blur).mouseover(tb_mouseover).mouseout(tb_mouseout);
}

// 设置tab切换
function ui_change_tab(index)
{
  for (var i=1;i<=6;i++)
  {
     document.getElementById ("li_"+i).className ="umenu4";
     document.getElementById ("li_"+index).className ="umenu3";
     document.getElementById ("div"+i).style.display  ="none";
  }
  document.getElementById ("div"+index).style.display  ="block";
}

function backtoIndex(){
	
	window.location.href =  '/ucenter/index.php' ;
}

/***
 * 去掉数组中重复的元素
 * @return
 */
Array.prototype.unique = function() 
{ 
  var a = {}; 
   for(var i=0; i<this.length; i++) 
  { 
    if(typeof a[this[i]] == "undefined") 
      a[this[i]] = 1; 
  } 
  this.length = 0; 
  for(var i in a) 
    this[this.length] = i; 
  return this; 
}