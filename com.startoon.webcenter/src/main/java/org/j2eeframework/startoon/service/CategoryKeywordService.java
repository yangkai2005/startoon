package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ICategoryKeywordDAO;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.springframework.stereotype.Service;

@Service
public class CategoryKeywordService extends AbstractService<CategoryKeyword, Long, ICategoryKeywordDAO>
{
	
	private static final Log log = LogFactory.getLog(CategoryKeywordService.class);

	@Resource
	private ICategoryKeywordDAO categoryKeywordDAO;

	@Override
	public ICategoryKeywordDAO getGenericDAO()
	{
		return categoryKeywordDAO;
	}
	
	public List<CategoryKeyword> findByCategoryId(Long categoryId) {
		
		ParamCondition condition = new ParamCondition();
		condition.addParameter("categoryId", categoryId + "");
		
		List<CategoryKeyword> categoryKeywords = getGenericDAO().getEntitiesByParamCondition(condition, 0, 100);
		
		return categoryKeywords;
	}
	
	public boolean existCategory(Long categoryId) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("categoryId", categoryId + "");
		
		int count = getGenericDAO().getCountOfEntitiesByParamCondition(condition);
		
		return count>0;
	}
	
	public float getDiscountByTimeLimit(Long id, int timeLimit) {
		
		CategoryKeyword categoryKeyword = categoryKeywordDAO.getEntityById(id);
		float discount = 1;
		switch (timeLimit) {
		case 3:
			discount = categoryKeyword.getDiscount3();
			break;

		case 6:
			discount = categoryKeyword.getDiscount6();
			break;
			
		case 12:
			discount = categoryKeyword.getDiscount12();
			break;
		}
		
		return discount;
	}
	
	/**
	 * 更新关键词的状态为指定状态
	 * @param id
	 * @param status
	 * @return
	 */
	public CategoryKeyword updateStatus(Long id, int status) {
		CategoryKeyword ck = getGenericDAO().getEntityById(id);
		ck.setStatus(status);
		getGenericDAO().update(ck);
		return ck;
	}
	
	/**
	 * 更新关键词的状态和到期日期
	 * @param id
	 * @param status
	 * @return
	 */
	public CategoryKeyword updateStatus(Long id, Date expiredTime, int status) {
		CategoryKeyword ck = getGenericDAO().getEntityById(id);
		ck.setStatus(status);
		ck.setEtime(expiredTime);
		getGenericDAO().update(ck);
		return ck;
	}
	
	
	public void updateExpiredCategoryKeyword() {
		log.info("%%% 开始更新更新处理过期类别关键词 %%%");
		try {
			categoryKeywordDAO.updateExpiredCategoryKeyword();
			log.info("%%% 更新处理过期类别关键词字完成 %%%");
		} catch (Exception e) {
			log.error("%%% 更新处理过期类别关键词失败 %%%", e);
		}
	}
	
}
