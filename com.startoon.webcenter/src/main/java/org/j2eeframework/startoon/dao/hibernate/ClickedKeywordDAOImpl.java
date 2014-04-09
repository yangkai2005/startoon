package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.dao.IClickedKeywordDAO;
import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class ClickedKeywordDAOImpl extends GenericHibernateDAO<ClickedKeyword, Long> implements IClickedKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new ClickedKeywordQueryParameterParser();
	}

}

class ClickedKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isBlank("enterpriseId")) {
			Long eid = paramCondition.getLong("enterpriseId");
			criterions.add(Restrictions.eq("enterpriseId", eid));
		}
		
		if(!paramCondition.isBlank("ip")) {
			String ip = paramCondition.getParameter("ip");
			criterions.add(Restrictions.eq("ip", ip));
		}
		
		if(!paramCondition.isBlank("longIP")) {
			long lip = paramCondition.getLong("longIP");
			criterions.add(Restrictions.eq("lip", lip));
		}
		
		if(!paramCondition.isBlank("stime")) {
			String s = paramCondition.getParameter("stime");
			Date stime = DateUtil.parseDate(s);
			criterions.add(Restrictions.gt("clickedTime", stime));
		}
		
		if(!paramCondition.isBlank("etime")) {
			String s = paramCondition.getParameter("etime");
			Date etime = DateUtil.parseDate(s);
			criterions.add(Restrictions.lt("clickedTime", etime));
		}
		
		if(!paramCondition.isBlank("flag")) {
			int type = paramCondition.getInteger("flag");
			criterions.add(Restrictions.eq("flag", type));
		}
		
		if(!paramCondition.isBlank("q")) {
			String q = paramCondition.getParameter("q");
			q = "%" + q + "%";
			criterions.add(Restrictions.like("keyword", q));
		}
		
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("clickedTime"));
		return orders;
	}
	
}