package org.j2eeframework.information.dao.hibernate;

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
import org.j2eeframework.information.dao.ISubjectDAO;
import org.j2eeframework.information.entity.Subject;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SubjectDAOImpl extends GenericHibernateDAO<Subject, Long> implements ISubjectDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new SubjectQueryParameterParser();
	}

	public int updateStatus(int status) {
		String hql = "update Subject s set s.status=:st";
		Query qry = getSession().createQuery(hql);
		qry.setParameter("st", status);
		int c = qry.executeUpdate();
		return c;
	}

}

class SubjectQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		if (!cond.isBlank("status")) {
			Integer st = cond.getInteger("status");
			criterions.add(Restrictions.eq("status", st));
		}
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("orderNo"));
		orders.add(Order.desc("id"));
		return orders;
	}

}