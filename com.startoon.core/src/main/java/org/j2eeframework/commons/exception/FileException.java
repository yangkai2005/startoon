package org.j2eeframework.commons.exception;

/**
 * 保存文件失败
 * 
 * @author william
 * 
 */
public class FileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileException() {
		super();
	}

	public FileException(String errorMsg) {
		super(errorMsg);
	}

	public FileException(Throwable t) {
		super(t);
	}

	public FileException(String errorMsg, Throwable cause) {
		initCause(cause);
	}

}
