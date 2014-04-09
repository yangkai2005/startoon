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
import org.j2eeframework.startoon.dao.ILinkTypeDAO;
import org.j2eeframework.startoon.entity.LinkType;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class LinkTypeDAOImpl extends GenericHibernateDAO<LinkType, Long> implements ILinkTypeDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new LinkTypeQueryParameterParser();
	}

}

class LinkTypeQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (cond.isNotBlank("pid")) {
			Long pid = cond.getLong("pid");
			criterions.add(Restrictions.eq("parent.id", pid));
		}
		if (cond.isNotBlank("lvl")) {
			criterions.add(Restrictions.eq("lvl", cond.getInteger("lvl")));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.asc("orderNo"));
		orders.add(Order.asc("id"));

		return orders;
	}

}