package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IPublishPriceDAO;
import org.j2eeframework.startoon.entity.PublishPrice;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class PublishPriceService extends AbstractService<PublishPrice, Long, IPublishPriceDAO>
{
	@Resource
	private IPublishPriceDAO publishPriceDAO;

	@Override
	public IPublishPriceDAO getGenericDAO()
	{
		return publishPriceDAO;
	}
}
