package org.j2eeframework.startoon.web.actions.admin.category;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class CategoryListAction extends ServiceBasePaginationAction<Category, Long> {

	private static final long serialVersionUID = 8084283632581500665L;

	@Resource
	private CategoryService categoryService;
	
	@Override
	public IGenericService<Category, Long> getGenericService()	{
		return categoryService;
	}

	@Override
	public void preExecute() {
		
	}

}
