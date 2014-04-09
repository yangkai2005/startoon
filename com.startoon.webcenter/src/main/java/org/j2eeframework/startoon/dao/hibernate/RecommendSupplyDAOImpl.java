package org.j2eeframework.startoon.dao.hibernate;

import org.springframework.stereotype.Repository;

import org.j2eeframework.startoon.dao.IRecommendSupplyDAO;
import org.j2eeframework.startoon.entity.RecommendSupply;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class RecommendSupplyDAOImpl extends GenericHibernateDAO<RecommendSupply, Long> implements IRecommendSupplyDAO {

}
