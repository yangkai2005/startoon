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
import org.j2eeframework.information.dao.IReplyDAO;
import org.j2eeframework.information.entity.Reply;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class ReplyDAOImpl extends GenericHibernateDAO<Reply, Long> implements IReplyDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new ReplyQueryParameterParser();
	}

}

class ReplyQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("status")) {
			Integer s = paramCondition.getInteger("status");
			
			if(s==-1) {
				
			} else {
				
				criterions.add(Restrictions.eq("status", s));
			}
		} else {
			criterions.add(Restrictions.eq("status", 2));
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