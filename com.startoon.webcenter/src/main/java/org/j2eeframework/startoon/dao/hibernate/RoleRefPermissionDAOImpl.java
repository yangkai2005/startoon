package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IRoleRefPermissionDAO;
import org.j2eeframework.startoon.entity.RoleRefPermission;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class RoleRefPermissionDAOImpl extends GenericHibernateDAO<RoleRefPermission, Long> implements IRoleRefPermissionDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new RoleRefPermissionQueryParameterParser();
	}
	
	public RoleRefPermission findByExample(RoleRefPermission roleRefPermission) {
		Criteria cri = getSession().createCriteria(RoleRefPermission.class);
		cri.add(Restrictions.eq("role", roleRefPermission.getRole()));
		cri.add(Restrictions.eq("permission", roleRefPermission.getPermission()));
		return (RoleRefPermission) cri.uniqueResult();
	}

}

class RoleRefPermissionQueryParameterParser implements IQueryParameterParser {

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