package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.INewsTypeDAO;
import org.j2eeframework.startoon.entity.NewsType;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class NewsTypeDAOImpl extends GenericHibernateDAO<NewsType, Long> implements INewsTypeDAO {

}
