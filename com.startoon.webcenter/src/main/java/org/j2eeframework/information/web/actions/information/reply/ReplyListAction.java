package org.j2eeframework.information.web.actions.information.reply;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Reply;
import org.j2eeframework.information.service.ReplyService;


public class ReplyListAction extends ServiceBasePaginationAction<Reply, Long> {

	private static final long serialVersionUID = -2507982760909334349L;

	@Resource
	private ReplyService replyService;
	
	@Override
	public IGenericService<Reply, Long> getGenericService()	{
		return replyService;
	}

	@Override
	public void preExecute() {
		
	}

}
