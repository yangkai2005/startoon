package org.j2eeframework.startoon.web.actions.admin.category;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

public class CategorySortListAction extends ActionSupport {
	
	private static final long serialVersionUID = -1275582708763253044L;
	
	private static final Log log = LogFactory.getLog(CategorySortListAction.class);
	
	@Resource
	private CategoryService categoryService;
	private List<Category> categories;
	
	private Long fatherId;
	
	public String execute() {
		categories = categoryService.getCategoryByFatherId(fatherId);
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Long getFatherId() {
		return fatherId;
	}

	public void setFatherId(Long fatherId) {
		this.fatherId = fatherId;
	}
	

}
