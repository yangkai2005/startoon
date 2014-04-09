package org.j2eeframework.commons.dao;

import java.io.Serializable;
import java.util.List;

import org.j2eeframework.commons.pager.ParamCondition;

public interface IGenericDAO<T, ID extends Serializable> {

	/**
	 * find entity by ID<br/>
	 * 
	 * @param id
	 * @return
	 */
	public T getEntityById(ID id);

	/**
	 * find entity by ID in locked mode<br/>
	 * 
	 * @param id
	 * @param lockMode
	 * @return
	 */
	public T getEntityById(ID id, LockMode lockMode);

	/**
	 * insert a entity to database<br/>
	 * 
	 * @param entity
	 * @return
	 */
	public T insert(T entity);

	/**
	 * update the entity<br/>
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity);

	/**
	 * save or update the entity<br/>
	 * 
	 * @param entity
	 * @return
	 */
	public T saveOrUpdate(T entity);

	/**
	 * delete the entity from database<br/>
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * delete the entity from database by id<br/>
	 * 
	 * @param id
	 */
	public void deleteEntityById(ID id);

	/**
	 * find the all entity<br/>
	 * 
	 * @return
	 */
	public List<T> getAllEntity();

	/**
	 * find the entity by condition<br/>
	 * 
	 * @param paramCondition
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	public List<T> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize);

	/**
	 * find the entity count by condition<br/>
	 * 
	 * @param paramCondition
	 * @return
	 */
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition);

	/**
	 * @描述 执行修改或者删除HQL语句
	 * @author zhousp@126.com
	 * @since 2010-01-16
	 * @param hql
	 */
	public List<?> findByHql(String hql);

	/**
	 * @描述 查询SQL语句
	 * @author zhousp@126.com
	 * @since 2010-01-16
	 * @param hql
	 */
	public List<?> executeQuery(String sql);

	/**
	 * @描述 执行修改或者删除HQL语句
	 * @author tmxk307@126.com
	 * @since 2011-01-13
	 * @param sql
	 */
	public int execUpdate(String sql);
}
