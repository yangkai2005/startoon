/*
 * 获取国家，地区
 */
function ajax_get_country_province_city_county(url,data,fn_name)
{
	$.ajax({
		type : 'get',
		url  : url,
		data : data,
		dataType : 'json',
		success  : function(jsonData,stauts){eval(fn_name+"(jsonData)")}
	});
}


/**
 * 获取国家地区
 */
function get_country(jsonData)
{
	var data = jsonData['data'];
		var option = '<option value="0"> 请选择国家、地区</option>';
		for(var i in data)
		{
			option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>";
		}
		$('#country').html(option);
}

/**
 * 获取省份
 */
function get_province(jsonData)
{
	var data = jsonData['data'];
	    
	  var option = '<option value="0"> 请选择省份</option>';
		for(var i in data)
		{
		option += "<option value="+data[i]['id']+">"+data[i]['name']+"</option>";
		}
		$('#province').html(option);
}

/**
 * 获取城市
 */
function get_city(jsonData)
{
	var data = jsonData['data'];
	 
	  var option = ' <option value="0">请选择县市</option>';
	for(var i in data)
	{
		option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>";
	}
	$('#city').html(option);
	$('#city').css("width", "100px");
}

/**
 * 获取县
 */
function get_county(jsonData)
{
	var data = jsonData['data'];
	 var option = '<option value="0">请选择城镇</option>';
	for(var i in data)
	{
		option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>";
	}
	$('#county').html(option);
	$('#county').css("width", "100px");
}

/**
 * 清除分类tag
     id1 province
     id2 city
     id3 county
 */
function clear_country_province_city_county_tag(id1,id2,id3)
{
	if(id1)
	{
		var option = '<option value="0"> 请选择省份</option>';
		$('#'+id1).html(option);
	}
	
	if(id2)
	{
		 var option = ' <option value="0">请选择县市</option>';
		$('#'+id2).html(option);
	}
	if(id2)
	{
		 var option = '<option value="0">请选择城镇</option>';
		$('#'+id3).html(option);
	}
}


