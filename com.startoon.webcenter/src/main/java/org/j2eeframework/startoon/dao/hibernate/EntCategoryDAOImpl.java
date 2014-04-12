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
import org.j2eeframework.startoon.dao.IEntCategoryDAO;
import org.j2eeframework.startoon.entity.EntCategory;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EntCategoryDAOImpl extends GenericHibernateDAO<EntCategory, Long> implements IEntCategoryDAO {

	@Override
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = new EntCategoryQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		int countOfEntity = getCountOfEntity(criterions);
		return countOfEntity;
	}
	
	@Override
	public List<EntCategory> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = new EntCategoryQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		List<Order> orders = parser.getOrder(paramCondition);
		List<EntCategory> entitys = findEntityByCriteria(criterions, firstResult, pageSize, orders);
		return entitys;
	}

}

class EntCategoryQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		if(paramCondition.getParameter("enterpriseId")!=null) {
			Enterprise ent = new Enterprise();
			ent.setId(paramCondition.getLong("enterpriseId"));
			criterions.add(Restrictions.eq("enterprise", ent));
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
