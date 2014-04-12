package org.j2eeframework.startoon.web.actions.enterprises;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.startoon.entity.Category;
import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.ClickedKeywordService;
import org.j2eeframework.startoon.service.EntCategoryService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class EntIndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1768620628978699013L;

	private static final Log log = LogFactory.getLog(EntIndexAction.class);

	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EntInfoService entInfoService;
	@Resource
	private EntCategoryService entCategoryService;
	@Resource
	private SupplyService supplyService;
	@Resource
	private ClickedKeywordService clickedKeywordService;

	private EntInfo entInfo;

	private Long enterpriseId;

	private Enterprise enterprise;

	private List<Category> categories;

	private List<Supply> recommends;

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		log.debug(enterpriseId);

		/**
		 * 主营产品
		 */
		categories = entCategoryService.getOrderedCategory(enterpriseId);

		/**
		 * 推荐产品
		 */
		recommends = supplyService.getRecommendSupplies(enterpriseId, 5);

		entInfo = entInfoService.getEntInfoByEnterpriseId(enterpriseId);
		if (entInfo != null) {

			enterprise = entInfo.getEnterprise();

			// 更新点击率
			enterprise.setHit(enterprise.getHit() + 1);
			enterpriseService.update(enterprise);

			log.debug(entInfo);
			log.debug(enterprise);

		}

		// 关键字扣费处理
		log.debug("==>企业关键词排名点击扣费[" + enterprise.getName() + "]");
		clickedKeywordExecute(request);
		log.debug("==>企业关键词排名点击扣费结束。");

		return SUCCESS;
	}

	/**
	 * 关键词点击扣费处理
	 * 
	 * @param request
	 */
	public void clickedKeywordExecute(HttpServletRequest request) {

		String __flag = (String) request.getSession().getAttribute("__flag");
		String __key = (String) request.getSession().getAttribute("__key");
		String __ip = request.getRemoteAddr();

		if (__key != null && __flag != null && __flag.equals("1")) {

			ClickedKeyword ck = new ClickedKeyword();
			ck.setClickedTime(new Date());
			ck.setEnterpriseId(enterpriseId);
			ck.setIp(__ip);
			ck.setKeyword(__key);
			ck.setFlag(1); // 企业关键词点击扣费

			ClickedKeyword clickedKeyword = clickedKeywordService.add(ck); // 添加点击记录

			// 扣费处理
			if (clickedKeyword != null) {

				EnterpriseKeyword enterpriseKeyword = clickedKeyword.getEnterpriseKeyword();
				Keyword keyword = enterpriseKeyword.getKeyword();

				// 判断是否过期，过期将不再进行扣费
				Date deadTime = keyword.getDeadTime();
				boolean expired = (deadTime.getTime() < System.currentTimeMillis());
				float amount = clickedKeyword.getEnterpriseKeyword().getPrice();

				Enterprise enterprise = enterpriseService.getEntityById(enterpriseId);
				String enterpriseName = enterprise.getName();
				String desc = "企业关键词点击扣费[" + enterpriseName + "|" + keyword.getKeyword() + "|" + amount + "]";
				try {
					if (!expired) { // 关键词为过期
						log.info("==>关键字点击扣费处理[enterprise.id: " + enterpriseId + ", IP: " + __ip + ", keyword: " + __key + "]");
						log.info(desc);
						enterpriseService.pay(enterpriseId, amount, desc);
					} else {
						log.info("%%% 该关键字已经过期[enterprise.id: " + enterpriseId + ", IP: " + __ip + ", keyword: " + __key + "]");
						log.debug("%%% 删除过期关键字的点击记录 begin %%%");
						clickedKeywordService.delete(clickedKeyword);
						log.debug("%%% 删除过期关键字的点击记录 end %%%");
					}
				} catch (Exception e) { // 没有足够的费用，将关键字排序作废
					log.error("==>点击扣费出错：" + e.getMessage());
					enterpriseService.invalidKeyword(enterpriseId);
				}
			}
		}

		// 去掉session
		request.getSession().removeAttribute("__flag");
		request.getSession().removeAttribute("__key");

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
