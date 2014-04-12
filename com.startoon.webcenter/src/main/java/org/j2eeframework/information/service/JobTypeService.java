package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IJobTypeDAO;
import org.j2eeframework.information.entity.JobType;
import org.springframework.stereotype.Service;

@Service
public class JobTypeService extends AbstractService<JobType, Long, IJobTypeDAO> {

	@Resource
	private IJobTypeDAO jobTypeDAO;

	@Override
	public IJobTypeDAO getGenericDAO() {
		return jobTypeDAO;
	}

	@Override
	public JobType insert(JobType job) {
		JobType p = job.getParent();
		if (p != null) {
			int lvl = p.getLvl();
			job.setLvl(lvl + 1);
		}

		return getGenericDAO().insert(job);
	}

	@Override
	public JobType update(JobType job) {
		JobType p = job.getParent();
		if (p != null) {
			int lvl = p.getLvl();
			job.setLvl(lvl + 1);
		} else {
			job.setLvl(1);
		}

		return getGenericDAO().update(job);
	}

	public JSONObject getJSONObject(JobType jobType) {

		if (jobType == null) {
			return null;
		}

		JSONObject json = new JSONObject();
		json.put("id", jobType.getId());
		json.put("name", jobType.getName());
		if (jobType.getParent() != null) {
			json.put("pid", jobType.getParent().getId());
		} else {
			json.put("pid", 0);
		}

		return json;
	}

	public String getJSONString(JobType jobType) {
		return getJSONObject(jobType).toString();
	}

	public String getJSONString(List<JobType> jobTypes) {

		if (jobTypes != null && !jobTypes.isEmpty()) {
			JSONArray arr = new JSONArray();
			for (JobType type : jobTypes) {
				arr.add(getJSONObject(type));
			}

			return arr.toString();
		}

		return null;
	}

	public String getAllJSONString() {
		List<JobType> all = getGenericDAO().getAllEntity();
		String jsonString = getJSONString(all);
		return jsonString;
	}

	public List<JobType> getJobTypeByLevel(int lvl) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("lvl", lvl + "");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 100);
	}
}
