package org.j2eeframework.startoon.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.service.CategoryKeywordService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExpiredCategoryKeywordJob extends QuartzJobBean {

	private final static Log log = LogFactory.getLog(ExpiredCategoryKeywordJob.class);

	private CategoryKeywordService categoryKeywordService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		try {
			categoryKeywordService.updateExpiredCategoryKeyword();
		} catch (Exception e) {
			log.error("更新处理过期类别关键词出错：", e);
		}		
	}

	public void setCategoryKeywordService(CategoryKeywordService categoryKeywordService) {
		this.categoryKeywordService = categoryKeywordService;
	}

}
