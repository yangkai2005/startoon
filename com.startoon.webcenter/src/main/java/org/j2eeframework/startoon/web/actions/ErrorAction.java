package org.j2eeframework.startoon.web.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ErrorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6385191292509498389L;

	
	@Override
	public String execute() {
		addActionError();
		return SUCCESS;
	}
	
    public void addActionError() {
    	super.addActionError("hello, action error!");
    }
}
