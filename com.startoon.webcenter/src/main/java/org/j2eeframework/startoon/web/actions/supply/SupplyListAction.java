package org.j2eeframework.startoon.web.actions.supply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryAttr;
import org.j2eeframework.startoon.entity.SearchedKeyword;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.AttrTypeService;
import org.j2eeframework.startoon.service.CategoryAttrService;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.KeywordService;
import org.j2eeframework.startoon.service.PTagsService;
import org.j2eeframework.startoon.service.SearchedKeywordService;
import org.j2eeframework.startoon.service.SupplyService;
import org.j2eeframework.startoon.util.CookieUtil;

public class SupplyListAction extends ServiceBasePaginationAction<Supply, Long> {

	private static final long serialVersionUID = -340949007826185020L;

	private static final Log log = LogFactory.getLog(SupplyListAction.class);

	@Resource
	private SupplyService supplyService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private CategoryAttrService categoryAttrService;
	@Resource
	private AttrTypeService attrTypeService;
	@Resource
	private SearchedKeywordService searchedKeywordService;
	@Resource
	private KeywordService keywordService;
	@Resource
	private PTagsService pTagsService;

	private long supplyId;
	private long categoryId;
	private List<AttrType> attrTypes;
	private List<CategoryAttr> categoryAttrs = new ArrayList<CategoryAttr>();
	private List<Category> topCategories;
	private List<Category> headerCategories;// 顶部的分类筛选类别
	private String type;
	private Category currentCategory;

	private List<Supply> recentlyBrowseSupplies = new ArrayList<Supply>(); // 最近浏览的记录

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	@Override
	public void preExecute() {
		Pager<Supply> pager = getPager();
		getPager().setPageSize(15);
		ParamCondition cond = pager.getParamCondition();
		cond.remove("categoryId");

		// 关键字搜索统计处理
		searchExecute(pager);

		// 处理翻页后筛选条件的丢失的问题
		if (categoryId == 0) {
			if (cond.getParameter("cid") != null) {
				categoryId = cond.getLong("cid");
			}
		}

		cond.addParameter("cid", categoryId + "");

		List<Category> categories = null;
		if (categoryId != 0) {
			String idStr = "";
			categories = categoryService.getAllSubCategory(categoryId);
			if (categories != null && categories.size() > 0) {
				String[] ids = new String[categories.size()];
				int i = 0;
				for (Category c : categories) {
					ids[i] = c.getId() + "";
					idStr += ids[i] + ",";
					i++;
				}
				log.debug(">>>类别和所有的字类别ID：" + idStr);
				getPager().getParamCondition().addParameterValues("categoryIds", ids);
			}
		}

		attrTypes = attrTypeService.getAttrType();

		if (categoryId != 0) {
			for (Category c : categories) {
				List<CategoryAttr> attrs = categoryAttrService.getCategoryAttrByCategory(c.getId());
				categoryAttrs.addAll(attrs);
			}
		}

		if (categoryId != 0) {
			currentCategory = categoryService.getEntityById(categoryId);
			headerCategories = categoryService.getCategory4Filter(categoryId);
		}

		// 只查询通过标签
		String[] tagIds = pTagsService.getPassPTagsIds();
		cond.addParameterValues("tagIds", tagIds);
	}

	@Override
	@Action(results = { @Result(name = "category", location = "/category/category-list.action?categoryId=${categoryId}", type = "redirect") })
	public String execute() {

		/*
		 * 处理左边筛选的“分类查看信息”
		 * 
		 * 当前至少为3级分类
		 */
		Category currentCategory = categoryService.getEntityById(categoryId);
		Category fatherCategory = currentCategory.getCategory();
		topCategories = categoryService.getCategoriesByFatherId(fatherCategory.getId());

		for (Category c : topCategories) {
			List<Category> cs = categoryService.getCategoriesByFatherId(c.getId());
			List<Category> list = new ArrayList<Category>();
			for (Category category : cs) {
				if (category.getCategoryLevel() < 4) {
					list.add(category);
				}
			}
			c.setCategories(list);
		}

		// 处理最近浏览的产品
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Long> recentlyBrowseSupplyId = (List<Long>) request.getSession().getAttribute(SystemVariables.RECENTLY_BROWSE_SUPPLY);
		if (recentlyBrowseSupplyId == null) {
			recentlyBrowseSupplyId = CookieUtil.getSupplyIdByCookies(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		}
		if (recentlyBrowseSupplyId != null) {
			for (Long sid : recentlyBrowseSupplyId) {
				Supply s = supplyService.getEntityById(sid);
				recentlyBrowseSupplies.add(s);
			}
		}

		return super.execute();
	}

	/**
	 * 关键字搜索预处理
	 * 
	 * @param pager
	 */
	private void searchExecute(Pager<Supply> pager) {

		HttpServletRequest request = ServletActionContext.getRequest();

		int currentPageNo = pager.getPageNo();
		ParamCondition paramCondition = pager.getParamCondition();
		String __key = paramCondition.getParameter("searchKey");

		if (currentPageNo == 1 && __key != null) {
			paramCondition.addParameter("__flag", "0");
		}

		String __flag = paramCondition.getParameter("__flag");
		if (__flag != null && __flag.equals("0")) {
			SearchedKeyword sk = new SearchedKeyword();
			sk.setKeyword(__key);
			sk.setLastSearchTime(new Date());
			sk.setSearchIp(request.getRemoteAddr());
			searchedKeywordService.insert(sk);

			keywordService.addKeywordSearchTimes(sk.getKeyword());

			paramCondition.addParameter("__flag", "1");

			request.getSession().setAttribute("__flag", "1");
			request.getSession().setAttribute("__key", __key);

		}

	}

	public long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(long supplyId) {
		this.supplyId = supplyId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<AttrType> getAttrTypes() {
		return attrTypes;
	}

	public void setAttrTypes(List<AttrType> attrTypes) {
		this.attrTypes = attrTypes;
	}

	public List<CategoryAttr> getCategoryAttrs() {
		return categoryAttrs;
	}

	public void setCategoryAttrs(List<CategoryAttr> categoryAttrs) {
		this.categoryAttrs = categoryAttrs;
	}

	public List<Category> getTopCategories() {
		return topCategories;
	}

	public void setTopCategories(List<Category> topCategories) {
		this.topCategories = topCategories;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public List<Category> getHeaderCategories() {
		return headerCategories;
	}

	public void setHeaderCategories(List<Category> headerCategories) {
		this.headerCategories = headerCategories;
	}

	public List<Supply> getRecentlyBrowseSupplies() {
		return recentlyBrowseSupplies;
	}

	public void setRecentlyBrowseSupplies(List<Supply> recentlyBrowseSupplies) {
		this.recentlyBrowseSupplies = recentlyBrowseSupplies;
	}

}
