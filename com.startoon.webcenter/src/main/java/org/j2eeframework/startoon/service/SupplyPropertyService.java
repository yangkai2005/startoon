package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.ISupplyPropertyDAO;
import org.j2eeframework.startoon.entity.SupplyProperty;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class SupplyPropertyService extends AbstractService<SupplyProperty, Long, ISupplyPropertyDAO>
{
	@Resource
	private ISupplyPropertyDAO supplyPropertyDAO;

	@Override
	public ISupplyPropertyDAO getGenericDAO()
	{
		return supplyPropertyDAO;
	}
}
