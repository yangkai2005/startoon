package org.j2eeframework.startoon.web.actions.newstype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.News;
import org.j2eeframework.startoon.service.NewsService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class NewsAction extends ServiceBaseManageAction<News,Long>
{
	private static final long serialVersionUID = 5719362608577700711L;
	@Resource
	private NewsService newsService;
	private News news;
	@Override
	public IGenericService<News, Long> getGenericService()
	{
		return newsService;
	}

	public News getModel()
	{
		return news;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			news = new News();
		} else
		{
			news = newsService.getEntityById(getRequestId());
		}
	}

}
