package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IAskPriceDAO;
import org.j2eeframework.startoon.entity.AskPrice;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class AskPriceService extends AbstractService<AskPrice, Long, IAskPriceDAO>
{
	@Resource
	private IAskPriceDAO askPriceDAO;

	@Override
	public IAskPriceDAO getGenericDAO()
	{
		return askPriceDAO;
	}
}
