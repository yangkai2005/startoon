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
import org.j2eeframework.startoon.dao.IUserRefRoleDAO;
import org.j2eeframework.startoon.entity.AdminUser;
import org.j2eeframework.startoon.entity.UserRefRole;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class UserRefRoleDAOImpl extends GenericHibernateDAO<UserRefRole, Long> implements IUserRefRoleDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new UserRefRoleQueryParameterParser();
	}

	public UserRefRole findByExample(UserRefRole userRefRole) {
		Criteria cri = getSession().createCriteria(UserRefRole.class);
		cri.add(Restrictions.eq("user", userRefRole.getUser()));
		cri.add(Restrictions.eq("role", userRefRole.getRole()));
		return (UserRefRole) cri.uniqueResult();
	}

	@Override
	public UserRefRole findByUser(Long userId) {
		
		Criteria cri = getSession().createCriteria(UserRefRole.class);
		AdminUser user = new AdminUser();
		user.setId(userId);
		
		cri.add(Restrictions.eq("user", user));

		return (UserRefRole) cri.uniqueResult();
		
	}
	
}

class UserRefRoleQueryParameterParser implements IQueryParameterParser {

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