package org.j2eeframework.startoon.web.actions.admin.newstype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.NewsType;
import org.j2eeframework.startoon.service.NewsTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class NewsTypeAction extends ServiceBaseManageAction<NewsType,Long>
{
	private static final long serialVersionUID = 419071335217297019L;
	@Resource
	private NewsTypeService newsTypeService;
	private NewsType newsType;
	@Override
	public IGenericService<NewsType, Long> getGenericService()
	{
		return newsTypeService;
	}

	public NewsType getModel()
	{
		return newsType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			newsType = new NewsType();
		} else
		{
			newsType = newsTypeService.getEntityById(getRequestId());
		}
	}

}
