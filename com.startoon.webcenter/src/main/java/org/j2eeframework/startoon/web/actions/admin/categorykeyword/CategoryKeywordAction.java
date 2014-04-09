package org.j2eeframework.startoon.web.actions.admin.categorykeyword;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.CategoryKeyword;
import org.j2eeframework.startoon.service.CategoryKeywordService;
import org.j2eeframework.startoon.service.CategoryService;

public class CategoryKeywordAction extends ServiceBaseManageAction<CategoryKeyword, Long> {
	
	private static final long serialVersionUID = -7428276900902883767L;

	private static final Log log = LogFactory.getLog(CategoryKeywordAction.class);
	
	@Resource
	private CategoryKeywordService categoryKeywordService;
	@Resource
	private CategoryService categoryService;

	private CategoryKeyword categoryKeyword;

	private Category currentCategory;

	private Long cid;

	private List<Float> prices;
	private List<Float> discounts3;
	private List<Float> discounts6;
	private List<Float> discounts12;

	private List<CategoryKeyword> categoryKeywords;

	@Override
	public IGenericService<CategoryKeyword, Long> getGenericService() {
		return categoryKeywordService;
	}

	public CategoryKeyword getModel() {
		return categoryKeyword;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			categoryKeyword = new CategoryKeyword();
		} else {
			categoryKeyword = categoryKeywordService
					.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {

		HttpServletRequest request = ServletActionContext.getRequest();
		boolean exist = categoryKeywordService.existCategory(cid);
		if (exist) {
			log.debug("已经添加这样的类别关键词");
			request.setAttribute("categoryId", cid);
			return "exist";
		}
		

		currentCategory = categoryService.getEntityById(cid);

		return super.input();

	}

	@Override
	public String edit() {
		setNextMethod("update");
		return "update";
	}

	@Override
	public String insert() {

		Category category = categoryService.getEntityById(cid);

		int rank = 1;
		int index = 0;
		for (Float price : prices) {

			if (price == null || price == 0)
				continue;

			float d3 = discounts3.get(index);
			float d6 = discounts6.get(index);
			float d12 = discounts12.get(index);

			CategoryKeyword ck = new CategoryKeyword();
			ck.setCategoryName(category.getName());
			ck.setCategory(category);
			ck.setMinPrice(price);
			ck.setMaxPrice(price);
			ck.setCurrentMaxPrice(price);
			ck.setRank(rank);
			ck.setDiscount3(d3);
			ck.setDiscount6(d6);
			ck.setDiscount12(d12);

			index++;
			rank++;

			getGenericService().insert(ck);

		}

		return ResultConstants.LIST;
	}

	public CategoryKeyword getCategoryKeyword() {
		return categoryKeyword;
	}

	public void setCategoryKeyword(CategoryKeyword categoryKeyword) {
		this.categoryKeyword = categoryKeyword;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public List<Float> getPrices() {
		return prices;
	}

	public void setPrices(List<Float> prices) {
		this.prices = prices;
	}

	public List<Float> getDiscounts3() {
		return discounts3;
	}

	public void setDiscounts3(List<Float> discounts3) {
		this.discounts3 = discounts3;
	}

	public List<Float> getDiscounts6() {
		return discounts6;
	}

	public void setDiscounts6(List<Float> discounts6) {
		this.discounts6 = discounts6;
	}

	public List<Float> getDiscounts12() {
		return discounts12;
	}

	public void setDiscounts12(List<Float> discounts12) {
		this.discounts12 = discounts12;
	}

	public List<CategoryKeyword> getCategoryKeywords() {
		return categoryKeywords;
	}

	public void setCategoryKeywords(List<CategoryKeyword> categoryKeywords) {
		this.categoryKeywords = categoryKeywords;
	}

}
