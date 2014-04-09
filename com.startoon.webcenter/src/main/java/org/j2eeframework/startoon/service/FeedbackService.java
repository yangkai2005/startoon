package org.j2eeframework.startoon.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IFeedbackDAO;
import org.j2eeframework.startoon.entity.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService extends
		AbstractService<Feedback, Long, IFeedbackDAO> {
	@Resource
	private IFeedbackDAO feedbackDAO;

	@Override
	public IFeedbackDAO getGenericDAO() {
		return feedbackDAO;
	}
}
