package org.j2eeframework.startoon.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.service.IndexService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("rawtypes")
public class CategoryAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 394643436201028171L;
	private static final Log log = LogFactory.getLog(CategoryAction.class);
	
	@Resource
	private IndexService indexService;

	private List<Category> categories;
	
	private List<?> list;
	
	private String type;
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	private long categoryId;
	
	@Override
	public String execute() {
		log.debug(">>> Category.id: " + categoryId);
		log.debug("%%%%%%%%%% type: " + type);
		categories = indexService.getCategoriesForIndex(categoryId);
		if("1".equals(type)) {
			return "ent";
		}
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
