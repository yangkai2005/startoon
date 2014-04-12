package org.j2eeframework.startoon.web.actions.inc;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryLeftAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626323695742160663L;
	
	@Resource
	private CategoryService categoryService;
	
	private List<Category> categories;
	
	@Override
	public String execute() {
		
		categories = categoryService.getCategoriesByFatherId(0L);
		
		for(Category c : categories) {
			Long id = c.getId();
			List<Category> sub = categoryService.getCategoryByFatherId(id, 6);
			c.setCategories(sub);
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
