package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.ITalentInfoDAO;
import org.j2eeframework.information.entity.TalentInfo;

@Service
public class TalentInfoService extends AbstractService<TalentInfo, Long, ITalentInfoDAO>
{
	@Resource
	private ITalentInfoDAO talentInfoDAO;

	@Override
	public ITalentInfoDAO getGenericDAO()
	{
		return talentInfoDAO;
	}
}
