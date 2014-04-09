package org.j2eeframework.information.web.actions.information.bar;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 电子吧首页
 * 
 * @author kai
 */
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8192855877605059610L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private InfoTypeService infoTypeService;

	private InfoType infoType;

	private List<Info> hotInfos;

	private List<Info> latestInfos;

	private List<Info> topInfos;
	private List<Info> info38;
	private List<Info> info39;
	private List<Info> info40;
	private List<Info> info41;

	private InfoType infoType38;
	private InfoType infoType39;
	private InfoType infoType40;
	private InfoType infoType41;

	@Override
	public String execute() {
		log.debug(">>>>>店长吧首页...");

		infoType = new InfoType();
		infoType.setId(5L);

		hotInfos = infoService.getHotInfo(10);
		latestInfos = infoService.getLatestInfo(10);

		topInfos = infoService.getTopInfo(6);
		info38 = infoService.getInfoByInfoType(38L, 4);
		info39 = infoService.getInfoByInfoType(39L, 4);
		info40 = infoService.getInfoByInfoType(40L, 4);
		info41 = infoService.getInfoByInfoType(41L, 4);

		infoType38 = infoTypeService.getEntityById(38L);
		infoType39 = infoTypeService.getEntityById(39L);
		infoType40 = infoTypeService.getEntityById(40L);
		infoType41 = infoTypeService.getEntityById(41L);

		return SUCCESS;
	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public List<Info> getLatestInfos() {
		return latestInfos;
	}

	public void setLatestInfos(List<Info> latestInfos) {
		this.latestInfos = latestInfos;
	}

	public List<Info> getInfo38() {
		return info38;
	}

	public void setInfo38(List<Info> info38) {
		this.info38 = info38;
	}

	public List<Info> getInfo39() {
		return info39;
	}

	public void setInfo39(List<Info> info39) {
		this.info39 = info39;
	}

	public List<Info> getInfo40() {
		return info40;
	}

	public void setInfo40(List<Info> info40) {
		this.info40 = info40;
	}

	public List<Info> getInfo41() {
		return info41;
	}

	public void setInfo41(List<Info> info41) {
		this.info41 = info41;
	}

	public List<Info> getTopInfos() {
		return topInfos;
	}

	public void setTopInfos(List<Info> topInfos) {
		this.topInfos = topInfos;
	}

	public InfoType getInfoType38() {
		return infoType38;
	}

	public void setInfoType38(InfoType infoType38) {
		this.infoType38 = infoType38;
	}

	public InfoType getInfoType39() {
		return infoType39;
	}

	public void setInfoType39(InfoType infoType39) {
		this.infoType39 = infoType39;
	}

	public InfoType getInfoType40() {
		return infoType40;
	}

	public void setInfoType40(InfoType infoType40) {
		this.infoType40 = infoType40;
	}

	public InfoType getInfoType41() {
		return infoType41;
	}

	public void setInfoType41(InfoType infoType41) {
		this.infoType41 = infoType41;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}
}
