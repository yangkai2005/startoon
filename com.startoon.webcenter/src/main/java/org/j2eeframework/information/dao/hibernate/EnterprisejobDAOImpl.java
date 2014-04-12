package org.j2eeframework.information.dao.hibernate;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.information.dao.IEnterprisejobDAO;
import org.j2eeframework.information.entity.EnterpriseJob;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class EnterprisejobDAOImpl extends GenericHibernateDAO<EnterpriseJob, Long> implements IEnterprisejobDAO {

	

}
