package org.j2eeframework.information.web.actions.information.attachment;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Attachment;
import org.j2eeframework.information.entity.AttachmentType;
import org.j2eeframework.information.service.AttachmentService;
import org.j2eeframework.information.service.AttachmentTypeService;

public class IndexAction extends ServiceBasePaginationAction<Attachment, Long> {

	private static final long serialVersionUID = -8658875393383574861L;

	@Resource
	private AttachmentService attachmentService;
	@Resource
	private AttachmentTypeService attachmentTypeService;

	private List<AttachmentType> attachmentTypes;

	@Override
	public IGenericService<Attachment, Long> getGenericService() {
		return attachmentService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(6);

		attachmentTypes = attachmentTypeService.getAllEntity();
	}

	public List<AttachmentType> getAttachmentTypes() {
		return attachmentTypes;
	}

	public void setAttachmentTypes(List<AttachmentType> attachmentTypes) {
		this.attachmentTypes = attachmentTypes;
	}

}
