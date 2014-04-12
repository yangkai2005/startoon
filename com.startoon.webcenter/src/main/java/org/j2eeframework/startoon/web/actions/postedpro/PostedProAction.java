package org.j2eeframework.startoon.web.actions.postedpro;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.PostedProService;
import org.j2eeframework.startoon.service.SupplyService;

public class PostedProAction extends ServiceBaseManageAction<PostedPro, Long> {
	private static final long serialVersionUID = -6192327510426585651L;
	@Resource
	private PostedProService postedProService;
	@Resource
	private SupplyService supplyService;
	@Resource
	private CategoryService categoryService;

	private String seoStr; //SEO关键字

	private PostedPro postedPro;
	private List<Category> categories;

	private List<PostedPro> relationPostedPros;
	private List<PostedPro> latestPostedPros;
	private List<Supply> latestSupplies;

	@Override
	public IGenericService<PostedPro, Long> getGenericService() {
		return postedProService;
	}

	public PostedPro getModel() {
		return postedPro;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			postedPro = new PostedPro();
		} else {
			postedPro = postedProService.getEntityById(getRequestId());
		}

		relationPostedPros = postedProService.getRelationPostedPros(postedPro, 10);
		latestPostedPros = postedProService.getLatestPostedPro(10);
		latestSupplies = supplyService.getLatestSupplies(10);

	}

	public String detail() {

		//获取SEO关键字
		if (postedPro != null && postedPro.getCategory() != null) {
			int level = postedPro.getCategory().getCategoryLevel().intValue();
			String firstName = postedPro.getCategory().getName(); //显示在最前面的类别名称
			switch (level) {
			case 1://第一级
				seoStr = firstName;
				break;
			case 2://第二级
				seoStr = firstName + "," + postedPro.getCategory().getCategory().getName();
				break;
			case 3://第三级
				seoStr = firstName + "," + postedPro.getCategory().getCategory().getName() + "," + postedPro.getCategory().getCategory().getCategory().getName();
				break;
			case 4: //第四级
				seoStr = firstName + "," + postedPro.getCategory().getCategory().getName() + "," + postedPro.getCategory().getCategory().getCategory().getName() + postedPro.getCategory().getCategory().getCategory().getCategory().getName();
				break;
			default:
				seoStr = "";
				break;
			}
		}
		return "detail";
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<PostedPro> getRelationPostedPros() {
		return relationPostedPros;
	}

	public void setRelationPostedPros(List<PostedPro> relationPostedPros) {
		this.relationPostedPros = relationPostedPros;
	}

	public List<PostedPro> getLatestPostedPros() {
		return latestPostedPros;
	}

	public void setLatestPostedPros(List<PostedPro> latestPostedPros) {
		this.latestPostedPros = latestPostedPros;
	}

	public List<Supply> getLatestSupplies() {
		return latestSupplies;
	}

	public void setLatestSupplies(List<Supply> latestSupplies) {
		this.latestSupplies = latestSupplies;
	}

	public String getSeoStr() {
		return seoStr;
	}

	public void setSeoStr(String seoStr) {
		this.seoStr = seoStr;
	}

}
