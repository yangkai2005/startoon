package org.j2eeframework.information.web.actions.information.inc;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

import com.opensymphony.xwork2.ActionSupport;

public class InfoLatestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -445067053240837747L;
	
	@Resource
	private InfoService infoService;
	
	private List<Info> latestInfos;
	
	public String execute() {
		
		Pager<Info> pager = new Pager<Info>();
		infoService.getEntitiesOfPagerByParamCondition(pager);
		latestInfos = pager.getItems();

		return SUCCESS;
	}

	public List<Info> getLatestInfos() {
		return latestInfos;
	}

	public void setLatestInfos(List<Info> latestInfos) {
		this.latestInfos = latestInfos;
	}

}
