package org.j2eeframework.information.web.actions.admin.information.jobtype;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.JobType;
import org.j2eeframework.information.service.JobTypeService;

public class JobTypeAction extends ServiceBaseManageAction<JobType, Long> {
	private static final long serialVersionUID = 3177564657315583037L;
	@Resource
	private JobTypeService jobTypeService;
	private JobType jobType;
	private List<JobType> jobTypes;
	private Long pid;

	@Override
	public IGenericService<JobType, Long> getGenericService() {
		return jobTypeService;
	}

	public JobType getModel() {
		return jobType;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			jobType = new JobType();
		} else {
			jobType = jobTypeService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		jobTypes = getGenericService().getAllEntity();
		return super.input();
	}

	@Override
	public String edit() {
		jobTypes = getGenericService().getAllEntity();
		pid = getModel().getParent() != null ? getModel().getParent().getId() : null;
		return super.edit();
	}

	@Override
	public String insert() {
		if (pid != null && pid != 0) {
			JobType parent = new JobType();
			parent.setId(pid);

			getModel().setParent(parent);
		}

		return super.insert();

	}

	@Override
	public String update() {
		if (pid != null && pid != 0) {
			JobType parent = new JobType();
			parent.setId(pid);

			getModel().setParent(parent);
		}

		return super.update();
	}

	public List<JobType> getJobTypes() {
		return jobTypes;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
