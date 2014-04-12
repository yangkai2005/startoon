package org.j2eeframework.startoon.web.actions.link;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Link;
import org.j2eeframework.startoon.service.LinkService;

public class LinkAction extends ServiceBaseManageAction<Link,Long>
{
	private static final long serialVersionUID = -117187218978444038L;
	@Resource
	private LinkService linkService;
	private Link link;
	@Override
	public IGenericService<Link, Long> getGenericService()
	{
		return linkService;
	}

	public Link getModel()
	{
		return link;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			link = new Link();
		} else
		{
			link = linkService.getEntityById(getRequestId());
		}
		
	}

}
