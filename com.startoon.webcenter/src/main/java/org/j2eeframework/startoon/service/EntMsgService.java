package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IEntMsgDAO;
import org.j2eeframework.startoon.entity.EntMsg;

@Service
public class EntMsgService extends AbstractService<EntMsg, Long, IEntMsgDAO>
{
	@Resource
	private IEntMsgDAO entMsgDAO;

	@Override
	public IEntMsgDAO getGenericDAO()
	{
		return entMsgDAO;
	}
}
