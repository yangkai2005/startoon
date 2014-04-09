var tipid = '';
var previewid = '';
var imgid = '';
function uploadpic(fileElementId,image_id,type){
	tipid = $('#'+fileElementId+'Tip');
	previewid = $('#preview_'+fileElementId);
	imgid = $('#'+fileElementId+'_id');
	$('#del_'+fileElementId).val('0');


	tipid.html('<img src="http://jic.b2b.makepolo.com/img/wait.gif">上传中......');
	$.ajaxFileUpload
	(
		{
			url:'/misc/image/image_upload_tmp_p.php?image_id=' + image_id +'&type=' + type,
			secureuri:false,
			fileElementId:fileElementId,
			dataType: 'json',
			success: doResponse_p,
			error: function (data, status, e)
			{
				tipid.css('color','red').html('上传失败');
			}
		}
	);
	return false;
}

/**
 *	imgid: file框id
 *	type: 类型
 *	tag: 0 提交后物理删除, 1 点删除按钮直接删除
 */
function deletepic(imgid,type,tag)
{
	var image_value = $('#'+imgid+'_id').val();
	if(image_value == '') return false;
	var param = {'image_id':image_value, 'type':type};

	if(tag)
	{
		$.ajax({
		   type: "POST",
		   url: "/misc/image/image_d.php",
		   data: param,
		   success: function(msg){
		     	$('#'+imgid+'Tip').css('color','green').html('删除成功');
			   	$('#preview_'+imgid).attr('src','http://jic.b2b.makepolo.com/img/none.jpg');
				$('#'+imgid+'_id').val('');
		   },
		   error: function (data, status, e)
			{
				$('#'+imgid).css('color','red').html('删除失败');
			}
		});
	}
	else
	{
		$('#del_'+imgid).val('1');
		$('#preview_'+imgid).attr('src','http://jic.b2b.makepolo.com/img/none.jpg');
		$('#'+imgid+'Tip').css('color','green').html('删除成功');
	}
}
function doResponse_p(jsonArr, status){
	switch (jsonArr['errno']) {
		case 0:
			tipid.css('color','green').html('上传成功');
			PADshowDIV();
			var image_url = jsonArr['param']['image_url'];
			var show_image = jsonArr['param']['image_id'];
			image_url += '?' + Math.random();
			previewid.attr('src',image_url);
			imgid.val(show_image);
			break;
		case 1:
			var msg = jsonArr['msg'];
			if(msg != null)
			{
				switch (msg) {
				case 'err_file_ext':
					tipid.css('color','red').html('图片格式错误');
					break;
				case 'err_size':
					tipid.css('color','red').html('图片大小超过限制');
					break;
				default:
					alert(MSG['upload'][msg]);
					break;
				}
			}
			break;
		default:
			break;
	}
}

