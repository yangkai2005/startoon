package org.j2eeframework.startoon.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.EntProduce;

public interface IEntProduceDAO extends IGenericDAO<EntProduce, Long> {

	public EntProduce getEntProduceByLogicKey(Long enterpriseId, Long categoryId);
	
}