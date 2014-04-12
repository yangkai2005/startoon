package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.EnterpriseRefKeyword;

public interface IEnterpriseRefKeywordDAO extends IGenericDAO<EnterpriseRefKeyword, Long> {
	
	public void deleteByLogicKey(Long enterpriseId, Long enterpriseKeywordId);

}