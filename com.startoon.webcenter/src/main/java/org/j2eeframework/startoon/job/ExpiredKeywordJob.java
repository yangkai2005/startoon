package org.j2eeframework.startoon.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.KeywordService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExpiredKeywordJob extends QuartzJobBean {

	private final static Log log = LogFactory.getLog(ExpiredKeywordJob.class);

	private KeywordService keywordService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			keywordService.updateExpiredKeyword();
		} catch (Exception e) {
			log.error("更新处理过期关键字出错：", e);
		}
		
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

}
