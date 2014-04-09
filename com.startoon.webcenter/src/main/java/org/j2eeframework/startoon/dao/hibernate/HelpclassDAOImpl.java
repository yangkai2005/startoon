package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IHelpclassDAO;
import org.j2eeframework.startoon.entity.Helpclass;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class HelpclassDAOImpl extends GenericHibernateDAO<Helpclass, Long> implements IHelpclassDAO {

}
