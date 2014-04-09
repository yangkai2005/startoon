package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IAttachmentDAO;
import org.j2eeframework.information.entity.Attachment;

@Service
public class AttachmentService extends AbstractService<Attachment, Long, IAttachmentDAO>
{
	@Resource
	private IAttachmentDAO attachmentDAO;

	@Override
	public IAttachmentDAO getGenericDAO()
	{
		return attachmentDAO;
	}
}
