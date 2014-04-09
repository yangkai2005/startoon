package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.SearchedKeyword;

public interface ISearchedKeywordDAO extends IGenericDAO<SearchedKeyword, Long> {
	
	public SearchedKeyword findByKeyword(String keyword);

	public int findCountByKeyword(String keyword);
	
}