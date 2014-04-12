package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.Supply;

public interface ISupplyDAO extends IGenericDAO<Supply, Long> {

	void deleteById(Long id);


}