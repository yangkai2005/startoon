package org.j2eeframework.startoon.web.actions.admin.ptags;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.service.PTagsService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class PTagsAction extends ServiceBaseManageAction<PTags,Long>
{
	private static final long serialVersionUID = -3986732027855427144L;
	@Resource
	private PTagsService pTagsService;
	private PTags pTags;
	@Override
	public IGenericService<PTags, Long> getGenericService()
	{
		return pTagsService;
	}

	public PTags getModel()
	{
		return pTags;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			pTags = new PTags();
		} else
		{
			pTags = pTagsService.getEntityById(getRequestId());
		}
	}

}
