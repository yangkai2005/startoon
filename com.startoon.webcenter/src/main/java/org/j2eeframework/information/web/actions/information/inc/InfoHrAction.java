package org.j2eeframework.information.web.actions.information.inc;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoHrAction extends ServiceBasePaginationAction<Info, Long> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1821532029649789073L;

	private static final Log log = LogFactory.getLog(InfoHrAction.class);

	@Resource
	private InfoService infoService;
	
	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		getPager().getParamCondition().addParameter("status", "6");
	}
	
	public String execute() {
		log.debug("人才服务-人才工作站...");
		super.execute();
		return SUCCESS;
	}

}
