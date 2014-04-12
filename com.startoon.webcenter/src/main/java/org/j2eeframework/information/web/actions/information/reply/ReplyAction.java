package org.j2eeframework.information.web.actions.information.reply;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Reply;
import org.j2eeframework.information.service.ReplyService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class ReplyAction extends ServiceBaseManageAction<Reply,Long>
{
	private static final long serialVersionUID = -6717416940084915607L;
	@Resource
	private ReplyService replyService;
	private Reply reply;
	@Override
	public IGenericService<Reply, Long> getGenericService()
	{
		return replyService;
	}

	public Reply getModel()
	{
		return reply;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			reply = new Reply();
		} else
		{
			reply = replyService.getEntityById(getRequestId());
		}
	}

}
