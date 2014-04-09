package org.j2eeframework.startoon.web.actions.enterprises;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.EntCategoryService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.SupplyService;

public class EntProduceAction extends ServiceBasePaginationAction<Supply, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8536682347768386281L;

	private static final Log log = LogFactory.getLog(EntProduceAction.class);

	@Resource
	private EntInfoService entInfoService;

	@Resource
	private EntCategoryService entCategoryService;

	@Resource
	private EnterpriseService enterpriseService;

	@Resource
	private SupplyService supplyService;

	private EntInfo entInfo;

	private Long enterpriseId;

	private Enterprise enterprise;

	private List<Category> categories;

	private List<Supply> recommends;

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	@Override
	public void preExecute() {

		/**
		 * 企业信息
		 */
		enterprise = enterpriseService.getEntityById(enterpriseId);
		categories = entCategoryService.getOrderedCategory(enterpriseId);
		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);

		/**
		 * 推荐产品
		 */
		Pager<Supply> recommendPager = new Pager<Supply>();
		recommendPager.getParamCondition().addParameter("recommend", "1");
		recommendPager.getParamCondition().addParameter("enterpriseId", enterpriseId + "");
		recommendPager.setPageSize(4);
		supplyService.getEntitiesOfPagerByParamCondition(recommendPager);
		recommends = recommendPager.getItems();

		getPager().setPageSize(12);

	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Supply> getRecommends() {
		return recommends;
	}

	public void setRecommends(List<Supply> recommends) {
		this.recommends = recommends;
	}

}
