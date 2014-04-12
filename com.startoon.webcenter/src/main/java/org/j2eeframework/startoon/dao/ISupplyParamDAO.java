package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.SupplyParam;

public interface ISupplyParamDAO extends IGenericDAO<SupplyParam, Long> {

	List<SupplyParam> getSupplyParamBySupplyId(Long supplyId);

	void deleteBySupplyId(Long id);

	List<SupplyParam> getSupplyParamByCategoryAttrId(Long categoryAttrId);

	List<SupplyParam> getSupplyParamByCategoryId(Long categoryId);

}