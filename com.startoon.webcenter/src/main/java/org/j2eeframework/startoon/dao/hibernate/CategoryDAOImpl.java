package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ICategoryDAO;
import org.j2eeframework.startoon.entity.Category;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CategoryDAOImpl extends GenericHibernateDAO<Category, Long> implements ICategoryDAO {
	
	
	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new CategoryQueryParameterParser();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getCategoriesByFatherId(Long fatherCategoryId) {
		
		Criteria cri = getSession().createCriteria(Category.class);
		
		Category category = new Category();
		category.setId(fatherCategoryId);
		
		cri.add(Restrictions.not(Restrictions.eq("id", 0L)));
		cri.add(Restrictions.eq("category", category));
		cri.add(Restrictions.eq("isDelete", false));
		
		return cri.list();
		
	}
	
	/**
	 * @param fatherCategoryId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getCategoryByFatherId(Long fatherCategoryId) {
		Query qry = getSession().createQuery("from Category where category.id=:fatherCategoryId and id<>0 and isDelete=false ");
		qry.setParameter("fatherCategoryId", fatherCategoryId);
		return qry.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryByLevel(int level) {
		return getSession().createCriteria(Category.class)
			.add(Restrictions.eq("categoryLevel", level))
			.add(Restrictions.eq("isDelete", false))
			.list();
	}

	/**
	 * 
	 */
	@Override
	public void deleteEntityById(Long id) {
		Category category = getEntityById(id);
		delete(category);
	}
	
	/**
	 * 逻辑删除类别
	 */
	@Override
	public void delete(Category category) {
		category.setDelete(true);
		update(category);
	}
}

class CategoryQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		if(paramCondition.getParameter("fatherId")!=null) {
			Category category = new Category();
			category.setId(paramCondition.getLong("fatherId"));
			criterions.add(Restrictions.eq("category", category));
		}
		
		
		if(paramCondition.getParameter("cname")!=null) {
			criterions.add(Restrictions.like("name", "%"+paramCondition.getParameter("cname")+"%"));
		}
		
		if(paramCondition.getParameter("level")!=null) {
			int level = paramCondition.getInteger("level");
			criterions.add(Restrictions.eq("categoryLevel", level));
		}
		
		criterions.add(Restrictions.not(Restrictions.isNull("category")));
		//过滤删除掉的类别
		criterions.add(Restrictions.eq("isDelete", false));
		// root不展示出来
		criterions.add(Restrictions.not(Restrictions.eq("id", 0L)));
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("categoryLevel"));
		orders.add(Order.asc("orderNo"));
		return orders;
	}
	
}
