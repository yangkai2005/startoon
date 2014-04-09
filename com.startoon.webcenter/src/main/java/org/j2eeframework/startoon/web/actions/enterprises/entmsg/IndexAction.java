package org.j2eeframework.startoon.web.actions.enterprises.entmsg;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EntMsgService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class IndexAction extends ServiceBasePaginationAction<EntMsg, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7086426221429209500L;

	@Resource
	private EntMsgService entMsgService;

	@Resource
	private EntInfoService entInfoService;

	@Resource
	private EnterpriseService enterpriseService;

	private Enterprise enterprise;

	private EntInfo entInfo;

	private Long enterpriseId;

	private Integer flag;

	@Override
	public IGenericService<EntMsg, Long> getGenericService() {
		return entMsgService;
	}

	@Override
	public void preExecute() {
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);

		Pager<EntMsg> pager = getPager();
		int pageSize = 3;
		pager.setPageSize(pageSize);
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

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
