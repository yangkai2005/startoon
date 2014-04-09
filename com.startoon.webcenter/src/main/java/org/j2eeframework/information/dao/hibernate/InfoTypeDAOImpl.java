package org.j2eeframework.information.dao.hibernate;

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
import org.j2eeframework.information.dao.IInfoTypeDAO;
import org.j2eeframework.information.entity.InfoType;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class InfoTypeDAOImpl extends GenericHibernateDAO<InfoType, Long> implements IInfoTypeDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new InfoTypeQueryParameterParser();
	}
	
	/**
	 * 根据父ID查询所有的子类别
	 * @param fatherId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InfoType> getInfoTypeByFatherId(Long fatherId) {
		Criteria cri = getSession().createCriteria(InfoType.class);
		InfoType fatherInfoType = new InfoType();
		fatherInfoType.setId(fatherId);
		cri.add(Restrictions.eq("infoType", fatherInfoType));
		cri.add(Restrictions.eq("isDeleted", false));
		return cri.list();
	}

}

class InfoTypeQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("typeNo")) {
			String typeNo = paramCondition.getParameter("typeNo");
			criterions.add(Restrictions.like("typeNo", typeNo + "%"));
		}

		if(!paramCondition.isParameterNull("fatherId")) {
			Long fatherId = paramCondition.getLong("fatherId");
			InfoType fatherInfoType = new InfoType();
			fatherInfoType.setId(fatherId);
			criterions.add(Restrictions.like("infoType", fatherInfoType));
		}
		
		if(!paramCondition.isParameterNull("isDeleted")) {
			String p = paramCondition.getParameter("isDeleted");
			Boolean isDeleted = new Boolean(p);
			criterions.add(Restrictions.eq("isDeleted", isDeleted));
			
		} else {
			criterions.add(Restrictions.eq("isDeleted", false));
		}
		
		return criterions;
	}

	@Override
	public List<Order> getOrder(ParamCondition paramCondition) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("id"));
		return orders;
	}
	
}