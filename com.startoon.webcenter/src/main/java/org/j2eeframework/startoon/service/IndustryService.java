package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IIndustryDAO;
import org.j2eeframework.startoon.entity.Industry;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class IndustryService extends AbstractService<Industry, Long, IIndustryDAO>
{
	@Resource
	private IIndustryDAO industryDAO;

	@Override
	public IIndustryDAO getGenericDAO()
	{
		return industryDAO;
	}
}
