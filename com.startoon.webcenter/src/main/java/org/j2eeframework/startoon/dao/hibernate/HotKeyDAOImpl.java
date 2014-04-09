package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IHotKeyDAO;
import org.j2eeframework.startoon.entity.HotKey;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class HotKeyDAOImpl extends GenericHibernateDAO<HotKey, Long> implements IHotKeyDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new HotKeyQueryParameterParser();
	}

}

class HotKeyQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		if (!cond.isBlank("name")) {
			String name = cond.getParameter("name");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("name", name));
		}

		if (!cond.isBlank("status")) {
			criterions.add(Restrictions.eq("status", cond.getInteger("status")));

		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("orderNo"));
		orders.add(Order.desc("id"));
		return orders;
	}

}