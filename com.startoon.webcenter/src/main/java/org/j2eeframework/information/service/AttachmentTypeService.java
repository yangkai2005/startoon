package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.j2eeframework.commons.service.impl.AbstractService;

import org.j2eeframework.information.dao.IAttachmentTypeDAO;
import org.j2eeframework.information.entity.AttachmentType;

@Service
public class AttachmentTypeService extends AbstractService<AttachmentType, Long, IAttachmentTypeDAO>
{
	@Resource
	private IAttachmentTypeDAO attachmentTypeDAO;

	@Override
	public IAttachmentTypeDAO getGenericDAO()
	{
		return attachmentTypeDAO;
	}
}
