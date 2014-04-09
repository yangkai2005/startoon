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
import org.j2eeframework.information.dao.ICommentsDAO;
import org.j2eeframework.information.entity.Comments;
import org.j2eeframework.information.entity.Info;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CommentsDAOImpl extends GenericHibernateDAO<Comments, Long>
		implements ICommentsDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new CommentsQueryParameterParser();
	}
	
	public void deleteByInfoId(Long infoId) {
		
		String hql = "delete from Comments c where c.info=:info";
		
		Info info = new Info();
		info.setId(infoId);
		
		getSession().createQuery(hql)
			.setParameter("info", info)
			.executeUpdate();
	}

}

class CommentsQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("status")) { 
			int st = paramCondition.getInteger("status");
			criterions.add(Restrictions.eq("status", st));
		} else {
			criterions.add(Restrictions.eq("status", 2));
		}
		
		if(!paramCondition.isParameterNull("infoId")) {
			Long infoId = paramCondition.getLong("infoId");
			Info info = new Info();
			info.setId(infoId);
			criterions.add(Restrictions.eq("info", info));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		return orders;
	}

}