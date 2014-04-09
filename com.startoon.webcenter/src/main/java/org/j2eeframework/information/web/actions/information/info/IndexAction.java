package org.j2eeframework.information.web.actions.information.info;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

/**
 * 资讯中心
 * 
 * @author kai
 */
public class IndexAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 831626779866232809L;

	@Resource
	private InfoService infoService;

	private InfoType infoType;

	private List<Info> imgInfos;// 图片
	private List<Info> tradeInfos;// 行业
	private List<Info> productInfos;// 产品
	private List<Info> zcInfos;// 政策
	private List<Info> marketInfos;// 市场
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

		tradeInfos = infoService.getInfoByInfoType(13L, 6); // 行业
		zcInfos = infoService.getInfoByInfoType(14L, 6); // 政策
		marketInfos = infoService.getInfoByInfoType(15L, 6); // 市场
		productInfos = infoService.getInfoByInfoType(16L, 6); // 产品
		hitInfos = infoService.getHitInfo(8); // 阅读排行

		return SUCCESS;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

	public List<Info> getImgInfos() {
		return imgInfos;
	}

	public List<Info> getTradeInfos() {
		return tradeInfos;
	}

	public List<Info> getProductInfos() {
		return productInfos;
	}

	public List<Info> getZcInfos() {
		return zcInfos;
	}

	public List<Info> getMarketInfos() {
		return marketInfos;
	}

	public List<Info> getHitInfos() {
		return hitInfos;
	}

}
