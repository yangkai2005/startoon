package org.j2eeframework.information.web.actions.admin.information.video;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 6591248361442504866L;

	@Resource
	private InfoService infoService;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		ParamCondition cond = getPager().getParamCondition();
		cond.addParameter("infoTypeId", "25");
		cond.addParameter("category", Info.CATEGORY_VIDEO + "");
	}

}
