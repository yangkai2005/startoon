package org.j2eeframework.startoon.web.actions.supply;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.commons.Unit;
import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.entity.EntInfo;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.entity.Keyword;
import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.ClickedKeywordService;
import org.j2eeframework.startoon.service.EntInfoService;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.SupplyService;
import org.j2eeframework.startoon.util.CookieUtil;
import org.j2eeframework.startoon.util.Struts2Utils;

import com.opensymphony.xwork2.ActionSupport;

@Results({ @Result(name = "list", location = "/supply/supply-list.action", type = "redirect") })
public class SupplyManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4360614649129999852L;

	private static final Log log = LogFactory.getLog(SupplyManageAction.class);

	@Resource
	private SupplyService supplyService;
	private String unitname; // 单位名称
	@Resource
	private EntInfoService entInfoService;
	@Resource
	private ClickedKeywordService clickedKeywordService;
	@Resource
	private EnterpriseService enterpriseService;

	private Long supplyId;
	private String seoStr; // SEO关键字

	private Supply supply;
	private String type;

	private EntInfo entInfo;

	private List<Supply> recommends;

	public String detail() {

		type = "0";// 产品搜索标识
		supply = supplyService.getEntityById(supplyId);

		if (supply.getStatus() == 1) {
			return "list";
		}

		/*
		 *	2012/9/11
		 *  判断产品是否被禁止,不用查看
		 *  能够查看的条件：
		 *  1. 登录 & 是自己的产品 
		 *  2. 登录 & 后台管理员 
		 */
		PTags tag = supply.getPtags();
		boolean pass = tag == null ? true : tag.getPass();
		if (!pass) {
			if (Struts2Utils.getSession().getAttribute(SystemVariables.ADMIN_USER) == null || Struts2Utils.getSession().getAttribute(SystemVariables.CUSTOME_USER) == null || (Struts2Utils.getSession().getAttribute(SystemVariables.CUSTOME_USER) != null && ((Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.CUSTOME_USER)).getId() != supply.getCreator().getId())) {
				return "list";
			}
		}

		List<Map<String, String>> units = Unit.getInstance().getUnits();
		if (supply != null && units != null) {
			for (int i = 0; i < units.size(); i++) {
				Map map = units.get(i);
				if (map != null && map.get("id") != null && map.get("id").toString().equals(supply.getUnit())) {
					unitname = map.get("name").toString();
					break;
				}
			}
		}
		// 获取SEO关键字
		if (supply != null && supply.getCategory() != null) {
			int level = supply.getCategory().getCategoryLevel().intValue();
			String firstName = supply.getCategory().getName(); // 显示在最前面的类别名称
			switch (level) {
			case 1:// 第一级
				seoStr = firstName;
				break;
			case 2:// 第二级
				seoStr = firstName + "," + supply.getCategory().getCategory().getName();
				break;
			case 3:// 第三级
				seoStr = firstName + "," + supply.getCategory().getCategory().getName() + "," + supply.getCategory().getCategory().getCategory().getName();
				break;
			case 4: // 第四级
				seoStr = firstName + "," + supply.getCategory().getCategory().getName() + "," + supply.getCategory().getCategory().getCategory().getName() + supply.getCategory().getCategory().getCategory().getCategory().getName();
				break;
			default:
				seoStr = "";
				break;
			}
			seoStr = supply.getName() + "," + seoStr;
		}

		entInfo = entInfoService.getEntInfoByEnterpriseId(supply.getCreator().getId());

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		clickedKeywordExecute(request);

		// 将最近浏览过的产品添加到cookie当中
		String ids = CookieUtil.setSupplyIdCookies(request, response, supplyId + "");
		// 将最近浏览过的产品添加到session当中
		List<Long> supplyIds = CookieUtil.getSupplyIdByString(ids);
		request.getSession().setAttribute(SystemVariables.RECENTLY_BROWSE_SUPPLY, supplyIds);

		Enterprise ent = supply.getCreator();
		Long enterpriseId = ent.getId();
		recommends = supplyService.getRecommendSupplies(enterpriseId, 5);

		// 商品的点击率
		int hit = supply.getHit() == null ? 0 : supply.getHit();
		supply.setHit(hit + 1);
		supplyService.update(supply);

		return "detail";
	}

	public void clickedKeywordExecute(HttpServletRequest request) {

		String __flag = (String) request.getSession().getAttribute("__flag");
		String __key = (String) request.getSession().getAttribute("__key");
		String __ip = request.getRemoteAddr();

		Long enterpriseId = supply.getCreator().getId();

		if (__key != null && __flag != null && __flag.equals("1")) {

			ClickedKeyword ck = new ClickedKeyword();
			ck.setClickedTime(new Date());
			ck.setEnterpriseId(enterpriseId);
			ck.setIp(__ip);
			ck.setKeyword(__key);

			ClickedKeyword clickedKeyword = clickedKeywordService.add(ck); // 添加点击记录

			// 扣费处理
			if (clickedKeyword != null) {
				EnterpriseKeyword enterpriseKeyword = clickedKeyword.getEnterpriseKeyword();
				Keyword keyword = enterpriseKeyword.getKeyword();

				// 判断是否过期，过期将不再进行扣费
				Date deadTime = keyword.getDeadTime();
				boolean expired = (deadTime.getTime() < System.currentTimeMillis());
				float amount = clickedKeyword.getEnterpriseKeyword().getPrice();

				String supplyName = supply.getName();
				String desc = "产品关键词点击扣费[" + supplyName + "|" + keyword.getKeyword() + "|" + amount + "]";
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
					supplyService.invalidKeyword(supply.getId());
				}
			}
		}

		// 去掉session
		request.getSession().removeAttribute("__flag");
		request.getSession().removeAttribute("__key");

	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public EntInfo getEntInfo() {
		return entInfo;
	}

	public void setEntInfo(EntInfo entInfo) {
		this.entInfo = entInfo;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeoStr() {
		return seoStr;
	}

	public void setSeoStr(String seoStr) {
		this.seoStr = seoStr;
	}

	public List<Supply> getRecommends() {
		return recommends;
	}

}
