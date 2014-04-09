package org.j2eeframework.startoon.web.actions.enterprise.enterprisecategorykeyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseCategoryKeyword;
import org.j2eeframework.startoon.service.EnterpriseCategoryKeywordService;


public class EnterpriseCategoryKeywordListAction extends ServiceBasePaginationAction<EnterpriseCategoryKeyword, Long> {

	private static final long serialVersionUID = 3528430248171472025L;

	@Resource
	private EnterpriseCategoryKeywordService enterpriseCategoryKeywordService;
	
	@Override
	public IGenericService<EnterpriseCategoryKeyword, Long> getGenericService()	{
		return enterpriseCategoryKeywordService;
	}

	@Override
	public void preExecute() {
		Enterprise enterprise = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("enterpriseId", enterprise.getId() + "");
	}
	
	@Override
	public String execute() {

		String flag = getPager().getParamCondition().getParameter("flag");
		
		super.execute();
		
		if(flag!=null && flag.equals("1")) {
			return "select";
		}
		
		return SUCCESS;
		
	}

}
