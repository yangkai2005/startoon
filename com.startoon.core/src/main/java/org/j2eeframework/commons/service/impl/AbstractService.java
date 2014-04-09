package org.j2eeframework.commons.service.impl;

import java.io.Serializable;
import java.util.List;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.commons.dao.LockMode;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 通用服务层的实现
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <ID>
 * @param <DAO>
 */
@Transactional
public abstract class AbstractService<T, ID extends Serializable, DAO extends IGenericDAO<T, ID>> implements IGenericService<T, ID> {

	public void delete(T entity) {
		getGenericDAO().delete(entity);
	}

	public void deleteEntityById(ID id) {
		getGenericDAO().deleteEntityById(id);

	}

	public List<T> getAllEntity() {
		return getGenericDAO().getAllEntity();
	}

	public T getEntityById(ID id) {
		return getGenericDAO().getEntityById(id);
	}

	public T getEntityById(ID id, LockMode lockMode) {
		return getGenericDAO().getEntityById(id, lockMode);
	}

	public T insert(T entity) {
		return getGenericDAO().insert(entity);
	}

	public T saveOrUpdate(T entity) {
		return getGenericDAO().saveOrUpdate(entity);
	}

	public T update(T entity) {
		return getGenericDAO().update(entity);
	}

	public void getEntitiesOfPagerByParamCondition(Pager<T> pager) {
		ParamCondition paramCondition = pager.getParamCondition();
		pager.setItems(getGenericDAO().getEntitiesByParamCondition(paramCondition, pager.getFirstResult(), pager.getPageSize()));
		pager.setCountOfTotalItem(getGenericDAO() .getCountOfEntitiesByParamCondition(paramCondition));
	}

	public abstract DAO getGenericDAO();

}
