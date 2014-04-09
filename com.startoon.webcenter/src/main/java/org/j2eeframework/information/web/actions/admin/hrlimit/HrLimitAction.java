package org.j2eeframework.information.web.actions.admin.hrlimit;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.information.service.HrLimitService;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class HrLimitAction extends ServiceBaseManageAction<HrLimit, Long> {

	private static final Log log = LogFactory.getLog(HrLimitAction.class);

	private static final long serialVersionUID = -4337637444054736517L;
	@Resource
	private HrLimitService hrLimitService;
	@Resource
	private EnterpriseService enterpriseService;

	private HrLimit hrLimit;

	private Long entId;
	private Integer lvl;

	@Override
	public IGenericService<HrLimit, Long> getGenericService() {
		return hrLimitService;
	}

	public HrLimit getModel() {
		return hrLimit;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			hrLimit = new HrLimit();
		} else {
			hrLimit = hrLimitService.getEntityById(getRequestId());
		}
	}

	public String upgrade() {

		Enterprise ent = hrLimit.getEnterprise();
		Integer level = ent.getMemberLevel();
		level = level == null ? 0 : level;
		level += 1;
		level = level > 2 ? 2 : level;
		ent.setMemberLevel(level);

		enterpriseService.update(ent);

		Date now = new Date();
		Date dueTime = null;
		if (level == 1) {
			dueTime = DateUtil.addMonths(now, 3);
			hrLimit.setMemberDeadTime(dueTime);
			hrLimit.setMaxJobCount(15);
			hrLimit.setMaxViewCount(200);
			hrLimit.setMemberLevel(level);
		} else if (level == 2) {
			dueTime = DateUtil.addYears(now, 1);
			hrLimit.setMemberDeadTime(dueTime);
			hrLimit.setMaxJobCount(99999);
			hrLimit.setMaxViewCount(99999);
			hrLimit.setMemberLevel(level);
		}

		hrLimit.setBecomeMemberTime(now);

		getGenericService().update(getModel());

		return ResultConstants.LIST;
	}

	public String down() {

		Enterprise ent = hrLimit.getEnterprise();
		Integer level = ent.getMemberLevel();
		level = level == null ? 0 : level;
		level -= 1;
		level = level < 0 ? 0 : level;
		ent.setMemberLevel(level);

		enterpriseService.update(ent);

		Date now = new Date();
		Date dueTime = null;
		if (level == 1) {
			dueTime = DateUtil.addMonths(now, 3);
			hrLimit.setMemberDeadTime(dueTime);
			hrLimit.setMaxJobCount(15);
			hrLimit.setMaxViewCount(200);
			hrLimit.setMemberLevel(level);
		} else if (level == 0) {
			dueTime = DateUtil.addMonths(now, 3);
			hrLimit.setMemberDeadTime(dueTime);
			hrLimit.setMaxJobCount(5);
			hrLimit.setMaxViewCount(50);
			hrLimit.setMemberLevel(level);
		}

		getGenericService().update(hrLimit);

		return ResultConstants.LIST;
	}

	public Long getEntId() {
		return entId;
	}

	public void setEntId(Long entId) {
		this.entId = entId;
	}
}
