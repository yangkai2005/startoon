package org.j2eeframework.startoon.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.ISupplyImgDAO;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.entity.SupplyImg;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SupplyImgDAOImpl extends GenericHibernateDAO<SupplyImg, Long> implements ISupplyImgDAO {

	@SuppressWarnings("unchecked")
	public List<SupplyImg> getSupplyImgBySupplyId(Long supplyId) {
		Criteria cri = getSession().createCriteria(SupplyImg.class);
		Supply supply = new Supply();
		supply.setId(supplyId);
		cri.add(Restrictions.eq("supply", supply));
		return cri.list();
		
	}
	
}
