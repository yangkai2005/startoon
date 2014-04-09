package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.j2eeframework.startoon.dao.IPostedProMessageDAO;
import org.j2eeframework.startoon.entity.PostedProMessage;
import org.j2eeframework.commons.service.impl.AbstractService;

@Service
public class PostedProMessageService extends AbstractService<PostedProMessage, Long, IPostedProMessageDAO>
{
	@Resource
	private IPostedProMessageDAO postedProMessageDAO;

	@Override
	public IPostedProMessageDAO getGenericDAO()
	{
		return postedProMessageDAO;
	}
}
