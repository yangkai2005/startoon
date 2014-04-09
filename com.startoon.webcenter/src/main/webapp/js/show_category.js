/*
 * 获取产品分类
 */
function ajax_get_category(url,data,fn_name)
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
 * 获取一级分类
 */
function get_first_cat(jsonData)
{
	if(jsonData['errno'])
	{
		clear_select_value('second_id');
	}
	else
	{
		var data = jsonData['data'];
		var option = "<option value='0'>请选择二级分类</option>";
		for(var i in data)
		{
			option += " <option value="+data[i]['id']+">"+data[i]['cname']+"</option>"
		}
		$('#first_cat').html(option);
	}
}

/**
 * 获取二级分类
 */
function get_second_cat(jsonData)
{
	var data = jsonData['data'];
	var option = "<option value='0'>请选择三级分类</option>";
	for(var i in data)
	{
		option += " <option value="+data[i]['id']+">"+data[i]['cname']+"</option>"
	}
	$('#second_cat').html(option);
}

/* 
 * 清除分类框内容 
 */
function clear_select_value(tipId)
{
	var option = (tipId == 'first_cat') ? '<option value=0>请选择二级分类</option>' : '<option>请选择三级分类</option>';
	$("#"+tipId).html(option);
}

/**
 * 清除分类tag
 */
function clear_category_tag(id1,id2)
{
	if(id1)
	{
		$('#'+id1).html('');
	}
	
	if(id2)
	{
		$('#'+id2).html('');
	}
}


/**
 * 获取三级分类属性
 */
function ajax_get_category_attr(category_id,url)
{
	$.ajax({
		type : 'get',
		url  : url,
		data : {'category_id':category_id},
		dataType : 'json',
		success  : function(jsonData,status){
			if(!jsonData['errno'])
			{
				var data = jsonData['data'];
				var html = '';

				for(var i in data)
				{
					html += data[i];
				}
				$('#category_attr').html(html);
			}
			else
			{
				$('#category_attr').html('');
			}
		}
	});
}