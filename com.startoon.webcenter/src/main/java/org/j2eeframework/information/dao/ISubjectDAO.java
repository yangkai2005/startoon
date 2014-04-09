package org.j2eeframework.information.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.Subject;

public interface ISubjectDAO extends IGenericDAO<Subject, Long> {
	int updateStatus(int status);

}