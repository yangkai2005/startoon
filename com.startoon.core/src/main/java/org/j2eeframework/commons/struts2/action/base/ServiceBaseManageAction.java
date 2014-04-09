package org.j2eeframework.commons.struts2.action.base;

import java.io.Serializable;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.AbstractManageAction;
import org.j2eeframework.commons.struts2.action.ResultConstants;

/**
 * 基于Service层通用实现的方便CRUD管理类<br>
 * 继承此类可以获取系统预定的方便CRUD功能，子类必须传入相应的Service实现（实现了接口IGenericService）<br>
 * 子类也可以覆盖相关的方法，满足定制需求
 * @author william
 *
 * @param <T>
 * @param <ID>
 * @param <DAO>
 */
public abstract class ServiceBaseManageAction<T,ID extends Serializable> extends AbstractManageAction<T>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long requestId;//实体id
	private boolean readOnly = false;//是否只读,如果需要页面字段根据此字段来判断是否只读
	private String nextMethod;
	private String actionName;
	private String namespace;
	
	public String getActionName()
	{
		return actionName;
	}

	public void setActionName(String actionName)
	{
		this.actionName = actionName;
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	/**展示数据页面
	 * @return
	 */
	@SkipValidation 
	public String show()
	{
		return ResultConstants.SHOW;
	}

	/**展示增加数据的页面
	 * @return
	 */
	@SkipValidation
	public String input()
	{
		setNextMethod(ResultConstants.INSERT);
		return ResultConstants.INPUT;
	}
	

	/**保存数据
	 * @return
	 */
	 public String insert()
	{
		 getGenericService().insert(getModel());
		 return ResultConstants.LIST ;
	}

	/**展示修改数据页面
	 * @return
	 */
	@SkipValidation
	 public String edit()
	{
		setNextMethod(ResultConstants.UPDATE);
		return ResultConstants.INPUT;
	}
	
	/**更新数据
	 * @return
	 */
	 public String update()
	{
		 getGenericService().update(getModel());
		 return ResultConstants.LIST; 
	}
	

	/**展示删除页面确认
	 * @return
	 */
	@SkipValidation
	public String destroy()
	{
		setNextMethod(ResultConstants.DELETE);
		return ResultConstants.SUCCESS;
	}

	/**删除数据
	 * @return
	 */
	 public String delete()
	 {
		 getGenericService().delete(getModel());
		 return ResultConstants.LIST; 
	 }
	
	
	public Long getRequestId()
	{
		return requestId;
	}

	public void setRequestId(Long requestId)
	{
		this.requestId = requestId;
	}

	public boolean isReadOnly()
	{
		return readOnly;
	}

	public void setReadOnly(boolean readOnly)
	{
		this.readOnly = readOnly;
	}


	public abstract IGenericService<T, ID> getGenericService();
	

	public String getNextMethod()
	{
		return nextMethod;
	}

	public void setNextMethod(String nextMethod)
	{
		this.nextMethod = nextMethod;
	}
	
	

}
