package org.j2eeframework.startoon.web.actions.admin.linktype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.LinkType;
import org.j2eeframework.startoon.service.LinkTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class LinkTypeAction extends ServiceBaseManageAction<LinkType,Long>
{
	private static final long serialVersionUID = -4249798512877319065L;
	@Resource
	private LinkTypeService linkTypeService;
	private LinkType linkType;
	@Override
	public IGenericService<LinkType, Long> getGenericService()
	{
		return linkTypeService;
	}

	public LinkType getModel()
	{
		return linkType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			linkType = new LinkType();
		} else
		{
			linkType = linkTypeService.getEntityById(getRequestId());
		}
	}

}
