package org.j2eeframework.startoon.web.actions.category;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.SupplyService;

public class CategoryListAction extends ServiceBasePaginationAction<Category, Long> {

	private static final long serialVersionUID = 4987487735631695904L;

	@Resource
	private CategoryService categoryService;
	
	@Resource
	private SupplyService supplyService;
	
	private List<Supply> supplies;
	
	private Category category;
	
	private String type;
	
	@Override
	public IGenericService<Category, Long> getGenericService()	{
		return categoryService;
	}

	@Override
	public void preExecute() {
		
	}
	
	public String execute() {
		
		String categoryId = getPager().getParamCondition().getParameter("categoryId");
		Long cid = new Long(categoryId);
		category = categoryService.getEntityById(cid);
		
		List<Category> categories = categoryService.getCategoryByFatherId(new Long(categoryId));
		
		Pager<Supply> supplyPager = new Pager<Supply>();
		supplyPager.setPageSize(10);
		supplyService.getEntitiesOfPagerByParamCondition(supplyPager);
		supplies = supplyPager.getItems();
		
		for(Category category : categories) {
			Long id = category.getId();
			List<Category> subCategories = categoryService.getCategoryByFatherId(id);
			category.setCategories(subCategories);
		}
		
		getPager().setItems(categories);
		
		type = getPager().getParamCondition().getParameter("t");
		
		if("1".equals(type)) {
			return "ent";
		}
		
		return SUCCESS;
		
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
