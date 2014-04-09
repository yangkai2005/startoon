function confirmDel()
{
	if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？"))
	{
		return true;
	}
	return false;
}

function chg(id_num){
	var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
    var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block") {
    	oa.style.display = "none";
    	imgButton.src = "<%=request.getContextPath() %>/resources/images/icon_down.gif";
    	imgButton.alt = "展开搜索";
    } else {
    	oa.style.display = "block";
    	imgButton.src = "<%=request.getContextPath() %>/resources/images/icon_up.gif";
    	imgButton.alt = "隐藏搜索";
    }
    return false;
}