package org.j2eeframework.startoon.web.actions.newstype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.News;
import org.j2eeframework.startoon.service.NewsService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class NewsListAction extends ServiceBasePaginationAction<News, Long> {

	private static final long serialVersionUID = -774357971068253243L;

	@Resource
	private NewsService newsService;
	
	@Override
	public IGenericService<News, Long> getGenericService()	{
		return newsService;
	}

	@Override
	public void preExecute() {
		
	}

}
