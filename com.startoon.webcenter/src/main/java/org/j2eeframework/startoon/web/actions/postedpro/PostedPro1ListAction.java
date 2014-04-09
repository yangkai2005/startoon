package org.j2eeframework.startoon.web.actions.postedpro;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.PostedProService;

public class PostedPro1ListAction extends ServiceBasePaginationAction<PostedPro, Long> {

	private static final long serialVersionUID = -8049424106504868352L;

	@Resource
	private PostedProService postedProService;
	
	@Resource
	private CategoryService categoryService;
	
	private List<Supply> supplies;
	
	private List<Category> categories;
	
	private List<Category> topCategories; //左边分类查询信息筛选条件
	
	private Category currentCategory;
	
	private int categoryCount;
	
	private List<Category> headerCategories;//顶部的分类筛选类别
	
	@Override
	public IGenericService<PostedPro, Long> getGenericService()	{
		return postedProService;
	}

	@Override
	public void preExecute() {
		/*
		 * 处理左边筛选的“分类查看信息”
		 * 
		 * 当前至少为3级分类
		 */
		String cid = getPager().getParamCondition().getParameter("categoryIdStr");
		if(cid==null) {
			cid = "0";
		}
		
		Category currentCategory = categoryService.getEntityById(new Long(cid));
		Category fatherCategory = currentCategory.getCategory();
		topCategories = categoryService.getCategoriesByFatherId(fatherCategory.getId());
		
		for(Category c : topCategories) {
			List<Category> cs = categoryService.getCategoriesByFatherId(c.getId());
			c.setCategories(cs);
		}
		
		//顶部的分类筛选
		if (currentCategory!=null && currentCategory.getId() != 0) {
			headerCategories = categoryService.getCategory4Filter(currentCategory.getId());
		}
		
	}

	@Override
	public String execute()
	{
		super.execute();
		return SUCCESS;
	}	
	
	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}

	public List<Category> getTopCategories() {
		return topCategories;
	}

	public void setTopCategories(List<Category> topCategories) {
		this.topCategories = topCategories;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public List<Category> getHeaderCategories() {
		return headerCategories;
	}

	public void setHeaderCategories(List<Category> headerCategories) {
		this.headerCategories = headerCategories;
	}

}
