package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IEnterpriseRefKeywordDAO;
import org.j2eeframework.startoon.entity.EnterpriseRefKeyword;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseRefKeywordService extends AbstractService<EnterpriseRefKeyword, Long, IEnterpriseRefKeywordDAO>
{
	@Resource
	private IEnterpriseRefKeywordDAO enterpriseRefKeywordDAO;

	@Override
	public IEnterpriseRefKeywordDAO getGenericDAO()
	{
		return enterpriseRefKeywordDAO;
	}

	public void deleteByLogicKey(Long enterpriseId, Long enterpriseKeywordId) {
		getGenericDAO().deleteByLogicKey(enterpriseId, enterpriseKeywordId);
	}
	
	
}
