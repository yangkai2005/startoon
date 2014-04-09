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
import org.j2eeframework.information.dao.IJobsDAO;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class JobsDAOImpl extends GenericHibernateDAO<Jobs, Long> implements IJobsDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new JobsQueryParameterParser();
	}

}

class JobsQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {

		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!paramCondition.isParameterNull("enterpriseId")) {
			Long enterpriseId = paramCondition.getLong("enterpriseId");
			Enterprise ent = new Enterprise();
			ent.setId(enterpriseId);
			criterions.add(Restrictions.eq("enterprise", ent));
		}

		if (!paramCondition.isParameterNull("status")) { // 冻结状态过滤
			Integer status = paramCondition.getInteger("status");
			criterions.add(Restrictions.eq("status", status));
		}

		if (!paramCondition.isParameterNull("q")) { // 全文
			String q = paramCondition.getParameter("q");
			q = "%" + q + "%";

			Criterion criterion = Restrictions.or(Restrictions.like("name", q), Restrictions.like("description", q));
			criterion = Restrictions.or(criterion, Restrictions.like("enterpriseName", q));

			criterions.add(criterion);
		}

		if (!paramCondition.isParameterNull("address")) { // 地点
			String q = paramCondition.getParameter("address");
			q = "%" + q + "%";
			criterions.add(Restrictions.like("workAddress", q));
		}

		if (!paramCondition.isParameterNull("name")) { // 职位名称
			String q = paramCondition.getParameter("name");
			q = "%" + q + "%";
			criterions.add(Restrictions.like("name", q));
		}

		if (!paramCondition.isParameterNull("ename")) { // 公司名称
			String q = paramCondition.getParameter("ename");
			q = "%" + q + "%";
			criterions.add(Restrictions.like("enterpriseName", q));
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