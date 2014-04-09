/*
 * 获取国家，地区
 */
function ajax_get_country_province_city_county1(url,data,fn_name)
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
function get_country1(jsonData)
{
	var data = jsonData['data'];
		var option = '<option value="0"> 请选择国家、地区</option>';
		for(var i in data)
		{
			option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>"
		}
		$('#country1').html(option);
}

/**
 * 获取省份
 */
function get_province1(jsonData)
{
	
	var data = jsonData['data'];
	    
	  var option = '<option value="0"> 请选择省份</option>';
		for(var i in data)
		{
		option += "<option value="+data[i]['id']+">"+data[i]['name']+"</option>"
		}
		
		$('#province1').html(option);
		
}

/**
 * 获取城市
 */
function get_city1(jsonData)
{
	var data = jsonData['data'];
	 
	  var option = ' <option value="0">请选择城市</option>';
	for(var i in data)
	{
		option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>"
	}
	$('#city1').html(option);
	$('#city1').css("width", "100px");
}

/**
 * 获取县
 */
function get_county1(jsonData)
{
	var data = jsonData['data'];
	 var option = '<option value="0">请选择县</option>';
	for(var i in data)
	{
		option += " <option value="+data[i]['id']+">"+data[i]['name']+"</option>";
	}
	$('#county1').html(option);
	$('#county1').css("width", "100px");
}

/**
 * 清除分类tag
     id1 province
     id2 city
     id3 county
 */
function clear_country_province_city_county_tag1(id1,id2,id3)
{
	if(id1)
	{
		var option = '<option value="0"> 请选择省份</option>';
		$('#'+id1).html(option);
	}
	
	if(id2)
	{
		 var option = ' <option value="0">请选择城市</option>';
		$('#'+id2).html(option);
	}
	if(id2)
	{
		 var option = '<option value="0">请选择县</option>';
		$('#'+id3).html(option);
	}
}


