package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IPostDAO;
import org.j2eeframework.information.entity.Post;

@Service
public class PostService extends AbstractService<Post, Long, IPostDAO>
{
	@Resource
	private IPostDAO postDAO;

	@Override
	public IPostDAO getGenericDAO()
	{
		return postDAO;
	}
}
