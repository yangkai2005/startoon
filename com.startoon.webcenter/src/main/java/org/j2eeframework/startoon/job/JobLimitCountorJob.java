/**
 * @Title: ExampleJob.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author yangkai_2005@163.com
 * @date 2011-8-23 下午03:40:36 
 * @version V1.0
 */
package org.j2eeframework.startoon.job;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.information.service.HrLimitService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author kai
 * 
 */
public class JobLimitCountorJob extends QuartzJobBean {

	private static final Log log = LogFactory.getLog(JobLimitCountorJob.class);

	private HrLimitService hrLimitService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		log.debug("开始调度：" + DateUtil.formatDateTime(new Date()));

		hrLimitService.updateHrLimit();

		log.debug("结束调度：" + DateUtil.formatDateTime(new Date()));
	}

	public void setHrLimitService(HrLimitService hrLimitService) {
		this.hrLimitService = hrLimitService;
	}

}
