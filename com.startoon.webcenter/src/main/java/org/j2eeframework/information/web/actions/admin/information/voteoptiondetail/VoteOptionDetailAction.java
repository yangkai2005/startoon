package org.j2eeframework.information.web.actions.admin.information.voteoptiondetail;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.VoteOptionDetail;
import org.j2eeframework.information.service.VoteOptionDetailService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class VoteOptionDetailAction extends ServiceBaseManageAction<VoteOptionDetail,Long>
{
	private static final long serialVersionUID = -6232480845755811025L;
	@Resource
	private VoteOptionDetailService voteOptionDetailService;
	private VoteOptionDetail voteOptionDetail;
	@Override
	public IGenericService<VoteOptionDetail, Long> getGenericService()
	{
		return voteOptionDetailService;
	}

	public VoteOptionDetail getModel()
	{
		return voteOptionDetail;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			voteOptionDetail = new VoteOptionDetail();
		} else
		{
			voteOptionDetail = voteOptionDetailService.getEntityById(getRequestId());
		}
	}

}
