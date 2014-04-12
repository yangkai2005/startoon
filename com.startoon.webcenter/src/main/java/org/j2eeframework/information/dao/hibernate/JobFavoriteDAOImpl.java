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
import org.j2eeframework.information.dao.IJobFavoriteDAO;
import org.j2eeframework.information.entity.JobFavorite;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class JobFavoriteDAOImpl extends GenericHibernateDAO<JobFavorite, Long> implements IJobFavoriteDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new JobFavoriteQueryParameterParser();
	}

}

class JobFavoriteQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("jobId")) {
			Long jid = cond.getLong("jobId");
			criterions.add(Restrictions.eq("job.id", jid));
		}

		if (!cond.isBlank("userId")) {
			Long uid = cond.getLong("userId");
			criterions.add(Restrictions.eq("owner.id", uid));
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