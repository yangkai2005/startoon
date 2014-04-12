package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IJobsDAO;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.startoon.entity.Enterprise;
import org.springframework.stereotype.Service;

@Service
public class JobsService extends AbstractService<Jobs, Long, IJobsDAO> {
	@Resource
	private IJobsDAO jobsDAO;

	@Override
	public IJobsDAO getGenericDAO() {
		return jobsDAO;
	}

	public List<Jobs> getLatestJobsBySize(int size) {
		Pager<Jobs> pager = new Pager<Jobs>();
		pager.setPageSize(size);
		pager.getParamCondition().addParameter("status", "0");

		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	public List<Jobs> getRelateJobsBySize(int size) {
		ParamCondition condition = new ParamCondition();
		List<Jobs> jobs = jobsDAO.getEntitiesByParamCondition(condition, 0, size);
		return jobs;
	}

	public Enterprise getEnterpriseFromJob(Long id) {
		Jobs job = getEntityById(id);
		return job == null ? null : job.getEnterprise();
	}

	/**
	 * 冻结招聘
	 * @param id
	 * @param desc
	 * @return
	 */
	public Jobs freeze(Long id, String desc) {
		Jobs job = getGenericDAO().getEntityById(id);
		job.setStatus(1); // 冻结状态
		job.setFreezeDesc(desc);
		getGenericDAO().update(job);
		return job;
	}

	public void freeze(List<Long> ids, String desc) {
		for (Long id : ids) {
			freeze(id, desc);
		}
	}

	public int getPublishJobCount(Long enterpriseId) {
		// TODO Auto-generated method stub
		ParamCondition cond = new ParamCondition();
		cond.addParameter("status", "0"); //发布状态
		cond.addParameter("enterpriseId", enterpriseId + ""); //发布ID
		return getGenericDAO().getCountOfEntitiesByParamCondition(cond);
	}
}
