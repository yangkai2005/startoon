package org.j2eeframework.commons.file;

import java.io.File;

/**
 * 文件系统接口
 * 
 * @author william
 * 
 */
public interface IFileSystem {
	/**
	 * 保存图片文件，同时产生图片缩略图
	 * 
	 * @param uploadedFile
	 * @param basePath
	 * @param OutputWidth
	 *            缩略图宽
	 * @param OutputHeight
	 *            缩略图高
	 * @return
	 * @author william
	 */
	public FileItemInfo saveImageFileAndGenerateAbbreviative(File uploadedFile, String fileExtension, String basePath, int outputWidth, int outputHeight);

	/**
	 * 保存文件
	 * 
	 * @param uploadedFile
	 * @param basePath
	 * @return
	 * @author william
	 */
	public FileItemInfo saveFile(File uploadedFile, String fileExtension, String basePath);

}
