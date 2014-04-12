/*
 * 发布采购js处理文件-弹出层
 * author by 王方超  2010-9-10 修改 by 蒋睿 10-11-11 （默认非会员）
 */
MSG = {
	/** 发布采购验证*/
	"title" : {
		"succ" : "",
		"on_focus" : "",
		"err_len": "标题为1-60个字符,请确认"
	},
//	"amount" : {
//		"succ" : "",
//		"on_focus" : "",
//		"err_len": "标题为1-10个字符,请确认"
//	},
/**	
	"biz_industry" : {
		"succ" : "",
		"on_focus" : "",
		"err_len": "请选择产品一级分类"
	},
	"first_cat" : {
		"succ" : "",
		"on_focus" : "",
		"err_len": "请选择产品二级分类"
	},
	"second_cat" : {
		"succ" : "",
		"on_focus" : "",
		"err_len": "请选择产品三级分类"
	},
*/	
	"desc" : {
		"succ" : "",
		"on_focus" : "",
		"err_len": "详细说明由1~1000个字符组成"
	},
	
	"contact_person" : {
		"succ" : "&nbsp;",
		"on_focus" : "联系人由1-6个中文或字母组成 为了方便对您感兴趣的客户联系您、建议填写真实姓名",
		"err_len":"联系人不能为空，长度为1-6个中文或字母组成，请确认",
		"err_invalid": "联系人非法，请确认",
		"regexp":"^[\\u4E00-\\u9FA5\\uF900-\\uFA2Da-zA-Z]{1,6}$" 
	},	
	"phone" : {
		"succ" : "&nbsp;",
		"on_focus" : "正确填写电话格式、如：010-82855558-996、如果是手机直接输入手机号码便可",
		"err_invalid": "联系电话不能为空，请正确填写电话格式、如：010-82855558-996、如果是手机直接输入手机号码便可",
		"regexp":"^((\\d{3,4}(-)?\\d{7,8}(-\\d{1,5})*)|([1-9]\\d{10})){1,20}$"
	},
	
	"vcode" : {
		"succ" : "&nbsp;",
		"on_focus" : "请输入验证码",
		"err_invalid" : "验证码非法，请确认"
	},
	"license" : {
		"succ" : " ",
		"on_focus" : "只有阅读了信息发布规则才能发布信息",
		"err_invalid" : "您没有阅读信息发布规则"
	},
	//会员登陆
	"username" : {
		"succ" : "",
		"err_len": "用户名长度不对",
		"err_empty": "用户名为空",
		"err_invalid": "用户名非法",
		"err_exist": "该用户名已经被注册",
		"err_wrong": "用户名或密码错误",
		"err_deny": "账户被锁定，请与客服联系。电话：010-82855188"
	},
	"member1_passwd" : {
		"succ" : "",
		"err_len" : "密码长度不对",
		"err_deny": "用户名或密码错误"
	},
	//注册验证
	"contact_email" : {
		"succ" : "&nbsp;",
		"on_focus" : "请填写有效的电子邮箱，便于找回密码及获得商机。如：abc@153.com",
		"err_len": "电子邮箱不能为空,最多50个字符",
		"err_invalid": "您的电子邮箱格式不正确，请重新输入",
		"err_exist": "您的电子邮箱已经注册过",
		"regexp" : "^(\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*[.]\\w+([-.]\\w+)*){1,50}$"
	}
	
}


