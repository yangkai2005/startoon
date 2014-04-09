package org.j2eeframework.startoon.web.actions.admin.entmsg;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntMsgService;


public class EntMsgListAction extends ServiceBasePaginationAction<EntMsg, Long> {

	private static final long serialVersionUID = -2921186624932530293L;

	@Resource
	private EntMsgService entMsgService;
	private String content;
	@Override
	public IGenericService<EntMsg, Long> getGenericService()	{
		return entMsgService;
	}

	@Override
	public void preExecute() {
		getPager().getParamCondition().addParameter("content", content);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
