package org.j2eeframework.startoon.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class EntLibraryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8973882161817677905L;
	
	@Resource
	private CategoryService categoryService;

	@Resource
	private EnterpriseService enterpriseService;
	
	private List<Category> categories;
	
	@Override
	public String execute() {
		
		categories = categoryService.getCategoriesByFatherId(0L);

		Pager<Enterprise> pager = new Pager<Enterprise>();
		pager.setPageSize(3);
		
		for(Category c : categories) {
			Long categoryId = c.getId();
			pager.getParamCondition().addParameter("businessIds", categoryId + "");
			enterpriseService.getEntitiesOfPagerByParamCondition(pager);
			List<Enterprise> enterprises = pager.getItems();
			c.setEnterprises(enterprises);
		}
		
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	
}
