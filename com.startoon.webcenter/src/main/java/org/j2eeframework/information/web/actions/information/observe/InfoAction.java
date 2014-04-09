package org.j2eeframework.information.web.actions.information.observe;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoAction extends ServiceBaseManageAction<Info,Long>
{
	private static final long serialVersionUID = -931311095396859148L;
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
