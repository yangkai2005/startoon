package org.j2eeframework.startoon.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IEntProduceDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntProduce;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EntProduceDAOImpl extends GenericHibernateDAO<EntProduce, Long> implements IEntProduceDAO {

	@SuppressWarnings("unchecked")
	public EntProduce getEntProduceByLogicKey(Long enterpriseId, Long categoryId) {
		Criteria cri = getSession().createCriteria(EntProduce.class);
		Enterprise ent = new Enterprise();
		ent.setId(enterpriseId);
		
		Category category = new Category();
		category.setId(categoryId);
		
		cri.add(Restrictions.eq("enterprise", ent));
		cri.add(Restrictions.eq("category", category));
		
		List<EntProduce> list = cri.list();
		
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}
	
}
