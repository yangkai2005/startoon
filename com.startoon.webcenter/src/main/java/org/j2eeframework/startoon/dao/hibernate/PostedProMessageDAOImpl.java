package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IPostedProMessageDAO;
import org.j2eeframework.startoon.entity.PostedProMessage;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PostedProMessageDAOImpl extends GenericHibernateDAO<PostedProMessage, Long> implements IPostedProMessageDAO {

}
