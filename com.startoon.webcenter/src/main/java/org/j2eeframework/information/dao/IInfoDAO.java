package org.j2eeframework.information.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.Info;

public interface IInfoDAO extends IGenericDAO<Info, Long> {
	
	public Info getPreInfo(Info info);
	
	public Info getNextInfo(Info info);

}