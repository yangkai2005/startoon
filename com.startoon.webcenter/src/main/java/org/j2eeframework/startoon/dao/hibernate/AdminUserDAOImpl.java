package org.j2eeframework.startoon.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IAdminUserDAO;
import org.j2eeframework.startoon.entity.AdminUser;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class AdminUserDAOImpl extends GenericHibernateDAO<AdminUser, Long> implements IAdminUserDAO {

	@Override
	public AdminUser getAdminUserByAccount(String account) {
		Criteria cri = getSession().createCriteria(AdminUser.class);
		cri.add(Restrictions.eq("account", account));
		AdminUser u = (AdminUser) cri.uniqueResult();
		return u;
	}

}
