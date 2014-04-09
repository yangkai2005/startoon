package org.j2eeframework.startoon.web.actions;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseListAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = 8572525686884837113L;

	private static final Log log = LogFactory.getLog(EnterpriseListAction.class);	
	
	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	@Override
	public void preExecute() {
		log.debug("按企业字母分类查询企业");
		getPager().setPageSize(80);
		
		if(getPager().getParamCondition().isParameterNull("pinyin"))
			getPager().getParamCondition().addParameter("pinyin", "A");
			
	}

}
