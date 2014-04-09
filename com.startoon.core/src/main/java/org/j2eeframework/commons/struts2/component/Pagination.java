package org.j2eeframework.commons.struts2.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 分页UI BEAN
 * 
 * @author william
 * 
 */
@StrutsTag(name = "pagination", tldTagClass = "org.j2eeframework.commons.struts2.component.PaginationTag", description = "返回分页条", allowDynamicAttributes = true)
public class Pagination extends UIBean
{
	final public static String DEFAULT_TEMPLATE = "pagination";
	private String template = DEFAULT_TEMPLATE;

	public Pagination(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
	}

	/**
	 * getDefaultTemplate()方法用于返回模板的名字，Struts2会自动在后面加入.ftl扩展名以找到特定的模板文件
	 * 
	 * @see org.apache.struts2.components.UIBean#getDefaultTemplate()
	 */
	@Override
	protected String getDefaultTemplate()
	{
		return template;
	}

	/**
	 * 覆写evaluateExtraParams（）方法，在UIBean初始化后会调用这个方法来初始化设定参数，如addParameter方法，会在freemarker里的parameters里加入一个key
	 * value。这里要注意findString，还有相关的findxxxx方法，它们是已经封装好了的解释ognl语法的工具，具体是怎么样的，大家可以查看一下UIBean的api doc。
	 * 
	 * @see org.apache.struts2.components.UIBean#evaluateExtraParams()
	 */
	@Override
	protected void evaluateExtraParams()
	{
		super.evaluateExtraParams();

	}


	@Override
	@StrutsTagAttribute(description="设置模板名称", type="String")
	public void setTemplate(String template)
	{
		this.template = template;
	}

}
