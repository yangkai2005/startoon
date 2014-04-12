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
import org.j2eeframework.startoon.dao.IFavoriteDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Favorite;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class FavoriteDAOImpl extends GenericHibernateDAO<Favorite, Long> implements IFavoriteDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new FavoriteQueryParameterParser();
	}

}

class FavoriteQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("enterpriseId")) {
			Long eid = paramCondition.getLong("enterpriseId");
			Enterprise ent = new Enterprise();
			ent.setId(eid);
			criterions.add(Restrictions.eq("enterprise", ent));
		}
		
		if(!paramCondition.isParameterNull("type")) {
			Integer type = paramCondition.getInteger("type");
			criterions.add(Restrictions.eq("type", type));
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