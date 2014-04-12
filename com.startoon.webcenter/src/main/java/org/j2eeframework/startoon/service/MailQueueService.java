package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.j2eeframework.startoon.dao.IMailQueueDAO;
import org.j2eeframework.startoon.entity.MailQueue;
import org.j2eeframework.startoon.util.email.MailSender;
import org.springframework.stereotype.Service;

@Service
public class MailQueueService extends AbstractService<MailQueue, Long, IMailQueueDAO> {
	@Resource
	private IMailQueueDAO mailQueueDAO;

	@Override
	public IMailQueueDAO getGenericDAO() {
		return mailQueueDAO;
	}

	public void send(MailQueue mail) {
		String rcvEmail = mail.getTo(),
			subject = mail.getSubject(),
			content = mail.getContent();

		MailSender.sendMail(rcvEmail, subject, content);

	}

	public void sendMail(MailQueue mail) {
		send(mail);
		delete(mail);
	}

	public void batchSend() {
		Pager<MailQueue> pager = new Pager<MailQueue>();
		pager.setPageSize(1000);

		getEntitiesOfPagerByParamCondition(pager);

		List<MailQueue> mails = pager.getItems();
		for (MailQueue mail : mails) {
			sendMail(mail);
		}

	}
	
	/**
	 * 发送指定数量的邮件
	 * @param size
	 */
	public void send(int size) {
		Pager<MailQueue> pager = new Pager<MailQueue>();
		pager.setPageSize(size);
		
		getEntitiesOfPagerByParamCondition(pager);
		
		List<MailQueue> mails = pager.getItems();
		for (MailQueue mail : mails) {
			sendMail(mail);
		}
		
	}
	
	/**
	 * 
	 */
	public void send() {
		int size = SystemConfig.BOOKING_MAIL_BATCH_SEND_COUNT;
		send(size);		
	}

}
