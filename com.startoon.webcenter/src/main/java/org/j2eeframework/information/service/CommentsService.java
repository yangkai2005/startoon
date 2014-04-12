package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.ICommentsDAO;
import org.j2eeframework.information.entity.Comments;
import org.springframework.stereotype.Service;

@Service
public class CommentsService extends
		AbstractService<Comments, Long, ICommentsDAO> {
	@Resource
	private ICommentsDAO commentsDAO;

	@Override
	public ICommentsDAO getGenericDAO() {
		return commentsDAO;
	}
	
	
	public void deleteByInfoId(Long infoId) {
		getGenericDAO().deleteByInfoId(infoId);
	}

}
