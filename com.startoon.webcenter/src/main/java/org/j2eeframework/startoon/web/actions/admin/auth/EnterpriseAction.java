package org.j2eeframework.startoon.web.actions.admin.auth;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseAction extends ServiceBaseManageAction<Enterprise, Long> {

	private static final long serialVersionUID = -5046080261655016521L;

	@Resource
	private EnterpriseService enterpriseService;
	private Enterprise enterprise;

	private List<Long> ids;
	private Boolean auth;

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

	public String auth() {
		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				Enterprise ent = getGenericService().getEntityById(id);
				ent.setAuth(auth);
				getGenericService().update(ent);
			}
		}
		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

}