jQuery(document).ready(function(){
	formInit();
	if($('#is_login').val() == '1')
	{
		if($('#is_member').val()== 0){
			$('#member0').hide();
			$('#mem').hide();
			$('#member1').hide();
			$('#member2').show();
		}
	}
	else
	{
	       ucenter_login();
	       document.getElementById('contact_person2').disabled = true;
	   	document.getElementById('contact_email2').disabled = true;
	   	document.getElementById('phone2').disabled = true;
	   	$("#username").attr("disabled",true).unFormValidator(true);
	   	$("#member1_passwd").attr("disabled",true).unFormValidator(true);
	   	$("#contact_email").attr("disabled",false).formValidator({
	   		//tipid : "contact_email_tip",
	   		onshow:" ",
	   		onfocus:MSG.contact_email.on_focus,
	   		oncorrect:MSG.contact_email.succ
	   	}).inputValidator({
	   		min:6,
	   		max:50,
	   		onerror:MSG.contact_email.err_len
	   	}).regexValidator({
	   		regexp:MSG.contact_email.regexp,
	   		onerror:MSG.contact_email.err_invalid
	   	});		
	   	$("#contact_person").attr("disabled",false).formValidator({
	   		onshow:" ",
	   		onfocus:MSG.contact_person.on_focus,
	   		oncorrect:MSG.contact_person.succ
	   	}).inputValidator({
	   		min:1,
	   		max:6,
	   		onerror:MSG.contact_person.err_len
	   	}).regexValidator({
	   		regexp:MSG.contact_person.regexp,
	   		onerror:MSG.contact_person.err_invalid
	   	});
	   	$("#phone").attr("disabled",false).formValidator({
	   		onshow:" ",
	   		onfocus:MSG.phone.on_focus,
	   		oncorrect:MSG.phone.succ
	   	}).regexValidator({
	   		regexp:MSG.phone.regexp,
	   		onerror:MSG.phone.err_invalid
	   	});
		
	}
	
	category();
	dic_country_province_city_county();
  $("#title").formValidator({
		onshow:" ",
		onfocus:MSG.title.on_focus,
		oncorrect:MSG.title.succ
	}).inputValidator({
		min:1,
		max:60,
		onerror:MSG.title.err_len
	});	
//  $("#amount").formValidator({
//		onshow:" ",
//		onfocus:MSG.amount.on_focus,
//		oncorrect:MSG.amount.succ
//	}).inputValidator({
//		min:1,
//		max:10,
//		onerror:MSG.amount.err_len
//	});	
 /** 
	$("#biz_industry").formValidator({
		tipid : "categoryTip",
		onshow:" ",
		onfocus:MSG.biz_industry.on_focus,
		oncorrect:MSG.biz_industry.succ
	}).inputValidator({
		min:1,
		onerror:MSG.biz_industry.err_len
	});	
	$("#first_cat").formValidator({
		tipid : "categoryTip",
		onshow:" ",
		onfocus:MSG.first_cat.on_focus,
		oncorrect:MSG.first_cat.succ
	}).inputValidator({
		min:1,
		onerror:MSG.first_cat.err_len
	});	
	
	$("#second_cat").formValidator({
		tipid : "categoryTip",
		onshow:" ",
		onfocus:MSG.second_cat.on_focus,
		oncorrect:MSG.second_cat.succ
	}).inputValidator({
		min:1,
		onerror:MSG.second_cat.err_len
	});	
*/	
	$("#desc").formValidator({
		onshow:" ",
		onfocus:MSG.desc.on_focus,
		oncorrect:MSG.desc.succ
	}).inputValidator({
		min:1,
		max:1000,
		onerror:MSG.desc.err_len
	});	
	/**	
	$("#contact_person").formValidator({
		onshow:" ",
		onfocus:MSG.contact_person.on_focus,
		oncorrect:MSG.contact_person.succ
	}).inputValidator({
		min:1,
		max:6,
		onerror:MSG.contact_person.err_len
	}).regexValidator({
		regexp:MSG.contact_person.regexp,
		onerror:MSG.contact_person.err_invalid
	});	

	

	$("#phone").formValidator({
		tipid : "phoneTip",
		onshow:" ",
		onfocus:MSG.phone.on_focus,
		oncorrect:MSG.phone.succ
	}).inputValidator({
		min:6,
		max:50,
		onerror:MSG.phone.err_len
	}).regexValidator({
		regexp:MSG.phone.regexp,
		onerror:MSG.phone.err_invalid
	});	
	**/

	
	$("#vcode").formValidator({
		onshow:" ",
		onfocus:MSG.vcode.on_focus,
		oncorrect:MSG.vcode.succ
	}).inputValidator({
		min:1,
		max:10,
		onerror:MSG.vcode.err_invalid
	});

   $("#license").formValidator({
		onshow:" ",
		onfocus:"",
		oncorrect:"",
		onerror:MSG.license.err_invalid
	}).functionValidator({
		onerror:MSG.license.err_invalid,
	    fun:function(val,elem){
	        $("#submitBtn").attr("disabled", ! elem.checked);
	    	return elem.checked;
		}
	});
	
	/* 判断二级分类，为空时删除二级分类验证绑定 */
	$("#submitBtn").click(function(){
		var check=$("#check").val();
		var check1=$("#check1").val();
		var check2=$("#check2").val();
		if((check =='') && (check1=='')&&(check2==''))
		{	
			if(!$("#second_cat").html())
			{
				$("#second_cat").unFormValidator(true);
			}
		}
		else if(check == 4)
		{
			alert("价格为1-10个数字");
			return false;
		}
		else if(check2 == 3)
		{
			alert("数量为1-10个数字");
			return false;
		}
		else if(check1 == 5)
		{
			alert('采购名称最大20个字');
			return false;
			
		}	
	});	
	$('#amount').bind('blur',toggleM23);
	$('#price').bind('blur',toggleM22);
	$('#category_manual').bind('click',toggleCategoryManual);
	$('#cage').bind('click',toggleM);
	$('#cage1').bind('click',toggleM1);
	
	$('#other_1').bind('click',toggleM21);
	$('#other_2').bind('click',toggleM21);
	$('#other_3').bind('click',toggleM21);
	$('#other_4').bind('click',toggleM21);
	$('#other_5').bind('click',toggleM21);
	
	$('#other_1').bind('change',toggleM2);
	$('#other_2').bind('change',toggleM2);
	$('#other_3').bind('change',toggleM2);
	$('#other_4').bind('change',toggleM2);
	$('#other_5').bind('change',toggleM2);
    
	$("#title").blur(function(){
		var title = $.trim($("#title").val());
		if(title != ''){
			if(title.length>1 && title.length<50){
				var desc = $("#desc").val();
				if(desc!="" && desc.indexOf("XXX")!=-1){
					desc = desc.replace("XXX","\"" + title + "\"");
					$("#desc").html(desc);
				}
			}
			$('#see').show();
			$('#see1').show();
//			$("#biz_industry").;
			clear_select_value('first_cat');
			clear_select_value('second_cat');
			clear_category_tag('selected_biz_industry');
			clear_category_tag('selected_first_cat');
		    clear_category_tag('selected_second_cat');
			$('#category_table1').hide();
//			$("#cage").show();
//			$('#category_table').show();
//			clear_select_value('biz_industry');
//			$("#biz_industry").unFormValidator(true);			
//			clear_span_value('selected_biz_industry');

		}
			$.ajax({
				url: "iframe_purchase_add_title_choose_p.php",
				type: "POST",
				data: {
						'key':	title},
				success: function(msg)
				{
				    var json = eval(msg);
				    if (json == '') {
//				    	alert("00");
				    	$('#category_table').hide();
				    	$("#cage").hide();
				    	};
				    for (var i=0; i<json.length; i++)
				    {
				    	if (json[i].second_cat_name !== 'null')
				    	{
					    	var html = json[i].biz_industry_name;
					    	if (json[i].first_cat_name != 'null')
					    		html += ' > '+json[i].first_cat_name;
					    	
					    		html += ' > '+json[i].second_cat_name;
					    	var html2 = '<input type="radio" value="" id="title_radio" name="radio">';
					    	var html3 = json[i].biz_industry_id + '_' + json[i].first_cat_id + '_' 
					    				+ json[i].second_cat_id;	
					    			    	
					    	$('.zys').eq(i).html(html);
					    	$(".toptions").eq(i).find('label').html(html2);
					    	$(".toptions").eq(i).find('input').val(html3).bind('click',titleChoose);
					    	$('#category_table').show();
							$("#cage").show();
				    	}
				    	else
				    	{   $('#category_table').show();
						    $("#cage").show();			    	    
				    	}
				    }					
				}
			});
//                          $("#cage").show();

	});
	
});



