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
import org.j2eeframework.information.dao.IVoteDAO;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.Vote;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class VoteDAOImpl extends GenericHibernateDAO<Vote, Long> implements IVoteDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new VoteQueryParameterParser();
	}

	
	public void delete(Vote vote) {
		vote.setStatus(3);
		update(vote);
	}
	
}

class VoteQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("status")) {
			criterions.add(Restrictions.eq("status", paramCondition.getInteger("status")));
		} else {
			criterions.add(Restrictions.not(Restrictions.eq("status", 3))); //去掉删除的
		}
		
		if(!paramCondition.isParameterNull("infoId")) {
			Long infoId = paramCondition.getLong("infoId");
			Info info = new Info();
			info.setId(infoId);
			
			criterions.add(Restrictions.eq("info", info));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("id"));
		orders.add(Order.asc("status"));
		return orders;
	}
	
}