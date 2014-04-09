package org.j2eeframework.generator.generate.service;

import java.util.HashMap;
import java.util.Map;

import org.j2eeframework.generator.generate.AbstractCodeGenerator;

/**Service类文件产生器
 * @author william
 *
 */
public class ServiceCodeGenerator extends AbstractCodeGenerator
{

	/**需要传入变量如下：
	 * classPackagePath--接口类所在包路径<br>
	 * className--产生类名称<br>
	 * entityName--实体名称<br>
	 * entityPackagePath--实体类路径<br>
	 * daoInterfacePackagePath--dao接口类路径<br>
	 * daoInterfaceName--dao接口类名称<br>
	 * daoVariableName--dao接口变量名称<br>
	 * @param variable
	 */
	public ServiceCodeGenerator(Map<String, String> variable)
	{
		super(variable);
	}
	
	public static void main(String[] args)
	{
		Map<String,String> variable = new HashMap<String,String>();
		variable.put("classPackagePath", "org.j2eeframework.example.service");
		variable.put("className", "TestService");
		variable.put("entityName", "Test");
		variable.put("entityPackagePath", "org.j2eeframework.example.entity");
		variable.put("daoInterfacePackagePath", "org.j2eeframework.example.dao");
		variable.put("daoInterfaceName", "ITestDAO");
		variable.put("daoVariableName", "testDAO");
		ServiceCodeGenerator dicg = new ServiceCodeGenerator(variable);
		dicg.generateFile();
	}

	@Override
	protected String getTemplateFileName()
	{
		return "service/ServiceTemplate.ftl";
	}

}