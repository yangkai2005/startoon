package org.j2eeframework.information.web.actions.information.attachment;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Attachment;
import org.j2eeframework.information.entity.AttachmentType;
import org.j2eeframework.information.service.AttachmentService;
import org.j2eeframework.information.service.AttachmentTypeService;

public class AttachmentAction extends ServiceBaseManageAction<Attachment, Long> {

	private static final long serialVersionUID = -175152075404541438L;

	@Resource
	private AttachmentService attachmentService;
	@Resource
	private AttachmentTypeService attachmentTypeService;

	private Attachment attachment;

	private List<AttachmentType> attachmentTypes;

	@Override
	public IGenericService<Attachment, Long> getGenericService() {
		return attachmentService;
	}

	public Attachment getModel() {
		return attachment;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			attachment = new Attachment();
		} else {
			attachment = attachmentService.getEntityById(getRequestId());
		}
	}

	@Override
	public String show() {
		attachmentTypes = attachmentTypeService.getAllEntity();
		return super.show();
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public List<AttachmentType> getAttachmentTypes() {
		return attachmentTypes;
	}

	public void setAttachmentTypes(List<AttachmentType> attachmentTypes) {
		this.attachmentTypes = attachmentTypes;
	}

}
