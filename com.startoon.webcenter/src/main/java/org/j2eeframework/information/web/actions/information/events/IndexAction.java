package org.j2eeframework.information.web.actions.information.events;

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
	
	private InfoType infoType;
	
	private List<Info> imgReportInfos; //报道
	private List<Info> reportInfos; //报道
	private List<Info> imgInfos;    //图集
	private List<Info> innerInfos;  //国内预告
	private List<Info> outerInfos;  //国外预告
	
	
	private Info previewInfo;
	
	private Info surveyInfo;
	
	
	public String execute() {
		log.debug(">>>展会活动首页...");
		
		infoType = new InfoType();
		infoType.setId(8L);
		
		imgReportInfos = infoService.getImgInfoByInfoTypeId(27L, 4);
		reportInfos = infoService.getInfoByInfoType(27L, 8);
		outerInfos = infoService.getInfoByInfoType(29L, 10);
		imgInfos = infoService.getInfoByInfoType(30L, 14);
		List<Info> items = infoService.getInfoByInfoType(28L, 7);
		
		surveyInfo = infoService.getLatestSurveyInfo(44L);
		
		if(items!=null && items.size()>1) {
			previewInfo = items.get(0);
			innerInfos = items.subList(1, items.size());
		}
		
		return SUCCESS;
	}


	public List<Info> getReportInfos() {
		return reportInfos;
	}


	public void setReportInfos(List<Info> reportInfos) {
		this.reportInfos = reportInfos;
	}


	public List<Info> getImgInfos() {
		return imgInfos;
	}


	public void setImgInfos(List<Info> imgInfos) {
		this.imgInfos = imgInfos;
	}


	public List<Info> getInnerInfos() {
		return innerInfos;
	}


	public void setInnerInfos(List<Info> innerInfos) {
		this.innerInfos = innerInfos;
	}


	public List<Info> getOuterInfos() {
		return outerInfos;
	}


	public void setOuterInfos(List<Info> outerInfos) {
		this.outerInfos = outerInfos;
	}


	public Info getPreviewInfo() {
		return previewInfo;
	}


	public void setPreviewInfo(Info previewInfo) {
		this.previewInfo = previewInfo;
	}


	public Info getSurveyInfo() {
		return surveyInfo;
	}


	public void setSurveyInfo(Info surveyInfo) {
		this.surveyInfo = surveyInfo;
	}


	public List<Info> getImgReportInfos() {
		return imgReportInfos;
	}


	public void setImgReportInfos(List<Info> imgReportInfos) {
		this.imgReportInfos = imgReportInfos;
	}


	public InfoType getInfoType() {
		return infoType;
	}


	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}
}
