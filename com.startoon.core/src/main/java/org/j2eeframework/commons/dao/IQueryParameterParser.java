package org.j2eeframework.commons.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.j2eeframework.commons.pager.ParamCondition;

/**
 * 查询参数解释器接口（Hibernate版本）
 * 
 * @author william
 * 
 */
public interface IQueryParameterParser {

	/**
	 * 根据分页对象中的查询参数解释出相应的Criterion
	 * 
	 * @param pager
	 * @return
	 * @author william
	 */
	public List<Criterion> getCriterions(ParamCondition paramCondition);

	/**
	 * 根据分页对象中的相关参数解释出相关的排序方式
	 * 
	 * @param pager
	 * @return
	 * @author william
	 */
	public List<Order> getOrder(ParamCondition paramCondition);
}
