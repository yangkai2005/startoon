package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IFavoriteDAO;
import org.j2eeframework.startoon.entity.Favorite;

@Service
public class FavoriteService extends AbstractService<Favorite, Long, IFavoriteDAO>
{
	@Resource
	private IFavoriteDAO favoriteDAO;

	@Override
	public IFavoriteDAO getGenericDAO()
	{
		return favoriteDAO;
	}
}
