package org.j2eeframework.commons.file;

import org.apache.commons.io.FilenameUtils;

public class FileUtils {

	/**
	 * 取得后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		return org.apache.commons.io.FilenameUtils.getExtension(fileName);
	}

	/**
	 * 取得没有后缀名的文件名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileNameWithoutExtension(String fileName) {
		return FilenameUtils.getBaseName(fileName);
	}

}
