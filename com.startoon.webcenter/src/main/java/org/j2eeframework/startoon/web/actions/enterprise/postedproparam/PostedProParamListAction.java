package org.j2eeframework.startoon.web.actions.enterprise.postedproparam;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.PostedProParam;
import org.j2eeframework.startoon.service.PostedProParamService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class PostedProParamListAction extends ServiceBasePaginationAction<PostedProParam, Long> {

	private static final long serialVersionUID = 2207340429603665408L;

	@Resource
	private PostedProParamService postedProParamService;
	
	@Override
	public IGenericService<PostedProParam, Long> getGenericService()	{
		return postedProParamService;
	}

	@Override
	public void preExecute() {
		
	}

}
