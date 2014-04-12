package org.j2eeframework.information.web.actions.information.member.resumerecord;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.ResumeRecord;
import org.j2eeframework.information.service.ResumeRecordService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.Struts2Utils;

public class ResumeRecordListAction extends ServiceBasePaginationAction<ResumeRecord, Long> {

	private static final long serialVersionUID = 459964413206686209L;

	@Resource
	private ResumeRecordService resumeRecordService;

	@Override
	public IGenericService<ResumeRecord, Long> getGenericService() {
		return resumeRecordService;
	}

	@Override
	public void preExecute() {
		Enterprise user = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
		getPager().getParamCondition().addParameter("creatorId", user.getId() + "");
	}

}
