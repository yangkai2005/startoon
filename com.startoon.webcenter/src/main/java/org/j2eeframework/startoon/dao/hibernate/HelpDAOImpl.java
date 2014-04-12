package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IHelpDAO;
import org.j2eeframework.startoon.entity.Help;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class HelpDAOImpl extends GenericHibernateDAO<Help, Long> implements IHelpDAO {

}
