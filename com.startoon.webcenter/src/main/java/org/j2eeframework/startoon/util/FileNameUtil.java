package org.j2eeframework.startoon.util;

import java.util.Date;
import java.util.UUID;

import org.j2eeframework.commons.util.DateUtil;

public class FileNameUtil {
	
	/**
	 * 获取唯一的文件名
	 * @param fileExtName
	 * @return
	 */
	public static String getUniqueFileName(String fileExtName) {
		// 存放路径
		String filePath = DateUtil.formatDateByPattern(new Date(), "yyyy/MM/dd");
		String fileName = getFileNameWithExtenstion(fileExtName);
		return filePath + "/" + fileName;
	}

	public static String getFileNameWithoutExtenstion() {
		return UUID.randomUUID().toString();
	}

	public static String getFileNameWithExtenstion(String extenstionName) {
		return getFileNameWithoutExtenstion() + "." + extenstionName;
	}
	
	public static void main(String[] args) {
		String fn = getUniqueFileName("jpg");
		System.out.println(fn);
	}
	
	
}
