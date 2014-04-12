package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IPTagsDAO;
import org.j2eeframework.startoon.entity.PTags;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PTagsDAOImpl extends GenericHibernateDAO<PTags, Long> implements IPTagsDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new PTagsQueryParameterParser();
	}

}

class PTagsQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (cond.isNotBlank("pass")) {
			Boolean b = new Boolean(cond.getParameter("pass"));
			criterions.add(Restrictions.eq("pass", b));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}

}