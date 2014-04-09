package org.j2eeframework.startoon.job;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.service.BookingService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class BookingEmailGernatorJob extends QuartzJobBean {

	private final static Log log = LogFactory.getLog(BookingEmailGernatorJob.class);

	private BookingService bookingService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		try {
			Date end = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -7);
			Date start = calendar.getTime();
			log.info("<<<开始生成订阅邮件[" + DateUtil.formatDateTime(start) + " - " + DateUtil.formatDateTime(end) + "]>>>");
			bookingService.gernateEmail(start, end);
			log.info("<<<生成订阅邮件结束>>>");
		} catch (Exception e) {
			log.error("调度生成订阅邮件出错：", e);
		}
	}

	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

}
