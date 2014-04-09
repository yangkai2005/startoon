package org.j2eeframework.commons.exception;

public class ZitopCommonException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ZitopCommonException()
	{
		super();
	}
	public ZitopCommonException(String errorMsg)
	{
		super(errorMsg);
	}
	public ZitopCommonException(Throwable t)
	{
		super(t);
	}
	public ZitopCommonException(String errorMsg, Throwable cause)
	{
		initCause(cause);
	}
}
