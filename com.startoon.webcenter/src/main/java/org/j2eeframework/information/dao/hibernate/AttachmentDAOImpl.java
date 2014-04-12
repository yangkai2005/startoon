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
import org.j2eeframework.information.dao.IAttachmentDAO;
import org.j2eeframework.information.entity.Attachment;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class AttachmentDAOImpl extends GenericHibernateDAO<Attachment, Long> implements IAttachmentDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new AttachmentQueryParameterParser();
	}

}

class AttachmentQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {
		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("typeId")) {
			Long typeId = cond.getLong("typeId");
			criterions.add(Restrictions.eq("attachmentType.id", typeId));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {

		List<Order> orders = new ArrayList<Order>();

		orders.add(Order.desc("id"));
		orders.add(Order.asc("attachmentType.id"));

		return orders;
	}

}