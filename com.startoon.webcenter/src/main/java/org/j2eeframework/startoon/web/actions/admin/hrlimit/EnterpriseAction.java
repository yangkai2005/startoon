package org.j2eeframework.startoon.web.actions.admin.hrlimit;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {

	private static final long serialVersionUID = 711156659373355730L;

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private HrLimitService hrLimitService;

	private Enterprise enterprise;

	private List<Long> ids;

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

	public String apply() {

		hrLimitService.apply(ids);

		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
