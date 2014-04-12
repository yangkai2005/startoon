package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IMsgRecordDAO;
import org.j2eeframework.startoon.entity.MsgRecord;

@Service
public class MsgRecordService extends AbstractService<MsgRecord, Long, IMsgRecordDAO>
{
	@Resource
	private IMsgRecordDAO msgRecordDAO;

	@Override
	public IMsgRecordDAO getGenericDAO()
	{
		return msgRecordDAO;
	}
}
