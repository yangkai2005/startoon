package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IClickedKeywordDAO;
import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.util.CalendarUtil;
import org.j2eeframework.startoon.util.IPUtil;
import org.springframework.stereotype.Service;

@Service
public class ClickedKeywordService extends AbstractService<ClickedKeyword, Long, IClickedKeywordDAO>
{
	@Resource
	private IClickedKeywordDAO clickedKeywordDAO;
	@Resource
	private KeywordService keywordService;
	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	@Resource
	private SupplyService supplyService;

	@Override
	public IClickedKeywordDAO getGenericDAO()
	{
		return clickedKeywordDAO;
	}
	
	/**
	 * 添加点击记录
	 * 只有如下的条件满足时，才添加一条点击记录：
	 * 1.关键词必须是系统当中存在的关键词
	 * 2.被点击的关键词必须绑定到产品或者企业
	 * @param clickedKeyword
	 * @return
	 */
	public ClickedKeyword add(ClickedKeyword clickedKeyword) {
		
		if(clickedKeyword==null) {
			return null;
		}
		
		String key = clickedKeyword.getKeyword();

		Keyword keyword = keywordService.getKeywordByKey(key);
		if(keyword==null) {
			return null;
		}
		
		Long keywordId = keyword.getId();
		Long enterpriseId = clickedKeyword.getEnterpriseId();
		
		EnterpriseKeyword enterpriseKeyword = enterpriseKeywordService.findEntKey(enterpriseId, keywordId);
		if(enterpriseKeyword==null) {
			return null;
		}
		clickedKeyword.setEnterpriseKeyword(enterpriseKeyword);		
		
		String ip = clickedKeyword.getIp();
		long longIP = IPUtil.ip2Long(ip);
		clickedKeyword.setLip(longIP);
		clickedKeyword.setKeywordId(keywordId);
		
		if(hadCllickedKeywordInTimeRange(enterpriseId, ip)) { //在半个小时内被点击过则不计算点击
			return null;
		}
		
		insert(clickedKeyword);

		return clickedKeyword;
		
	}
	
	/**
	 * 查询指定IP在指定时间内被点击记录<BR/>
	 * 若该企业的关键字在半个小时内被同一个IP点击过，则返回true<br/>
	 * 其他情况则返回false
	 * @param enterpriseId
	 * @param ip
	 * @return
	 */
	public boolean hadCllickedKeywordInTimeRange(Long enterpriseId, String ip) {

		List<ClickedKeyword> clickedKeywords = getClickedKeywordByIP(enterpriseId, ip);
		if(clickedKeywords!=null && clickedKeywords.size()>0) {
			ClickedKeyword clickedKeyword = clickedKeywords.get(0);
			Date clickedTime = clickedKeyword.getClickedTime();
			Date[] range = CalendarUtil.getDateTimeRange(new Date());
			boolean isInRange = CalendarUtil.isTimeInRange(range, clickedTime);
			return isInRange;
		}
		
		return false;
		
	}
	
	
	/**
	 * 根据企业ID和IP查询指定的点击记录
	 * @param enterpriseId
	 * @param ip
	 * @return
	 */
	public List<ClickedKeyword> getClickedKeywordByIP(Long enterpriseId, String ip) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("enterpriseId", enterpriseId + "");
		condition.addParameter("longIP", IPUtil.ip2Long(ip) + "");
		List<ClickedKeyword> clickedKeywords = clickedKeywordDAO.getEntitiesByParamCondition(condition, 0, 10);
		return clickedKeywords;
	}
	
	@Override
	public void getEntitiesOfPagerByParamCondition(Pager<ClickedKeyword> pager) {
		super.getEntitiesOfPagerByParamCondition(pager);
		List<ClickedKeyword> list = pager.getItems();
		
		for(ClickedKeyword ck : list) {
			Long enterpriseId = ck.getEnterpriseId();
			Long enterpriseKeywordId = ck.getEnterpriseKeyword().getId();
			
			Supply supply = supplyService.getSupplyByBindKeyword(enterpriseId, enterpriseKeywordId);
			
			ck.setSupply(supply);
			
		}
		
	}
	
}
