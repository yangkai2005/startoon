package org.j2eeframework.startoon.dao.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.dao.ICastDAO;
import org.j2eeframework.startoon.entity.Cast;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CastDAOImpl extends GenericHibernateDAO<Cast, Long> implements ICastDAO {
	
	private static final Log log = LogFactory.getLog(CastDAOImpl.class);

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new CastQueryParameterParser();
	}
	
	@SuppressWarnings("unchecked")
	public Double cuputeCast(Long enterpriseId, Date stime, Date etime) {
		
		String hql = "select new map(sum(amount) as amount) from Cast where ctime>:stime and ctime<:etime and enterprise=:enterprise ";
		Query qry = getSession().createQuery(hql);
		
		Enterprise enterprise = new Enterprise();
		enterprise.setId(enterpriseId);
		
		qry.setParameter("stime", stime);
		qry.setParameter("etime", etime);
		qry.setParameter("enterprise", enterprise);
		
		Map map = (Map) qry.uniqueResult();
		
		Double amount = (Double)map.get("amount");
		
		return amount;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cast> getCastByParamCondition(ParamCondition condition, int firstResult, int pageSize) {
		String sql = buildSQL(condition, firstResult, pageSize, false);
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(Cast.class);
		List<Cast> payments = query.list();
		log.debug(sql);
		return payments;
	}
	

	public int getCountOfCast(ParamCondition condition) {
		String sql = buildSQL(condition, 0, 0, true);
		
		SQLQuery query = getSession().createSQLQuery(sql);
		Object count = query.uniqueResult();
		
		int n = ((BigInteger)count).intValue();
		
		log.debug(sql);
		
		return n;
		
	}
	
	private String buildSQL(ParamCondition paramCondition, int offset, int pageSize, boolean isCount) {
		
		StringBuffer sql = new StringBuffer();
		
		if(isCount) {
			sql.append(" select count(*) as c ");
		} else {
			sql.append(" select * ");
		}
		
		sql.append(" from t_cast p left join enterprise e on p.enterprise_id=e.id ");
		sql.append(" where 1=1 ");
		
		if(!paramCondition.isParameterNull("enterpriseId")) {
			Long cid = paramCondition.getLong("enterpriseId");
			sql.append(" and p.enterprise_id=");
			sql.append(cid);
		}
		
		if(!paramCondition.isBlank("account")) {
			String account = paramCondition.getParameter("account");
			account = "%" + account + "%";
			sql.append(" and e.account like ");
			sql.append("'");
			sql.append(account);
			sql.append("'");
		}
		
		if(!paramCondition.isBlank("name")) {
			String name = paramCondition.getParameter("name");
			name = "%" + name + "%";
			
			sql.append(" and e.name like ");
			sql.append("'");
			sql.append(name);
			sql.append("'");
		}
		
		if(!paramCondition.isBlank("stime")) {
			Date stime = paramCondition.getDate("stime");
			sql.append(" and p.ctime> ");
			sql.append("'");
			sql.append(DateUtil.formatDateTime(stime));
			sql.append("'");
		}
		
		if(!paramCondition.isBlank("etime")) {
			Date etime = paramCondition.getDate("etime");
			sql.append(" and p.ctime<=");
			sql.append("'");
			sql.append(DateUtil.formatDateTime(etime));
			sql.append("'");
		}
		
		
		if(!isCount) {
			sql.append(" order by p.id desc ");
			sql.append(" limit " + offset + ", " + pageSize);
		}
		
		return sql.toString();
	}

	

}

class CastQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isBlank("enterpriseId")) {
			Long enterpriseId = paramCondition.getLong("enterpriseId");
			Enterprise enterprise = new Enterprise();
			enterprise.setId(enterpriseId);
			criterions.add(Restrictions.eq("enterprise", enterprise));
		}
		
		if(!paramCondition.isBlank("account")) {
			String account = paramCondition.getParameter("account");
			account = "%" + account + "%";
			criterions.add(Restrictions.like("enterprise.account", account));
		}

		if(!paramCondition.isBlank("name")) {
			String name = paramCondition.getParameter("name");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("enterprise.name", name));
		}
		
		if(!paramCondition.isBlank("stime")) {
			Date stime = paramCondition.getDate("stime");
			criterions.add(Restrictions.gt("ctime", stime));
		}
		
		if(!paramCondition.isBlank("etime")) {
			Date etime = paramCondition.getDate("etime");
			criterions.add(Restrictions.lt("ctime", etime));
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