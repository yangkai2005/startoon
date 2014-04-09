package org.j2eeframework.information.web.actions.information.info;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

/**
 * @author kai
 */
public class InfoIndexAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 831626779866232809L;

	@Resource
	private InfoService infoService;

	private InfoType infoType;

	private List<Info> imgInfos;// 图片
	private List<Info> tradeInfos;// 行业
	private List<Info> productInfos;// 产品
	private List<Info> zcInfos;// 政策
	private List<Info> marketInfos;// 市场
	private List<Info> ztInfos;// 专题
	private List<Info> latestInfos;// 最新资讯
	private List<Info> hitInfos;// 阅读排行

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	@Override
	public void preExecute() {
	}

	@Override
	public String execute() {

		infoType = new InfoType();
		infoType.setId(2L);

		Pager<Info> pager = getPager();

		/*
		 * 图片
		 */
		imgInfos = infoService.getInfoByInfoType(18L, 4);
		if (imgInfos == null) {
			imgInfos = new ArrayList<Info>();
			for (int i = 0; i < 4; i++) {
				Info info = new Info();
				InfoImg img = new InfoImg();
				info.setMainImg(img);
				imgInfos.add(info);
			}
		}
		if (imgInfos.size() < 4) {
			int size = imgInfos.size();
			for (int i = 0; i < 4 - size; i++) {
				Info info = new Info();
				InfoImg img = new InfoImg();
				info.setMainImg(img);
				imgInfos.add(info);
			}
		}
		/*
		 * 行业
		 */
		tradeInfos = infoService.getInfoByInfoType(13L, 11);
		/*
		 * 政策
		 */
		zcInfos = infoService.getInfoByInfoType(14L, 6);
		/*
		 * 市场
		 */
		marketInfos = infoService.getInfoByInfoType(15L, 6);
		/*
		 * 产品
		 */
		productInfos = infoService.getInfoByInfoType(16L, 6);
		/*
		 * 专题
		 */
		ztInfos = infoService.getInfoByInfoType(17L, 6);
		/*
		 * 最新
		 */
		pager.setPageSize(10);
		pager.getParamCondition().addParameter("orderBy", "id");
		pager.getParamCondition().addParameter("orderType", "desc");
		infoService.getEntitiesOfPagerByParamCondition(pager);
		latestInfos = pager.getItems();
		/*
		 * 点击
		 */
		pager.setPageSize(8);
		pager.getParamCondition().addParameter("orderBy", "hits");
		pager.getParamCondition().addParameter("orderType", "desc");
		infoService.getEntitiesOfPagerByParamCondition(pager);
		hitInfos = pager.getItems();

		return SUCCESS;
	}

	public List<Info> getTradeInfos() {
		return tradeInfos;
	}

	public void setTradeInfos(List<Info> tradeInfos) {
		this.tradeInfos = tradeInfos;
	}

	public List<Info> getImgInfos() {
		return imgInfos;
	}

	public void setImgInfos(List<Info> imgInfos) {
		this.imgInfos = imgInfos;
	}

	public List<Info> getProductInfos() {
		return productInfos;
	}

	public void setProductInfos(List<Info> productInfos) {
		this.productInfos = productInfos;
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

	public List<Info> getZtInfos() {
		return ztInfos;
	}

	public void setZtInfos(List<Info> ztInfos) {
		this.ztInfos = ztInfos;
	}

	public List<Info> getLatestInfos() {
		return latestInfos;
	}

	public void setLatestInfos(List<Info> latestInfos) {
		this.latestInfos = latestInfos;
	}

	public List<Info> getHitInfos() {
		return hitInfos;
	}

	public void setHitInfos(List<Info> hitInfos) {
		this.hitInfos = hitInfos;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
