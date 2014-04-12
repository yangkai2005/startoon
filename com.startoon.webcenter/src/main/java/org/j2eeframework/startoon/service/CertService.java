package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.ICertDAO;
import org.j2eeframework.startoon.entity.Cert;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class CertService extends AbstractService<Cert, Long, ICertDAO>
{
	@Resource
	private ICertDAO certDAO;

	@Override
	public ICertDAO getGenericDAO()
	{
		return certDAO;
	}
}
