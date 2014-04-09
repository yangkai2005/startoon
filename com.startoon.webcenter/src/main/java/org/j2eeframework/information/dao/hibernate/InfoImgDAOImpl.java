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
import org.j2eeframework.information.dao.IInfoImgDAO;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.springframework.stereotype.Repository;


@ChildOf(parent = "genericHibernateDAO")
@Repository
public class InfoImgDAOImpl extends GenericHibernateDAO<InfoImg, Long> implements IInfoImgDAO {

	protected IQueryParameterParser buildQueryParameterParser() {
		return new InfoImgQueryParameterParser();
	}
	
	public InfoImg getInfoMainImg(Long infoId) {
		Criteria cri = getSession().createCriteria(InfoImg.class);
		Info info = new Info();
		info.setId(infoId);
		
		cri.add(Restrictions.eq("info", info));
		cri.add(Restrictions.eq("isMainImg", true));
		
		return (InfoImg) cri.uniqueResult();
	}

}

class InfoImgQueryParameterParser implements IQueryParameterParser {

	@Override
	public List<Criterion> getCriterions(ParamCondition paramCondition) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		
		if(!paramCondition.isParameterNull("infoId")){
			Long infoId = paramCondition.getLong("infoId");
			Info info = new Info();
			info.setId(infoId);
			criterions.add(Restrictions.eq("info", info));
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