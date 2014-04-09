package org.j2eeframework.startoon.web.actions.enterprise.enterprisekeyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.service.EnterpriseKeywordService;


public class EnterpriseKeywordListAction extends ServiceBasePaginationAction<EnterpriseKeyword, Long> {

	private static final long serialVersionUID = 7837056397203481371L;

	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	
	@Override
	public IGenericService<EnterpriseKeyword, Long> getGenericService()	{
		return enterpriseKeywordService;
	}

	@Override
	public void preExecute() {
		
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("enterpriseId", user.getId() + "");
		
	}
	

}
