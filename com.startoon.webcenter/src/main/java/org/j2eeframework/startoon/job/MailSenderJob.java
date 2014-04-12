package org.j2eeframework.startoon.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.MailQueueService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MailSenderJob extends QuartzJobBean {

	private final static Log log = LogFactory.getLog(MailSenderJob.class);

	private MailQueueService mailQueueService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			mailQueueService.send();
		} catch (Exception e) {
			log.error("调度发送邮件出错：", e);
		}
	}

	public void setMailQueueService(MailQueueService mailQueueService) {
		this.mailQueueService = mailQueueService;
	}

}
