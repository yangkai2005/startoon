package org.j2eeframework.startoon.web.actions.enterprise.entcategory;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.EntCategory;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntCategoryService;

public class EntCategoryListAction extends ServiceBasePaginationAction<EntCategory, Long> {

	private static final long serialVersionUID = 8547820586524027786L;

	@Resource
	private EntCategoryService entCategoryService;
	
	@Override
	public IGenericService<EntCategory, Long> getGenericService()	{
		return entCategoryService;
	}

	@Override
	public void preExecute() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("enterpriseId", user.getId() + "");
	}

}
