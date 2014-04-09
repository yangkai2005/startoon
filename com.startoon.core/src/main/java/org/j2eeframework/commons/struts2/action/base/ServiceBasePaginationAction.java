package org.j2eeframework.commons.struts2.action.base;

import java.io.Serializable;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.AbstractPaginationAction;

/**
 * 基于Service的分页action基础类<br>
 * 继承此类可以获取系统预定的分页功能，子类必须传入相应的Service实现（实现了接口IGenericService）<br>
 * 子类也可以覆盖相关的方法，满足定制需求
 * 
 * @author william
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class ServiceBasePaginationAction<T, ID extends Serializable> extends AbstractPaginationAction<T>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940370565644741401L;

	/**
	 * 分页查询运行类
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute()
	{
		preExecute();
		getGenericService().getEntitiesOfPagerByParamCondition(getPager());
		return SUCCESS;
	}

	/**
	 * 在execute方法运行之前运行的方法，可以进行一些前置工作等<br>
	 * 子类必须实现此方法，如果没有可为空
	 * 
	 * @author william
	 */
	public abstract void preExecute();

	public abstract IGenericService<T, ID> getGenericService();
}
