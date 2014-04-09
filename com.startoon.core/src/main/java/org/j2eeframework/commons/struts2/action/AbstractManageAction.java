package org.j2eeframework.commons.struts2.action;

import org.j2eeframework.commons.struts2.interceptor.ActionPathAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class AbstractManageAction<T> extends ActionSupport implements
ModelDriven<T>,Preparable,ActionPathAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 285137114882610915L;


}
