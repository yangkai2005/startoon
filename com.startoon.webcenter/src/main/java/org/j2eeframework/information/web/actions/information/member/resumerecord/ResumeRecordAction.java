package org.j2eeframework.information.web.actions.information.member.resumerecord;

import javax.annotation.Resource;

import org.j2eeframework.information.entity.ResumeRecord;
import org.j2eeframework.information.service.ResumeRecordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class ResumeRecordAction extends ServiceBaseManageAction<ResumeRecord,Long>
{
	private static final long serialVersionUID = 7970120203628821895L;
	@Resource
	private ResumeRecordService resumeRecordService;
	private ResumeRecord resumeRecord;
	@Override
	public IGenericService<ResumeRecord, Long> getGenericService()
	{
		return resumeRecordService;
	}

	public ResumeRecord getModel()
	{
		return resumeRecord;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			resumeRecord = new ResumeRecord();
		} else
		{
			resumeRecord = resumeRecordService.getEntityById(getRequestId());
		}
	}

}
