package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IRoleDAO;
import org.j2eeframework.startoon.entity.Role;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class RoleDAOImpl extends GenericHibernateDAO<Role, Long> implements IRoleDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new RoleQueryParameterParser();
	}

}

class RoleQueryParameterParser implements IQueryParameterParser {

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