<%
/* *
 功能：付完款后跳转的页面（页面跳转同步通知页面）
 版本：3.1
 日期：2010-11-01
 说明：
 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 //***********页面功能说明***********
 该页面可在本机电脑测试
 该页面称作“页面跳转同步通知页面”，是由支付宝服务器同步调用，可当作是支付完成后的提示信息页，如“您的某某某订单，多少金额已支付成功”。
 可放入HTML等美化页面的代码和订单交易完成后的数据库更新程序代码
 TRADE_FINISHED(表示交易已经成功结束，为普通即时到帐的交易状态成功标识);
 TRADE_SUCCESS(表示交易已经成功结束，为高级即时到帐的交易状态成功标识);
 //********************************
 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="org.j2eeframework.startoon.service.PaymentService"%>
<%@ page import="org.j2eeframework.startoon.commons.SystemVariables"%>
<%@ page import="org.j2eeframework.commons.util.SystemContext"%>

<%@page import="org.j2eeframework.startoon.service.EnterpriseService"%>
<%@page import="org.j2eeframework.startoon.commons.SysContext"%>
<%@page import="org.j2eeframework.startoon.entity.Enterprise"%><html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>支付成功客户端返回</title>
<style type="text/css">
.font_content{
    font-family:"宋体";
    font-size:14px;
    color:#FF6600;
}
.font_title{
    font-family:"宋体";
    font-size:16px;
    color:#FF0000;
    font-weight:bold;
}
table{
    border: 1px solid #CCCCCC;
}
</style>
  </head>
  <body>
<%
	String key = AlipayConfig.key;
	//获取支付宝GET过来反馈信息
	Map params = new HashMap();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
		
		//modified by ukai on 2011-06-13
		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
		//end modify
		
		params.put(name, valueStr);
	}
	
	//判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
	//responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
	//mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
	String mysign = AlipayNotify.GetMysign(params,key);
	String responseTxt = AlipayNotify.Verify(request.getParameter("notify_id"));
	String sign = request.getParameter("sign");
	
	//写日志记录（若要调试，请取消下面两行注释）
	//String sWord = "responseTxt=" + responseTxt + "\n return_url_log:sign=" + sign + "&mysign=" + mysign + "\n return回来的参数：" + AlipayFunction.CreateLinkString(params);
	//AlipayFunction.LogResult(sWord);
	
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	String trade_no = request.getParameter("trade_no");				//支付宝交易号
	String order_no = request.getParameter("out_trade_no");	        //获取订单号
	String total_fee = request.getParameter("total_fee");	        //获取总金额
	//modified by ukai on 2011-06-13
	//String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");//商品名称、订单名称
	String subject = request.getParameter("subject");//商品名称、订单名称
	//end modify
	
	String body = "";
	if(request.getParameter("body") != null){
		//modified by ukai on 2011-06-13
		//body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");//商品描述、订单备注、描述
		body = request.getParameter("body");//商品描述、订单备注、描述
		//end modified
	}
	String buyer_email = request.getParameter("buyer_email");		//买家支付宝账号
	String trade_status = request.getParameter("trade_status");		//交易状态
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
	String verifyStatus = "";
	
	//added by ukai on 2011-06-13
	System.err.println("==>返回数据[subject:"+subject+", body:"+body+", sign:"+sign+", mysign:"+mysign+"]");
	//end added
	if(mysign.equals(sign) && responseTxt.equals("true")){
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码

		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			//更新订单付款状态 
			PaymentService payservice = (PaymentService)SystemContext.getApplicationContext().getBean("paymentService");
			int status = payservice.checkOrderStatus(order_no);
			if(status == SystemVariables.ORDER_UNPAY){//检测到未支付,更新支付状态
				payservice.updateOrderStatus(SystemVariables.ORDER_PAYED,order_no);
				//更新用户账户余额
				payservice.updateAmount(order_no);
				
				//更新当前用户信息主要是账户余额
				try{
					Enterprise ent = SysContext.getCurrentEnterpriserUser();
					EnterpriseService enterpriseService = (EnterpriseService)SystemContext.getApplicationContext().getBean("enterpriseService");
					ent = enterpriseService.getEntityById(ent.getId());
					
					SysContext.setEnterpriseUser(ent);
					request.getSession().setAttribute(SystemVariables.ENTERPRISE_USER, ent);
				} catch(Exception e) {
					
					System.err.println(e);
					
				}
			}
		}
		verifyStatus = "验证成功";
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

		//////////////////////////////////////////////////////////////////////////////////////////
	}else{
		verifyStatus = "验证失败";
	}
%>
<table align="center" width="350" cellpadding="5" cellspacing="0">
            <tr>
                <td align="center" class="font_title" colspan="2">
                    通知返回</td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    支付宝交易号：</td>
                <td class="font_content" align="left"><%=trade_no %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    订单号：</td>
                <td class="font_content" align="left"><%=order_no %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    付款总金额：</td>
                <td class="font_content" align="left"><%=total_fee %>元</td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    商品标题：</td>
                <td class="font_content" align="left"><%=subject %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    商品描述：</td>
                <td class="font_content" align="left"><%=body %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    买家账号：</td>
                <td class="font_content" align="left"><%=buyer_email %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    交易状态：</td>
                <td class="font_content" align="left"><%=trade_status %></td>
            </tr>
            <tr>
                <td class="font_content" align="right">
                    验证状态：</td>
                <td class="font_content" align="left"><%=verifyStatus %></td>
            </tr>
        </table>
  </body>
</html>
