package org.j2eeframework.information.web.actions.information.cooperation;

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
	private static final long serialVersionUID = -5066351713495942412L;
	
	private static final Log log = LogFactory.getLog(IndexAction.class);
	
	@Resource
	private InfoService infoService;
	
	private InfoType infoType;
	
	private List<Info> proxyInfos; //代理
	private List<Info> coopInfos;  //合作
	private List<Info> enterInfos; //加密
	private List<Info> chanceInfos;//商机

	private List<Info> recommendInfos; // 阅读推荐
	private List<Info> hotInfos;       // 热点排行
	
	
	
	public String execute() {
		
		log.debug(">>>>> 产业合作首页...");
		
		infoType = new InfoType();
		infoType.setId(9L);
		
		int size = 10;
		proxyInfos = infoService.getInfoByInfoType(31L, size);
		coopInfos = infoService.getInfoByInfoType(32L, size);
		enterInfos = infoService.getInfoByInfoType(33L, size);
		chanceInfos = infoService.getInfoByInfoType(34L, size);
		
		recommendInfos = infoService.getRecommendInfo(8);
		hotInfos = infoService.getHotInfo(8);
		
		return SUCCESS;
		
	}

	public List<Info> getProxyInfos() {
		return proxyInfos;
	}

	public void setProxyInfos(List<Info> proxyInfos) {
		this.proxyInfos = proxyInfos;
	}

	public List<Info> getCoopInfos() {
		return coopInfos;
	}

	public void setCoopInfos(List<Info> coopInfos) {
		this.coopInfos = coopInfos;
	}

	public List<Info> getEnterInfos() {
		return enterInfos;
	}

	public void setEnterInfos(List<Info> enterInfos) {
		this.enterInfos = enterInfos;
	}

	public List<Info> getChanceInfos() {
		return chanceInfos;
	}

	public void setChanceInfos(List<Info> chanceInfos) {
		this.chanceInfos = chanceInfos;
	}

	public List<Info> getRecommendInfos() {
		return recommendInfos;
	}

	public void setRecommendInfos(List<Info> recommendInfos) {
		this.recommendInfos = recommendInfos;
	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
