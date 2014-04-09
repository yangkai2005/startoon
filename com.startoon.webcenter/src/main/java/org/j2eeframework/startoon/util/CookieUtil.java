package org.j2eeframework.startoon.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.startoon.commons.SystemVariables;

public class CookieUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6744633827156331820L;
	
	private static final Log log = LogFactory.getLog(CookieUtil.class);
	
	/**
	 * 添加供应ID的cookie
	 * @param request
	 * @param response
	 * @param supplyIds
	 * @return
	 */
	public static String setSupplyIdCookies(HttpServletRequest request, HttpServletResponse response, String supplyId) {
        
		String sids = "";
		
		Cookie[] cookies = request.getCookies();
        
        
        
        if(cookies != null && cookies.length>0)
        {
            for(Cookie cookie : cookies)
            {
                if(cookie.getName().equals(SystemVariables.SUPPLY_ID))
                {
                    log.debug("存在cookie " + SystemVariables.SUPPLY_ID + ": " + cookie.getValue());
                    sids = cookie.getValue();
                }
            }
        }
        List<String> idstr = new ArrayList<String>();
        idstr.add(supplyId);
        
        String newSupplyIds = appendSupplyId(sids, idstr);
        
        Cookie cookie = new Cookie(SystemVariables.SUPPLY_ID, newSupplyIds);
        cookie.setPath("/");
        response.addCookie(cookie);
        
        log.debug("新增加cookie " + SystemVariables.SUPPLY_ID + ": " + cookie.getValue());
        
        return cookie.getValue();
		
	}
	
	/**
	 * 获取最近浏览过的供应ID列表，用","分隔
	 * @param request
	 * @param response
	 * @param supplyIds
	 * @return
	 */
	public static String getSupplyIdCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>0)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals(SystemVariables.SUPPLY_ID))
				{
					log.debug("存在cookie " + SystemVariables.SUPPLY_ID + ": " + cookie.getValue());
					return cookie.getValue();
				}
			}
		}
		
		return null;
		
	}
	
	public static List<Long> getSupplyIdByCookies(HttpServletRequest request, HttpServletResponse response) {
		
		String ids = getSupplyIdCookies(request, response);
		
		List<Long> list = new ArrayList<Long>();
		if(ids!=null && ids.length()>0) {
			String[] idArr = ids.split("-");
			for(String id : idArr) {
				list.add(new Long(id));
			}
		}
		
		return list;
		
	}
	
	/**
	 * 将产品ID字符转换为Long
	 * @param ids
	 * @return
	 */
	public static List<Long> getSupplyIdByString(String ids) {
		List<Long> list = new ArrayList<Long>();
		if(ids!=null && ids.length()>0) {
			String[] idArr = ids.split("-");
			for(String id : idArr) {
				if(id!=null && id.length()>0) {
					list.add(new Long(id));
				}
			}
		}
		
		return list;
	}
	
	/**
	 * 直接向字符串后面添加ID 并自动处理重复的ID
	 * @param sids
	 * @param supplyId
	 * @return
	 */
	public static String appendSupplyId(String sids, List<String> idstr) {
		String supplyIds = "";
		Set<String> set = new HashSet<String>();

		if(sids!=null && sids.length()>0) {
			String[] ids = sids.split("-");
			int c = 0;
			for(String id : ids) {
				if(c>8) break; //最多存放之前的8条记录
				set.add(id);
				c++;
			}
		}
		
		for(String id: idstr) {
			set.add(id);
		}
		boolean flag = false;
		for(Iterator<String> itr = set.iterator(); itr.hasNext();) {
			String id = itr.next();
			if(flag)
				supplyIds += "-";
			supplyIds += id;
			flag = true;
			
		}
		
		return supplyIds;
	}
	
	public static void main(String[] args) {
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			ids.add(i+"");
			ids.add(i+"");
			ids.add(i+"");
			ids.add(i+"");
			
		}
		System.out.println(appendSupplyId(null, ids));
	}
}
