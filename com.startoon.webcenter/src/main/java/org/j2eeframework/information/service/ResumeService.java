package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IResumeDAO;
import org.j2eeframework.information.entity.Resume;

@Service
public class ResumeService extends AbstractService<Resume, Long, IResumeDAO>
{
	@Resource
	private IResumeDAO resumeDAO;

	@Override
	public IResumeDAO getGenericDAO()
	{
		return resumeDAO;
	}
}
