package org.j2eeframework.generator.generate.jsp;

import java.util.Map;

import org.j2eeframework.commons.util.WordDealUtil;
import org.j2eeframework.generator.generate.AbstractCodeGenerator;

/**实体类列表JSP文件产生器
 * @author william
 *
 */
public class JSPEntityListCodeGenerator extends AbstractCodeGenerator
{

	/**需要传入变量如下：
	 * classPackagePath--接口类所在包路径<br>
	 * namespace--命名空间<br>
	 * manageActionName--管理ActionJSP页面名称<br>
	 * listActionName--列表ActionJSP页面名称<br>
	 * @param variable
	 */
	public JSPEntityListCodeGenerator(Map<String, String> variable)
	{
		super(variable);
	}
	
	
	/**取得生成文件的路径
	 * @return
	 * @author william
	 */
	@Override
	protected String getFilePath()
	{
		String entityName = getVariable().get("className");
		String path = getFileDirPath();
		path += WordDealUtil.wordFormat4JSP(entityName)+"-list.jsp";
		return path;
		
	}
	
	/**取得生成文件所在目录
	 * @return
	 * @author william
	 */
	@Override
	protected String getFileDirPath()
	{
		String path = getProjectPath();
		
		StringBuilder str = new StringBuilder();
		str.append(path);
		str.append("/src/main/webapp/");
		str.append(getVariable().get("namespace"));
		str.append("/");
		
		return str.toString();
	}

	@Override
	protected String getTemplateFileName()
	{
		return "jsp/JSPEntityListTemplate.ftl";
	}

}