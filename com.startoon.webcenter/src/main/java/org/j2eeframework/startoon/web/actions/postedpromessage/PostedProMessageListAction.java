package org.j2eeframework.startoon.web.actions.postedpromessage;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.PostedProMessage;
import org.j2eeframework.startoon.service.PostedProMessageService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class PostedProMessageListAction extends ServiceBasePaginationAction<PostedProMessage, Long> {

	private static final long serialVersionUID = -4411961962888699793L;

	@Resource
	private PostedProMessageService postedProMessageService;
	
	@Override
	public IGenericService<PostedProMessage, Long> getGenericService()	{
		return postedProMessageService;
	}

	@Override
	public void preExecute() {
		
	}

}
