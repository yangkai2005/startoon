package org.j2eeframework.startoon.dao;

import java.util.Date;
import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.startoon.entity.Cast;

public interface ICastDAO extends IGenericDAO<Cast, Long> {
	
	public Double cuputeCast(Long enterpriseId, Date stime, Date etime);

	public List<Cast> getCastByParamCondition(ParamCondition condition, int firstResult, int pageSize);
	
	public int getCountOfCast(ParamCondition condition);

}