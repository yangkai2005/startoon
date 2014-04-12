/**
 * 转发至微博
 * @param {string} _title 当前调查标题
 * @return void
 */
function sent_to_vb(_title){
	_channelUrl = 'http:\/\/'+location.host+'/';
	if(typeof _title == 'undefined' || _title == ''){
		_title = document.title;	
	}
	_url = location.href.replace('?f=1&','?');
	_url = _url.replace('?f=1','');
	//alert(_channelUrl + '\n' + _title + '\n' + _url );
	
	(function(s,d,e,r,l,p,t,z,c){
				var f='http://v.t.sina.com.cn/share/share.php?',u=z||d.location,p=['url=',e(u),'&title=',e(t||d.title),'&source=',e(r),'&sourceUrl=',e(l),'&content=',c||'gb2312','&pic=',e(p||'')].join('');function a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(s.width-440)/2,',top=',(s.height-430)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else a();})(screen,document,encodeURIComponent,'新浪-调查',_channelUrl,'',_title,_url,'gb2312');			
}