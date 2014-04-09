package org.j2eeframework.commons.exception;

public class DateUtilityException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DateUtilityException()
	{
		super();
	}
	public DateUtilityException(String errorMsg)
	{
		super(errorMsg);
	}
	public DateUtilityException(Throwable t)
	{
		super(t);
	}
	public DateUtilityException(String errorMsg, Throwable cause)
	{
		initCause(cause);
	}
}
