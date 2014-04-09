package org.j2eeframework.information.service;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IJobRefEmployeeDAO;
import org.j2eeframework.information.entity.JobRefEmployee;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.entity.Resume;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class JobRefEmployeeService extends AbstractService<JobRefEmployee, Long, IJobRefEmployeeDAO>
{
	@Resource
	private IJobRefEmployeeDAO jobRefEmployeeDAO;
	@Resource
	private JobsService jobsService;

	@Override
	public IJobRefEmployeeDAO getGenericDAO()
	{
		return jobRefEmployeeDAO;
	}
	
	public JobRefEmployee addResumeRef(Long jobId, Long resumeId) {
		
		Jobs job = new Jobs();
		job.setId(jobId);
		
		Resume resume = new Resume();
		resume.setId(resumeId);
		
		Enterprise enterprise = jobsService.getEnterpriseFromJob(jobId);
		
		JobRefEmployee jre = new JobRefEmployee();
		jre.setJobs(job);
		jre.setResume(resume);
		jre.setEnterprise(enterprise);
		jre.setType(0);
		
		getGenericDAO().insert(jre);
		
		return jre;
		
	}
	
	public JobRefEmployee addTalentRef(Long jobId, Long talentId) {
		
		Jobs job = new Jobs();
		job.setId(jobId);
		
		Talent talent = new Talent();
		talent.setId(talentId);
		
		Enterprise enterprise = jobsService.getEnterpriseFromJob(jobId);
		
		JobRefEmployee jre = new JobRefEmployee();
		jre.setJobs(job);
		jre.setTalent(talent);
		jre.setEnterprise(enterprise);
		jre.setType(1);
		
		getGenericDAO().insert(jre);
		
		return jre;
	}
	
}
