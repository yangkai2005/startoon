package org.j2eeframework.information.web.actions.admin.information.hits;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -3819423734986407113L;

	@Resource
	private InfoService infoService;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
	}

}
