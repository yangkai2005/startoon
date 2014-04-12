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
import org.j2eeframework.information.dao.IPostTypeDAO;
import org.j2eeframework.information.entity.PostType;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PostTypeDAOImpl extends GenericHibernateDAO<PostType, Long> implements IPostTypeDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new PostTypeQueryParameterParser();
	}

	
	public void delete(PostType postType) {
		postType.setIsDeleted(true);
		update(postType);
	}
	
	public void deleteEntityById(Long id) {
		PostType postType = getEntityById(id);
		delete(postType);
	}
}

class PostTypeQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		
		criterions.add(Restrictions.eq("isDeleted", false));
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}
	
}