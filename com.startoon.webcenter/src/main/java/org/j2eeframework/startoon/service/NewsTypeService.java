package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.INewsTypeDAO;
import org.j2eeframework.startoon.entity.NewsType;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class NewsTypeService extends AbstractService<NewsType, Long, INewsTypeDAO>
{
	@Resource
	private INewsTypeDAO newsTypeDAO;

	@Override
	public INewsTypeDAO getGenericDAO()
	{
		return newsTypeDAO;
	}
}
