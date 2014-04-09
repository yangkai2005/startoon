package org.j2eeframework.startoon.web.actions.admin.newstype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.NewsType;
import org.j2eeframework.startoon.service.NewsTypeService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class NewsTypeListAction extends ServiceBasePaginationAction<NewsType, Long> {

	private static final long serialVersionUID = 2726652477998872623L;

	@Resource
	private NewsTypeService newsTypeService;
	
	@Override
	public IGenericService<NewsType, Long> getGenericService()	{
		return newsTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
