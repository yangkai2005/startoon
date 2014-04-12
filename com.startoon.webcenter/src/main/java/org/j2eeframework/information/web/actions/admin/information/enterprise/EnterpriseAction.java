package org.j2eeframework.information.web.actions.admin.information.enterprise;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {
	private static final long serialVersionUID = -2523738998791368006L;
	@Resource
	private EnterpriseService enterpriseService;
	private Enterprise enterprise;
	private Integer status;
	private List<Long> ids;
	/**
	 * 类别标志
	 * 0-创意show
	 * 1-店长吧
	 */
	private Integer type;
	

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	public Enterprise getModel() {
		return enterprise;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			enterprise = new Enterprise();
		} else {
			enterprise = enterpriseService.getEntityById(getRequestId());
		}
	}
	
	public String audit() {
		if(type==0) {
			for (Long id : ids) {
				enterprise = enterpriseService.getEntityById(id);
				enterprise.setIsShow(status);
				enterpriseService.update(enterprise);
			}
			
		} else if(type==1) {
			for (Long id : ids) {
				enterprise = enterpriseService.getEntityById(id);
				enterprise.setIsBar(status);
				enterpriseService.update(enterprise);
			}
			
		}
		
		return ResultConstants.LIST;
		
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


}
