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
import org.j2eeframework.startoon.dao.IEnterpriseCategoryKeywordDAO;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseCategoryKeyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EnterpriseCategoryKeywordDAOImpl extends GenericHibernateDAO<EnterpriseCategoryKeyword, Long> implements IEnterpriseCategoryKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new EnterpriseCategoryKeywordQueryParameterParser();
	}

	@SuppressWarnings("unchecked")
	@Override
	public EnterpriseCategoryKeyword findByCategoryKeywordIdId(Long categoryKeywordId, Long enterpriseId) {
		
		Criteria cri = getSession().createCriteria(EnterpriseCategoryKeyword.class);
		CategoryKeyword ck = new CategoryKeyword();
		ck.setId(categoryKeywordId);
		
		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		
		cri.add(Restrictions.eq("categoryKeyword", ck));
		cri.add(Restrictions.eq("enterprise", enterprise));
		
		List<EnterpriseCategoryKeyword> list = cri.list();
		
		if(list!=null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

}

class EnterpriseCategoryKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isBlank("enterpriseId")) {
			Long eid = paramCondition.getLong("enterpriseId");
			Enterprise enterprise = new Enterprise();
			enterprise.setId(eid);
			criterions.add(Restrictions.eq("enterprise", enterprise));
		}
		
		if(!paramCondition.isBlank("flag")) {
			criterions.add(Restrictions.gt("useLimit", 0));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		
		return orders;
	}
	
}