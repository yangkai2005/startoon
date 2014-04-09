package org.j2eeframework.startoon.dao.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.IQueryParameterParser;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IEnterpriseDAO;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.StringUtil;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EnterpriseDAOImpl extends GenericHibernateDAO<Enterprise, Long> implements IEnterpriseDAO {

	private static final Log log = LogFactory.getLog(EnterpriseDAOImpl.class);

	@Override
	protected IQueryParameterParser buildQueryParameterParser() {
		return new EnterpriseQueryParameterParser();
	}

	public List<Long> getAllId() {
		String hql = "select e.id from Enterprise e";
		Query qry = getSession().createQuery(hql);
		return qry.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enterprise getEnterpriseByAccount(String account) {

		Criteria cri = getSession().createCriteria(Enterprise.class);

		cri.add(Restrictions.eq("account", account));
		cri.add(Restrictions.eq("status", Enterprise.STATUS_ONLINE));

		List<Enterprise> list = cri.list();
		if (list != null && list.size() > 0) {
			return list.get(0);

		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public List<Enterprise> search(ParamCondition condition, int offset, int pageSize) {
		String sql = "select distinct a.* from enterprise a left outer join t_enterprise_ref_keyword b on a.id=b.enterprise_id where a.status=2 and a.status<>3 and a.user_type=1 and (a.name like :q or b.keyword like :q) order by b.price desc, a.id desc";
		Query query = getSession().createSQLQuery(sql).addEntity(Enterprise.class);
		if (!condition.isBlank("searchKey")) {
			String q = condition.getParameter("searchKey");
			q = "%" + q + "%";
			query.setParameter("q", q);
		} else {
			query.setParameter("q", "%");
		}
		query.setFirstResult(offset);
		query.setFetchSize(pageSize);

		log.debug(query.getQueryString());

		return query.list();
	}

	public int count(ParamCondition condition) {
		String sql = "select count(id) as n from (select distinct a.id from enterprise a left outer join t_enterprise_ref_keyword b on a.id=b.enterprise_id where a.status=2 and a.status<>3 and a.user_type=1 and (a.name like :q or b.keyword like :q)) t";
		SQLQuery query = getSession().createSQLQuery(sql);
		if (!condition.isBlank("searchKey")) {
			String q = condition.getParameter("searchKey");
			q = "%" + q + "%";
			query.setParameter("q", q);
		} else {
			query.setParameter("q", "%");
		}
		Object count = query.uniqueResult();
		int n = ((BigInteger) count).intValue();
		return n;
	}

}

class EnterpriseQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition cond) {

		List<Criterion> criterions = new ArrayList<Criterion>();

		if (!cond.isBlank("enterpriseId")) {
			Enterprise ent = new Enterprise();
			ent.setId(cond.getLong("enterpriseId"));

			criterions.add(Restrictions.eq("enterprise", ent));
		}

		if (!cond.isBlank("searchKey")) {
			String key = cond.getParameter("searchKey");
			String likeKey = "%" + key + "%";
			criterions.add(Restrictions.or(Restrictions.like("name", likeKey), Restrictions.eq("keyword", key)));

		}

		if (!cond.isBlank("email")) {
			String key = cond.getParameter("email");
			criterions.add(Restrictions.like("email", "%" + key + "%"));
		}

		if (!cond.isBlank("industry")) {
			String industry = cond.getParameter("industry");
			criterions.add(Restrictions.eq("industry", industry));
		}

		if (!cond.isBlank("categoryIds")) {
			String id = cond.getParameter("categoryIds");
			criterions.add(Restrictions.like("categoryIds", "%" + id + "%"));
		}

		if (!cond.isBlank("categoryKeys")) {
			String key = cond.getParameter("categoryKeys");
			criterions.add(Restrictions.like("categoryKeys", "%" + key + "%"));
		}

		/*
		 * 对审核状态的筛选，默认是查询审核通过的企业
		 */
		if (!cond.isBlank("status")) {
			Integer status = cond.getInteger("status");
			if (status == -1) {

			} else {
				criterions.add(Restrictions.eq("status", status));
			}
		} else {
			criterions.add(Restrictions.eq("status", 2));
		}

		criterions.add(Restrictions.not(Restrictions.eq("status", 3))); // 过滤删除的用户

		// 默认查询企业用户
		if (!cond.isBlank("userType")) {
			Integer userType = cond.getInteger("userType");
			if (userType == -1) {

			} else {
				criterions.add(Restrictions.eq("userType", userType));
			}
		} else {
			criterions.add(Restrictions.eq("userType", 1));
		}

		/*
		 * 根据拼音查询
		 */
		if (!cond.isBlank("pinyin")) {
			String pinyin = cond.getParameter("pinyin");
			criterions.add(Restrictions.eq("nameFirstPinyin", pinyin));
		}

		/*
		 * 查询公司名称不为空的
		 */
		if (!cond.isBlank("nameNotNull")) {
			// String p = paramCondition.getParameter("nameNotNull");
			criterions.add(Restrictions.isNotNull("name"));
		}

		/*
		 * 根据编号查询企业列表
		 */
		if (!cond.isBlank("ids")) {
			String ids = cond.getParameter("ids");
			criterions.add(Restrictions.in("id", StringUtil.convertionToLong(ids.split(","))));
		}

		/*
		 * 主营业务
		 */
		if (!cond.isBlank("businessIds")) {
			String bid = cond.getParameter("businessIds");
			bid = "%" + bid + "%";
			criterions.add(Restrictions.like("businessIds", bid));
		}

		/*
		 * 公司地址
		 */
		if (!cond.isBlank("address")) {
			String address = cond.getParameter("address");
			address = "%" + address + "%";
			criterions.add(Restrictions.like("address", address));
		}

		/*
		 * 店长吧会员标志
		 */
		if (!cond.isBlank("isBar")) {
			Integer isBar = cond.getInteger("isBar");
			criterions.add(Restrictions.eq("isBar", isBar));
		}

		/*
		 * 创意show会员
		 */
		if (!cond.isBlank("isShow")) {
			Integer isShow = cond.getInteger("isShow");
			criterions.add(Restrictions.eq("isShow", isShow));
		}

		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {

		List<Order> orders = new ArrayList<Order>();

		if (!paramCondition.isBlank("searchKey")) { // 关键字排序
			orders.add(Order.desc("keywordPrice")); // 价格作为主排序字段
		}

		if (paramCondition.getParameter("orderBy") != null) {
			orders.add(Order.desc("id"));
		} else {
			orders.add(Order.asc("id"));
		}

		return orders;
	}

}