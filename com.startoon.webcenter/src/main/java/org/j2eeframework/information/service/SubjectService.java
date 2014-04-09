package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.ISubjectDAO;
import org.j2eeframework.information.entity.Subject;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends AbstractService<Subject, Long, ISubjectDAO> {
	@Resource
	private ISubjectDAO subjectDAO;

	@Override
	public ISubjectDAO getGenericDAO() {
		return subjectDAO;
	}

	public Subject getCurrentSubject() {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("status", Subject.STATUS_ONLINE + "");
		List<Subject> subjects = getGenericDAO().getEntitiesByParamCondition(cond, 0, 1);
		if (subjects != null && !subjects.isEmpty()) {
			return subjects.get(0);
		}
		return null;
	}

	public Subject online(long subjectId) {
		// 下线其他
		// getGenericDAO().updateStatus(Subject.STATUS_OFFLINE);

		// 上线当前专题
		Subject subject = getGenericDAO().getEntityById(subjectId);
		subject.setStatus(Subject.STATUS_ONLINE);
		getGenericDAO().update(subject);
		return subject;
	}

	public Subject offline(long subjectId) {
		// 上线当前专题
		Subject subject = getGenericDAO().getEntityById(subjectId);
		subject.setStatus(Subject.STATUS_OFFLINE);
		getGenericDAO().update(subject);
		return subject;
	}

}
