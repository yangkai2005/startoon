package org.j2eeframework.startoon.web.actions.category;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

public class CategoryAction extends ServiceBaseManageAction<Category, Long> {
	private static final long serialVersionUID = -1071113265793687574L;
	@Resource
	private CategoryService categoryService;
	private Category category;

	@Override
	public IGenericService<Category, Long> getGenericService() {
		return categoryService;
	}

	public Category getModel() {
		return category;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			category = new Category();
		} else {
			category = categoryService.getEntityById(getRequestId());
		}
	}

	public String tree() {

		return "tree";
	}

}
