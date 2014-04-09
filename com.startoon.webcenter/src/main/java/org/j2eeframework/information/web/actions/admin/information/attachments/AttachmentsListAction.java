package org.j2eeframework.information.web.actions.admin.information.attachments;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Attachments;
import org.j2eeframework.information.service.AttachmentsService;


public class AttachmentsListAction extends ServiceBasePaginationAction<Attachments, Long> {

	private static final long serialVersionUID = 2508340901398857192L;

	@Resource
	private AttachmentsService attachmentsService;
	
	@Override
	public IGenericService<Attachments, Long> getGenericService()	{
		return attachmentsService;
	}

	@Override
	public void preExecute() {
		
	}

}
