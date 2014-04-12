/**
 * @Title: ExampleJob.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author yangkai_2005@163.com
 * @date 2011-8-23 下午03:40:36 
 * @version V1.0
 */
package org.j2eeframework.startoon.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.commons.SystemConfig;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * @author kai
 * 
 */
public class FileCheckJob extends QuartzJobBean {

	private static final Log log = LogFactory.getLog(FileCheckJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		log.info("木马文件检查作业开始调度：" + DateUtil.formatDateTime(new Date()));
		VirusDetector detector = new VirusDetector(SystemConfig.VIRUS_DETECT_PATH);
		detector.cleanVirus();
		log.info("木马文件检查作业调度：" + DateUtil.formatDateTime(new Date()));
	}

}

class VirusDetector {

	private static final Log log = LogFactory.getLog(VirusDetector.class);

	private String path;

	private List<File> virusFiles = new ArrayList<File>();
	
	private List<String> files = new ArrayList<String>();

	public VirusDetector(String path) {
		super();
		this.path = path;
	}

	public static void main(String[] args) {
		String path = "E:\\workspace\\startoon\\startoon20121227\\src\\main\\webapp";
		VirusDetector detector = new VirusDetector(path);
		detector.cleanVirus();
	}
	
	public void cleanVirus() {

		File dir = new File(path);
		listFile(dir);

		if (virusFiles.isEmpty()) {
			log.info("未检测到木马！");

		} else {
			log.info(">>> 木马列表:");
			for (File file : virusFiles) {
				log.info(file.getName() + "|" + file.getAbsolutePath());
			}
			log.info(">>> 木马列表  <<<");
		}

		delete();
		
	}

	public void listFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				listFile(f);
			}
		} else {
			String ext = FilenameUtils.getExtension(file.getName());
			if ("jsp".equalsIgnoreCase(ext)) {
				findText(file);
			}

		}
	}

	public void findText(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String str = null;
			while ((str = reader.readLine()) != null) {
				if (str.indexOf("java.io") > 0) {
					log.warn(">>>找到木马文件:" + file.getAbsolutePath());
					virusFiles.add(file);
					files.add(file.getAbsolutePath());
					break;
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		for (String path: files) {
			File file = new File(path);
			file.delete();
		}
	}

}