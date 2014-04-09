package org.j2eeframework.information.web.actions.information.survey;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = 8932931554753902217L;
	@Resource
	private InfoService infoService;
	private Info info;
	
	private Info surveyInfo;

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	public Info getModel() {
		return info;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			info = new Info();
		} else {
			info = infoService.getEntityById(getRequestId());
		}
	}
	
	public String show() {
		surveyInfo = infoService.getSurveyInfoById(getRequestId());
		return ResultConstants.SHOW;
	}

	public Info getSurveyInfo() {
		return surveyInfo;
	}

	public void setSurveyInfo(Info surveyInfo) {
		this.surveyInfo = surveyInfo;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

}
