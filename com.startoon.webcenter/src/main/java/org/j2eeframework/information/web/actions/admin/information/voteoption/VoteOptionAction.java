package org.j2eeframework.information.web.actions.admin.information.voteoption;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.VoteOption;
import org.j2eeframework.information.service.VoteOptionService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class VoteOptionAction extends ServiceBaseManageAction<VoteOption,Long>
{
	private static final long serialVersionUID = 5316447723017508372L;
	@Resource
	private VoteOptionService voteOptionService;
	private VoteOption voteOption;
	@Override
	public IGenericService<VoteOption, Long> getGenericService()
	{
		return voteOptionService;
	}

	public VoteOption getModel()
	{
		return voteOption;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			voteOption = new VoteOption();
		} else
		{
			voteOption = voteOptionService.getEntityById(getRequestId());
		}
	}

}
