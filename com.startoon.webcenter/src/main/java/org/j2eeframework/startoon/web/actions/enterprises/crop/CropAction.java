package org.j2eeframework.startoon.web.actions.enterprises.crop;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CropService;

public class CropAction extends ServiceBaseManageAction<Crop, Long> {
	private static final long serialVersionUID = -660851157705668672L;
	@Resource
	private CropService cropService;
	private Crop crop;
	private Enterprise enterprise;
	private Long enterpriseId;

	@Override
	public IGenericService<Crop, Long> getGenericService() {
		return cropService;
	}

	public Crop getModel() {
		return crop;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			crop = new Crop();
		} else {
			crop = cropService.getEntityById(getRequestId());
		}
		
		enterprise = crop.getEnterprise();
		enterpriseId = enterprise.getId();
	}

	@Override
	public String execute() {
		return "success";
	}
	
	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
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
