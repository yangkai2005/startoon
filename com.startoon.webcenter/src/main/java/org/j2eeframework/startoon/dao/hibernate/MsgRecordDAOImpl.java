package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IMsgRecordDAO;
import org.j2eeframework.startoon.entity.MsgRecord;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class MsgRecordDAOImpl extends GenericHibernateDAO<MsgRecord, Long> implements IMsgRecordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new MsgRecordQueryParameterParser();
	}

}

class MsgRecordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cnd) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (cnd.isNotBlank("title")) {
			String title = cnd.getParameter("title");
			title = "%" + title + "%";
			criterions.add(Restrictions.like("title", title));
		}

		if (cnd.isNotBlank("content")) {
			String param = cnd.getParameter("content");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("content", param));
		}

		if (cnd.isNotBlank("stime")) {
			Date stime = cnd.getDate("stime");
			criterions.add(Restrictions.gt("ctime", stime));
		}

		if (cnd.isNotBlank("etime")) {
			Date etime = cnd.getDate("etime");
			criterions.add(Restrictions.lt("etime", etime));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition cnd) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("id"));
		return orders;
	}

}