function category(){
	//--------------获取产品分类--BEGIN------------------------	
	$('#biz_industry').click(function(){
		var category_id = $(this).val();
		var url = '/misc/dic/get_product_category.php';
		var data = {'category_id':category_id,grade:'2'};
		
		/* 获取一级分类 */
		ajax_get_category(url,data,"get_first_cat");
		
		/* 清除二级分类 */
		clear_select_value('second_cat');
		
		/* 清除一级、二级分类tag */
		clear_category_tag('selected_first_cat','selected_second_cat');
		/* 一级的值名赋值入相应hidden input*/
		$('#selected_biz_industry').html($('#biz_industry option:selected').html());
		$('#inter_1').hide();
		$("#inter_2").hide();
		
		$('#i_biz_industry').val($('#selected_biz_industry').html());
		$('#i_biz_industry_num').val(category_id);
	});
	
	$('#first_cat').click(function(){
		var category_id = $(this).val();
		var url = '/misc/dic/get_product_category.php';
		var data = {'category_id':category_id,grade:'3'};
		
		/* 获取二级分类 */
		ajax_get_category(url,data,"get_second_cat");
		
		/* 清除二级分类tag */
		clear_category_tag('selected_second_cat');
		/* 二级的值名赋值入相应hidden input*/	
		$('#inter_1').show();
		$('#selected_first_cat').html($('#first_cat option:selected').html());
		
		$('#i_first_cat').val($('#selected_first_cat').html());
		$('#i_first_cat_num').val(category_id);
	});
	$('#second_cat').click(function(){		
		var category_id = $(this).val();
		var url = '/misc/dic/get_dic_category_attr.php';
		ajax_get_category_attr(category_id,url);
		
		/* 三级的值名赋值入相应hidden input*/
		$('#second_cat_num').val(category_id);
		$('#inter_2').show();
		$('#selected_second_cat').html($('#second_cat option:selected').html());
		$('#i_second_cat_num').val(category_id);
		$('#check3').val(3);
		//showVariableNeccesory();
	});
	$("#category_attr").css("display","none");
	$(".show_category_attr").click(function(){
		if($("#category_attr").css('display') == 'none')
		{
			$("#category_attr").css("display","block");
			$("#img_category_attr").attr("src","http://jic.b2b.makepolo.com/img/y_sort2.jpg");
		}
		else
		{
			$("#category_attr").css("display","none");
			$("#img_category_attr").attr("src","http://jic.b2b.makepolo.com/img/y_sort1.jpg");
		}	
	});
	
//--------------获取产品分类--END------------------------	
}

