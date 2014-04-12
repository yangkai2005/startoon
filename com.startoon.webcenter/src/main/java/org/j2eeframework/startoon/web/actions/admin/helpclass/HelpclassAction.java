package org.j2eeframework.startoon.web.actions.admin.helpclass;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Helpclass;
import org.j2eeframework.startoon.service.HelpclassService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class HelpclassAction extends ServiceBaseManageAction<Helpclass,Long>
{
	private static final long serialVersionUID = 6800025394792378607L;
	@Resource
	private HelpclassService helpclassService;
	private Helpclass helpclass;
	@Override
	public IGenericService<Helpclass, Long> getGenericService()
	{
		return helpclassService;
	}

	public Helpclass getModel()
	{
		return helpclass;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			helpclass = new Helpclass();
		} else
		{
			helpclass = helpclassService.getEntityById(getRequestId());
		}
	}

}
