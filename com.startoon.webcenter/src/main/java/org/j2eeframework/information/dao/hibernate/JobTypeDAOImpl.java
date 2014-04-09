package org.j2eeframework.information.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.information.dao.IJobTypeDAO;
import org.j2eeframework.information.entity.JobType;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class JobTypeDAOImpl extends GenericHibernateDAO<JobType, Long> implements IJobTypeDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new JobTypeQueryParameterParser();
	}

}

class JobTypeQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("lvl")) {
			int level = cond.getInteger("lvl");
			criterions.add(Restrictions.eq("lvl", level));
		}

		if (!cond.isBlank("name")) {
			String name = cond.getParameter("name");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("name", name));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {

		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.asc("pos"));
		orders.add(Order.asc("id"));

		return orders;
	}

}