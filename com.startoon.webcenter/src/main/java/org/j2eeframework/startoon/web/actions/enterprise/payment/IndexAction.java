package org.j2eeframework.startoon.web.actions.enterprise.payment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179937449319387630L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	public String execute() {
		log.debug("支付首页。");
		return SUCCESS;
	}

}
