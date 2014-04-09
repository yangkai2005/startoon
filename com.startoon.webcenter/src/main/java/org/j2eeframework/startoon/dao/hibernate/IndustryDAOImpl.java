package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IIndustryDAO;
import org.j2eeframework.startoon.entity.Industry;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class IndustryDAOImpl extends GenericHibernateDAO<Industry, Long> implements IIndustryDAO {

}
