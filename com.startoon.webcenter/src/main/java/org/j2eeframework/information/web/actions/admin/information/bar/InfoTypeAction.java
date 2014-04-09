package org.j2eeframework.information.web.actions.admin.information.bar;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class InfoTypeAction extends ServiceBaseManageAction<InfoType,Long>
{
	private static final long serialVersionUID = 1547770127940378250L;
	@Resource
	private InfoTypeService infoTypeService;
	private InfoType infoType;
	@Override
	public IGenericService<InfoType, Long> getGenericService()
	{
		return infoTypeService;
	}

	public InfoType getModel()
	{
		return infoType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			infoType = new InfoType();
		} else
		{
			infoType = infoTypeService.getEntityById(getRequestId());
		}
	}

}
