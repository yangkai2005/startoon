/**
 * 检查是否有新消息
 */

$(document).ready(function() {

	jQuery.ajax({
		type : "POST",
		url : "/ucenter/msg/check_new_msg_js.php",
		dataType : 'json',
		success : function(msg) {
			if ($("#msg_new") == null) {
				return '';
			}
			if (msg == null) {
				return '';
			}
			if (msg.errno == 0) {
				var msgdata1 = parseInt(msg['data'][1]);
				var msgdata2 = parseInt(msg['data'][2]);
				var msgdata3 = parseInt(msg['data'][3]);
				var msgdata4 = parseInt(msg['data'][4]);
				var num = msgdata1 + msgdata2 + msgdata3 + msgdata4;
				if (num > 0) {
					$("#msg_new").html("您有(" + num + ")条新消息");
					if (msgdata1 != 0)
						$("#msg_new").attr("href",
								"/ucenter/msg/private_msg.php?type=1&origin=0"
						);
					else if (msgdata2 != 0)
						$("#msg_new").attr("href",
								"/ucenter/msg/private_msg.php?type=2&origin=0"
						);
					else if (msgdata3 != 0)
						$("#msg_new").attr("href",
								"/ucenter/msg/private_msg.php?type=3"
						);
					else
						$("#msg_new").attr("href",
								"/ucenter/msg/private_msg.php?type=4"
						);
				} else {
					$("#msg_new").html("");
				}
			} else {
				$("#msg_new").html("");
			}
		},
		error : function() {
			$("#msg_new").html("");
		}
	});
	
});

/**
 * 设为首页
 */
function setMakepoloHomepage(url) { 
	if (document.all) {
		document.body.style.behavior = "url(#default#homepage)";
		document.body.setHomePage("http://china.makepolo.com");
	} else {
		if (window.sidebar) {
			if (window.netscape) {
				try {
					netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
				}
				catch (e) {
					alert("该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");
				}
			}
			var prefs = Components.classes["@mozilla.org/preferences-service;1"].getService(Components.interfaces.nsIPrefBranch);
			prefs.setCharPref("browser.startup.homepage","http://china.makepolo.com");
		}
	}
}