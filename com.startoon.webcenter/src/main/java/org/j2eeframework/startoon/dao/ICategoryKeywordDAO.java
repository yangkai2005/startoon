package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.CategoryKeyword;

public interface ICategoryKeywordDAO extends IGenericDAO<CategoryKeyword, Long> {

	public void updateExpiredCategoryKeyword() throws Exception;

	
}