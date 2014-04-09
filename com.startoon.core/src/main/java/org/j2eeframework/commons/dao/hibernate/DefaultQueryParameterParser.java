package org.j2eeframework.commons.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.pager.ParamCondition;

/**
 * 默认参数解释器，返回空
 * 
 * @param <T>
 */
public class DefaultQueryParameterParser implements IQueryParameterParser {

	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		ArrayList<Criterion> criterions = new ArrayList<Criterion>();
		return criterions;
	}

	public List<Order> getOrder(ParamCondition paramCondition) {
		ArrayList<Order> orders = new ArrayList<Order>();
		return orders;
	}

}
