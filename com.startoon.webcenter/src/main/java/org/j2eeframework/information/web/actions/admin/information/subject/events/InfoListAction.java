package org.j2eeframework.information.web.actions.admin.information.subject.events;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -2627540570344295037L;

	@Resource
	private InfoService infoService;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		Pager<Info> pager = getPager();
		ParamCondition cond = pager.getParamCondition();
		cond.addParameter("infoTypeId", "50");
		cond.addParameter("isSubject", "true");
	}

}
