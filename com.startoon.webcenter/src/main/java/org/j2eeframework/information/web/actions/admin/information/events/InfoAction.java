package org.j2eeframework.information.web.actions.admin.information.events;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class InfoAction extends ServiceBaseManageAction<Info,Long>
{
	private static final long serialVersionUID = 6331539449706714936L;
	@Resource
	private InfoService infoService;
	private Info info;
	@Override
	public IGenericService<Info, Long> getGenericService()
	{
		return infoService;
	}

	public Info getModel()
	{
		return info;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			info = new Info();
		} else
		{
			info = infoService.getEntityById(getRequestId());
		}
	}

}
