package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.Business;

public interface IBusinessDAO extends IGenericDAO<Business, Long> {

	public void removeByLogicId(Long enterpriseId, Long categoryId);
	
	public List<Business> findByLogicId(Long enterpriseId, Long categoryId);
	
}