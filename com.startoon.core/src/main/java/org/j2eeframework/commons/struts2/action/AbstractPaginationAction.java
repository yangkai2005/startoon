package org.j2eeframework.commons.struts2.action;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.struts2.interceptor.PagerAware;
import org.j2eeframework.commons.struts2.interceptor.RememberParamAware;

import com.opensymphony.xwork2.ActionSupport;

public  class AbstractPaginationAction<T> extends ActionSupport implements PagerAware<T>,RememberParamAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6771435725601783426L;
	private Pager<T> pager;
	public void setPager(Pager<T> pager)
	{
		this.pager = pager;
	}
	public Pager<T> getPager()
	{
		return pager;
	}
	

}
