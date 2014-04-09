package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;

public interface IEnterpriseKeywordDAO extends IGenericDAO<EnterpriseKeyword, Long> {

	public List<EnterpriseKeyword> getEnterpriseKeywordByKeywordId(Long keywordId);
	
	public EnterpriseKeyword findEntKey(Long enterpriseId, Long keywordId);
	
}