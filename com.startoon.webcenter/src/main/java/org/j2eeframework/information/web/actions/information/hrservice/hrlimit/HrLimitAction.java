package org.j2eeframework.information.web.actions.information.hrservice.hrlimit;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class HrLimitAction extends ServiceBaseManageAction<HrLimit,Long>
{
	private static final long serialVersionUID = -8598568936854252875L;
	@Resource
	private HrLimitService hrLimitService;
	private HrLimit hrLimit;
	@Override
	public IGenericService<HrLimit, Long> getGenericService()
	{
		return hrLimitService;
	}

	public HrLimit getModel()
	{
		return hrLimit;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			hrLimit = new HrLimit();
		} else
		{
			hrLimit = hrLimitService.getEntityById(getRequestId());
		}
	}

}
