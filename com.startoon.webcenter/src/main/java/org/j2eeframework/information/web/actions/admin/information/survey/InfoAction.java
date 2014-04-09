package org.j2eeframework.information.web.actions.admin.information.survey;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;
import org.j2eeframework.information.service.VoteService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.AdminUser;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = -6028343073791575309L;
	@Resource
	private InfoService infoService;
	@Resource
	private InfoTypeService infoTypeService;
	@Resource
	private VoteService voteService;
	
	private Info info;
	
	private List<InfoType> infoTypes;
	
	private int status;

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
		
		infoTypes = infoTypeService.getInfoTypeByFatherId(22L);
	}
	
	public String insert() {

		AdminUser user = SysContext.getCurrentAdminUser();
		
		info.setCreator(user.getId());
		info.setCreatorType(3);
		info.setCreatorName(user.getName());
		info.setStatus(0);
		
		return super.insert();
	}
	
	public String publish() {
		
		voteService.publishByInfoId(info.getId());
		info.setStatus(2);
		return super.update();
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<InfoType> getInfoTypes() {
		return infoTypes;
	}

	public void setInfoTypes(List<InfoType> infoTypes) {
		this.infoTypes = infoTypes;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
