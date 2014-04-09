package org.j2eeframework.information.web.actions.admin.information.attachmenttype;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.AttachmentType;
import org.j2eeframework.information.service.AttachmentTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class AttachmentTypeAction extends ServiceBaseManageAction<AttachmentType,Long>
{
	private static final long serialVersionUID = -8576656434233581048L;
	@Resource
	private AttachmentTypeService attachmentTypeService;
	private AttachmentType attachmentType;
	@Override
	public IGenericService<AttachmentType, Long> getGenericService()
	{
		return attachmentTypeService;
	}

	public AttachmentType getModel()
	{
		return attachmentType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			attachmentType = new AttachmentType();
		} else
		{
			attachmentType = attachmentTypeService.getEntityById(getRequestId());
		}
	}

}
