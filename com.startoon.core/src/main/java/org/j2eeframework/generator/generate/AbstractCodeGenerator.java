package org.j2eeframework.generator.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import org.j2eeframework.generator.generate.commons.Constant;

import freemarker.template.Configuration;
import freemarker.template.Template;

public abstract class AbstractCodeGenerator
{
	/**
	 * 模板位置
	 */
	protected static final String TEMPLATEPATH = Constant.TEMPLATEPATH;
	private static final String CODEPATH = Constant.CODEPATH;
	private static final String TESTCODEPATH = Constant.TESTCODEPATH;
	protected static final String SYSTEM_ENCODING = Constant.SYSTEM_ENCODING;
	protected static final String PROJECT_PATH = Constant.PROJECT_PATH;
	
	
	/**
	 * 产生代码的变量
	 */
	private final Map<String,String> variable;
	
	public AbstractCodeGenerator(Map<String,String> variable)
	{
		this.variable = variable;
	}
	
	public void generateFile(){
		try {
			String fileNamePath = getFilePath();
			File file = new File(fileNamePath);
			if( file.exists() && !getOverWrite() )
			{
				System.out.println("已存在，默认不覆盖:"+fileNamePath);
				return;
			}
			String fileDir = getFileDirPath();
			Template template = getConfiguration().getTemplate(getTemplateFileName());
			org.apache.commons.io.FileUtils.forceMkdir(new File(fileDir + "/"));
			Writer out = new OutputStreamWriter(new FileOutputStream(
					fileNamePath), SYSTEM_ENCODING);
			template.process(variable, out);
			out.close();
			System.out.println("生成成功:"+fileNamePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	abstract protected String getTemplateFileName();
	
	/**是否强制覆盖已经存在文件
	 * @return
	 * @author william
	 */
	protected boolean getOverWrite()
	{
		String overWrite = variable.get("OverWrite");
		return "true".equals(overWrite);
	}
	
	
	/**设置FreeMarker配置
	 * @return
	 * @throws IOException
	 * @author william
	 */
	protected Configuration getConfiguration() throws IOException {
		Configuration cfg = new Configuration();
		String path = getTemplatepath();
		//File templateDirFile = new File(path);
		//cfg.setDirectoryForTemplateLoading(templateDirFile);
		//类加载路径
		cfg.setClassForTemplateLoading(AbstractCodeGenerator.class,path);

		cfg.setLocale(Locale.CHINA);
		cfg.setDefaultEncoding("UTF-8");
		return cfg;
	}
	
	
	/**取得生成文件的路径
	 * @return
	 * @author william
	 */
	protected String getFilePath()
	{
		String entityName = variable.get("className");
		String path = getFileDirPath();
		path += entityName+".java";
		return path;
		
	}
	
	/**取得生成文件所在目录
	 * @return
	 * @author william
	 */
	protected String getFileDirPath()
	{
		String path = getProjectPath();
		String entityPackage = variable.get("classPackagePath");
		
		StringBuilder str = new StringBuilder();
		str.append(path);
		str.append(getCodepath());
		str.append(convertPackageToDirStyle(entityPackage));
		str.append("/");
		
		return str.toString();
	}
	
	/**将包路径转化为目录形式
	 * @return
	 * @author william
	 */
	protected String convertPackageToDirStyle(String entityPackage)
	{
		return entityPackage != null ? entityPackage.replace(".", "/"):null;
	}
	
	/*
	 * 得到项目代码的绝对路径，到src
	 */
	protected String getProjectPath() {
		
		String path = System.getProperty("user.dir").replace("\\", "/") + "/";
		
//		return path;
		
//		path = PROJECT_PATH.replace("\\", "/");
		if(!path.endsWith("/")) {
			path = path + "/";
		}
		
		return path;
	}
	
	protected  String getTemplatepath()
	{
		return TEMPLATEPATH;
	}

	protected  String getCodepath()
	{
		return CODEPATH;
	}

	protected  String getTestcodepath()
	{
		return TESTCODEPATH;
	}

	protected  String getSystemEncoding()
	{
		return SYSTEM_ENCODING;
	}

	protected Map<String, String> getVariable()
	{
		return variable;
	}
	
	
}