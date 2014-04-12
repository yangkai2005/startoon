package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ISupplyParamDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SupplyParamDAOImpl extends GenericHibernateDAO<SupplyParam, Long> implements ISupplyParamDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplyParam> getSupplyParamBySupplyId(Long supplyId) {
		Criteria cri = getSession().createCriteria(SupplyParam.class);
		Supply supply = new Supply();
		supply.setId(supplyId);
		cri.add(Restrictions.eq("supply", supply));
		
		return cri.list();
		
	}

	@Override
	public void deleteBySupplyId(Long supplyId) {
		
		Supply supply = new Supply();
		supply.setId(supplyId);
		
		Query qry = getSession().createQuery(" delete SupplyParam p where supply=:supply ");
		qry.setParameter("supply", supply);
		qry.executeUpdate();
		
	}
	
	@Override
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = new SupplyParamQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		int countOfEntity = getCountOfEntity(criterions);
		return countOfEntity;
	}
	
	@Override
	public List<SupplyParam> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = new SupplyParamQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		List<Order> orders = parser.getOrder(paramCondition);
		List<SupplyParam> entitys = findEntityByCriteria(criterions, firstResult, pageSize, orders);
		return entitys;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplyParam> getSupplyParamByCategoryAttrId(Long categoryAttrId) {
		
		Criteria cri = getSession().createCriteria(SupplyParam.class);
		
		CategoryAttr attr = new CategoryAttr();
		attr.setId(categoryAttrId);
		cri.add(Restrictions.eq("categoryAttr", attr));
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplyParam> getSupplyParamByCategoryId(Long categoryId) {
		Criteria cri = getSession().createCriteria(SupplyParam.class);
		
		Category category = new Category();
		
		category.setId(categoryId);
		cri.add(Restrictions.eq("categoryId", categoryId));
		return cri.list();
	}
}

class SupplyParamQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(paramCondition.getParameter("categoryAttrId")!=null) {
			CategoryAttr categoryAttr = new CategoryAttr();
			categoryAttr.setId(paramCondition.getLong("categoryAttrId"));
			criterions.add(Restrictions.eq("categoryAttr", categoryAttr));
		}
		
		return criterions;
		
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("id"));
		return orders;
	}
	
}