package org.j2eeframework.information.web.actions.information.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.TalentService;

public class TalentListAction extends ServiceBasePaginationAction<Talent, Long> {

	private static final long serialVersionUID = 5777715394242643593L;

	@Resource
	private TalentService talentService;

	private InfoType infoType;

	@Override
	public IGenericService<Talent, Long> getGenericService() {
		return talentService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(24);

		infoType = new InfoType();
		infoType.setId(48L);

		getPager().getParamCondition().addParameter("state", "0");

	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}