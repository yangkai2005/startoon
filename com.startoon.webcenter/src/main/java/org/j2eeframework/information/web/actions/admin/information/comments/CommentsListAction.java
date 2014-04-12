package org.j2eeframework.information.web.actions.admin.information.comments;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Comments;
import org.j2eeframework.information.service.CommentsService;


public class CommentsListAction extends ServiceBasePaginationAction<Comments, Long> {

	private static final long serialVersionUID = -7531706692203043227L;

	@Resource
	private CommentsService commentsService;
	
	@Override
	public IGenericService<Comments, Long> getGenericService()	{
		return commentsService;
	}

	@Override
	public void preExecute() {
		
	}

}
