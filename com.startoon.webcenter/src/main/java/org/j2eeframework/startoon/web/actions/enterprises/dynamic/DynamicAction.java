package org.j2eeframework.startoon.web.actions.enterprises.dynamic;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Dynamic;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.DynamicService;
import org.j2eeframework.startoon.service.EntInfoService;

public class DynamicAction extends ServiceBaseManageAction<Dynamic, Long> {
	private static final long serialVersionUID = 1589269036304424252L;
	@Resource
	private DynamicService dynamicService;
	@Resource
	private EntInfoService entInfoService;
	
	private Dynamic dynamic;
	private Enterprise enterprise;
	private Long enterpriseId;
	private EntInfo entInfo;
	

	@Override
	public IGenericService<Dynamic, Long> getGenericService() {
		return dynamicService;
	}

	public Dynamic getModel() {
		return dynamic;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			dynamic = new Dynamic();
		} else {
			dynamic = dynamicService.getEntityById(getRequestId());
		}

		enterprise = dynamic.getEnterprise();
		enterpriseId = enterprise.getId();
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public Dynamic getDynamic() {
		return dynamic;
	}

	public void setDynamic(Dynamic dynamic) {
		this.dynamic = dynamic;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

}
