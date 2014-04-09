package org.j2eeframework.startoon.web.actions.enterprises;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Cert;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.CertService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EntCertAction extends ServiceBasePaginationAction<Cert, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8324962305039511731L;

	//private static final Log log = LogFactory.getLog(EntCertAction.class);
	
	@Resource
	private CertService certService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	private Long enterpriseId;
	
	private Enterprise enterprise;
	
	@Resource
	private EntInfoService entInfoService;
	
	private EntInfo entInfo;

	@Override
	public IGenericService<Cert, Long> getGenericService() {
		return certService;
	}

	@Override
	public void preExecute() {
		enterprise = enterpriseService.getEntityById(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
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

}
