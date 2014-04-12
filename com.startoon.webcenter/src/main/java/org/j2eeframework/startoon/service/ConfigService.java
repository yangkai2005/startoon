package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.startoon.dao.IConfigDAO;
import org.j2eeframework.startoon.entity.Config;

@Service
public class ConfigService extends AbstractService<Config, Long, IConfigDAO>
{
	@Resource
	private IConfigDAO configDAO;

	@Override
	public IConfigDAO getGenericDAO()
	{
		return configDAO;
	}
	/**
	 * 返回实体
	 * @param skey
	 * @return
	 * @author tandishan
	 */
	public Config getBySkey(String skey) {
		Config c=configDAO.getConfigBySkey(skey);
		if (c==null) {
			return null;
		}
		return c;
		
	}
}
