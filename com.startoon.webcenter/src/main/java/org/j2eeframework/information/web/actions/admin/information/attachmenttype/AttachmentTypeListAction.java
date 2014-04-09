package org.j2eeframework.information.web.actions.admin.information.attachmenttype;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.AttachmentType;
import org.j2eeframework.information.service.AttachmentTypeService;


public class AttachmentTypeListAction extends ServiceBasePaginationAction<AttachmentType, Long> {

	private static final long serialVersionUID = -1905058982678082374L;

	@Resource
	private AttachmentTypeService attachmentTypeService;
	
	@Override
	public IGenericService<AttachmentType, Long> getGenericService()	{
		return attachmentTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
