package org.j2eeframework.information.web.actions.information.analogworld;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1012971452483617324L;
	
	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;
	
	private List<Info> imgInfos; //首页图片框
	
	private List<Info> technologyInfos;

	private List<Info> marketInfos;
	
	private List<Info> productInfos;

	private InfoType infoType;
	
	public String execute() {
		
		log.debug(">>>模拟世界首页...");
		
		infoType = new InfoType();
		infoType.setId(10L);
		
		imgInfos = infoService.getImgInfoByInfoTypeId(35L, 4);
		
		technologyInfos = infoService.getInfoByInfoType(35L, 8);
		marketInfos = infoService.getInfoByInfoType(36L, 8);
		productInfos = infoService.getInfoByInfoType(37L, 10);
		
		return SUCCESS;
	}


	public List<Info> getTechnologyInfos() {
		return technologyInfos;
	}


	public void setTechnologyInfos(List<Info> technologyInfos) {
		this.technologyInfos = technologyInfos;
	}


	public List<Info> getMarketInfos() {
		return marketInfos;
	}


	public void setMarketInfos(List<Info> marketInfos) {
		this.marketInfos = marketInfos;
	}


	public List<Info> getProductInfos() {
		return productInfos;
	}


	public void setProductInfos(List<Info> productInfos) {
		this.productInfos = productInfos;
	}


	public List<Info> getImgInfos() {
		return imgInfos;
	}


	public void setImgInfos(List<Info> imgInfos) {
		this.imgInfos = imgInfos;
	}


	public InfoType getInfoType() {
		return infoType;
	}


	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}


}