//获取国家，省，城市，县

$(function(){
	if(countryid = '10001')
		{						
		get_address_list({'countryid':countryid,'type':1},'province');
		document.getElementById('city').disabled = true;
		document.getElementById('county').disabled = true;
		}  
});



function dic_country_province_city_county(){
	
	/* 根据国家取省份 */
	$("#country").change(function(){
		var countryid = $(this).val();
		if(countryid>0)
		{
//			$('#province').unFormValidator(false);
//			$('#city').unFormValidator(false);
//			$('#county').unFormValidator(false);
			$('#province').html("<option value='0'>请选择省份</option>");
			$('#city').html("<option value='0'>请选择城市</option>");
			$('#county').html("<option value='0'>请选择县区镇</option>");
			get_address_list({'countryid':countryid,'type':1},'province');
//			if(countryid != '10001')
//			{
//				
//				document.getElementById('province').disabled = false;
//				
//			}
		}
	});
	
	$('#province').change(function(){
		var countryid = $('#country').val();
		var provinceid = $(this).val();
		   $('#city').html("<option value='0'>请选择城市</option>");
			$('#county').html("<option value='0'>请选择县区镇</option>");
		if(provinceid>0)
		{
			get_address_list({'countryid':countryid,'provinceid':provinceid,'type':2},'city');
			document.getElementById('city').disabled = false;
		}
	});

	$('#city').change(function(){
	var countryid = $('#country').val();
		var provinceid = $('#province').val();
		var cityid = $(this).val();
		$('#county').html("<option value='0'>请选择县区镇</option>");
		if(cityid>0)
		{
			get_address_list({'countryid':countryid,'provinceid':provinceid,'cityid':cityid,'type':3},'county');
			document.getElementById('county').disabled = false;
		}
	});

}



