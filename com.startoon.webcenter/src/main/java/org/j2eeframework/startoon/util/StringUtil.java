package org.j2eeframework.startoon.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringUtil {
	/**
	 * 过滤特殊字符
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String filter(String str) throws PatternSyntaxException {
		// String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？_]";
		String regEx = "[^0-9a-zA-Z\u4e00-\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	
	public static Long[] convertionToLong(String[] strs){
		// 将String数组转换为Long类型数组 
		Long[] longs = new Long[strs.length]; 
		//声明long类型的数组  
		for(int i = 0;i<strs.length;i++) {   
			String str = strs[i];//将strs字符串数组中的第i个值赋值给str   
			long thelong = Long.valueOf(str);//将str转换为long类型，并赋值给thelong   
			longs[i] = thelong;//将thelong赋值给 longs数组中对应的地方  
			}      
		return longs;  //返回long数组 
	}
	
	/**
	 * 判断非空 主要用于主键、字符串类型的非空判断 目前只支持Long、String、Integer、Long类型
	 * 空值：0/0.0/null/NULL
	 * 
	 * @param obj
	 *            代判断是否空的实例
	 * @return true/false
	 */

	public static boolean notNull(Object obj) {
		if (obj != null) {
			if (obj instanceof String) {
				// 如果 长度>0 并且 <>"null" 返回true，否则，false
				if (obj.toString().trim().length() > 0
						&& !obj.toString().trim().equalsIgnoreCase("null")) {
					return true;
				} else {
					return false;
				}

			} else if (obj instanceof Long) {
				Long new_name = (Long) obj;
				if (new_name.longValue() > 0.0) {
					return true;
				}

			} else if (obj instanceof Integer) {
				Integer new_name = (Integer) obj;
				if (new_name.intValue() > 0) {
					return true;
				}

			} else if (obj instanceof Long) {
				Long new_name = (Long) obj;
				if (new_name.doubleValue() > 0.0) {
					return true;
				}

			} else if (obj instanceof List) {
				return ((List) obj).size() > 0;

			} else if (obj instanceof Set) {
				return ((Set) obj).size() > 0;

			} else if (obj instanceof Object[]) {
				return Array.getLength(obj) > 0;

			}
		}
		return false;
	}
	
	
	
	public static String getStringByByteSize(String target, int length) {
		
		if(target==null)
			return null;
		
		if(target.length()<length) {
			return target;
		}
		
		String dest = null;
		int pos = length;
		
		try {
			
			while(true) {
				
				dest = target.substring(0, pos);
				byte[] b = dest.getBytes("GBK");
				if(b.length>=length*2) {
					break;
				}
				
				pos++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dest;
		
	}	

	public static boolean containString(String str, String substr) {
		if(str==null || substr==null) {
			return false;
		}
		
		int index = str.indexOf(substr);
		
		return index>0;
	}
	
	public static void main(String[] args) {
		String s1 = "7谷歌与AOL聊天工具实现彻底双向互通7谷歌与AOL聊天工具实现彻底双向互通";
		String s2 = "苹果超越谷歌成全球第一品牌苹果超越谷歌成全球第一品牌";
		System.out.println(getStringByByteSize(s1, 15));
		System.out.println(getStringByByteSize(s2, 15));
	}

}
