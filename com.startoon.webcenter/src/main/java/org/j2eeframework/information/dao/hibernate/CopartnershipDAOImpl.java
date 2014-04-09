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
import org.j2eeframework.information.dao.ICopartnershipDAO;
import org.j2eeframework.information.entity.Copartnership;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CopartnershipDAOImpl extends GenericHibernateDAO<Copartnership, Long> implements ICopartnershipDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new CopartnershipQueryParameterParser();
	}

}

class CopartnershipQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {

		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!paramCondition.isParameterNull("position")) {
			int position = paramCondition.getInteger("position");
			criterions.add(Restrictions.eq("position", position));
		}

		if (!paramCondition.isBlank("infoTypeId")) {
			Long infoTypeId = paramCondition.getLong("infoTypeId");
			criterions.add(Restrictions.eq("infoTypeId", infoTypeId));
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