package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.startoon.entity.SupplyImg;

public interface ISupplyImgDAO extends IGenericDAO<SupplyImg, Long> {
	public List<SupplyImg> getSupplyImgBySupplyId(Long supplyId);
}