package org.j2eeframework.startoon.web.actions.enterprises;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EntHrAction extends ServiceBasePaginationAction<Jobs, Long> {

	private static final long serialVersionUID = 7542693943595997257L;

	private static final Log log = LogFactory.getLog(EntHrAction.class);

	@Resource
	private JobsService jobsService;
	@Resource
	private EntInfoService entInfoService;
	@Resource
	private EnterpriseService enterpriseService;

	private EntInfo entInfo;
	private Long enterpriseId;
	private Enterprise enterprise;

	@Override
	public IGenericService<Jobs, Long> getGenericService() {
		return jobsService;
	}

	@Override
	public void preExecute() {
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		log.debug("enterpriseId:" + enterpriseId + "\t EntInfo:" + entInfo);

		getPager().getParamCondition().addParameter("enterpriseId", enterpriseId + "");
		getPager().getParamCondition().addParameter("status", "0");
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}