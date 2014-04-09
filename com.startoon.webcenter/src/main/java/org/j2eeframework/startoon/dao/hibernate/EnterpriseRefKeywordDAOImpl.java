package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IEnterpriseRefKeywordDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.EnterpriseRefKeyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EnterpriseRefKeywordDAOImpl extends GenericHibernateDAO<EnterpriseRefKeyword, Long> implements IEnterpriseRefKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new EnterpriseRefKeywordQueryParameterParser();
	}
	
	public void deleteByLogicKey(Long enterpriseId, Long enterpriseKeywordId) {

		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		EnterpriseKeyword enterpriseKeyword = new EnterpriseKeyword();
		enterpriseKeyword.setId(enterpriseKeywordId);
		
		String hql = "delete EnterpriseRefKeyword p where p.enterprise=:enterprise and p.enterpriseKeyword=:enterpriseKeyword";
		Query query = getSession().createQuery(hql);
		query.setParameter("enterprise", enterprise);
		query.setParameter("enterpriseKeyword", enterpriseKeyword);
		query.executeUpdate();		
	}

}

class EnterpriseRefKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}
	
}