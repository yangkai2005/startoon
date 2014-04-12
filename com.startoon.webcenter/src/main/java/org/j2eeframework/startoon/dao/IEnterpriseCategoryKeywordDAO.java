package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.EnterpriseCategoryKeyword;

public interface IEnterpriseCategoryKeywordDAO extends IGenericDAO<EnterpriseCategoryKeyword, Long> {

	public EnterpriseCategoryKeyword findByCategoryKeywordIdId(Long categoryKeywordId, Long enterpriseId);

}