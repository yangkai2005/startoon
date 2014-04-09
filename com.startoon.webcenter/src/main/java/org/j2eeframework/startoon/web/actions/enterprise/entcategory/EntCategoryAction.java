package org.j2eeframework.startoon.web.actions.enterprise.entcategory;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntCategory;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EntCategoryService;

public class EntCategoryAction extends
		ServiceBaseManageAction<EntCategory, Long> {
	private static final long serialVersionUID = 3951669243753826151L;
	@Resource
	private EntCategoryService entCategoryService;
	@Resource
	private CategoryService categoryService;

	private EntCategory entCategory;

	private List<Category> categories;

	private List<Long> categoryIds;

	private boolean flag;
	
	private List<Long> ids;

	@Override
	public IGenericService<EntCategory, Long> getGenericService() {
		return entCategoryService;
	}

	public EntCategory getModel() {
		return entCategory;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			entCategory = new EntCategory();
		} else {
			entCategory = entCategoryService.getEntityById(getRequestId());
		}

		categories = categoryService.getCategoryByFatherId(0L);

	}

	public String insert() {

		if (categoryIds != null && categoryIds.size() > 0) {
			Enterprise ent = SysContext.getCurrentEnterpriserUser();
			for (Long cid : categoryIds) {
				Category c = new Category();
				c.setId(cid);

				EntCategory ec = new EntCategory();
				ec.setCategory(c);
				ec.setEnterprise(ent);

				entCategoryService.insert(ec);
			}

			flag = true;
		}

		return "input";
	}

	/**
	 * 删除数据
	 * 
	 * @return
	 */
	public String delete() {
		getGenericService().delete(getModel());
		return ResultConstants.LIST;
	}
	
	public String deleteAll() {
		for(Long id :ids) 
			getGenericService().deleteEntityById(id);
		
		return ResultConstants.LIST;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
