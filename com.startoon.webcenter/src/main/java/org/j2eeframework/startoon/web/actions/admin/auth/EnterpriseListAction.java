package org.j2eeframework.startoon.web.actions.admin.auth;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseListAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = 2117201501187179371L;

	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	@Override
	public void preExecute() {

		Pager<Enterprise> pager = getPager();
		ParamCondition cond = pager.getParamCondition();
		pager.setPageSize(15);

		String ptype = cond.getParameter("ptype");
		if (!StringUtils.isBlank(ptype)) {
			if ("0".equals(ptype)) {
				cond.addParameter("userType", Enterprise.USER_TYPE_PERSON + "");
				cond.addParameter("isShow", "0");
				cond.addParameter("isBar", "0");
			} else if ("isShow".equals(ptype)) {
				cond.addParameter("userType", Enterprise.USER_TYPE_PERSON + "");
				cond.addParameter("isShow", "2");
			} else if ("isBar".equals(ptype)) {
				cond.addParameter("userType", Enterprise.USER_TYPE_PERSON + "");
				cond.addParameter("isBar", "2");
			}
		}
	}

}
