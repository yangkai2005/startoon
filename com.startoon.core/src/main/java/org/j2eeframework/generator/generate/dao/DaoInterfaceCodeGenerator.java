package org.j2eeframework.generator.generate.dao;

import java.util.HashMap;
import java.util.Map;

import org.j2eeframework.generator.generate.AbstractCodeGenerator;

/**Dao层接口文件产生器
 * @author william
 *
 */
public class DaoInterfaceCodeGenerator extends AbstractCodeGenerator
{

	/**需要传入变量如下：
	 * classPackagePath--接口类所在包路径<br>
	 * className--产生类名称<br>
	 * entityName--实体名称<br>
	 * entityPackagePath--实体类路径<br>
	 * @param variable
	 */
	public DaoInterfaceCodeGenerator(Map<String, String> variable)
	{
		super(variable);
	}
	
	public static void main(String[] args)
	{
		Map<String,String> variable = new HashMap<String,String>();
		variable.put("classPackagePath", "org.j2eeframework.example.dao");
		variable.put("className", "ITestDAO");
		variable.put("entityName", "Test");
		variable.put("entityPackagePath", "org.j2eeframework.example.entity");
		DaoInterfaceCodeGenerator dicg = new DaoInterfaceCodeGenerator(variable);
		dicg.generateFile();
	}

	@Override
	protected String getTemplateFileName()
	{
		return "dao/DaoInterfaceTemplate.ftl";
	}

}
