package org.j2eeframework.startoon.web.actions.admin.msg;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.MsgRecord;
import org.j2eeframework.startoon.service.MsgRecordService;


public class MsgRecordListAction extends ServiceBasePaginationAction<MsgRecord, Long> {

	private static final long serialVersionUID = 8560975575242698500L;

	@Resource
	private MsgRecordService msgRecordService;
	
	@Override
	public IGenericService<MsgRecord, Long> getGenericService()	{
		return msgRecordService;
	}

	@Override
	public void preExecute() {
		
	}

}
