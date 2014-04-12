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
import org.j2eeframework.startoon.dao.IBookingDAO;
import org.j2eeframework.startoon.entity.Booking;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class BookingDAOImpl extends GenericHibernateDAO<Booking, Long> implements IBookingDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new BookingQueryParameterParser();
	}

}

class BookingQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!paramCondition.isParameterNull("enterpriseId")) {
			Long eid = paramCondition.getLong("enterpriseId");
			Enterprise ent = new Enterprise();
			ent.setId(eid);

			criterions.add(Restrictions.eq("enterprise", ent));

		}

		if (!paramCondition.isParameterNull("categoryId")) {
			Long cid = paramCondition.getLong("categoryId");
			Category c = new Category();
			c.setId(cid);
			criterions.add(Restrictions.eq("category", c));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("id"));
		return orders;
	}

}