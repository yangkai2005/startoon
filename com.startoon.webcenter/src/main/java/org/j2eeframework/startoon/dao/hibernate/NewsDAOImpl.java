package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.INewsDAO;
import org.j2eeframework.startoon.entity.News;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class NewsDAOImpl extends GenericHibernateDAO<News, Long> implements INewsDAO {

}
