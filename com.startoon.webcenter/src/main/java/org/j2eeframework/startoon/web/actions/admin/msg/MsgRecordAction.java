package org.j2eeframework.startoon.web.actions.admin.msg;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.MsgRecord;
import org.j2eeframework.startoon.service.MsgRecordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class MsgRecordAction extends ServiceBaseManageAction<MsgRecord,Long>
{
	private static final long serialVersionUID = 1267288098218511915L;
	@Resource
	private MsgRecordService msgRecordService;
	private MsgRecord msgRecord;
	@Override
	public IGenericService<MsgRecord, Long> getGenericService()
	{
		return msgRecordService;
	}

	public MsgRecord getModel()
	{
		return msgRecord;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			msgRecord = new MsgRecord();
		} else
		{
			msgRecord = msgRecordService.getEntityById(getRequestId());
		}
	}

}
