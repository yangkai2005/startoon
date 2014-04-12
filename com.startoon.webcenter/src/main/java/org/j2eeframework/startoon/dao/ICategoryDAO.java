package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.Category;

public interface ICategoryDAO extends IGenericDAO<Category, Long> {
	
	public List<Category> getCategoriesByFatherId(Long fatherCategoryId);
	
	public List<Category> getCategoryByFatherId(Long fatherCategoryId);

	public List<Category> getCategoryByLevel(int level);

}