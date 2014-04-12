package org.j2eeframework.information.web.actions.information.member.jobfavorite;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.JobFavorite;
import org.j2eeframework.information.service.JobFavoriteService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.Struts2Utils;

public class JobFavoriteListAction extends ServiceBasePaginationAction<JobFavorite, Long> {

	private static final long serialVersionUID = 7512411429160792297L;

	@Resource
	private JobFavoriteService jobFavoriteService;

	@Override
	public IGenericService<JobFavorite, Long> getGenericService() {
		return jobFavoriteService;
	}

	@Override
	public void preExecute() {
		Enterprise user = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
		getPager().getParamCondition().addParameter("userId", user.getId() + "");
	}

}
