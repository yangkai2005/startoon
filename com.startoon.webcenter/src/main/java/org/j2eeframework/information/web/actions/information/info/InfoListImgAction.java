package org.j2eeframework.information.web.actions.information.info;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

public class InfoListImgAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 831626779866232809L;

	@Resource
	private InfoService infoService;

	@Resource
	private InfoTypeService infoTypeService;

	private List<Info> hotInfos;

	private InfoType infoType;

	private boolean typeIdEq2;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {

		Long infoTypeId = getPager().getParamCondition().getLong("infoTypeId");
		infoType = infoTypeService.getEntityById(infoTypeId);

		if (infoType.getTypeNo().startsWith("0001")) {
			typeIdEq2 = true;
		}

		getPager().setPageSize(6);

	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public boolean isTypeIdEq2() {
		return typeIdEq2;
	}

	public void setTypeIdEq2(boolean typeIdEq2) {
		this.typeIdEq2 = typeIdEq2;
	}

}
