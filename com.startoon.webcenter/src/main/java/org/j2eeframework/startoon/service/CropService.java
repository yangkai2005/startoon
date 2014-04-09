package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.ICropDAO;
import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class CropService extends AbstractService<Crop, Long, ICropDAO>
{
	@Resource
	private ICropDAO cropDAO;

	@Override
	public ICropDAO getGenericDAO()
	{
		return cropDAO;
	}
}
