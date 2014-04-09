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
import org.j2eeframework.startoon.dao.ISupplyDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SupplyDAOImpl extends GenericHibernateDAO<Supply, Long> implements ISupplyDAO {

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new SupplyQueryParameterParser();
	}

	@Override
	public void deleteById(Long id) {
		Supply supply = getEntityById(id);
		supply.setIsDelete(Supply.IS_DELETE_DELETED);
		update(supply);
	}
}

class SupplyQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {

		List<Criterion> criterions = new ArrayList<Criterion>();
		if (cond.getParameter("categoryId") != null) {
			Category category = new Category();
			category.setId(cond.getLong("categoryId"));
			criterions.add(Restrictions.eq("category", category));
		}

		if (cond.getParameter("enterpriseId") != null) {
			Enterprise ent = new Enterprise();
			ent.setId(cond.getLong("enterpriseId"));
			criterions.add(Restrictions.eq("creator", ent));
		}

		if (cond.getParameter("categoryIds") != null) {
			String[] categoryIds = cond.get("categoryIds");
			List<Category> categories = new ArrayList<Category>();
			for (String id : categoryIds) {
				Category c = new Category();
				c.setId(new Long(id));
				categories.add(c);
			}
			criterions.add(Restrictions.in("category", categories));
		}

		/*
		 * 删除查询
		 */
		if (cond.getParameter("isDelete") != null) {
			criterions.add(Restrictions.eq("isDelete", cond.getInteger("isDelete")));
		} else {
			criterions.add(Restrictions.eq("isDelete", Supply.IS_DELETE_UNDELETED));
		}

		/*
		 * 推荐查询 
		 */
		if (cond.getParameter("recommend") != null) {
			criterions.add(Restrictions.eq("isRecommend", cond.getInteger("recommend")));
		}

		/*
		 * 顶部查询
		 */
		if (!cond.isParameterNull("searchKey")) {
			String skey = cond.getParameter("searchKey");
			String key = "%" + skey + "%";

			criterions.add(Restrictions.or(Restrictions.like("name", key), Restrictions.or(Restrictions.like("description", key), Restrictions.eq("keyword", skey))));
		}

		String key = cond.getParameter("aKey");
		if (key != null) {
			key = "%" + key + "%";
			criterions.add(Restrictions.like("attrContent", key));
		}

		/*
		 * 根据拼音查询
		 */
		if (!cond.isParameterNull("pinyin")) {
			String pinyin = cond.getParameter("pinyin");
			criterions.add(Restrictions.eq("nameFirstPinyin", pinyin));
		}

		/*
		 * 审核筛选
		 */
		if ("00".equals(cond.getParameter("status"))) { //查询全部状态的

		} else if (cond.getParameter("status") != null) { //查询指定状态
			int st = cond.getInteger("status");
			criterions.add(Restrictions.eq("status", st));
		} else { //默认是查询审核通过的
			criterions.add(Restrictions.eq("status", 2));
		}

		/*
		 * 时间段查询
		 */
		if (!cond.isParameterNull("startCreateTime")) {
			Long start = cond.getLong("startCreateTime");
			Date stime = new Date(start);
			criterions.add(Restrictions.gt("createTime", stime));
		}
		if (!cond.isParameterNull("endCreateTime")) {
			Long etime = cond.getLong("endCreateTime");
			Date end = new Date(etime);
			criterions.add(Restrictions.lt("createTime", end));
		}

		/*
		 * 根据关键字ID查询对应的产品 
		 */
		if (!cond.isParameterNull("enterpriseKeywordId")) {
			Long enterpriseKeywordId = cond.getLong("enterpriseKeywordId");
			criterions.add(Restrictions.eq("enterpriseKeywordId", enterpriseKeywordId));
		}

		/*
		 * 根据标签查询
		 */
		if (cond.isNotBlank("ptagIds")) {
			String[] ptagIds = cond.get("ptagIds");
			List<PTags> tags = new ArrayList<PTags>();
			for (String id : ptagIds) {
				PTags c = new PTags();
				c.setId(new Long(id));
				tags.add(c);
			}

			criterions.add(Restrictions.in("ptags", tags));
		}

		return criterions;

	}

	@Override
	public List<Order> getOrder(ParamCondition cond) {

		List<Order> orders = new ArrayList<Order>();

		if (cond.isNotBlank("searchKey")) { //关键字排序
			orders.add(Order.desc("keywordStatus")); // 第一排序字段 关键字是否有效
			orders.add(Order.desc("keywordPrice")); //第二排序字段  关键字价格作为主排序字段
		}

		if (cond.isNotBlank("categoryId")) { // 类别关键字排序
			orders.add(Order.desc("categoryKeywordStatus")); // 第一排序字段-关键字是否有效 
			orders.add(Order.desc("isCategoryKeyword")); // 第二排序字段   类别关键字和类别是否为同一个
			orders.add(Order.desc("categoryKeywordPrice")); // 第三排序字段  类别关键字的价格
		}

		orders.add(Order.desc("id"));

		return orders;
	}
}