function get_address_list(value,tipid)
{
	var str = '';
	switch(tipid)
	{
		case 'province':
			str = "<option value='0'>请选择省份</option>";
			break;
		case 'city':
			str = "<option value='0'>请选择城市</option>";
			break;
		case 'county':
			str = "<option value='0'>请选择县区镇</option>";
			break;
	}

	$.ajax({
		type : 'post',
		url  : '/ucenter/corp/get_address_list.php',
		data : {'addr_id':value},
		dataType : 'json',
		success  : function(jsonArr){
			var data_arr = jsonArr['data'];
			for(var i in data_arr)
			{
				str +="<option value='"+data_arr[i]['id']+"'>"+data_arr[i]['name']+"</option>";
			}
			$("#"+tipid).html(str);
		}
	});
}
function toggleCategoryManual(){
//	$('#category_table').toggle();
	$('#category_table').hide();
	$('#category_table1').show();
	$("#cage").show();
}
/*
 * 分类联动框函数
 */
function toggleM(){

		$('#category_table1').hide();
		$('#category_table').hide();
		$('#cage1').show();
		$('#cage').hide();

}
function toggleM1(){
	var check3=$('#check3').val();
	if(check3 == 3)
	{
		$('#category_table1').show();
	}else if(check3 == 2){
		$('#category_table').show();
	}else{
		if($("#category_table").is(":hidden")){
		$('#category_table').hide();
		$('#category_table1').show();
	}
		else{
			$('#category_table').show();
			$('#category_table1').show();
		}
	}
	$('#cage1').hide();
	$('#cage').show();

}
/*
 * 其他采购js函数 联动改变
 */
function toggleM2(){
	if($(this).val().length > 20)
	{
		alert('最大20个字');
		$("#check1").val('5');
		return false;
	}
	else
	{
		$("#check1").val('');
	}
	$('#search_1').show();
	if($('#pur_1').html()=='')
	{
		if($(this).val()!= '')
		{
			$('#pur_1').append("<span to="+$(this).attr('to')+">"+$(this).val()+"</span>");
		}
	}
	else
	{
		test=$("span[to]").size();
		switch (test)
		{
			case 1:
				test_t=$("span[to]:eq(0)").attr('to');
				break;
			case 2:
				test_t=$("span[to]:eq(0)").attr('to')+$("span[to]:eq(1)").attr('to');
				break;
			case 3:
				test_t=$("span[to]:eq(0)").attr('to')+$("span[to]:eq(1)").attr('to')+$("span[to]:eq(2)").attr('to');
				break;
			case 4:
				test_t=$("span[to]:eq(0)").attr('to')+$("span[to]:eq(1)").attr('to')+$("span[to]:eq(2)").attr('to')+$("span[to]:eq(3)").attr('to');
				break;
			case 5:
				test_t=$("span[to]:eq(0)").attr('to')+$("span[to]:eq(1)").attr('to')+$("span[to]:eq(2)").attr('to')+$("span[to]:eq(3)").attr('to')+$("span[to]:eq(4)").attr('to');
				break;
		}
		if($(this).val()!= '')
		{
			if(test_t.indexOf($(this).attr('to'))!= -1)
			{
				$("span[to="+$(this).attr('to')+"]").html($(this).val());
			}
			else
			{
				$('#pur_1').append("、<span to="+$(this).attr('to')+">"+$(this).val()+"</span>");
			}		
			
		}
		else
		{
			$("span[to="+$(this).attr('to')+"]").html($(this).val());
		}
	}
	var ses=$('#pur_1').text();
	$.ajax({
		type : 'post',
		url  : 'new_iframe_purchase_match.php',
		data : {'title':ses},
		dataType : 'json',
		success  : function(jsonArr){
			$("#num_1").text(jsonArr);
		},
		error : function()
		{
			alert('error');
		}
	});

}
function get_address_list1(value,tipid)
{
	var str = '';
	switch(tipid)
	{
		case 'province1':
			str = "<option value='0'>请选择省份</option>";
			break;
		case 'city1':
			str = "<option value='0'>请选择城市</option>";
			break;
		case 'county1':
			str = "<option value='0'>请选择县区镇</option>";
			break;
	}

	$.ajax({
		type : 'post',
		url  : '/ucenter/corp/get_address_list.php',
		data : {'addr_id':value},
		dataType : 'json',
		success  : function(jsonArr){
			var data_arr = jsonArr['data'];
			for(var i in data_arr)
			{
				str +="<option value='"+data_arr[i]['id']+"'>"+data_arr[i]['name']+"</option>";
			}
			$("#"+tipid).html(str);
		}
	});
}

