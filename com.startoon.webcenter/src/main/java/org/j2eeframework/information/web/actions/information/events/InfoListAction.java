package org.j2eeframework.information.web.actions.information.events;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 1999002714946927706L;

	@Resource
	private InfoService infoService;

	@Resource
	private InfoTypeService infoTypeService;

	private InfoType infoType;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {

		Long infoTypeId = getPager().getParamCondition().getLong("infoTypeId");

		if (infoTypeId == 30) {
			getPager().setPageSize(6);
		} else {
			getPager().setPageSize(23);
		}

		if (infoTypeId == 289) {
			infoType = new InfoType();
			infoType.setId(28L);
			infoType.setName("预告");

			getPager().getParamCondition().remove("infoTypeId");

			String[] infoTypeIds = {"28", "29"};
			getPager().getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);

		} else
			infoType = infoTypeService.getEntityById(infoTypeId);

	}

	@Override
	public String execute() {

		super.execute();

		getPager().getParamCondition().addParameter("infoTypeId", infoType.getId() + "");

		if (infoType != null && infoType.getId() == 30) {
			return SUCCESS;
		}

		return "report";

	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
