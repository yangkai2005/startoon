package org.j2eeframework.startoon.web.actions.enterprises;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.service.EntInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class EntMessageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8536682347768386281L;

	private static final Log log = LogFactory.getLog(EntMessageAction.class);
	
	@Resource
	private EntInfoService entInfoService;
	
	private EntInfo entInfo;
	
	@Override
	public String execute() {
		return SUCCESS;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

}
