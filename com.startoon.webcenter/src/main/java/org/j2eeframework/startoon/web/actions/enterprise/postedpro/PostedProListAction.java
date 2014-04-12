package org.j2eeframework.startoon.web.actions.enterprise.postedpro;

import javax.annotation.Resource;

import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.service.PostedProService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class PostedProListAction extends ServiceBasePaginationAction<PostedPro, Long> {

	private static final long serialVersionUID = 5609864110566448198L;

	@Resource
	private PostedProService postedProService;
	
	@Override
	public IGenericService<PostedPro, Long> getGenericService()	{
		return postedProService;
	}

	@Override
	public void preExecute() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", enterpriseId + "");
	}

}
