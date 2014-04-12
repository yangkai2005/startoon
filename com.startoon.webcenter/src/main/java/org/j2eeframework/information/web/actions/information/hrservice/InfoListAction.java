package org.j2eeframework.information.web.actions.information.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4134116409480470053L;

	@Resource
	private InfoService infoService;

	@Resource
	private InfoTypeService infoTypeService;
	
	private Long infoTypeId;
	
	private InfoType infoType;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(20);
		getPager().getParamCondition().addParameter("infoTypeId", infoTypeId + "");
		getPager().getParamCondition().addParameter("status", "6");
		
		infoType = infoTypeService.getEntityById(infoTypeId);
	}

	public Long getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(Long infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
