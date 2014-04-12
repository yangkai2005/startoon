package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IPostTypeDAO;
import org.j2eeframework.information.entity.PostType;

@Service
public class PostTypeService extends AbstractService<PostType, Long, IPostTypeDAO>
{
	@Resource
	private IPostTypeDAO postTypeDAO;

	@Override
	public IPostTypeDAO getGenericDAO()
	{
		return postTypeDAO;
	}
}
