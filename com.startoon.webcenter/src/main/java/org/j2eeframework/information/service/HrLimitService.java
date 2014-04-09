package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IHrLimitDAO;
import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.springframework.stereotype.Service;

@Service
public class HrLimitService extends AbstractService<HrLimit, Long, IHrLimitDAO> {
	@Resource
	private IHrLimitDAO hrLimitDAO;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private JobsService jobsService;

	@Override
	public IHrLimitDAO getGenericDAO() {
		return hrLimitDAO;
	}

	public HrLimit getByEnterpriseId(Long eid) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("enterpriseId", eid + "");

		List<HrLimit> list = getGenericDAO().getEntitiesByParamCondition(cond, 0, 1);

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	public boolean canViewResume(Long eid) {
		boolean canView = false;
		HrLimit limit = getByEnterpriseId(eid);
		Enterprise ent = enterpriseService.getEntityById(eid);

		canView = ent.getUserType() == Enterprise.USER_TYPE_ENTERPRISE;
		canView = canView && limit != null;

		// 企业用户

		canView = canView && (limit == null || !ent.getIsFree()) ? true : (limit.getViewCount() <= limit.getMaxViewCount());

		return canView;
	}

	public boolean canPublishJob(Long eid) {
		HrLimit limit = getByEnterpriseId(eid);
		Enterprise ent = enterpriseService.getEntityById(eid);

		if (limit == null) {
			return true;
		}

		if (!ent.getIsFree()) {
			return true;
		}

		if (ent.getIsFree() && limit.getJobCount() < limit.getMaxJobCount()) {
			return true;
		}

		return false;
	}

	public HrLimit increaseJobCount(Long eid) {
		HrLimit limit = getByEnterpriseId(eid);
		if (limit == null) {
			limit = new HrLimit();

			Enterprise ent = new Enterprise();
			ent.setId(eid);
			limit.setEnterprise(ent);
		}

		int jobCount = limit.getJobCount();
		jobCount += 1;
		limit.setJobCount(jobCount);
		getGenericDAO().saveOrUpdate(limit);
		return limit;
	}

	public HrLimit increaseViewResumeCount(Long eid) {
		HrLimit limit = getByEnterpriseId(eid);

		if (limit == null) {
			limit = new HrLimit();

			Enterprise ent = new Enterprise();
			ent.setId(eid);
			limit.setEnterprise(ent);
		}

		int viewCount = limit.getViewCount();
		viewCount += 1;
		limit.setViewCount(viewCount);
		getGenericDAO().saveOrUpdate(limit);
		return limit;
	}

	/**
	 * 会员报名
	 * 
	 * @param enterpriseId
	 * @return
	 */
	public boolean apply(Long enterpriseId) {

		if (enterpriseId == null || enterpriseId == 0) {
			return false;
		}

		enterpriseService.upgrade(enterpriseId, 2);

		Enterprise ent = enterpriseService.getEntityById(enterpriseId);
		HrLimit limit = ent.getLimit();
		limit.setIsApply(true);
		hrLimitDAO.update(limit);

		return true;
	}

	public void apply(List<Long> ids) {
		if (ids == null || ids.isEmpty())
			return;

		for (Long id : ids) {
			apply(id);
		}

	}

	/**
	 * 更新企业发布职位数
	 * @param enterpriserId
	 */
	public void updateHrLimit(Long enterpriserId) {
		int count = jobsService.getPublishJobCount(enterpriserId);
		HrLimit limit = getByEnterpriseId(enterpriserId);

		if (limit == null) {
			limit = new HrLimit();
			Enterprise enterprise = new Enterprise();
			enterprise.setId(enterpriserId);
			limit.setEnterprise(enterprise);
		}

		limit.setJobCount(count);

		getGenericDAO().saveOrUpdate(limit);
	}

	public void updateHrLimit() {
		List<Long> enterprises = enterpriseService.getAllId();
		for (Long eid : enterprises) {
			updateHrLimit(eid);
		}
	}

}
