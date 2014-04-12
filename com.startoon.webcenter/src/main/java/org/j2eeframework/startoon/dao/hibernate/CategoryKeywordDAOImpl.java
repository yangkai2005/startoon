package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ICategoryKeywordDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CategoryKeywordDAOImpl extends GenericHibernateDAO<CategoryKeyword, Long> implements ICategoryKeywordDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new CategoryKeywordQueryParameterParser();
	}

	
	public void updateExpiredCategoryKeyword() throws Exception {
		try {
			String sql = "call sp_expired_category_keyword()";
			Query query = getSession().createSQLQuery(sql);
			query.executeUpdate();
		} catch (Exception e) {
			throw new Exception("%%%更新处理过期类别关键词出错%%%", e.getCause());
		}
	}	


}

class CategoryKeywordQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isBlank("categoryId")) {
			Long cid = paramCondition.getLong("categoryId");
			Category category = new Category();
			category.setId(cid);
			criterions.add(Restrictions.eq("category", category));
		}
		
		if(!paramCondition.isBlank("categoryIds")) {
			String[] cids = paramCondition.get("categoryIds");
			List<Category> categories = new ArrayList<Category>();
			for(String id : cids) {
				Category c = new Category();
				c.setId(new Long(id));
				categories.add(c);
			}
			
			criterions.add(Restrictions.in("category", categories));
		}
		
		
		if(!paramCondition.isBlank("q")) {
			String cname = paramCondition.getParameter("q");
			cname = "%" + cname + "%";
			criterions.add(Restrictions.like("categoryName", cname));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("category"));
		orders.add(Order.asc("rank"));
		return orders;
	}

}