package org.j2eeframework.information.web.actions.information.subject.video;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

/**
 * 专题视频列表
 * 
 * @author kai
 */
public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 6571701887001084754L;

	private static final Long INFO_TYPE_ID_VOIDE = 51L;

	@Resource
	private InfoService infoService;

	private InfoType infoType;

	private Long subjectId;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		ParamCondition cond = getPager().getParamCondition();
		cond.addParameter("infoTypeId", INFO_TYPE_ID_VOIDE + "");
		getPager().setPageSize(20);
		infoType = new InfoType();
		infoType.setId(17L); // 专题
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

}
