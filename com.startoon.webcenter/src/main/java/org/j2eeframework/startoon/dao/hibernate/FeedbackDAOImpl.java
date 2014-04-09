package org.j2eeframework.startoon.dao.hibernate;

import org.j2eeframework.commons.dao.hibernate.GenericHibernateDAO;
import org.j2eeframework.commons.springframework.ChildOf;
import org.j2eeframework.startoon.dao.IFeedbackDAO;
import org.j2eeframework.startoon.entity.Feedback;
import org.springframework.stereotype.Repository;

@ChildOf(parent = "genericHibernateDAO")
@Repository
public class FeedbackDAOImpl extends GenericHibernateDAO<Feedback, Long> implements IFeedbackDAO {

}
