package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IKeywordDAO;
import org.j2eeframework.startoon.entity.Keyword;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class KeywordDAOImpl extends GenericHibernateDAO<Keyword, Long>
		implements IKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new KeywordQueryParameterParser();
	}
	
	@Override
	public void deleteEntityById(Long id) {
		Keyword keyword = getEntityById(id);
		delete(keyword);
	}
	
	@Override
	public void delete(Keyword keyword) {
		keyword.setIsDeleted(Keyword.IS_DELETED_DELETED);
		update(keyword);
	}

	@Override
	public Keyword getKeywordByKey(String keyword) {
		Criteria cri = getSession().createCriteria(Keyword.class);
		cri.add(Restrictions.eq("keyword", keyword));
		cri.add(Restrictions.eq("isDeleted", Keyword.IS_DELETED_UNDELETED));
		List<Keyword> keyowrds = cri.list();
		if(keyowrds!=null && !keyowrds.isEmpty()) {
			return keyowrds.get(0);
		}
		return null;		
	}
	
	public void updateExpiredKeyword() throws Exception {
		try {
			String sql = "call sp_expired_keyword()";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.executeUpdate();
		} catch (Exception e) {
			throw new Exception("%%%更新处理过期关键字出错%%%", e.getCause());
		}
	}

}

class KeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("isDeleted")) {
			String param = paramCondition.getParameter("isDeleted");
			Boolean isDeleted = Boolean.parseBoolean(param);
			criterions.add(Restrictions.eq("isDeleted", isDeleted));
		} else { //默认为未删除
			criterions.add(Restrictions.eq("isDeleted", Keyword.IS_DELETED_UNDELETED));
		}
		
		if(!paramCondition.isParameterNull("keyword")) {
			String param = paramCondition.getParameter("keyword");
			String key = "%" + param + "%";
			criterions.add(Restrictions.like("keyword", key));
		}

		/*
		 * 过期关键字
		 */
		if(!paramCondition.isParameterNull("deadTime")) {
			Date deadTime = paramCondition.getDate("deadTime");
			criterions.add(Restrictions.lt("deadTime", deadTime));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		if(!paramCondition.isParameterNull("OrderByIdDesc")) {
			orders.add(Order.desc("id"));
		} else {
			orders.add(Order.asc("id"));
		}
		return orders;
	}

}