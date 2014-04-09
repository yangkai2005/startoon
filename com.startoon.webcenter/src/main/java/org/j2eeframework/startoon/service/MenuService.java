package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IMenuDAO;
import org.j2eeframework.startoon.entity.Menu;

@Service
public class MenuService extends AbstractService<Menu, Long, IMenuDAO>
{
	@Resource
	private IMenuDAO menuDAO;

	@Override
	public IMenuDAO getGenericDAO()
	{
		return menuDAO;
	}
}
