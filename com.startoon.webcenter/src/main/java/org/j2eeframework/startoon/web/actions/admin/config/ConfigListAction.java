package org.j2eeframework.startoon.web.actions.admin.config;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Config;
import org.j2eeframework.startoon.service.ConfigService;


public class ConfigListAction extends ServiceBasePaginationAction<Config, Long> {

	private static final long serialVersionUID = 4559774749637320154L;

	@Resource
	private ConfigService configService;
	
	@Override
	public IGenericService<Config, Long> getGenericService()	{
		return configService;
	}

	@Override
	public void preExecute() {
		
	}

}
