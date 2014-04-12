package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IJobFavoriteDAO;
import org.j2eeframework.information.entity.JobFavorite;
import org.springframework.stereotype.Service;

@Service
public class JobFavoriteService extends AbstractService<JobFavorite, Long, IJobFavoriteDAO> {
	@Resource
	private IJobFavoriteDAO jobFavoriteDAO;

	@Override
	public IJobFavoriteDAO getGenericDAO() {
		return jobFavoriteDAO;
	}

	public JobFavorite findByLogicId(Long jid, Long uid) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("jobId", jid + "");
		cond.addParameter("userId", uid + "");

		List<JobFavorite> list = getGenericDAO().getEntitiesByParamCondition(cond, 0, 1);

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;

	}

	public int getCountByLogicId(Long jid, Long uid) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("jobId", jid + "");
		cond.addParameter("userId", uid + "");

		int count = getGenericDAO().getCountOfEntitiesByParamCondition(cond);

		return count;

	}

}
