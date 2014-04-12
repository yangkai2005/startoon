package org.j2eeframework.information.web.actions.information.show;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

/**
 * 创意Show列表
 * 
 * @author kai
 */
public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -2277950430032855884L;

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
		infoType = infoTypeService.getEntityById(infoTypeId);
		getPager().setPageSize(20);
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
