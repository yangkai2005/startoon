package org.j2eeframework.startoon.web.actions.enterprise.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;

public class JobsAction extends ServiceBaseManageAction<Jobs, Long> {

	private static final long serialVersionUID = -4481402264070711916L;

	@Resource
	private JobsService jobsService;
	@Resource
	private HrLimitService hrLimitService;

	private Jobs jobs;
	/**
	 * 标志 0：成功 1：免费会员发布次数超过最大限制
	 */
	private int flag;

	private HrLimit limit;

	@Override
	public IGenericService<Jobs, Long> getGenericService() {
		return jobsService;
	}

	public Jobs getModel() {
		return jobs;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			jobs = new Jobs();
		} else {
			jobs = jobsService.getEntityById(getRequestId());
		}

		Enterprise user = SysContext.getCurrentEnterpriserUser();
		jobs.setEnterprise(user);
	}

	public String publish() {
		jobs.setStatus(2);
		return super.update();
	}

	@Override
	public String input() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		Long uid = user.getId();
		limit = hrLimitService.getByEnterpriseId(uid);
		return super.input();
	}

	@Override
	public String insert() {

		Enterprise user = SysContext.getCurrentEnterpriserUser();

		boolean canPublish = hrLimitService.canPublishJob(user.getId());

		if (!canPublish) {
			return ResultConstants.ERROR;
		} else {
			hrLimitService.increaseJobCount(user.getId());
		}

		getModel().setEnterpriseName(user.getName());
		getGenericService().insert(getModel());

		return ResultConstants.LIST;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public HrLimit getLimit() {
		return limit;
	}

	public void setLimit(HrLimit limit) {
		this.limit = limit;
	}

}
