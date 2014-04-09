package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IMailQueueDAO;
import org.j2eeframework.startoon.entity.MailQueue;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class MailQueueDAOImpl extends GenericHibernateDAO<MailQueue, Long> implements IMailQueueDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new MailQueueQueryParameterParser();
	}

}

class MailQueueQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}
	
}