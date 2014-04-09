package org.j2eeframework.commons.exception;

/**加解密异常
 * @author william
 * @version 1.0.
 * @since 1.0.2
 */
public class EncryptException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EncryptException()
	{
		super();
	}
	public EncryptException(String errorMsg)
	{
		super(errorMsg);
	}
	public EncryptException(Throwable t)
	{
		super(t);
	}
	public EncryptException(String errorMsg, Throwable cause)
	{
		initCause(cause);
	}
}
