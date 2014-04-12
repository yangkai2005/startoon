package org.j2eeframework.startoon.web.actions.enterprise.cert;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Cert;
import org.j2eeframework.startoon.service.CertService;


public class CertListAction extends ServiceBasePaginationAction<Cert, Long> {

	private static final long serialVersionUID = -6815643682301832661L;

	@Resource
	private CertService certService;
	
	@Override
	public IGenericService<Cert, Long> getGenericService()	{
		return certService;
	}

	@Override
	public void preExecute() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", enterpriseId + "");
	}

}
