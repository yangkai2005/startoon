package org.j2eeframework.startoon.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.PostedProService;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 394643436201028171L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private CategoryService categoryService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private PostedProService postedProService;
	@Resource
	private SupplyService supplyService;

	private List<Category> categories;

	private long categoryId;

	private String type; // 企业和产品的标志 1 企业，其他就是产品

	private List<Enterprise> enterprises; // 最新入住企业

	private List<PostedPro> postedPros; // 最新发布求购信息
	private List<Supply> supplies; // 最新发布求购信息

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() {

		log.debug(">>>B2B网站首页.....");
		if (type == null || type.trim().length() == 0)
			type = "0";
		long fatherId = 0L;

		categories = categoryService.getCategoryByFatherId(fatherId);

		// 最新企业
		enterprises = enterpriseService.getLatestEnt(5);

		// 最新求购
		postedPros = postedProService.getLatestPostedPro(5);

		// 最新求购
		supplies = supplyService.getLatestSupplies(5);

		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public List<PostedPro> getPostedPros() {
		return postedPros;
	}

	public void setPostedPros(List<PostedPro> postedPros) {
		this.postedPros = postedPros;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

}
