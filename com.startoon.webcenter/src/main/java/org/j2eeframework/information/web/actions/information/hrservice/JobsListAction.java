package org.j2eeframework.information.web.actions.information.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;

public class JobsListAction extends ServiceBasePaginationAction<Jobs, Long> {

	private static final long serialVersionUID = 1685769491821810773L;

	@Resource
	private JobsService jobsService;

	private InfoType infoType;

	@Override
	public IGenericService<Jobs, Long> getGenericService() {
		return jobsService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(39);
		getPager().getParamCondition().addParameter("status", "0");
		infoType = new InfoType();
		infoType.setId(47L);
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
