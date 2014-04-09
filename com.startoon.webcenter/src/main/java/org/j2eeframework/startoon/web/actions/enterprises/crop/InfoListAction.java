package org.j2eeframework.startoon.web.actions.enterprises.crop;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -5382559372773601195L;

	@Resource
	private InfoService infoService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EntInfoService entInfoService;
	
	private EntInfo entInfo;
	private Enterprise enterprise;
	private Long enterpriseId;
	
	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		
		getPager().getParamCondition().addParameter("creator", enterpriseId + "");
		
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		
		
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
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

}
