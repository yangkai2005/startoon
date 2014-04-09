package org.j2eeframework.startoon.web.actions.enterprise.clickedkeyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.ClickedKeywordService;


public class ClickedKeywordListAction extends ServiceBasePaginationAction<ClickedKeyword, Long> {

	private static final long serialVersionUID = 4270917920646536878L;

	@Resource
	private ClickedKeywordService clickedKeywordService;
	
	@Override
	public IGenericService<ClickedKeyword, Long> getGenericService()	{
		return clickedKeywordService;
	}

	@Override
	public void preExecute() {
		
		Pager<ClickedKeyword> pager = getPager();
		ParamCondition paramCondition = pager.getParamCondition();

		Enterprise user = SysContext.getCurrentEnterpriserUser();
		
		paramCondition.addParameter("enterpriseId", user.getId() + "");

	}

}
