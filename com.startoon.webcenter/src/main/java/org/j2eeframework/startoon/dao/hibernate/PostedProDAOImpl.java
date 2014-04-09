package org.j2eeframework.startoon.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IPostedProDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PostedPro;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PostedProDAOImpl extends GenericHibernateDAO<PostedPro, Long> implements IPostedProDAO {

	@Override
	public int getCountOfEntitiesByParamCondition(ParamCondition paramCondition) {
		IQueryParameterParser parser = new PostedProQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		int countOfEntity = getCountOfEntity(criterions);
		return countOfEntity;
	}

	@Override
	public List<PostedPro> getEntitiesByParamCondition(ParamCondition paramCondition, int firstResult, int pageSize) {
		IQueryParameterParser parser = new PostedProQueryParameterParser();
		List<Criterion> criterions = parser.getCriterions(paramCondition);
		List<Order> orders = parser.getOrder(paramCondition);
		List<PostedPro> entitys = findEntityByCriteria(criterions, firstResult, pageSize, orders);
		return entitys;
	}
}

class PostedProQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {

		List<Criterion> criterions = new ArrayList<Criterion>();
		if (paramCondition.getParameter("categoryId") != null) {
			Category category = new Category();
			category.setId(paramCondition.getLong("categoryId"));
			criterions.add(Restrictions.eq("category", category));
		}

		if (paramCondition.getParameter("enterpriseId") != null) {
			Enterprise ent = new Enterprise();
			ent.setId(paramCondition.getLong("enterpriseId"));
			criterions.add(Restrictions.eq("creator", ent));
		}

		if (paramCondition.getParameter("categoryIds") != null) {
			String[] categoryIds = paramCondition.get("categoryIds");
			List<Category> categories = new ArrayList<Category>();
			for (String id : categoryIds) {
				Category c = new Category();
				c.setId(new Long(id));
				categories.add(c);

			}
			criterions.add(Restrictions.in("category", categories));
		}

		/*
		 * 顶部查询
		 */
		if (!paramCondition.isParameterNull("searchKey")) {
			String key = paramCondition.getParameter("searchKey");
			key = "%" + key + "%";

			criterions.add(Restrictions.or(Restrictions.like("proName", key), Restrictions.like("description", key)));
		}

		if (paramCondition.getParameter("categoryNameStr") != null) {
			String name = paramCondition.getParameter("categoryNameStr");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("categoryNameStr", name));
		}

		if (paramCondition.getParameter("categoryIdStr") != null) {
			String name = paramCondition.getParameter("categoryIdStr");
			name = "%" + name + "%";
			criterions.add(Restrictions.like("categoryIdStr", name));
		}

		if (paramCondition.isNotBlank("status")) {
			int status = paramCondition.getInteger("status");
			// -1为查询全部的，否则为只查询审核通过的
			if (-1 != status) {
				criterions.add(Restrictions.eq("status", status));
			}

		} else {
			criterions.add(Restrictions.eq("status", PostedPro.Status.pass.ordinal()));
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