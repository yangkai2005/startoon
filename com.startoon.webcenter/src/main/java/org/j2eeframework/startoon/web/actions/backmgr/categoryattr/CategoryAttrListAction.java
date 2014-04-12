package org.j2eeframework.startoon.web.actions.backmgr.categoryattr;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.service.AttrTypeService;
import org.j2eeframework.startoon.service.CategoryAttrService;
import org.j2eeframework.startoon.service.CategoryService;

public class CategoryAttrListAction extends
		ServiceBasePaginationAction<CategoryAttr, Long> {

	private static final long serialVersionUID = 8084283632581500665L;
	
	@Resource
	private AttrTypeService attrTypeService;
	
	private String cid;// 分类ID
	private String cname;// 分类名称
	private Category category;
	private List<AttrType> attrTypes;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Resource
	private CategoryAttrService categoryAttrService;

	@Resource
	private CategoryService categoryService;

	@Override
	public IGenericService<CategoryAttr, Long> getGenericService() {
		return categoryAttrService;
	}

	public IGenericService<Category, Long> getGenericCateService() {
		return categoryService;
	}

	@Override
	public void preExecute() {
		category = categoryService.getEntityById(new Long(cid));
		cname = category.getName();
		attrTypes = attrTypeService.getAllEntity();
	}

	public List<AttrType> getAttrTypes() {
		return attrTypes;
	}

	public void setAttrTypes(List<AttrType> attrTypes) {
		this.attrTypes = attrTypes;
	}

}
