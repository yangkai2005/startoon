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
import org.j2eeframework.startoon.dao.ITalentRefFavoriteDAO;
import org.j2eeframework.startoon.entity.TalentRefFavorite;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class TalentRefFavoriteDAOImpl extends GenericHibernateDAO<TalentRefFavorite, Long> implements ITalentRefFavoriteDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new TalentRefFavoriteQueryParameterParser();
	}

}

class TalentRefFavoriteQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("creatorId")) {
			Long cid = cond.getLong("creatorId");
			criterions.add(Restrictions.eq("creator.id", cid));
		}

		if (!cond.isBlank("talentId")) {
			Long cid = cond.getLong("talentId");
			criterions.add(Restrictions.eq("talent.id", cid));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}

}