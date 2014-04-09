/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($){
	$.datepicker.regional['zh-CN'] = {
		closeText: '关闭',
		prevText: '&#x3c;上月',
		nextText: '下月&#x3e;',
		currentText: '今天',
		monthNames: ['一月','二月','三月','四月','五月','六月',
		'七月','八月','九月','十月','十一月','十二月'],
		monthNamesShort: ['一','二','三','四','五','六',
		'七','八','九','十','十一','十二'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		dateFormat: 'yy-mm-dd', firstDay: 1,
		isRTL: false};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});
function isDate(str)
{
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
	if(r==null)return false; 
	var d= new Date(r[1], r[3]-1, r[4]); 
	return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}
         function getDate(str)
         {
          var ass=str.split("-");         //以"-"分割字符串，返回数组；
          var aD=new Date((ass[0]-0),(ass[1]-0)-1,(ass[2]-0));   //格式化为Date对像;
          return aD;
         }
         
         function showDate(d)
         {
         	alert(d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate());
         }