/**会员登陆验证*/

function  ucenter_login(){
	//alert('ucenter_login');
$("#username").formValidator({
		onshow:" ",
		onfocus:"",
		oncorrect:""
	}).inputValidator({
		min:4,
		max:32,
		onerror:"格式不正确，请检查"
	});

	$("#member1_passwd").formValidator({
		tipid : "member1_passwdTip",
		onshow:" ",
		onfocus:"",
		oncorrect:""
	}).inputValidator({
		min:6,
		max:20,
		onerror:"格式不正确，请检查"
	});
	 
	}	
		
function doResponse(jsonArr, status){
	
	switch (jsonArr['errno']) {
		// succ
		case 0:
			str=jsonArr['url'];
			if(str.indexOf('&amp;') != -1)
			{
				var	str=jsonArr['url'];
				str = str.replace('&amp;','&');
				location.href = str;
			}else{
				location.href = jsonArr['url'];
			}	
			
			break;

		// form表达错误
		case 1:
			form = jsonArr['form'];
			for (i in form)
			{
				errno = form[i];
				tip = $("#" + i + 'Tip');
				tip.attr('class', 'onError').show();
				if (MSG[i][errno] != null) {
					tip.html(MSG[i][errno]);
				} else {
					tip.html('错误');
				}
			}
			break;
			// 验证码错误
		case 2:
			$('#vcode').val('');
			fresh_vchode('img_vcode');
			$("#vcodeTip").html('验证码错误').attr('class', 'onError').show();
			break;
		case 9:
			alert(jsonArr['msg']);
			break;
	}
}	

function baseSubmit(){

		if(document.all){
			var image = $("#image");
			image.select();
			document.execCommand('delete');
		}else{
			$("#image").val("");
		}

	
}



function getRandNum(){
	return Math.round(Math.random()*1000);	
}

/*
 * 显示提示分类
 */
