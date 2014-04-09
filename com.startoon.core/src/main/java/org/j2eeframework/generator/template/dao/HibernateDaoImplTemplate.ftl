package ${classPackagePath};

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.springframework.stereotype.Repository;

import ${daoInterfacePackagePath}.${daoInterfaceName};
import ${entityPackagePath}.${entityName};


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class ${className} extends GenericHibernateDAO<${entityName}, Long> implements ${daoInterfaceName} {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new ${entityName}QueryParameterParser();
	}

}

class ${entityName}QueryParameterParser implements IQueryParameterParser {

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