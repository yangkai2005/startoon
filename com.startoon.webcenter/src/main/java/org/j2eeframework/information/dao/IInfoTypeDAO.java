package org.j2eeframework.information.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.InfoType;

public interface IInfoTypeDAO extends IGenericDAO<InfoType, Long> {
	public List<InfoType> getInfoTypeByFatherId(Long fatherId);
}