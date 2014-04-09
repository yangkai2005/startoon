package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.INewsDAO;
import org.j2eeframework.startoon.entity.News;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class NewsService extends AbstractService<News, Long, INewsDAO>
{
	@Resource
	private INewsDAO newsDAO;

	@Override
	public INewsDAO getGenericDAO()
	{
		return newsDAO;
	}
}
