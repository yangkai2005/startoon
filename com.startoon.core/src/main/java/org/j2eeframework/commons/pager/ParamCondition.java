package org.j2eeframework.commons.pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.j2eeframework.commons.util.DateUtil;

/**
 * 参数条件，收集页面传到后台的参数，并提供相关的方便方法。
 * 
 * @author william
 */
public class ParamCondition extends HashMap<String, String[]> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2471940838218450045L;

	/**
	 * 根据Key取得参数值(String型)，如果是多值参数，则返回第一个,为空返回null
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public String getParameter(String key) {
		return getParameter(key, null);
	}

	/**
	 * 根据Key取得参数值(String型)，如果是多值参数，则返回第一个,为空返回默认值
	 * 
	 * @param key
	 * @param defaultStr
	 * @return
	 * @author william
	 */
	public String getParameter(String key, String defaultStr) {
		String[] value = get(key);
		return value != null ? value[0] : defaultStr;
	}

	/**
	 * 根据Key取得参数值(Integer型)，如果是多值参数，则返回第一个,为空返回null
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public Integer getInteger(String key) {
		return getInteger(key, null);
	}

	/**
	 * 根据Key取得参数值(Integer型)，如果是多值参数，则返回第一个,为空返回默认值
	 * 
	 * @param key
	 * @param defaultInt
	 * @return
	 * @author william
	 */
	public Integer getInteger(String key, Integer defaultInt) {
		String[] value = get(key);
		return value != null ? Integer.parseInt(value[0]) : defaultInt;
	}

	/**
	 * 根据Key取得参数值(Long型)，如果是多值参数，则返回第一个,为空返回null
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public Long getLong(String key) {
		return getLong(key, null);
	}

	/**
	 * 根据Key取得参数值(Long型)，如果是多值参数，则返回第一个,为空返回默认值
	 * 
	 * @param key
	 * @param defaultInt
	 * @return
	 * @author william
	 */
	public Long getLong(String key, Long defaultInt) {
		String[] value = get(key);
		return value != null ? Long.parseLong(value[0]) : defaultInt;
	}

	/**
	 * 根据Key取得参数值(Date型)，如果是多值参数，则返回第一个,为空返回默认值
	 * 
	 * @param key
	 * @param pattern
	 * @param defaultDate
	 * @return
	 * @author william
	 */
	public Date getDate(String key, String pattern, Date defaultDate) {
		String[] value = get(key);
		return value != null ? DateUtil.parseDateByPattern(value[0], pattern) : defaultDate;
	}

	/**
	 * 根据Key取得参数值(Date型，默认使用{@link DateUtil.ISO_DATE_FORMAT}
	 * 格式日期)，如果是多值参数，则返回第一个,为空返回null
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public Date getDate(String key) {
		return getDate(key, DateUtil.ISO_DATE_FORMAT, null);
	}

	/**
	 * 根据Key取得参数值(Date型，默认使用{@link DateUtil.ISO_DATE_TIME_FORMAT}
	 * 格式日期)，如果是多值参数，则返回第一个,为空返回null
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public Date getDateTime(String key) {
		return getDate(key, DateUtil.ISO_DATE_TIME_FORMAT, null);
	}

	/**
	 * 根据Key取得参数值列表（String型）
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public List<String> getStringList(String key) {
		List<String> list = new ArrayList<String>();
		String[] value = get(key);
		if (value != null) {
			for (String v : value) {
				list.add(v);
			}
		}
		return list;
	}

	/**
	 * 根据Key取得参数值列表（Integer型）
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public List<Integer> getIntegerList(String key) {
		List<Integer> list = new ArrayList<Integer>();
		String[] value = get(key);
		if (value != null) {
			for (String v : value) {
				list.add(Integer.parseInt(v));
			}
		}
		return list;
	}

	/**
	 * 根据Key取得参数值列表（Long型）
	 * 
	 * @param key
	 * @return
	 * @author william
	 */
	public List<Long> getLongList(String key) {
		List<Long> list = new ArrayList<Long>();
		String[] value = get(key);
		if (value != null) {
			for (String v : value) {
				list.add(Long.parseLong(v));
			}
		}
		return list;
	}

	/**
	 * 增加查询参数(单值)
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @author william
	 */
	public void addParameter(String key, String value) {
		String[] values = new String[] { value };
		put(key, values);
	}

	/**
	 * 增加多值查询参数
	 * 
	 * @param key
	 * @param values
	 * @author william
	 */
	public void addParameterValues(String key, String[] values) {
		put(key, values);
	}

	/**
	 * 判断给定参数是否为null
	 * 
	 * @param key
	 * @return
	 */
	public boolean isParameterNull(String key) {
		return getParameter(key) == null;
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean isBlank(String key) {
		return org.apache.commons.lang.StringUtils.isBlank(getParameter(key));
	}

	/**
	 * @param key
	 * @return
	 */
	public boolean isNotBlank(String key) {
		return org.apache.commons.lang.StringUtils.isNotBlank(getParameter(key));
	}

}