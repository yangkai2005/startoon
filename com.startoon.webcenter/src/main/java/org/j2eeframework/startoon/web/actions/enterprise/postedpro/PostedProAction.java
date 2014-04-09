package org.j2eeframework.startoon.web.actions.enterprise.postedpro;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PostedPro;
import org.j2eeframework.startoon.entity.PostedProParam;
import org.j2eeframework.startoon.service.BookingService;
import org.j2eeframework.startoon.service.CategoryService;
import org.j2eeframework.startoon.service.PostedProParamService;
import org.j2eeframework.startoon.service.PostedProService;

public class PostedProAction extends ServiceBaseManageAction<PostedPro, Long> {
	private static final long serialVersionUID = -1225144832489992613L;
	@Resource
	private PostedProService postedProService;
	private PostedPro postedPro;
	private String ids;
	@Resource
	private CategoryService categoryService;
	private List<Category> categories;

	@Resource
	private PostedProParamService postedProParamService;
	@Resource
	private BookingService bookingService;

	List<String> paramKeys;
	List<String> paramValues;

	private String categoryId1;
	private String categoryName1;
	private String categoryId2;
	private String categoryName2;
	private String categoryId3;
	private String categoryName3;
	private String categoryId4;
	private String categoryName4;

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

		categories = categoryService.getCategoriesByFatherId(0L);
	}

	/**
	 * 删除采购信息
	 * 
	 * @return
	 */
	@Override
	public String delete() {
		if (ids != null && !ids.equals("")) {
			ids = ids.substring(0, ids.length() - 1);
			postedProService.deleteMuti(ids);
		}

		return ResultConstants.LIST;
	}

	public String deleteAll() {
		if (ids != null && !ids.equals("")) {
			String[] idArr = ids.split(",");
			for (String id : idArr) {
				postedProService.deleteEntityById(new Long(id.trim()));
			}
		}

		return ResultConstants.LIST;
	}

	/**
	 * 初始化修改采购页面
	 * 
	 * @return
	 */
	public String initupdate() {
		postedPro = postedProService.getEntityById(Long.valueOf(ids));

		return ResultConstants.UPDATE;
	}

	/**
	 * 修改采购
	 * 
	 * @return
	 */
	@Override
	public String update() {

		postedProService.update(postedPro);

		return ResultConstants.LIST;
	}

	/**保存数据
	 * @return
	 */
	@Override
	public String insert() {

		Enterprise ent = SysContext.getCurrentEnterpriserUser();
		postedPro.setCreator(ent);
		postedPro.setStatus(2);

		/*
		 * 设置直接类别 
		 */
		if (categoryId4 != null && !"".equals(categoryId4) && !"null".equals(categoryId4)) {
			Category c = new Category();
			c.setId(new Long(categoryId4));
			postedPro.setCategory(c);
		} else if (categoryId3 != null && !"".equals(categoryId3)) {
			Category c = new Category();
			c.setId(new Long(categoryId3));
			postedPro.setCategory(c);
		}

		/*
		 * 设置类别属性字符串
		 */
		String nameStr = getSplitKey(categoryName2) + getSplitKey(categoryName2) + getSplitKey(categoryName3) + getSplitKey(categoryName4);
		String idStr = getSplitKey(categoryId1) + getSplitKey(categoryId2) + getSplitKey(categoryId3) + getSplitKey(categoryId4);

		postedPro.setCategoryIdStr(idStr);
		postedPro.setCategoryNameStr(nameStr);

		getGenericService().insert(getModel());

		if (paramKeys != null && paramKeys.size() > 0) {
			int size = paramKeys.size();
			for (int i = 0; i < size; i++) {
				String pkey = paramKeys.get(i), pvalue = paramValues.get(i);

				PostedProParam param = new PostedProParam();
				param.setPostedPro(postedPro);
				param.setPkey(pkey);
				param.setPvalue(pvalue);
				postedProParamService.insert(param);
			}
		}

		return ResultConstants.LIST;
	}

	public String getSplitKey(String key) {

		if (key != null && key.trim().length() > 0)
			return "#" + key + "#";

		return "";
	}

	public PostedPro getPostedPro() {
		return postedPro;
	}

	public void setPostedPro(PostedPro postedPro) {
		this.postedPro = postedPro;
	}

	public List<String> getParamKeys() {
		return paramKeys;
	}

	public void setParamKeys(List<String> paramKeys) {
		this.paramKeys = paramKeys;
	}

	public List<String> getParamValues() {
		return paramValues;
	}

	public void setParamValues(List<String> paramValues) {
		this.paramValues = paramValues;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(String categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public String getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(String categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public String getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(String categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public String getCategoryId4() {
		return categoryId4;
	}

	public void setCategoryId4(String categoryId4) {
		this.categoryId4 = categoryId4;
	}

	public String getCategoryName4() {
		return categoryName4;
	}

	public void setCategoryName4(String categoryName4) {
		this.categoryName4 = categoryName4;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
