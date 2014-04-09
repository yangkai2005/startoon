package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IBusinessDAO;
import org.j2eeframework.startoon.entity.Business;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class BusinessDAOImpl extends GenericHibernateDAO<Business, Long> implements IBusinessDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new BusinessQueryParameterParser();
	}
	
	public void removeByLogicId(Long enterpriseId, Long categoryId) {
		String hql = "delete from Business b where b.enterprise.id=:enterpriseId and b.category.id=:categoryId";
		Query query = getSession().createQuery(hql);
		
		query.setParameter("enterpriseId", enterpriseId);
		query.setParameter("categoryId", categoryId);
		
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Business> findByLogicId(Long enterpriseId, Long categoryId) {
		String hql = "from Business b where b.enterprise.id=:enterpriseId and b.category.id=:categoryId";
		return getSession().createQuery(hql).setParameter("enterpriseId", enterpriseId).setParameter("categoryId", categoryId).list();
	}

}

class BusinessQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("type")) {
			int type = paramCondition.getInteger("type");
			criterions.add(Restrictions.eq("type", type));
		}
		
		if(!paramCondition.isParameterNull("enterpriseId")) {
			Long enterpriseId = paramCondition.getLong("enterpriseId");
			Enterprise enterprise = new Enterprise();
			enterprise.setId(enterpriseId);
			criterions.add(Restrictions.eq("enterprise", enterprise));
		}
		
		if(!paramCondition.isParameterNull("categoryId")) {
			Long categoryId = paramCondition.getLong("categoryId");
			Category category = new Category();
			category.setId(categoryId);
			criterions.add(Restrictions.eq("category", category));
		}
		
		if(!paramCondition.isParameterNull("type")) {
			int type = paramCondition.getInteger("type");
			criterions.add(Restrictions.eq("type", type));
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