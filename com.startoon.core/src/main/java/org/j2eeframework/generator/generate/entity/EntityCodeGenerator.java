package org.j2eeframework.generator.generate.entity;

import java.util.HashMap;
import java.util.Map;

import org.j2eeframework.commons.util.NonceUtils;
import org.j2eeframework.generator.generate.AbstractCodeGenerator;

/**实体类文件产生器
 * @author william
 *
 */
public class EntityCodeGenerator extends AbstractCodeGenerator
{

	/**
	 * 需要传入变量如下：
	 * classPackagePath--接口类所在包路径<br>
	 * className--产生类名称<br>
	 * @param variable
	 */
	public EntityCodeGenerator(Map<String, String> variable)
	{
		super(variable);
	}
	
	public static void main(String[] args)
	{
		Map<String,String> variable = new HashMap<String,String>();
		variable.put("classPackagePath", "org.jeeframework.example.entity");
		variable.put("className", "Test");
		long serialVersionUID = NonceUtils.randomLong()
		+ NonceUtils.currentMills();
		variable.put("serialVersionUID", serialVersionUID+"");
		EntityCodeGenerator dicg = new EntityCodeGenerator(variable);
		dicg.generateFile();
	}

	@Override
	protected String getTemplateFileName()
	{
		return "entity/EntityTemplate.ftl";
	}

}