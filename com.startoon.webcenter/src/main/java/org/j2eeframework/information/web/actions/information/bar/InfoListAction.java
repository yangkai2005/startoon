package org.j2eeframework.information.web.actions.information.bar;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

/**
 * 列表类
 * 
 * @author kai
 */
public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 831626779866232809L;

	@Resource
	private InfoService infoService;

	@Resource
	private InfoTypeService infoTypeService;

	private List<Info> hotInfos;

	private List<Info> latestInfos;

	private InfoType infoType;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {

		Long infoTypeId = getPager().getParamCondition().getLong("infoTypeId");
		infoType = infoTypeService.getEntityById(infoTypeId);

		hotInfos = infoService.getHotInfo(10);
		latestInfos = infoService.getLatestInfo(10);

		getPager().setPageSize(40);

	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public List<Info> getLatestInfos() {
		return latestInfos;
	}

	public void setLatestInfos(List<Info> latestInfos) {
		this.latestInfos = latestInfos;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
