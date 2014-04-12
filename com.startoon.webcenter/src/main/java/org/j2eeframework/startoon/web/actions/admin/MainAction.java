package org.j2eeframework.startoon.web.actions.admin;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7954128162843245597L;
	
	@Action(value="main", results = { @Result(name = "success", location = "/WEB-INF/content/admin/main/index.jsp") })
	public String execute() {
		return SUCCESS;
	}

	

}
