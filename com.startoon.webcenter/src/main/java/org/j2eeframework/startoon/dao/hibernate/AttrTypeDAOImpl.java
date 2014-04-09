package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IAttrTypeDAO;
import org.j2eeframework.startoon.entity.AttrType;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class AttrTypeDAOImpl extends GenericHibernateDAO<AttrType, Long> implements IAttrTypeDAO {

}
