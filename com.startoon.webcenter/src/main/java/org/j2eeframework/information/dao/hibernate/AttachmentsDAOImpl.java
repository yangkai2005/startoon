package org.j2eeframework.information.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.information.dao.IAttachmentsDAO;
import org.j2eeframework.information.entity.Attachments;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class AttachmentsDAOImpl extends GenericHibernateDAO<Attachments, Long> implements IAttachmentsDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new AttachmentsQueryParameterParser();
	}

	@Override
	public int deleteByFid(Long fid) {
		String hql = "delete from Attachments a where a.fid=:fid";
		Query qry = getSession().createQuery(hql);
		qry.setParameter("fid", fid);
		return qry.executeUpdate();
	}

}

class AttachmentsQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}

}