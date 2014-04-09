package org.j2eeframework.commons.file;

/**
 * 文件信息，包括名称路径等
 * 
 * @author william
 * 
 */
public class FileItemInfo {
	
	/**
	 * 文件名
	 */
	private String nameWithoutExt;
	
	/**
	 * 文件存放路径
	 */
	private String fileUrl;
	
	/**
	 * 文件的扩展名
	 */
	private String extension; 

	public String getFileName() {
		return nameWithoutExt + "." + extension;
	}

	public String getFileId() {
		return fileUrl + "/" + getFileName();
	}

	public String getNameWithoutExt() {
		return nameWithoutExt;
	}

	public void setNameWithoutExt(String nameWithoutExt) {
		this.nameWithoutExt = nameWithoutExt;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

}
