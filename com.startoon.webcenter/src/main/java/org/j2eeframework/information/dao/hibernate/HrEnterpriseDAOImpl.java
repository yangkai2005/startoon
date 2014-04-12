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
import org.j2eeframework.information.dao.IHrEnterpriseDAO;
import org.j2eeframework.information.entity.HrEnterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class HrEnterpriseDAOImpl extends GenericHibernateDAO<HrEnterprise, Long> implements IHrEnterpriseDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new HrEnterpriseQueryParameterParser();
	}

}

class HrEnterpriseQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("type")) {
			int type = cond.getInteger("type");
			if (-1 != type) {
				criterions.add(Restrictions.eq("type", type));
			}
		} else {
			criterions.add(Restrictions.eq("type", 0));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.asc("type"));
		orders.add(Order.desc("orderNo"));
		orders.add(Order.asc("id"));

		return orders;
	}

}