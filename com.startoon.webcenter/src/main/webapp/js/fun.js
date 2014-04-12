//中英文截取
String.prototype.cn_substr = function(start, len, replace)
{
	var s = this.replace(/([\u4e00-\u9fa5])/g,"\xff\$1");
	if(s.length > len)
	{
		if(s.length == this.length)return this.substring(start, len);
		return (s.substring(start, len).replace(/\xff/g, '') + replace);
	}
	return this;
	//return s.substring(start, len).replace(/\xff/g, '');
}

function addslashes( str ) {
    // Escapes single quote, double quotes and backslash characters in a string with backslashes  
    // *     example 1: addslashes("kevin's birthday");
    // *     returns 1: 'kevin\'s birthday'
 
    return (str+'').replace(/([\\"'])/g, "\\$1").replace(/\0/g, "\\0");
}


function animateBar(){
	$(".item .precent").each(function(){
		var pre;
		$(this).css("width","0px");
		if ($(this).attr("precent"))
		{
			pre = $(this).attr("precent");
		}
		else
		{
			pre = 0;
		}
		$(this).animate({width: pre},"slow");
	});
}

/**
 * 显示来源函数
 *
 * @param string from_type  来源类型 globa:整个调查 问题答案id数字：某个问题答案
 * @param string con_id  要显示的内容id
 * @param htmlElement obj 要操作的dom对象
 * @param event e 传递的事件
 * @param boolean allow_close 是否允许关闭 默认允许
 * @return void
 */
function areaInfo(from_type,con_id,obj,e,allow_close)
{
	if(typeof allow_close == 'undefined'){
		allow_close = true;
	}
	/*var e = e || window.event;
	var target= e.target || e.srcElement;
	if (jQuery.browser.msie && obj != target){//ie下有间距BUG
		$("#" + con_id).css("margin-top","-4px");
	}
	target = $(target);*/
	areaDom = $("#" + con_id);
	if ($(obj).attr("class").indexOf("selected") >= 0 && allow_close){ //处于打开状态 && 允许关闭
		$(obj).removeClass("selected");
		hideArea(areaDom);
	}else{ //未打开的状态
		$(obj).addClass("selected"); //让点击对象处于选中状态
		if($('#'+con_id).attr('loaded') == '1'){ //如果有此节点了就直接显示，否则则取创建节点，然后显示出来
			showArea(areaDom);
		}else{
			//AJAX读取数据
			var cgi = '';
			if(from_type == 'global'){//读取整个调查来源信息不需要答案id：aid参数 &debug=1//200909251058
				cgi = "/api/fusioncharts/get_from_data.php?sid="+Conf.sid+"&jsoncallback=?";
			}else{
				cgi = "/api/fusioncharts/get_from_data.php?sid="+Conf.sid+"&aid="+from_type+"&jsoncallback=?";	
			}
			setTimeout(function(){//setTimeout？ ie request mybe aborted
				$.getJSON(cgi,
					function(json_data){
						//根据json数据获得html代码
						var html = get_html_by_from_json_data(from_type,json_data);
						//alert(html);
						//将html代码追加到指定内容显示dom内
						$('#'+con_id).html(html);
						//执行html内需要执行的js代码
						//eval_function(from_type,json_data);						
						//读取完成后调用
						$('#'+con_id).attr('loaded','1');
						showArea(areaDom,function(){
												  eval_function(from_type,json_data);	//执行html内需要执行的js代码  回调方式解决，避免卡的情况
												  });
					}); 
				},0);			
		}
	}
}
function showArea(obj,completa_callback){
	$(obj).find(".menu-area").css("visibility","visible");
	//obj.animate({height:"show"},"slow");
	obj.animate({height:"show"},{duration:0,complete:function(){
																   //$(obj).get(0).scrollIntoView(false);
																   if(typeof completa_callback != 'undefined' && completa_callback.constructor == Function){
																	   	completa_callback();
																	   }
																   }});
	
}
function hideArea(obj){
	$(obj).find(".menu-area").css("visibility","hidden");
	obj.animate({height:"hide"},{duration:0});//"slow");
}

/**
 * 收起整个调查的来源信息
 */
function hide_global_from(){
	if ($('#S_Menu_13').length>0 && $('#S_Menu_13').attr("class").indexOf("selected") >= 0){ //处于选中状态
		$('#S_Menu_13').removeClass("selected");
		hideArea($('#from_global_host'));
	}	
}

/**
 * 点击总参与人数时显示调查用户分析 此方法也可收起用户分析 
 */
function show_global_from_by_vote_num(){
	areaInfo('global','from_global_host',document.getElementById('S_Menu_13'),null,true);	
}

//获得json数据的长度
function get_json_length(json_data){
	var i = 0;
	if(!json_data || json_data.constructor != Object){
		return i;
	}
	for(var pro in json_data){
		i++;
	}
	return i;
}

/**
 * 根据来源类型和来源json数据获得html代码
 * @param string from_type 来源类型 global：整个调查的来源 答案id：某个答案的id 标识这个一个具体的答案
 * @param number question_index 问题序列
 * @param number answer_index 答案序列
 * @return void
 */
function get_html_by_from_json_data(from_type,json_data){
	var html = '';
	//global 整个调查的来源和某个答案的来源html结构有点区别
	if(from_type != 'global'){
		html += '<div class="box-area">';
	}
	//php接口返回数据为空？
	if(!json_data || (json_data.constructor == Array && json_data.length <=0)){
		html += '<div style="color:#aaa; padding:10px;">暂无分析数据</div>';
		return html;
	}
	//*******************
	// 拼出舍签的menu部分
	//*******************
	html += '<ul class="menu-area">';
	var index = 1;
	for(var pro in json_data){
		if(index == 1){// first
			html += '<li id="from_'+from_type+'_menu_'+index+'" class="fst">';	
		}else{
			html += '<li id="from_'+from_type+'_menu_'+index+'">';		
		}
		html += '<a href="javascript:void(0);" onfocus="this.blur();" title="按'+pro+'">按'+pro+'</a></li>';
		index ++;
	}
	html += '</ul>';
	//*******************
	// 拼出内容(con)部分
	//*******************
	var index = 1;
	for(var pro in json_data){
		//内容块
		html += '<div id="from_'+from_type+'_con_'+index+'" style="display:none;">';
			//flash区域
			html += '<div class="area-flash">';
                    html += '<div id="from_'+from_type+'_flash_div_'+index+'" align="center"></div>';
			html += '</div>';
			html += '<div class="area-flash-tip" id="from_'+from_type+'_flash_div_'+index+'_tip"></div>';//选择行业的用户占40% 
					
		html += '</div>';
		index++;
	}  

	if(from_type != 'global'){
		html += '</div>';
	}
	return html;
}

/**
 * 对动态拼出的来源html代码内的js后期执行函数 以便解决innerHTML js代码不执行问题
 * @param string from_type 来源类型 global：整个调查的来源 答案id：某个答案的id 标识这个一个具体的答案
 * @param object/array json_data php接口返回的数据
 * @return boolean
 */
function eval_function(from_type,json_data){
	if(!from_type || !json_data || (json_data.constructor==Array && json_data.length <= 0)){
		return false;
	}
	//执行fusioncharts write js code
	var index = 1;
	for(var pro in json_data){
		window['from_'+from_type+'_fc_'+index] = new FusionCharts("http://www.sinaimg.cn/dy/fusioncharts/v3/flash/Pie3D.swf?PBarLoadingText=Loading&XMLLoadingText=Loading&ParsingDataText=Loading","from_"+from_type+"_flash_"+index, "620", "360", "0", "0");
		//window['from_'+from_type+'_fc_'+index] = new FusionCharts("http://www.sinaimg.cn/dy/deco/2009/0903/survey/Pie3D.swf","from_"+from_type+"_flash_"+index, "620", "200", "0", "0");
		var xml = get_chart_xml_by_json_data(from_type,json_data[pro], index);
		//alert(xml)
		//window['from_'+from_type+'_fc_'+index].addParam('wmode','transparent');
		window['from_'+from_type+'_fc_'+index].setTransparent(1);
		window['from_'+from_type+'_fc_'+index].setDataXML(xml);
		window['from_'+from_type+'_fc_'+index].render("from_"+from_type+"_flash_div_"+index);
		//追加area-flash-tip, e.g :选择行业的用户占40% 
		document.getElementById('from_'+from_type+'_flash_div_'+index+'_tip').innerHTML = get_area_flash_tip(pro,json_data[pro]);
		index++;
	}                   
	//执行来源舍签切换函数
	var index = 1;
	window['from_'+from_type+'_SubShow'] = new SubShowClass("none",'onmousedown',0,'selected','');
	for(var pro in json_data){
		window['from_'+from_type+'_SubShow'].addLabel("from_"+from_type+"_menu_"+index,"from_"+from_type+"_con_"+index);
		index++;
	}
	return true;
}

/**
 * 获得统计数据参与比例提示
 * @param string item_name 分析项名称 比如 行业 地区 等
 * @param json item_data 某分析项的json数据
 * @return string
 */
function get_area_flash_tip(item_name,item_data){
	if(item_name == '地区'){//地区不显示
		return '';	
	}
	tip = "选择"+item_name +"的用户占";
	percent = '';
	if(item_data && item_data['未知'] && item_data['未知']['percent']){
		percent = parseFloat(item_data['未知']['percent']);
		percent = 100 - percent;
		percent = percent.toFixed(1);
		percent += '%';
	}else{
		percent = '100%';	
	}	
	return tip + percent;
}

/**
 * 根据json data 拼出fusioncharts的xml
 * @param string from_type 来源类型 global：整个调查的来源 答案id：某个答案的id 标识这个一个具体的答案
 * @param object/array json_data php接口返回的json数据
 * @param number index 来源项目序列 比如按地区 按学历
 * @return boolean
 */
function get_chart_xml_by_json_data(from_type, item_data, index){
	if(!from_type || !index || !item_data || (item_data.constructor==Array && item_data.length <= 0)){
		return '<chart></chart>';
	}
	xml = '';
	//用于饼图
	xml += "<chart baseFontSize='12' numberSuffix='%' showAboutMenuItem='0' decimals='1' chartTopMargin='0' chartBottomMargin='0' caption='' showValues='0' formatNumberScale='0' bgAlpha='0' logoURL='http://www.sinaimg.cn/dy/deco/2009/0903/survey/wmark_pie3.png' logoPosition='TR' startingAngle='60'>";
	
	var subindex = 1;
	for(var pro in item_data){
		//获得要显示的toolText
		var toolText = pro;
		toolText = toolText.replace(/\'/g,'');
		toolText.cn_substr(0,30,'...');
		toolText = addslashes(toolText);
		toolText += ' (' + item_data[pro].percent + '%)';
	
		/*if(subindex != 1){
			xml +="<set label='"+subindex+"' value='"+item_data[pro].amount+"' toolText='" + toolText + "' displayValue='" + toolText + "' />"; //link='javascript:selectit2(\""+from_type+"\","+index+","+subindex+")'
		}else{
			xml +="<set label='"+subindex+"' value='"+item_data[pro].amount+"' toolText='" + toolText + "' displayValue='" + toolText + "' isSliced='1' />"; //link='javascript:selectit2(\""+from_type+"\","+index+","+subindex+")'
		}
		*/
		if(subindex != 1){
			xml +="<set label='"+toolText+"' value='"+item_data[pro].amount+"' toolText='" + toolText + "' displayValue='" + toolText + "' />"; //link='javascript:selectit2(\""+from_type+"\","+index+","+subindex+")'
		}else{
			xml +="<set label='"+toolText+"' value='"+item_data[pro].amount+"' toolText='" + toolText + "' displayValue='" + toolText + "' isSliced='1' />"; //link='javascript:selectit2(\""+from_type+"\","+index+","+subindex+")'
		}
		
		subindex++;
	}	
	xml +="</chart>";
	return xml;
}

/**
 * 刷新页面
 * @param boolean bol 从服务器上加载页面吗？ true：是  false：否 默认值为false
 * @return void
 */
function window_refresh(bol){
	bol = !!bol;
	location.reload(bol);
}

//init
try{	
	$(document).ready(function(){
		//初始进度条化动画
		animateBar();
	});
}catch(e){}