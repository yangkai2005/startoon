package org.j2eeframework.startoon.web.actions.enterprise.categorykeyword;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.service.CategoryKeywordService;


public class CategoryKeywordListAction extends ServiceBasePaginationAction<CategoryKeyword, Long> {

	private static final long serialVersionUID = 4727042088902253121L;

	@Resource
	private CategoryKeywordService categoryKeywordService;
	
	@Override
	public IGenericService<CategoryKeyword, Long> getGenericService()	{
		return categoryKeywordService;
	}

	@Override
	public void preExecute() {
		
	}
	
}
