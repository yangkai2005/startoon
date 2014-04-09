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
import org.j2eeframework.startoon.dao.IEnterpriseKeywordDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.Keyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EnterpriseKeywordDAOImpl extends GenericHibernateDAO<EnterpriseKeyword, Long> implements IEnterpriseKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new EnterpriseKeywordQueryParameterParser();
	}
	
	@SuppressWarnings("unchecked")
	public List<EnterpriseKeyword> getEnterpriseKeywordByKeywordId(Long keywordId) {
		Keyword keyword = new Keyword();
		keyword.setId(keywordId);
		Criteria cri = getSession().createCriteria(EnterpriseKeyword.class);
		cri.add(Restrictions.eq("keyword", keyword));
		return cri.list();
	}
	
	@SuppressWarnings("unchecked")
	public EnterpriseKeyword findEntKey(Long enterpriseId, Long keywordId) {
		Keyword keyword = new Keyword();
		keyword.setId(keywordId);
		
		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		
		Criteria cri = getSession().createCriteria(EnterpriseKeyword.class);
		cri.add(Restrictions.eq("keyword", keyword));
		cri.add(Restrictions.eq("enterprise", enterprise));
		
		List<EnterpriseKeyword> list = cri.list();
		
		if(list!=null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}

}

class EnterpriseKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isBlank("enterpriseId")) {
			Long enterpriseId = paramCondition.getLong("enterpriseId");
			Enterprise ent = new Enterprise();
			ent.setId(enterpriseId);
			criterions.add(Restrictions.eq("enterprise", ent));
		}
		
		if(!paramCondition.isBlank("usedLimit")) {
			criterions.add(Restrictions.gt("usedLimit", 0));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}
	
}