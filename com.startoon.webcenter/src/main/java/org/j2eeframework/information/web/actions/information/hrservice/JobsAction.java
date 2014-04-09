package org.j2eeframework.information.web.actions.information.hrservice;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;

public class JobsAction extends ServiceBaseManageAction<Jobs, Long> {
	
	private static final long serialVersionUID = -4481402264070711916L;
	
	@Resource
	private JobsService jobsService;
	@Resource
	private EntInfoService entInfoService;
	
	private Jobs jobs;
	
	private List<Jobs> otherJobs;
	
	private List<Jobs> relateJobs;
	

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
	
	@Override
	public String show() {
		
		Enterprise ent = jobs.getEnterprise();
		
		EntInfo entInfo = entInfoService.getEntInfoByEnterpriseId(ent.getId());
		ent.setEntInfo(entInfo);
		jobs.setEnterprise(ent);
		
		otherJobs = jobsService.getLatestJobsBySize(9);
		relateJobs = jobsService.getRelateJobsBySize(9);
		
		return ResultConstants.SHOW;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public List<Jobs> getOtherJobs() {
		return otherJobs;
	}

	public void setOtherJobs(List<Jobs> otherJobs) {
		this.otherJobs = otherJobs;
	}

	public List<Jobs> getRelateJobs() {
		return relateJobs;
	}

	public void setRelateJobs(List<Jobs> relateJobs) {
		this.relateJobs = relateJobs;
	}
	

}
