package org.j2eeframework.startoon.dao;

import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.startoon.entity.Enterprise;

public interface IEnterpriseDAO extends IGenericDAO<Enterprise, Long> {

	public Enterprise getEnterpriseByAccount(String account);

	/**
	 * 关键词搜索
	 * @param condition
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> search(ParamCondition condition, int offset, int pageSize);

	public int count(ParamCondition condition);

	/**
	 * 查询所有的ID
	 * @return
	 */
	public List<Long> getAllId();

}