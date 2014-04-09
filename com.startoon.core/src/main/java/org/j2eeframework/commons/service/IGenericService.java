package org.j2eeframework.commons.service;

import java.io.Serializable;
import java.util.List;

import org.j2eeframework.commons.dao.LockMode;
import org.j2eeframework.commons.pager.Pager;

/**
 * 通用服务接口
 * 
 * @author william
 * 
 */
public interface IGenericService<T, ID extends Serializable> {
	/**
	 * 通过ID查找一个实体<br>
	 * 
	 * @param id
	 * @return
	 */
	public T getEntityById(ID id);

	/**
	 * 通过ID查找一个实体,并且指定锁定模式<br>
	 * 
	 * @param id
	 * @param lockMode
	 * @return
	 * @author william
	 */
	public T getEntityById(ID id, LockMode lockMode);

	/**
	 * 纯粹保存一个实体，向数据库中插入一条记录
	 * 
	 * @author William
	 * @param entity
	 * @return
	 */
	public T insert(T entity);

	/**
	 * 纯粹更新一个实体信息，更新数据库的实体信息
	 * 
	 * @author William
	 * @param entity
	 * @return
	 */
	public T update(T entity);

	/**
	 * 更新或保存一个实体
	 * 
	 * @author William
	 * @param entity
	 * @return
	 */
	public T saveOrUpdate(T entity);

	/**
	 * 删除实体
	 * 
	 * @author William
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 通过实体ID删除一个实体
	 * 
	 * @author William
	 * @param id
	 */
	public void deleteEntityById(ID id);

	/**
	 * 查找所有实体
	 * 
	 * @author William
	 * @return
	 */
	public List<T> getAllEntity();

	/**
	 * 根据参数条件分页取得实体
	 * 
	 * @param pager
	 * @author william
	 */
	public void getEntitiesOfPagerByParamCondition(Pager<T> pager);
}
