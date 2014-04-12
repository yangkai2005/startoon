package org.j2eeframework.information.dao;

import org.j2eeframework.commons.dao.IGenericDAO;
import org.j2eeframework.information.entity.Attachments;

public interface IAttachmentsDAO extends IGenericDAO<Attachments, Long> {

	int deleteByFid(Long fid);

}