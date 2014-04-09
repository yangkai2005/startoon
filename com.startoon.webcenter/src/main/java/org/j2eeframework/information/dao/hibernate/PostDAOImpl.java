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
import org.j2eeframework.information.dao.IPostDAO;
import org.j2eeframework.information.entity.Post;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PostDAOImpl extends GenericHibernateDAO<Post, Long> implements IPostDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new PostQueryParameterParser();
	}

}

class PostQueryParameterParser implements IQueryParameterParser {

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
		return orders;
	}
	
}