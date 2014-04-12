package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IPostedProParamDAO;
import org.j2eeframework.startoon.entity.PostedProParam;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class PostedProParamDAOImpl extends GenericHibernateDAO<PostedProParam, Long> implements IPostedProParamDAO {

}
