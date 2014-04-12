function initMenu() {
	$('#menu ul').hide();
	$('#menu ul:first').show();
	$('#menu li a').click(function() {
		var checkElement = $(this).next();
		if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
			return false;
		}
		if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
			$('#menu ul:visible').slideUp('fast');
			checkElement.slideDown('fast');
			return false;
		}
	});
	//高亮当前选中的菜单
	$('#menu li').find("a").click(function(){
		$('#menu li').find(".light").removeClass("light");
		$(this).parent().addClass("light");
	});
}
$(document).ready(function() {
	initMenu();
});