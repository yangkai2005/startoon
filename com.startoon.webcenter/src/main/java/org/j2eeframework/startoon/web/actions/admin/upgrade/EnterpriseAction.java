package org.j2eeframework.startoon.web.actions.admin.upgrade;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {

	private static final long serialVersionUID = -2084615262039564668L;

	@Resource
	private EnterpriseService enterpriseService;

	private Enterprise enterprise;

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

	public String upgrade() {
		enterpriseService.upgrade(getRequestId(), 1);
		return ResultConstants.LIST;
	}

	public String down() {
		enterpriseService.upgrade(getRequestId(), -1);
		return ResultConstants.LIST;
	}

}
