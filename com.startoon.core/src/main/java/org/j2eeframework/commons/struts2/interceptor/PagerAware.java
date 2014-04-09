package org.j2eeframework.commons.struts2.interceptor;

import org.j2eeframework.commons.pager.Pager;

/**
 * 设置分页对象接口，实现此接口，PagerSupportInterceptor会将pager对象注入至相应对象中
 * 
 * @author william
 * 
 * @param <T>
 */
public interface PagerAware<T> {
	public void setPager(Pager<T> pager);
}