package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.Keyword;

public interface IKeywordDAO extends IGenericDAO<Keyword, Long> {

	Keyword getKeywordByKey(String keyword);
	
	public void updateExpiredKeyword() throws Exception;

}