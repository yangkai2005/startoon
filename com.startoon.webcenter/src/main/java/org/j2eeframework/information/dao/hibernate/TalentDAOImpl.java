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
import org.j2eeframework.information.dao.ITalentDAO;
import org.j2eeframework.information.entity.Talent;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class TalentDAOImpl extends GenericHibernateDAO<Talent, Long> implements ITalentDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new TalentQueryParameterParser();
	}

}

class TalentQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isParameterNull("q")) {
			String q = cond.getParameter("q");
			q = "%" + q + "%";
			criterions.add(Restrictions.or(Restrictions.like("jobIntent", q), Restrictions.like("workExperience", q)));
		}

		if (!cond.isParameterNull("address")) {
			String q = cond.getParameter("address");
			q = "%" + q + "%";
			criterions.add(Restrictions.like("currentAddress", q));
		}

		if (!cond.isBlank("enterpriseId")) {
			Long eid = cond.getLong("enterpriseId");
			criterions.add(Restrictions.eq("enterprise.id", eid));
		}

		if (!cond.isBlank("creatorId")) {
			Long creatorId = cond.getLong("creatorId");
			criterions.add(Restrictions.eq("creator.id", creatorId));
		}

		if (!cond.isBlank("intent")) { // 求职意向
			String intent = cond.getParameter("intent");
			intent = "%" + intent + "%";
			criterions.add(Restrictions.like("jobIntent", intent));
		}

		if (!cond.isBlank("spec")) { // 专业
			String param = cond.getParameter("spec");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("speciality", param));
		}

		if (!cond.isBlank("exper")) { // 经验
			String param = cond.getParameter("exper");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("workExperience", param));
		}

		if (!cond.isBlank("degree")) { // 学历
			String param = cond.getParameter("degree");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("degree", param));
		}

		if (!cond.isBlank("wage")) { // 工作年限
			String param = cond.getParameter("wage");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("workedAge", param));
		}

		if (!cond.isBlank("fullText")) { // 全文
			String p = cond.getParameter("fullText");
			p = "%" + p + "%";

			Criterion criterion = Restrictions.or(Restrictions.like("jobIntent", p), Restrictions.like("speciality", p));
			criterion = Restrictions.or(criterion, Restrictions.like("workExperience", p));

			criterions.add(criterion);

		}

		if (!cond.isBlank("state")) { // 冻结状态
			int state = cond.getInteger("state");
			Criterion criterion = Restrictions.eq("state", state);
			criterions.add(criterion);
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("modifyTime"));
		return orders;
	}

}