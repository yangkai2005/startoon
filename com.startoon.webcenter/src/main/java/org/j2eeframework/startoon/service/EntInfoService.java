package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IEntInfoDAO;
import org.j2eeframework.startoon.entity.EntInfo;
import org.springframework.stereotype.Service;

@Service
public class EntInfoService extends AbstractService<EntInfo, Long, IEntInfoDAO>
{
	@Resource
	private IEntInfoDAO entInfoDAO;

	@Override
	public IEntInfoDAO getGenericDAO()
	{
		return entInfoDAO;
	}

	public EntInfo getEntInfoByEnterpriseId(Long enterpriseId) {
		return entInfoDAO.getEntInfoByEnterpriseId(enterpriseId);
	}
}
