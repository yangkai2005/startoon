package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IEntInfoDAO;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EntInfoDAOImpl extends GenericHibernateDAO<EntInfo, Long> implements IEntInfoDAO {

	@Override
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = new EntInfoQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		int countOfEntity = getCountOfEntity(criterions);
		return countOfEntity;
	}
	
	@Override
	public List<EntInfo> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = new EntInfoQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		List<Order> orders = parser.getOrder(paramCondition);
		List<EntInfo> entitys = findEntityByCriteria(criterions, firstResult, pageSize, orders);
		return entitys;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EntInfo getEntInfoByEnterpriseId(Long enterpriseId) {
		
		Criteria cri = getSession().createCriteria(EntInfo.class);
		
		Enterprise ent = new Enterprise();
		ent.setId(enterpriseId);
		
		cri.add(Restrictions.eq("enterprise", ent));
		
		List<EntInfo> list = cri.list();
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}

class EntInfoQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("enterpriseId")) {
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