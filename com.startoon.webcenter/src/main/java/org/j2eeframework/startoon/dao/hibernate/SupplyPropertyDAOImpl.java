package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.ISupplyPropertyDAO;
import org.j2eeframework.startoon.entity.SupplyProperty;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class SupplyPropertyDAOImpl extends GenericHibernateDAO<SupplyProperty, Long> implements ISupplyPropertyDAO {

}
