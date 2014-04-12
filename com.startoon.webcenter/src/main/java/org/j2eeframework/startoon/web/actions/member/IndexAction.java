package org.j2eeframework.startoon.web.actions.member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1793533536222102040L;

	private static final Log log = LogFactory.getLog(IndexAction.class);
	
	
	public String execute() {
		log.debug(">>> 个人会员中心...");
		
		return SUCCESS;
	}

	
	
}
