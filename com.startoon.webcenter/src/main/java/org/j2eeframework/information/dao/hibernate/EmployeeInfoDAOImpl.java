package org.j2eeframework.information.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.springframework.stereotype.Repository;

import org.j2eeframework.information.dao.IEmployeeInfoDAO;
import org.j2eeframework.information.entity.EmployeeInfo;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EmployeeInfoDAOImpl extends GenericHibernateDAO<EmployeeInfo, Long> implements IEmployeeInfoDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new EmployeeInfoQueryParameterParser();
	}

}

class EmployeeInfoQueryParameterParser implements IQueryParameterParser {

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