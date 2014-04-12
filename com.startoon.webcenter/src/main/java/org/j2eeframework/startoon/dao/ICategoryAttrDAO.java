package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.CategoryAttr;

public interface ICategoryAttrDAO extends IGenericDAO<CategoryAttr, Long> {

	List<CategoryAttr> getCategoryAttrByCategoryId(long categoryId);

}