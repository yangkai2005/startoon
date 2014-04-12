package org.j2eeframework.startoon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.startoon.dao.ICategoryDAO;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

	@Resource
	private CategoryService categoryService;
	@Resource
	private SupplyService supplyService;

	@Resource
	private ICategoryDAO categoryDAO;

	private static final Log log = LogFactory.getLog(IndexService.class);

	public ICategoryDAO getGenericDAO() {
		return categoryDAO;
	}

	public List<Category> getCategoriesForIndex(long categoryId) {

		List<Category> categories = categoryService.getCategoryByFatherId(
				categoryId, 12);

		for (Category category : categories) {
			long cid = category.getId();
			List<Category> thirdCategories = categoryService
					.getCategoryByFatherId(cid, 10);
			category.setCategories(thirdCategories);

			/*
			 * for(Category c : thirdCategories) { long id = c.getId();
			 * List<Category> forthCategories =
			 * categoryService.getCategoryByFatherId(id, 2);
			 * if(forthCategories!=null && forthCategories.size()>0) {
			 * category.getForthCategories().add(forthCategories.get(0)); } }
			 */

		}

		return categories;
	}

	public List<Category> getCategoriesForIndex_(long categoryId) {
		List<Category> categories = categoryService
				.getCategoryByFatherId(categoryId);

		for (Category category : categories) {
			long cid = category.getId();
			Pager<Supply> pager = new Pager<Supply>();
			pager.setPageSize(12);
			pager.getParamCondition().addParameter("categoryId", cid + "");
			supplyService.getEntitiesOfPagerByParamCondition(pager);
			List<Supply> supplies = pager.getItems();
			category.setSupplies(supplies);
		}

		return categories;
	}

	/***
	 * 获取首页产品分类列表
	 * 
	 * @param categoryId
	 * @param num
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getCategoriesForIndex(long categoryId, int num) {
		
		log.debug("获取首页产品分类列表");
		List<Category> categories = categoryService
				.getCategoryByFatherId(categoryId);
		Map map = null;
		String sql = "";
		List returnList = new ArrayList();
		for (Category category : categories) {
			map = new HashMap();
			long cid = category.getId();
			sql = "select id,name from category where is_delete=0 and father_id="
					+ cid;
			sql = sql + " order by id desc";
			sql = sql + " LIMIT " + (num + 1);
			List twoList = categoryDAO.executeQuery(sql);
			map.put("twoLevel", twoList);

			sql = "select id,name from category where is_delete=0";
			sql = sql
					+ " and father_id in(select id from category where is_delete=0 and father_id="
					+ cid + ")";
			sql = sql + " order by id desc";
			sql = sql + " LIMIT " + (num + 1);
			List threeList = categoryDAO.executeQuery(sql);
			map.put("threeLevel", threeList);
			map.put("oneLevel", category);
			returnList.add(map);
		}

		return returnList;
	}

}
