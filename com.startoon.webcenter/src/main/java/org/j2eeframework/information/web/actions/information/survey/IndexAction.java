package org.j2eeframework.information.web.actions.information.survey;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author kai
 */
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4302003457943733821L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;

	private InfoType infoType;
	private List<Info> info19; // 编辑推荐
	private List<Info> info20; // 人气排行
	private List<Info> info21; // 行情综述
	private List<Info> info42; // 市场调查
	private List<Info> info43; // 产品调查
	private List<Info> info44; // 展会调查

	private Info info21First;

	private List<Info> imgInfo21; // 配图

	private Info info;// 最新调查

	@Override
	public String execute() {

		log.debug(">>>行情调查主页...");

		infoType = new InfoType();
		infoType.setId(3L);

		info = infoService.getLatestSurveyInfo();

		info19 = infoService.getInfoByInfoType(19L, 2);
		info20 = infoService.getInfoByInfoType(20L, 10);
		info21 = infoService.getInfoByInfoType(21L, 5);
		if (info21 != null && info21.size() > 1) {
			info21First = info21.get(0);
			info21 = info21.subList(1, info21.size());
		}

		imgInfo21 = infoService.getImgInfoByInfoTypeId(21L, 4);

		info42 = infoService.getInfoByInfoType(42L, 10);
		info43 = infoService.getInfoByInfoType(43L, 10);
		info44 = infoService.getInfoByInfoType(44L, 10);

		return SUCCESS;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
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

	public Info getInfo21First() {
		return info21First;
	}

	public void setInfo21First(Info info21First) {
		this.info21First = info21First;
	}

	public List<Info> getInfo42() {
		return info42;
	}

	public void setInfo42(List<Info> info42) {
		this.info42 = info42;
	}

	public List<Info> getInfo43() {
		return info43;
	}

	public void setInfo43(List<Info> info43) {
		this.info43 = info43;
	}

	public List<Info> getInfo44() {
		return info44;
	}

	public void setInfo44(List<Info> info44) {
		this.info44 = info44;
	}

	public List<Info> getImgInfo21() {
		return imgInfo21;
	}

	public void setImgInfo21(List<Info> imgInfo21) {
		this.imgInfo21 = imgInfo21;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
