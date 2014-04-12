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
import org.j2eeframework.startoon.dao.IConfigDAO;
import org.j2eeframework.startoon.entity.Config;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public  class ConfigDAOImpl extends GenericHibernateDAO<Config, Long> implements IConfigDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new ConfigQueryParameterParser();
	}

	/**
	 * 返回实体
	 */
	@Override
	public Config getConfigBySkey(String skey) {
		String hql="from Config c where c.skey=:skey";
		Query qry=getSession().createQuery(hql);
		qry.setParameter("skey", skey);
		Config c=(Config)qry.uniqueResult();
		
		return c;
	}

}

class ConfigQueryParameterParser implements IQueryParameterParser {

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