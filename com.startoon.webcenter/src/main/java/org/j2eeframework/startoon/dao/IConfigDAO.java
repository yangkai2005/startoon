package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.Config;

public interface IConfigDAO extends IGenericDAO<Config, Long> {
	Config getConfigBySkey(String skey);

}