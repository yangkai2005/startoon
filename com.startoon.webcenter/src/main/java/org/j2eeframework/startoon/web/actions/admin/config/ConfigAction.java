package org.j2eeframework.startoon.web.actions.admin.config;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Config;
import org.j2eeframework.startoon.service.ConfigService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class ConfigAction extends ServiceBaseManageAction<Config,Long>
{
	private static final long serialVersionUID = 6142561471727711553L;
	@Resource
	private ConfigService configService;
	private Config config;
	@Override
	public IGenericService<Config, Long> getGenericService()
	{
		return configService;
	}

	public Config getModel()
	{
		return config;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			config = new Config();
		} else
		{
			config = configService.getEntityById(getRequestId());
		}
	}

}
