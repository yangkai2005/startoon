package org.j2eeframework.startoon.dao.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.dao.IPaymentDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Payment;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PaymentDAOImpl extends GenericHibernateDAO<Payment, Long> implements IPaymentDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new PaymentQueryParameterParser();
	}
	
	public Payment getOrderById(String orderid) {
		Criteria cri = getSession().createCriteria(Payment.class);
		cri.add(Restrictions.eq("orderid", orderid));
		Payment u = (Payment) cri.uniqueResult();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> getPaymentByParamCondition(ParamCondition condition, int firstResult, int pageSize) {
		String sql = buildSQL(condition, firstResult, pageSize, false);
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(Payment.class);
		List<Payment> payments = query.list();
		
		return payments;
	}
	

	public int getCountOfPayment(ParamCondition condition) {
		String sql = buildSQL(condition, 0, 0, true);
		
		SQLQuery query = getSession().createSQLQuery(sql);
		Object count = query.uniqueResult();
		
		int n = ((BigInteger)count).intValue();
		
		return n;
		
	}
	
	private String buildSQL(ParamCondition paramCondition, int offset, int pageSize, boolean isCount) {
		
		StringBuffer sql = new StringBuffer();
		
		if(isCount) {
			sql.append(" select count(*) as c ");
		} else {
			sql.append(" select * ");
		}
		
		sql.append(" from t_payment p left join enterprise e on p.enterprise_id=e.id ");
		sql.append(" where 1=1 ");
		
		if(!paramCondition.isParameterNull("creatorId")) {
			Long cid = paramCondition.getLong("creatorId");
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
			sql.append(" and p.ordertime> ");
			sql.append("'");
			sql.append(DateUtil.formatDateTime(stime));
			sql.append("'");
		}
		
		if(!paramCondition.isBlank("etime")) {
			Date etime = paramCondition.getDate("etime");
			sql.append(" and p.ordertime<=");
			sql.append("'");
			sql.append(DateUtil.formatDateTime(etime));
			sql.append("'");
		}
		
		if(!paramCondition.isBlank("status")) {
			int status = paramCondition.getInteger("status");
			sql.append(" and p.status=");
			sql.append(status);
		}
		
		if(!paramCondition.isBlank("type")) {
			int type = paramCondition.getInteger("type");
			sql.append(" and p.type=");
			sql.append(type);
		}
		
		
		if(!isCount) {
			sql.append(" order by p.id desc ");
			sql.append(" limit " + offset + ", " + pageSize);
		}
		
		return sql.toString();
	}
	
}

class PaymentQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("creatorId")) {
			Long cid = paramCondition.getLong("creatorId");
			Enterprise creator = new Enterprise();
			creator.setId(cid);
			
			criterions.add(Restrictions.eq("creator", creator));
		}
		
		if(!paramCondition.isBlank("account")) {
			String account = paramCondition.getParameter("account");
			account = "%" + account + "%";
			criterions.add(Restrictions.like("creator.account", account));
		}

		if(!paramCondition.isBlank("name")) {
			String name = paramCondition.getParameter("name");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("creator.name", name));
		}
		
		if(!paramCondition.isBlank("stime")) {
			Date stime = paramCondition.getDate("stime");
			criterions.add(Restrictions.gt("ordertime", stime));
		}
		
		if(!paramCondition.isBlank("etime")) {
			Date etime = paramCondition.getDate("etime");
			criterions.add(Restrictions.lt("ordertime", etime));
		}

		if(!paramCondition.isBlank("status")) {
			int status = paramCondition.getInteger("status");
			criterions.add(Restrictions.eq("status", status));
		}
		
		if(!paramCondition.isBlank("type")) {
			int type = paramCondition.getInteger("type");
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