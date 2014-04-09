package org.j2eeframework.commons.exception;

/**保存文件失败
 * @author william
 *
 */
public class SaveFileException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public SaveFileException()
	{
		super();
	}
	public SaveFileException(String errorMsg)
	{
		super(errorMsg);
	}
	public SaveFileException(Throwable t)
	{
		super(t);
	}
	public SaveFileException(String errorMsg, Throwable cause)
	{
		initCause(cause);
	}

}
