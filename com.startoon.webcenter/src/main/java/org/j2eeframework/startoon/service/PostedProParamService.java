package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IPostedProParamDAO;
import org.j2eeframework.startoon.entity.PostedProParam;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class PostedProParamService extends AbstractService<PostedProParam, Long, IPostedProParamDAO>
{
	@Resource
	private IPostedProParamDAO postedProParamDAO;

	@Override
	public IPostedProParamDAO getGenericDAO()
	{
		return postedProParamDAO;
	}
}
