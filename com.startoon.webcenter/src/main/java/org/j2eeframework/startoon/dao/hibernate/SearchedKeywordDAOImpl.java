package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ISearchedKeywordDAO;
import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SearchedKeywordDAOImpl extends GenericHibernateDAO<SearchedKeyword, Long> implements ISearchedKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new SearchedKeywordQueryParameterParser();
	}
	
	public SearchedKeyword findByKeyword(String keyword) {
		Criteria cri = getSession().createCriteria(SearchedKeyword.class);
		cri.add(Restrictions.eq("keyword", keyword)); 
		List<SearchedKeyword> list = cri.list();
		if(list!=null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public int findCountByKeyword(String keyword) {
		ParamCondition paramCondition = new ParamCondition();
		paramCondition.addParameter("keyword", keyword);
		int c = getCountOfEntitiesByParamCondition(paramCondition);
		return c;
	}

}

class SearchedKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("keyword")) {
			String key = paramCondition.getParameter("keyword");
			String likeKey = "%" + key + "%";
			criterions.add(Restrictions.like("keyword", likeKey));
		}
		
		if(!paramCondition.isParameterNull("sdate") && paramCondition.getParameter("sdate").trim().length()>0) {
			Date sdate = paramCondition.getDate("sdate");
			criterions.add(Restrictions.gt("lastSearchTime", sdate));
		}
		
		if(!paramCondition.isParameterNull("edate") && paramCondition.getParameter("edate").trim().length()>0) {
			Date edate = paramCondition.getDate("edate");
			Calendar c = Calendar.getInstance();
			c.setTime(edate);
			c.setTimeInMillis(edate.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
			criterions.add(Restrictions.lt("lastSearchTime", c.getTime()));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("id"));
		return orders;
	}
	
	
}