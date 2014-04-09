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
import org.j2eeframework.information.dao.IAdvertisementDAO;
import org.j2eeframework.information.entity.Advertisement;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class AdvertisementDAOImpl extends GenericHibernateDAO<Advertisement, Long> implements IAdvertisementDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new AdvertisementQueryParameterParser();
	}

}

class AdvertisementQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {

		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!paramCondition.isBlank("id")) {
			Long id = paramCondition.getLong("id");
			criterions.add(Restrictions.eq("id", id));
		}

		if (!paramCondition.isParameterNull("infoTypeId")) {
			Long id = paramCondition.getLong("infoTypeId");
			criterions.add(Restrictions.eq("infoTypeId", id));
		}

		if (!paramCondition.isParameterNull("positionIndex")) {
			int id = paramCondition.getInteger("positionIndex");
			criterions.add(Restrictions.eq("positionIndex", id));
		}

		if (!paramCondition.isParameterNull("position")) {
			String pos = paramCondition.getParameter("position");
			pos = "%" + pos + "%";
			criterions.add(Restrictions.like("position", pos));
		}

		if (!paramCondition.isParameterNull("name")) {
			String param = paramCondition.getParameter("name");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("name", param));
		}

		if (!paramCondition.isParameterNull("adNo")) {
			String param = paramCondition.getParameter("adNo");
			param = "%" + param + "%";
			criterions.add(Restrictions.like("adNo", param));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.asc("adNo"));
		orders.add(Order.asc("id"));

		return orders;
	}

}