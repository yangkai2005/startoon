package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IResumeRecordDAO;
import org.j2eeframework.information.entity.ResumeRecord;

@Service
public class ResumeRecordService extends AbstractService<ResumeRecord, Long, IResumeRecordDAO>
{
	@Resource
	private IResumeRecordDAO resumeRecordDAO;

	@Override
	public IResumeRecordDAO getGenericDAO()
	{
		return resumeRecordDAO;
	}
}
