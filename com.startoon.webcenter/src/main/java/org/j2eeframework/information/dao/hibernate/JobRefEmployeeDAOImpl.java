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
import org.j2eeframework.information.dao.IJobRefEmployeeDAO;
import org.j2eeframework.information.entity.JobRefEmployee;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class JobRefEmployeeDAOImpl extends
		GenericHibernateDAO<JobRefEmployee, Long> implements IJobRefEmployeeDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new JobRefEmployeeQueryParameterParser();
	}

}

class JobRefEmployeeQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("enterpriseId")) {
			Long eid = cond.getLong("enterpriseId");
			criterions.add(Restrictions.eq("enterprise.id", eid));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("id"));
		return orders;
	}

}