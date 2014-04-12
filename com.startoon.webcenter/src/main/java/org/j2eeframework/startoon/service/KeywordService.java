package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.commons.util.DateUtil;
import org.j2eeframework.startoon.dao.IKeywordDAO;
import org.j2eeframework.startoon.entity.Keyword;
import org.springframework.stereotype.Service;

@Service
public class KeywordService extends AbstractService<Keyword, Long, IKeywordDAO>
{
	private static final Log log = LogFactory.getLog(KeywordService.class);
	
	@Resource
	private IKeywordDAO keywordDAO;

	@Override
	public IKeywordDAO getGenericDAO()
	{
		return keywordDAO;
	}
	
	public Keyword getKeywordByKey(String keyword) {
		return keywordDAO.getKeywordByKey(keyword);
	}
	
	public boolean exist(String key) {
		Keyword keyword = getKeywordByKey(key);
		return keyword != null;
	}
	
	/**
	 * 判断关键字是否有效
	 * @param id
	 * @return
	 */
	public boolean isvalid(Long id) {
		Keyword keyword = getEntityById(id);
		Date dtime = keyword.getDeadTime();
		long millis = dtime.getTime();
		long currentMillis = System.currentTimeMillis();
		return currentMillis<millis;
	}
	
	public Keyword updateKeywordCurrentPrice(Long id, Float price) {
		Keyword keyword = getEntityById(id);
		float prePrice = keyword.getCurrentPrice(), currentPrice;
		currentPrice = prePrice<price?price:prePrice;
		keyword.setCurrentPrice(currentPrice);
		update(keyword);
		return keyword;
	}
	
	public Keyword addKeywordSearchTimes(String key) {
		Keyword keyword = getKeywordByKey(key);
		if(keyword!=null) {
			int searchedTimes = keyword.getSearchTimes();
			searchedTimes += 1;
			keyword.setSearchTimes(searchedTimes);
			update(keyword);
		}
		
		return keyword;
	}
	
	/**
	 * 查询所有过期的关键字
	 * @return
	 */
	public List<Keyword> getDeadKeyword() {
		ParamCondition condition = new ParamCondition();
		String deadTime = DateUtil.formatDateTime(new Date());
		condition.addParameter("deadTime", deadTime );
		condition.addParameter("OrderByIdDesc", "id" );
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, 1000);
	}
	
	public void updateExpiredKeyword() {
		log.info("%%% 开始更新更新处理过期关键字 %%%");
		try {
			keywordDAO.updateExpiredKeyword();
			log.info("%%% 更新处理过期关键字完成 %%%");
		} catch (Exception e) {
			log.error("%%% 更新处理过期关键字失败 %%%", e);
		}
	}
	
}
