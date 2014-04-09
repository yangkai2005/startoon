package org.j2eeframework.generator.generate.struts2;

import java.util.HashMap;
import java.util.Map;

import org.j2eeframework.commons.util.NonceUtils;
import org.j2eeframework.generator.generate.AbstractCodeGenerator;

/**列表Action类文件产生器
 * @author william
 *
 */
public class ListActionCodeGenerator extends AbstractCodeGenerator
{

	/**需要传入变量如下：
	 * classPackagePath--接口类所在包路径<br>
	 * className--产生类名称<br>
	 * entityName--实体名称<br>
	 * entityPackagePath--实体类路径<br>
	 * servicePackagePath--service类路径<br>
	 * serviceName--service类名称<br>
	 * serviceVariableName--service类变量名称<br>
	 * @param variable
	 */
	public ListActionCodeGenerator(Map<String, String> variable)
	{
		super(variable);
	}
	
	public static void main(String[] args)
	{
		Map<String,String> variable = new HashMap<String,String>();
		variable.put("classPackagePath", "org.j2eeframework.example.web.actions.example");
		variable.put("className", "TestListAction");
		variable.put("entityName", "Test");
		variable.put("entityPackagePath", "org.j2eeframework.example.entity");
		variable.put("servicePackagePath", "org.j2eeframework.example.service");
		variable.put("serviceName", "TestService");
		variable.put("serviceVariableName", "testService");
		long serialVersionUID = NonceUtils.randomLong()
		+ NonceUtils.currentMills();
		variable.put("serialVersionUID", serialVersionUID+"");
		ListActionCodeGenerator dicg = new ListActionCodeGenerator(variable);
		dicg.generateFile();
	}

	@Override
	protected String getTemplateFileName()
	{
		return "struts2/ListActionTemplate.ftl";
	}

}