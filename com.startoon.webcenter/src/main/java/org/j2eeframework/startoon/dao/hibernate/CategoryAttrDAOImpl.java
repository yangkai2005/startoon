package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ICategoryAttrDAO;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class CategoryAttrDAOImpl extends GenericHibernateDAO<CategoryAttr, Long>
		implements ICategoryAttrDAO {
	
	@Override
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = new CategoryQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		int countOfEntity = getCountOfEntity(criterions);
		return countOfEntity;
	}
	
	@Override
	public List<CategoryAttr> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = new CategoryAttrQueryParameterParser();
		List<Criterion> categoryattrs = parser.getCriterions(paramCondition);
		List<Order> orders = parser.getOrder(paramCondition);
		List<CategoryAttr> entitys = findEntityByCriteria(categoryattrs, firstResult, pageSize, orders);
		return entitys;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryAttr> getCategoryAttrByCategoryId(long categoryId) {
		
		Criteria cri = getSession().createCriteria(CategoryAttr.class);
		
		Category category = new Category();
		category.setId(categoryId);
		cri.add(Restrictions.eq("category", category));
		
		return cri.list();

	}
}

class CategoryAttrQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		if(paramCondition.getParameter("cid")!=null) {
			Category category = new Category();
			category.setId(paramCondition.getLong("cid"));
			criterions.add(Restrictions.eq("category", category));
		}
		
		/*
		 * 属性分类
		 */
		if(paramCondition.getParameter("attrTypeId")!=null) {
			AttrType attrType = new AttrType();
			attrType.setId(paramCondition.getLong("attrTypeId"));
			
			criterions.add(Restrictions.eq("attrType", attrType));
		}
				
		criterions.add(Restrictions.not(Restrictions.isNull("category")));

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("id"));
		return orders;
	}
	
}
