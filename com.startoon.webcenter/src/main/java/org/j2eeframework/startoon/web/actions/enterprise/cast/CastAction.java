package org.j2eeframework.startoon.web.actions.enterprise.cast;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Cast;
import org.j2eeframework.startoon.service.CastService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class CastAction extends ServiceBaseManageAction<Cast,Long>
{
	private static final long serialVersionUID = -4202653267512675471L;
	@Resource
	private CastService castService;
	private Cast cast;
	@Override
	public IGenericService<Cast, Long> getGenericService()
	{
		return castService;
	}

	public Cast getModel()
	{
		return cast;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			cast = new Cast();
		} else
		{
			cast = castService.getEntityById(getRequestId());
		}
	}

}
