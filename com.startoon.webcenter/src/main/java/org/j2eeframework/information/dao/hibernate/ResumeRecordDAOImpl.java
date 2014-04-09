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
import org.j2eeframework.information.dao.IResumeRecordDAO;
import org.j2eeframework.information.entity.ResumeRecord;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class ResumeRecordDAOImpl extends GenericHibernateDAO<ResumeRecord, Long> implements IResumeRecordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new ResumeRecordQueryParameterParser();
	}

}

class ResumeRecordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("creatorId")) {
			Long creatorId = cond.getLong("creatorId");
			criterions.add(Restrictions.eq("creator.id", creatorId));
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