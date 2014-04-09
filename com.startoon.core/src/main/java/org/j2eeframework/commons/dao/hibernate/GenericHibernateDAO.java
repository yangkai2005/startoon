package org.j2eeframework.commons.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.LockMode;
import org.j2eeframework.commons.pager.ParamCondition;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Administrator
 * 
 * @param <T>
 * @param <ID>
 */
public class GenericHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport implements IGenericDAO<T, ID> {

	private Class<T> persistentClass; // 实体Class类

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T getEntityById(ID id) {
		return getHibernateTemplate().get(persistentClass, id);
	}

	public T getEntityById(ID id, LockMode lockMode) {
		return getHibernateTemplate().get(persistentClass, id,
				org.hibernate.LockMode.parse(lockMode.toString()));
	}

	public T insert(T entity) {
		getHibernateTemplate().save(entity);
		return entity;
	}

	public T update(T entity) {
		getHibernateTemplate().update(entity);
		return entity;
	}

	public T saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public void deleteEntityById(ID id) {
		T entity = getEntityById(id);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllEntity() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		List<T> items = crit.list();
		return items;
	}

	/**
	 * Hibernate 版本的QBC方便分页查询方法
	 * 
	 * @param criterions
	 *            查询条件List集合
	 * @param firstResult
	 *            第一条记录号
	 * @param pageSize
	 *            每页大小
	 * @param orders
	 *            排序
	 * @return
	 */
	protected List<T> findEntityByCriteria(List<Criterion> criterions, int firstResult, int pageSize, Order... orders) {
		List<Order> ordList = getOrders(orders);
		return findEntityByCriteria(criterions, firstResult, pageSize, ordList);
	}

	/**
	 * Hibernate 版本的QBC方便分页查询方法
	 * 
	 * @param criterions
	 *            查询条件List集合
	 * @param firstResult
	 *            第一条记录号
	 * @param pageSize
	 *            每页大小
	 * @param orders
	 *            排序
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findEntityByCriteria(List<Criterion> criterions, int firstResult, int pageSize, List<Order> orders) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		if (criterions != null) {
			for (Criterion c : criterions) {
				crit.add(c);
			}
		}

		crit.setFirstResult(firstResult);
		crit.setMaxResults(pageSize);

		if (orders != null) {
			for (Order order : orders) {
				crit.addOrder(order);
			}
		}

		return crit.list();
	}

	/**
	 * 构建查询条件
	 * 
	 * @return
	 */
	protected IQueryParameterParser buildQueryParameterParser() {
		return new DefaultQueryParameterParser();
	}

	/**
	 * Hibernate 版本的根据参数取得实体数量
	 * 
	 * @see com.zitop.infrastructure.dao.IGenericDAO#getCountOfEntitiesByParamCondition(com.jee.commons.pager.infrastructure.util.ParamCondition)
	 */
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = buildQueryParameterParser();
		// 通过参数解释器解释出相应的查询条件
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		// 查询出总对象数
		int countOfEntity = getCountOfEntity(criterions);

		return countOfEntity;
	}

	/**
	 * Hibernate 版本的根据参数取得实体
	 * 
	 * @see com.zitop.infrastructure.dao.IGenericDAO#getEntitiesByParamCondition(com.jee.commons.pager.infrastructure.util.ParamCondition,
	 *      int, int)
	 */
	public List<T> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = buildQueryParameterParser();
		// 通过参数解释器解释出相应的查询条件
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		// 通过参数解释器解释出排序方式
		List<Order> orders = parser.getOrder(paramCondition);
		// 查询出相应的实体对象
		List<T> entitys = findEntityByCriteria(criterions, firstResult,
				pageSize, orders);
		return entitys;
	}

	/**
	 * Hibernate 版本的QBC方便取得记录总数方法。
	 * 
	 * @param criterions
	 *            查询条件List集合
	 * @return
	 */
	protected int getCountOfEntity(List<Criterion> criterions) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		if (criterions != null) {
			for (Criterion c : criterions) {
				crit.add(c);
			}
		}
		int entryCount = (Integer) crit.setProjection(Projections.rowCount())
				.uniqueResult();
		return entryCount;
	}

	/**
	 * Hibernate 版本的QBC方便查询方法
	 * 
	 * @param criterions
	 *            查询条件List集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findEntityByCriteria(List<Criterion> criterions, List<Order> orders) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		if (criterions != null) {
			for (Criterion c : criterions) {
				crit.add(c);
			}
		}
		if (orders != null) {
			for (Order order : orders) {
				crit.addOrder(order);
			}
		}
		return crit.list();
	}

	/**
	 * 将查询条件(不定参数)转换成List
	 * 
	 * @param criterions
	 * @return
	 */
	protected List<Criterion> getCriterions(Criterion... criterions) {
		List<Criterion> list = new ArrayList<Criterion>();
		if (criterions != null) {
			for (Criterion c : criterions) {
				list.add(c);
			}
		}
		return list;
	}

	/**
	 * 将排序对象转换成List
	 * 
	 * @param criterions
	 * @return
	 */
	protected List<Order> getOrders(Order... orders) {
		List<Order> list = new ArrayList<Order>();
		if (orders != null) {
			for (Order o : orders) {
				list.add(o);
			}
		}
		return list;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @描述 执行修改或者删除HQL语句
	 * @author zhousp@126.com
	 * @since 2010-01-16
	 * @param hql
	 */
	public int executeUpdate(String hql) {
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}

	/**
	 * @描述 执行修改或者删除HQL语句
	 * @author zhousp@126.com
	 * @since 2010-01-16
	 * @param hql
	 */
	public List<?> findByHql(String hql) {
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	/**
	 * @描述 查询SQL语句
	 * @author zhousp@126.com
	 * @since 2010-01-16
	 * @param hql
	 */
	public List<?> executeQuery(String sql) {
		SQLQuery query = getSession().createSQLQuery(sql);
		return query.list();
	}

	/**
	 * @描述 执行修改或者删除HQL语句
	 * @author tmxk307@126.com
	 * @since 2011-01-13
	 * @param sql
	 */
	public int execUpdate(String sql) {
		SQLQuery query = getSession().createSQLQuery(sql);
		return query.executeUpdate();
	}

}
