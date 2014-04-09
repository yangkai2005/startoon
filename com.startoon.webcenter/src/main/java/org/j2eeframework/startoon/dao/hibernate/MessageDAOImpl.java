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
import org.j2eeframework.startoon.dao.IMessageDAO;
import org.j2eeframework.startoon.entity.Message;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class MessageDAOImpl extends GenericHibernateDAO<Message, Long> implements IMessageDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new MessageQueryParameterParser();
	}

}

class MessageQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("status")) {
			Integer status = paramCondition.getInteger("status");
			criterions.add(Restrictions.eq("status", status));
		}
		
		if(!paramCondition.isParameterNull("messageType")) {
			Integer messageType = paramCondition.getInteger("messageType");
			criterions.add(Restrictions.eq("messageType", messageType));
		}
		
		if(!paramCondition.isParameterNull("receiverId")) {
			Long receiverId = paramCondition.getLong("receiverId");
			criterions.add(Restrictions.eq("receiverId", receiverId));
		}
		
		if(!paramCondition.isParameterNull("senderId")) {
			Long senderId = paramCondition.getLong("senderId");
			criterions.add(Restrictions.eq("senderId", senderId));
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