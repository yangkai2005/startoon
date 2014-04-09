package org.j2eeframework.information.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.Comments;

public interface ICommentsDAO extends IGenericDAO<Comments, Long> {

	public void deleteByInfoId(Long infoId);
	
}