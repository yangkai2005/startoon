package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IHelpclassDAO;
import org.j2eeframework.startoon.entity.Helpclass;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class HelpclassService extends AbstractService<Helpclass, Long, IHelpclassDAO>
{
	@Resource
	private IHelpclassDAO helpclassDAO;

	@Override
	public IHelpclassDAO getGenericDAO()
	{
		return helpclassDAO;
	}
}
