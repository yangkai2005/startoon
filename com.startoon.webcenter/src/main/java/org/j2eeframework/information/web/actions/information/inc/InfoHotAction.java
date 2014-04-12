package org.j2eeframework.information.web.actions.information.inc;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoHotAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 831626779866232809L;

	@Resource
	private InfoService infoService;
	
	private List<Info> hotInfos;
	
	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
		//TODO:
	}
	
	public String execute() {
		
		hotInfos = infoService.getHotInfo(10);
		
		return SUCCESS;
	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

}
