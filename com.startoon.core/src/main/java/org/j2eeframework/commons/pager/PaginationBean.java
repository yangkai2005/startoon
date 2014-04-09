package org.j2eeframework.commons.pager;

import java.util.ArrayList;
import java.util.List;

/**提供的默认分页实现Bean，计算好分页数与页码数等
 * @author william
 *
 */
public class PaginationBean<T>
{
	private final Pager<T> pager;
	public PaginationBean(Pager<T> pager)
	{
		this.pager = pager;
		
	}
	
	/**取得参数的URL串
     * @return
     */
    public String getParamUrl()
    {
    	String paramUrl = "";
    	for(String key : pager.getParamCondition().keySet())
    	{
    		if("pager.pageSize".equals(key)||"pager.pageNo".equals(key))
    		{
    			continue;
    		}
    		String[] values = pager.getParamCondition().get(key);
    		for(String v : values)
    		{
    			if(v==null || v.trim().length()<1)
    			{
    				continue;
    			}
    			paramUrl += "&"+key+"="+v;
    		}
    	}
    	return paramUrl;
    }
	
	/**解释分页页码并将相应页码放入到列表中，-1表示（...）
     * @return
     */
    public List<Integer> getPageNumberList()
    {
        List<Integer> ret = new ArrayList<Integer>();
        if (pager.getCountOfTotalItem() == 0)
        {
            return ret;
        }
        int maxPageNum = pager.getCountOfPager();
        if (pager.getPageNumLength() >= maxPageNum)
        {
            for (int i = 1; i <= maxPageNum; i++)
                ret.add(new Integer(i));
            return ret;
        } else
        {
            int mid = pager.getPageNumLength() / 2;
            if (pager.getPageNo() <= mid)
            {
                for (int i = 1; i <= pager.getPageNumLength(); i++)
                {
                    ret.add(new Integer(i));
                }
                if ((maxPageNum - pager.getPageNumLength()) > 1)
                {
                    ret.add(new Integer(-1));// 表示...
                }
                ret.add(new Integer(maxPageNum));// 最大页码数
                return ret;
            } else if ((maxPageNum - pager.getPageNo()) <= mid)
            {
                ret.add(new Integer(1));// 第一页
                if ((maxPageNum - pager.getPageNumLength()) > 2)
                {
                    ret.add(new Integer(-1));// 表示...
                }
                for (int i = maxPageNum - pager.getPageNumLength(); i <= maxPageNum; i++)
                {
                    if (i > 1)
                    {
                        ret.add(new Integer(i));
                    }
                }
                return ret;
            } else
            {
                ret.add(new Integer(1));
                if ((pager.getPageNo() - mid) > 2)
                {
                    ret.add(new Integer(-1));// 表示...
                }
                for (int i = pager.getPageNo() - mid; i <= pager.getPageNo() + mid; i++)
                {
                    if (i > 1)
                    {
                        ret.add(new Integer(i));
                    }
                }
                if ((maxPageNum - (pager.getPageNo() + mid)) > 2)
                {
                    ret.add(new Integer(-1));// 表示...
                }
                ret.add(new Integer(maxPageNum));

                return ret;
            }
        }
    }
}