function titleChoose(){
	//alert($(this).children().eq(0).html());
	var html = $(this).parent().parent().find('.zys').html();
	html = html.split('>');
	var html2 = $(this).parent().parent().find('input').val();
	html2 = html2.split('_');
	var url = '/misc/dic/get_dic_category_attr.php';
	ajax_get_category_attr(html2[2],url);
	
	$("#selected_biz_industry").html(html[0]);
	$("#selected_first_cat").html(html[1]);
	$("#selected_second_cat").html(html[2]);
	
	$("#i_biz_industry").val(html[0]);
	$("#i_first_cat").val(html[1]);
	$("#i_second_cat").val(html[2]);
	
	$('#i_biz_industry_num').val(html2[0]);
	$('#i_first_cat_num').val(html2[1]);
	$('#i_second_cat_num').val(html2[2]);
	clear_category_tag('selected_first_cat','selected_second_cat');
	$('#inter_1').hide();
	$('#inter_2').hide();
	$('#check3').val(2);
}
function validMember(type){

	$("#vcode").formValidator({
		onshow:" ",
		onfocus:"",
		oncorrect:""
	}).inputValidator({
		min:1,
		onerror:"请输入验证码"
	});

		if(type == 0)
		{
			$("#contact_email").attr("disabled",true).unFormValidator(true);
			$("#contact_person").attr("disabled",true).unFormValidator(true);
			$("#phone").attr("disabled",true).unFormValidator(true);
			$("#username").attr("disabled",false).formValidator({
				onshow:" ",
				onfocus:"",
				oncorrect:""
			}).inputValidator({
				min:4,
				max:32,
				onerror:"格式不正确，请检查"
			});
			$("#member1_passwd").attr("disabled",false).formValidator({
				onshow:" ",
				onfocus:"",
				oncorrect:""
			}).inputValidator({
				min:6,
				max:32,
				onerror:"格式不正确，请检查"
			});
		}
		else
		{
			$("#username").attr("disabled",true).unFormValidator(true);
			$("#member1_passwd").attr("disabled",true).unFormValidator(true);
			$("#contact_email").attr("disabled",false).formValidator({
				//tipid : "contact_email_tip",
				onshow:" ",
				onfocus:MSG.contact_email.on_focus,
				oncorrect:MSG.contact_email.succ
			}).inputValidator({
				min:6,
				max:50,
				onerror:MSG.contact_email.err_len
			}).regexValidator({
				regexp:MSG.contact_email.regexp,
				onerror:MSG.contact_email.err_invalid
			});		
		    $("#contact_person").attr("disabled",false).formValidator({
				onshow:" ",
				onfocus:MSG.contact_person.on_focus,
				oncorrect:MSG.contact_person.succ
			}).inputValidator({
				min:1,
				max:6,
				onerror:MSG.contact_person.err_len
			}).regexValidator({
				regexp:MSG.contact_person.regexp,
				onerror:MSG.contact_person.err_invalid
			});
			$("#phone").attr("disabled",false).formValidator({
				onshow:" ",
				onfocus:MSG.phone.on_focus,
				oncorrect:MSG.phone.succ
			}).regexValidator({
				regexp:MSG.phone.regexp,
				onerror:MSG.phone.err_invalid
			});	
		}
}


function PADshowDIV(){
    if($("#img002").is(":hidden")){
         $("#image_button_1").show();
//       $("#img002").show();
    }
//    else{
//      if($("#img003").is(":hidden")){
//     	   $("#image_button_2").show();
//     	   $("#img003").show();	
//       }
//        else{
//     	  $("#image_button_3").show();   
//    }
//        }
}
function PADhideDIV(){
   if($("#img002").is(":hidden")){
        $("#image_button_1").show();
        $("#img002").show();
   }
   else{
       if($("#img003").is(":hidden")){
	   $("#image_button_2").show();
	   $("#img003").show();	
       }
 else{
	  $("#image_button_3").show();   
 }
 }
}
function toggleM21()
{
	if(($(this).val().indexOf('产品'))!= -1)
	{
		$(this).val('');
		
	}	
}
function toggleM22()
{
	if($(this).val()!='')
	{
	if((/^[0-9]{1,10}$/.exec($(this).val()))== null)
	{
		alert("价格为1-10个数字");
		$("#check").val('4');
		return false;
	}
	else
	{
		$("#check").val('');
	}
	}
}
function toggleM23()
{
	if($(this).val()!='')
	{
	if((/^[0-9]{1,10}$/.exec($(this).val()))== null)
	{
		alert("数量为1-10个数字");
		$("#check2").val('3');
		return false;
	}
	else
	{
		$("#check2").val('');
	}
	}
}	