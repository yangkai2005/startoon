package org.j2eeframework.information.web.actions.admin.information.job;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;

public class JobsAction extends ServiceBaseManageAction<Jobs, Long> {
	private static final long serialVersionUID = -6061272034411340216L;
	@Resource
	private JobsService jobsService;
	private Jobs jobs;

	private List<Long> ids;
	private String desc;
	private Integer status;

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
	}

	public String freeze() {

		String freezeDesc = status == 1 ? desc : "";

		for (Long id : ids) {
			Jobs job = getGenericService().getEntityById(id);
			job.setStatus(status);
			job.setFreezeDesc(freezeDesc);

			getGenericService().update(job);
		}

		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
