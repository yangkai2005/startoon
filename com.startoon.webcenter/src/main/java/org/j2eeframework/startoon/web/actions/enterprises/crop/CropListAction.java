package org.j2eeframework.startoon.web.actions.enterprises.crop;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CropService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class CropListAction extends ServiceBasePaginationAction<Crop, Long> {

	private static final long serialVersionUID = -6210848036564218845L;

	@Resource
	private CropService cropService;
	@Resource
	private EnterpriseService enterpriseService;
	
	
	
	@Resource
	private EntInfoService entInfoService;
	
	private EntInfo entInfo;
	private Long enterpriseId;
	private Enterprise enterprise;
	
	@Override
	public IGenericService<Crop, Long> getGenericService()	{
		return cropService;
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
