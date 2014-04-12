package org.j2eeframework.information.web.actions.information.video;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

/**
 * 动画列表
 * 
 * @author kai
 */
public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 6571701887001084754L;

	@Resource
	private InfoService infoService;

	private InfoType infoType;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		getPager().getParamCondition().addParameter("category", Info.CATEGORY_VIDEO + "");
		getPager().getParamCondition().addParameter("infoTypeId", 25 + "");
		getPager().setPageSize(20);
		infoType = new InfoType();
		infoType.setId(25L);
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
