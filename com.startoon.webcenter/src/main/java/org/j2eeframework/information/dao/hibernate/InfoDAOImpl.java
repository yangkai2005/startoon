package org.j2eeframework.information.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.information.dao.IInfoDAO;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class InfoDAOImpl extends GenericHibernateDAO<Info, Long> implements IInfoDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new InfoQueryParameterParser();
	}

	@SuppressWarnings("unchecked")
	public Info getPreInfo(Info info) {

		if (info == null || info.getId() == null) {
			return null;
		}

		Criteria cri = getSession().createCriteria(Info.class);
		cri.add(Restrictions.eq("status", 2)).add(Restrictions.eq("infoType", info.getInfoType())).add(Restrictions.lt("id", info.getId()));

		cri.setFetchSize(1);

		List<Info> infos = cri.list();
		if (infos != null && !infos.isEmpty()) {
			return infos.get(infos.size() - 1);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public Info getNextInfo(Info info) {
		if (info == null || info.getId() == null) {
			return null;
		}
		Criteria cri = getSession().createCriteria(Info.class);
		cri.add(Restrictions.eq("status", 2)).add(Restrictions.eq("infoType", info.getInfoType())).add(Restrictions.gt("id", info.getId()));
		cri.setFetchSize(1);

		List<Info> infos = cri.list();
		if (infos != null && !infos.isEmpty()) {
			return infos.get(0);
		}

		return null;
	}

}

class InfoQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isParameterNull("infoTypeId")) {
			Long tid = cond.getLong("infoTypeId");
			InfoType infoType = new InfoType();
			infoType.setId(tid);
			criterions.add(Restrictions.eq("infoType", infoType));
		}

		if (!cond.isParameterNull("infoTypeIds")) {
			String[] infoTypeIds = cond.get("infoTypeIds");
			List<InfoType> infoTypes = new ArrayList<InfoType>();
			for (String id : infoTypeIds) {
				InfoType infoType = new InfoType();
				infoType.setId(new Long(id));
				infoTypes.add(infoType);
			}

			criterions.add(Restrictions.in("infoType", infoTypes));
		}

		if (!cond.isParameterNull("hot")) {
			String hot = cond.getParameter("hot");
			criterions.add(Restrictions.eq("hot", new Boolean(hot)));
		}

		if (!cond.isParameterNull("recommend")) {
			String recommend = cond.getParameter("recommend");
			criterions.add(Restrictions.eq("recommend", new Boolean(recommend)));
		}

		if (!cond.isParameterNull("top")) {
			String top = cond.getParameter("top");
			criterions.add(Restrictions.eq("isTop", new Boolean(top)));
		}

		if (!cond.isParameterNull("status")) {
			Integer st = cond.getInteger("status");

			if (st == -1) {
				// 在-1情况下不做任何限制，查询所有
			} else
				criterions.add(Restrictions.eq("status", st));

		} else {
			criterions.add(Restrictions.eq("status", Info.STATUS_AUDIT_PASS));
		}

		if (!cond.isParameterNull("creatorType")) {
			Integer creatorType = cond.getInteger("creatorType");
			criterions.add(Restrictions.eq("creatorType", creatorType));
		}

		if (!cond.isParameterNull("creator")) {
			Long creatorId = cond.getLong("creator");
			criterions.add(Restrictions.eq("creator", creatorId));
		}

		if (!cond.isParameterNull("isImgInfo")) {
			String isImgInfo = cond.getParameter("isImgInfo");
			criterions.add(Restrictions.eq("isImgInfo", new Boolean(isImgInfo)));
		}

		if (!cond.isParameterNull("category")) {
			Integer category = cond.getInteger("category");
			criterions.add(Restrictions.eq("category", category));
		}

		if (!cond.isParameterNull("q")) {
			String q = cond.getParameter("q");
			q = "%" + q + "%";
			criterions.add(Restrictions.or(Restrictions.like("title", q), Restrictions.like("content", q)));
		}

		if (!StringUtils.isBlank(cond.getParameter("subjectId"))) {
			Long subjectId = cond.getLong("subjectId");
			criterions.add(Restrictions.eq("subject.id", subjectId));
		}

		if (!StringUtils.isBlank(cond.getParameter("isSubject"))) {
			criterions.add(Restrictions.isNotNull("subject"));
		}

		if (!StringUtils.isBlank(cond.getParameter("notSubjectId"))) {
			Long subjectId = cond.getLong("notSubjectId");
			criterions.add(Restrictions.or(Restrictions.isNull("subject"), Restrictions.not(Restrictions.eq("subject.id", subjectId))));
		}

		return criterions;
	}
	@Override
	public List<Order> getOrder(ParamCondition cond) {
		List<Order> orders = new ArrayList<Order>();

		if (!cond.isBlank("OrderByHits")) {
			orders.add(Order.desc("hits"));
		}

		if (!cond.isParameterNull("orderBy")) {
			String orderBy = cond.getParameter("orderBy");
			String orderType = cond.getParameter("orderType");

			if ("desc".equals(orderType)) {
				orders.add(Order.desc(orderBy));

			} else if ("asc".equals(orderType)) {
				orders.add(Order.asc(orderBy));

			} else {
				orders.add(Order.desc("id"));
			}
		} else {
			orders.add(Order.desc("id"));
		}

		return orders;
	}

}