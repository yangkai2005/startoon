package org.j2eeframework.information.web.actions.admin.information.attachments;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.Attachments;
import org.j2eeframework.information.service.AttachmentsService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class AttachmentsAction extends ServiceBaseManageAction<Attachments,Long>
{
	private static final long serialVersionUID = 7004065776061246240L;
	@Resource
	private AttachmentsService attachmentsService;
	private Attachments attachments;
	@Override
	public IGenericService<Attachments, Long> getGenericService()
	{
		return attachmentsService;
	}

	public Attachments getModel()
	{
		return attachments;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			attachments = new Attachments();
		} else
		{
			attachments = attachmentsService.getEntityById(getRequestId());
		}
	}

}
