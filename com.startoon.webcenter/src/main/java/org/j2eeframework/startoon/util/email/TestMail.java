package org.j2eeframework.startoon.util.email;


public class TestMail {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MailInfo mailinfo=new MailInfo();
		//--设置邮件服务器开始
		mailinfo.setMailServerHost("smtp.chnam.com");
		mailinfo.setMailServerPort("25");
		mailinfo.setValidate(true);
		mailinfo.setUserName("business@chnam.com");
		mailinfo.setPassword("yjdy2010");
		//--设置邮件服务器结束
		mailinfo.setFromAddress("business@chnam.com");//邮件发送者的地址
		mailinfo.setFromNickname("星力网");
		//设置接受用户
		String []ToAddress={"460000982@qq.com"};
		mailinfo.setToAddress(ToAddress);
		//设置附件
		//String []attach={"F:\\login.properties"};
		//mailinfo.setAttachFileNames(attach);
		mailinfo.setSubject("-----邮件测试----");
		mailinfo.setContent("<a href='#'>hiao的和</a>");//网页内容
		SendMail sm=new SendMail();
		if(sm.sendAttach(mailinfo))
			System.out.println("邮件发送成功");
		else
			System.out.println("邮件发送失败");
		
	}

}


