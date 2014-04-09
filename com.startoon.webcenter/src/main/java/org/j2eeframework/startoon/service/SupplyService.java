package org.j2eeframework.startoon.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ISupplyDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class SupplyService extends AbstractService<Supply, Long, ISupplyDAO> {

	private static final Log log = LogFactory.getLog(SupplyService.class);

	@Resource
	private ISupplyDAO supplyDAO;
	@Resource
	private CategoryService categoryService;
	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	@Resource
	private EnterpriseCategoryKeywordService enterpriseCategoryKeywordService;

	@Override
	public ISupplyDAO getGenericDAO() {
		return supplyDAO;
	}

	/**
	 * 删除多条记录
	 * 
	 * @author zhousp
	 * @param ids
	 *            : ID集体(如：1,2)
	 */
	public void deleteMuti(String ids) {

		/*
		 * String sql = "delete from supply_img where supply_id in(" + ids +
		 * ")"; supplyDAO.execUpdate(sql);// 删除产品图片 sql =
		 * "delete from supply where id in(" + ids + ")";
		 * supplyDAO.execUpdate(sql);// 删除产品
		 */
		if (ids != null && ids.trim().length() > 0) {
			String[] arr = ids.split(",");
			for (String sid : arr) {
				Long id = new Long(sid);
				delete(id);
			}
		}

		String sql = "delete from supply_img where supply_id in(" + ids + ")";
		getGenericDAO().execUpdate(sql);// 删除产品图片

	}

	public void delete(Long id) {
		getGenericDAO().deleteById(id);
		freeBind(id);
	}

	public List<Supply> getLatestSupplies(int size) {
		ParamCondition paramCondition = new ParamCondition();
		return supplyDAO.getEntitiesByParamCondition(paramCondition, 0, size);
	}

	public boolean generatePinyin() {
		Pager<Supply> pager = new Pager<Supply>();
		pager.setPageSize(100);
		getEntitiesOfPagerByParamCondition(pager);

		int pages = pager.getCountOfPager();

		for (int i = 0; i < pages; i++) {
			int currentPageNo = i + 1;
			pager.setPageNo(currentPageNo);
			getEntitiesOfPagerByParamCondition(pager);
			List<Supply> supplies = pager.getItems();

			for (Supply s : supplies) {

				try {

					String pinyin = s.getNamePinyinByName(), firstPinyin = s.getNameFirstPinyinByName();

					s.setNamePinyin(pinyin);
					s.setNameFirstPinyin(firstPinyin);

					log.debug(">>>>> 产品 更新拼音：id:" + s.getId() + ", name: " + s.getName() + ", pinyin:" + s.getNamePinyin() + ", first_pinyin:" + s.getNameFirstPinyin());
					String sql = "update enterprise set name_pinyin='" + s.getNamePinyin() + "', name_first_pinyin='" + s.getNameFirstPinyin() + "' where id=" + s.getId();
					getGenericDAO().execUpdate(sql);
					// getGenericDAO().update(s);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return true;
	}

	/**
	 * 作废产品的产品关键字
	 * 
	 * @param id
	 */
	public void invalidKeyword(Long id) {
		Supply supply = getEntityById(id);
		supply.setKeywordStatus(false);
		update(supply);
	}

	/**
	 * 作废产品的类别关键字
	 * 
	 * @param id
	 */
	public void invalidCategoryKeyword(Long id) {
		Supply supply = getEntityById(id);
		supply.setCategoryKeywordStatus(false);
		update(supply);
	}

	/**
	 * 获取最新审核通过的产品
	 * 
	 * @param size
	 * @return
	 */
	public List<Supply> getLatestSupply(int size) {

		ParamCondition condition = new ParamCondition();
		int offset = 0;

		List<Supply> supplies = supplyDAO.getEntitiesByParamCondition(condition, offset, size);
		return supplies;
	}

	/**
	 * 根据时间段获取最新审核通过的产品
	 * 
	 * @param size
	 * @return
	 */
	public List<Supply> getSupplyByTime(Long categoryId, Date start, Date end, int size) {

		int offset = 0;

		ParamCondition condition = new ParamCondition();

		// 处理类别和所有的子类别
		List<Category> categories = categoryService.getAllSubCategory(categoryId);
		String idStr = "";
		if (categories != null && categories.size() > 0) {
			String[] ids = new String[categories.size()];
			int i = 0;
			for (Category c : categories) {
				ids[i] = c.getId() + "";
				idStr += ids[i] + ",";
				i++;
			}
			log.debug(">>>类别和所有的子类别ID：" + idStr);
			condition.addParameterValues("categoryIds", ids);
		}

		condition.addParameter("startCreateTime", start.getTime() + "");
		condition.addParameter("endCreateTime", end.getTime() + "");

		List<Supply> supplies = supplyDAO.getEntitiesByParamCondition(condition, offset, size);

		return supplies;

	}

	public boolean canPublish(Long enterpriseId) {
		int c = getSupplyCountByEnterpriseId(enterpriseId);
		return c < 6;
	}

	public int getSupplyCountByEnterpriseId(Long enterpriseId) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("enterpriseId", enterpriseId + "");
		int count = getGenericDAO().getCountOfEntitiesByParamCondition(condition);
		return count;
	}

	/**
	 * 根据供应绑定的关键字查询供应
	 * 
	 * @return
	 */
	public Supply getSupplyByBindKeyword(Long id, Long enterpriseKeywordId) {

		ParamCondition condition = new ParamCondition();
		condition.addParameter("enterpriserId", id + "");
		condition.addParameter("enterpriseKeywordId", enterpriseKeywordId + "");
		List<Supply> supplies = getGenericDAO().getEntitiesByParamCondition(condition, 0, 1);

		return supplies != null && supplies.size() > 0 ? supplies.get(0) : null;

	}

	public int getSupplyCountByCreator(Long creatorId) {

		ParamCondition condition = new ParamCondition();
		condition.addParameter("enterpriseId", creatorId + "");

		int count = getGenericDAO().getCountOfEntitiesByParamCondition(condition);

		return count;

	}

	public void freeBind(Long id) {
		enterpriseKeywordService.unbindFromSupply(id);
		enterpriseCategoryKeywordService.unbindFromSupply(id);
	}

	/**
	 * 推荐产品
	 * 
	 * @return
	 */
	public List<Supply> getRecommendSupplies(Long enterpriseId, int size) {

		ParamCondition cond = new ParamCondition();

		cond.addParameter("recommend", "1");
		cond.addParameter("enterpriseId", enterpriseId + "");
		List<Supply> supplies = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		return supplies;

	}

}
