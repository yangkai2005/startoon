package org.j2eeframework.information.web.actions.information;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.information.entity.Copartnership;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.CopartnershipService;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.information.service.TalentService;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.EnterpriseService;
import org.j2eeframework.startoon.service.SupplyService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2727597049391586352L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private CopartnershipService copartnershipService;
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private SupplyService supplyService;
	@Resource
	private JobsService jobsService;
	@Resource
	private TalentService talentService;

	private InfoType infoType;

	private List<Info> tradeInfos;// 行业
	private List<Info> zcInfos;// 政策
	private List<Info> marketInfos;// 市场
	private List<Info> imgInfos;//
	private Info hotInfo;

	private Info info4; // 高端访谈
	private Info info6; // 星力观察家

	private List<Copartnership> copartnerships; // 合作单位

	private List<Info> technologyInfos; // 模拟世界-技术
	private List<Info> awMarketInfos; // 模拟世界-市场
	private List<Info> productInfos; // 模拟世界-产品

	private List<Info> cooperations; // 产业合作

	private List<Info> info19; // 行情-编辑推荐
	private List<Info> info20; // 行情-人气排行
	private List<Info> info21; // 行情-行情综述

	private List<Info> showInfos; // 创意show

	private List<Info> barLatestInfos; // 店长吧-最新
	private List<Info> barTopInfos; // 店长吧-置顶

	private List<Enterprise> enterprises; // 企业库企业
	private List<Supply> supplies; // 产品库产品

	private Info survey; // 在线调查

	private List<Info> info45; // 人才服务-人才工作站
	private List<Talent> talents; // 人才服务-人才库
	private List<Jobs> jobs; // 人才服务-企业招聘

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String ctx = request.getContextPath();
		try {
			response.sendRedirect(ctx + "/information/default.action");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.debug("资讯平台首页");
		String uri = request.getRequestURI();
		log.info(">>> 资讯平台首页 request.getRequestURI()：" + uri);
		if (uri.indexOf("") > 0 || uri.indexOf("") > 0) {

		}

		survey = infoService.getLatestSurveyInfo(); // 在线调查

		tradeInfos = infoService.getInfoByInfoType(13L, 5); // 行业
		zcInfos = infoService.getInfoByInfoType(14L, 6); // 政策
		marketInfos = infoService.getInfoByInfoType(15L, 5); // 市场
		imgInfos = infoService.getInfoByInfoType(18L, 4); // 图片
		List<Info> hotInfos = infoService.getHotInfo(1);
		if (hotInfos != null && !hotInfos.isEmpty()) {

			hotInfo = hotInfos.get(0);
		}

		// 高端访谈
		List<Info> hightVisitInfos = infoService.getInfoByInfoType(InfoType.INFO_TYPE_HIGH_VISITATION, 1);
		if (hightVisitInfos != null && hightVisitInfos.size() > 0) {
			info4 = hightVisitInfos.get(0);
		}

		// 星力观察家
		List<Info> observeInfos = infoService.getInfoByInfoType(InfoType.INFO_TYPE_OBSERVE, 1);
		if (observeInfos != null && observeInfos.size() > 0) {
			info6 = observeInfos.get(0);
		}

		// copartnerships = copartnershipService.getCopartnership(1L, 18);//合作单位

		technologyInfos = infoService.getInfoByInfoType(35L, 5); // 模拟世界-技术
		awMarketInfos = infoService.getInfoByInfoType(36L, 5); // 模拟世界-市场
		productInfos = infoService.getInfoByInfoType(37L, 5); // 模拟世界-产品

		// 产业合作
		Pager<Info> cooperationPager = new Pager<Info>();
		String[] infoTypeIds = { "31", "32", "33", "34" };
		cooperationPager.getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
		cooperationPager.setPageSize(7);
		infoService.getEntitiesOfPagerByParamCondition(cooperationPager);
		cooperations = cooperationPager.getItems();

		info19 = infoService.getInfoByInfoType(19L, 8); // 行情-编辑推荐
		info20 = infoService.getInfoByInfoType(20L, 8); // 行情-人气排行
		info21 = infoService.getInfoByInfoType(21L, 8); // 行情-行情综述

		// 创意show
		List<Long> typeIds = new ArrayList<Long>();
		typeIds.add(23L);
		typeIds.add(24L);
		showInfos = infoService.getInfoByInfoTypes(typeIds, 16);

		// 店长吧
		List<Long> barInfoTypeIds = new ArrayList<Long>();
		barInfoTypeIds.add(38L);
		barInfoTypeIds.add(39L);
		barInfoTypeIds.add(40L);
		barInfoTypeIds.add(41L);
		barLatestInfos = infoService.getInfoByInfoTypes(barInfoTypeIds, 6);

		barTopInfos = infoService.getTopInfo(6);

		// 企业库
		enterprises = enterpriseService.getEnterpriseBySize(15);

		supplies = supplyService.getLatestSupplies(6);

		// 人才服务
		info45 = infoService.getHrServiceInfo(45L, 6); // 人才工作站
		jobs = jobsService.getLatestJobsBySize(6); // 企业招聘
		talents = talentService.getLatestTalent(6); // 人才服务

		infoType = new InfoType();
		infoType.setId(1L);

		return SUCCESS;
	}

	public List<Info> getTradeInfos() {
		return tradeInfos;
	}

	public void setTradeInfos(List<Info> tradeInfos) {
		this.tradeInfos = tradeInfos;
	}

	public List<Info> getZcInfos() {
		return zcInfos;
	}

	public void setZcInfos(List<Info> zcInfos) {
		this.zcInfos = zcInfos;
	}

	public List<Info> getMarketInfos() {
		return marketInfos;
	}

	public void setMarketInfos(List<Info> marketInfos) {
		this.marketInfos = marketInfos;
	}

	public Info getInfo4() {
		return info4;
	}

	public void setInfo4(Info info4) {
		this.info4 = info4;
	}

	public Info getInfo6() {
		return info6;
	}

	public void setInfo6(Info info6) {
		this.info6 = info6;
	}

	public List<Copartnership> getCopartnerships() {
		return copartnerships;
	}

	public void setCopartnerships(List<Copartnership> copartnerships) {
		this.copartnerships = copartnerships;
	}

	public List<Info> getTechnologyInfos() {
		return technologyInfos;
	}

	public void setTechnologyInfos(List<Info> technologyInfos) {
		this.technologyInfos = technologyInfos;
	}

	public List<Info> getAwMarketInfos() {
		return awMarketInfos;
	}

	public void setAwMarketInfos(List<Info> awMarketInfos) {
		this.awMarketInfos = awMarketInfos;
	}

	public List<Info> getProductInfos() {
		return productInfos;
	}

	public void setProductInfos(List<Info> productInfos) {
		this.productInfos = productInfos;
	}

	public List<Info> getCooperations() {
		return cooperations;
	}

	public void setCooperations(List<Info> cooperations) {
		this.cooperations = cooperations;
	}

	public List<Info> getInfo19() {
		return info19;
	}

	public void setInfo19(List<Info> info19) {
		this.info19 = info19;
	}

	public List<Info> getInfo20() {
		return info20;
	}

	public void setInfo20(List<Info> info20) {
		this.info20 = info20;
	}

	public List<Info> getInfo21() {
		return info21;
	}

	public void setInfo21(List<Info> info21) {
		this.info21 = info21;
	}

	public List<Info> getShowInfos() {
		return showInfos;
	}

	public void setShowInfos(List<Info> showInfos) {
		this.showInfos = showInfos;
	}

	public List<Info> getBarLatestInfos() {
		return barLatestInfos;
	}

	public void setBarLatestInfos(List<Info> barLatestInfos) {
		this.barLatestInfos = barLatestInfos;
	}

	public List<Info> getBarTopInfos() {
		return barTopInfos;
	}

	public void setBarTopInfos(List<Info> barTopInfos) {
		this.barTopInfos = barTopInfos;
	}

	public List<Enterprise> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public List<Info> getImgInfos() {
		return imgInfos;
	}

	public void setImgInfos(List<Info> imgInfos) {
		this.imgInfos = imgInfos;
	}

	public Info getHotInfo() {
		return hotInfo;
	}

	public void setHotInfo(Info hotInfo) {
		this.hotInfo = hotInfo;
	}

	public Info getSurvey() {
		return survey;
	}

	public void setSurvey(Info survey) {
		this.survey = survey;
	}

	public List<Info> getInfo45() {
		return info45;
	}

	public void setInfo45(List<Info> info45) {
		this.info45 = info45;
	}

	public List<Talent> getTalents() {
		return talents;
	}

	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}

	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
