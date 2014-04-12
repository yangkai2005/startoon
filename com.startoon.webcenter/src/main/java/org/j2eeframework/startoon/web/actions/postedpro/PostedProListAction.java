package org.j2eeframework.startoon.web.actions.postedpro;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.PostedProService;
import org.j2eeframework.startoon.service.SupplyService;

public class PostedProListAction extends ServiceBasePaginationAction<PostedPro, Long> {

	private static final long serialVersionUID = -8049424106504868352L;

	@Resource
	private PostedProService postedProService;
	
	@Resource
	private SupplyService supplyService;
	
	@Resource
	private CategoryService categoryService;
	
	private List<Supply> supplies;
	
	private List<Category> categories;
	
	private int categoryCount;
	
	@Override
	public IGenericService<PostedPro, Long> getGenericService()	{
		return postedProService;
	}

	@Override
	public void preExecute() {
		Pager<Supply> supplyPager = new Pager<Supply>();
		supplyPager.setPageSize(12);
		supplyService.getEntitiesOfPagerByParamCondition(supplyPager);
		supplies = supplyPager.getItems();
		
		categories = categoryService.getCategoriesByFatherId(0L);
		if(categories!=null) {
			categoryCount = categories.size();
		}
		
	}

	@Override
	public String execute()
	{
		getPager().setPageSize(20);
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

}
