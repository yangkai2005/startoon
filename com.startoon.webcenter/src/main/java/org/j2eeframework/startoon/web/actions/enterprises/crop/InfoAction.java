package org.j2eeframework.startoon.web.actions.enterprises.crop;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	
	private static final long serialVersionUID = 5876047266496458519L;
	
	@Resource
	private InfoService infoService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EntInfoService entInfoService;
	
	private EntInfo entInfo;
	private Enterprise enterprise;
	private Long enterpriseId;
	private Info info;
	

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
		
		enterpriseId = info.getCreator();
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

}
