package org.j2eeframework.startoon.web.actions.enterprises.dynamic;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Dynamic;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.DynamicService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class DynamicListAction extends ServiceBasePaginationAction<Dynamic, Long> {

	private static final long serialVersionUID = 1420918541773904836L;

	@Resource
	private DynamicService dynamicService;
	
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EntInfoService entInfoService;
	
	private Long enterpriseId;
	
	private Enterprise enterprise;
	
	private EntInfo entInfo;
	
	@Override
	public IGenericService<Dynamic, Long> getGenericService()	{
		return dynamicService;
	}

	@Override
	public void preExecute() {
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
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
