package org.j2eeframework.information.web.actions.information.attachment;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Attachment;
import org.j2eeframework.information.service.AttachmentService;


public class AttachmentListAction extends ServiceBasePaginationAction<Attachment, Long> {

	private static final long serialVersionUID = -8658875393383574861L;

	@Resource
	private AttachmentService attachmentService;
	
	@Override
	public IGenericService<Attachment, Long> getGenericService()	{
		return attachmentService;
	}

	@Override
	public void preExecute() {
		
	}

}
