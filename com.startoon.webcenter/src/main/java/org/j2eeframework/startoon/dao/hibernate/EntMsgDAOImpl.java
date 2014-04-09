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
import org.j2eeframework.startoon.dao.IEntMsgDAO;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EntMsgDAOImpl extends GenericHibernateDAO<EntMsg, Long> implements IEntMsgDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new EntMsgQueryParameterParser();
	}

}

class EntMsgQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {

		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("enterpriseId")) {
			long eid = cond.getLong("enterpriseId");
			Enterprise ent = new Enterprise();
			ent.setId(eid);

			criterions.add(Restrictions.eq("enterprise", ent));
		}
		if (!cond.isBlank("content")) {
			String key = cond.getParameter("content");
			criterions.add(Restrictions.like("content", "%" + key + "%"));
		}

		if (!cond.isBlank("status")) {
			int st = cond.getInteger("status");
			if (st == -1) {
				// 全部
			} else {
				criterions.add(Restrictions.eq("status", st));
			}
		} else {
			criterions.add(Restrictions.eq("status", EntMsg.STATUS_PASS));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.desc("id"));

		return orders;
	}
}