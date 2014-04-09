package org.j2eeframework.startoon.web.actions.enterprises;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

import com.opensymphony.xwork2.ActionSupport;

public class EntContactAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8536682347768386281L;

	private static final Log log = LogFactory.getLog(EntContactAction.class);
	
	@Resource
	private EnterpriseService enterpriseService;
	
	private Enterprise enterprise;
	
	private EntInfo entInfo;
	
	private Long enterpriseId;
	
	@Override
	public String execute() {
		enterprise = enterpriseService.getEntityById(enterpriseId);
		log.debug(">>>获取企业的联系方式：" + enterprise);
		return SUCCESS;
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
