package org.j2eeframework.information.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.information.dao.IHrLimitDAO;
import org.j2eeframework.information.entity.HrLimit;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class HrLimitDAOImpl extends GenericHibernateDAO<HrLimit, Long> implements IHrLimitDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new HrLimitQueryParameterParser();
	}

}

class HrLimitQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("enterpriseId")) {
			Long eid = cond.getLong("enterpriseId");
			criterions.add(Restrictions.eq("enterprise.id", eid));
		}

		if (!cond.isBlank("memberLevel")) {
			Integer lvl = cond.getInteger("memberLevel");
			criterions.add(Restrictions.eq("memberLevel", lvl));
		}

		if (!cond.isBlank("account")) {
			String acc = cond.getParameter("account");
			criterions.add(Restrictions.eq("enterprise.account", acc));
		}

		if (!cond.isBlank("name")) {
			String name = cond.getParameter("name");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("enterprise.name", name));
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