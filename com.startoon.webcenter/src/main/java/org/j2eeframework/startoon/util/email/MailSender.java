package org.j2eeframework.startoon.util.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.commons.SystemConfig;

public class MailSender {
	
	private static final Log log = LogFactory.getLog(MailSender.class);
	
	public static void sendMail(String email, String content) {
		sendMail(email,SystemConfig.MAIL_SUBJECT, content);
	}
	
	@SuppressWarnings("static-access")
	public static void sendMail(String rcvEmail, String subject, String content) {
		//发送验证码到邮箱
		MailInfo mailinfo=new MailInfo();
		//--设置邮件服务器开始
		mailinfo.setMailServerHost(SystemConfig.MAIL_SERVER_HOST);
		mailinfo.setMailServerPort(SystemConfig.MAIL_SERVER_PORT);
		mailinfo.setValidate(SystemConfig.MAIL_SERVER_VALIDATE);
		mailinfo.setUserName(SystemConfig.MAIL_SERVER_USERNAME);
		mailinfo.setPassword(SystemConfig.MAIL_SERVER_PASSWORD);
		//--设置邮件服务器结束
		mailinfo.setFromAddress(SystemConfig.MAIL_SERVER_FROM);//邮件发送者的地址
		mailinfo.setFromNickname(SystemConfig.MAIL_SERVER_ALIAS); //邮件发送者的别名
		//设置接受用户
		String []ToAddress={rcvEmail};
		mailinfo.setToAddress(ToAddress);
		mailinfo.setSubject(subject);
		mailinfo.setContent(content);//网页内容
		SendMail sm = new SendMail();
		if(sm.sendAttach(mailinfo))
			log.warn("邮件发送成功");
		else
			log.warn("邮件发送失败");
	}
}
