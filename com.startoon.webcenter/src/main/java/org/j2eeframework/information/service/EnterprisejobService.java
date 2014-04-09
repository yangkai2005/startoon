package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IEnterprisejobDAO;
import org.j2eeframework.information.entity.EnterpriseJob;
import org.springframework.stereotype.Service;

@Service
public class EnterprisejobService extends
		AbstractService<EnterpriseJob, Long, IEnterprisejobDAO> {

	@Resource
	private IEnterprisejobDAO enterprisejobDAO;

	@Override
	public IEnterprisejobDAO getGenericDAO() {
		return enterprisejobDAO;
	}

}
