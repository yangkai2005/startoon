package org.j2eeframework.information.web.actions.information.hightvisit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoImgService;
import org.j2eeframework.information.service.InfoService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long	serialVersionUID		= -9221540974448890243L;

	private static final Log	log						= LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService			infoService;
	@Resource
	private InfoImgService		infoImgService;

	private InfoType			infoType;
	private List<Info>			hotInfos;														// 热点推荐
	private List<Info>			historyInfos			= new ArrayList<Info>();				// 历史访谈回顾
	private List<Info>			currentObserveSubInfos	= new ArrayList<Info>();				// 当前最新访谈
	private Info				currentObserveMainInfo;										// 标题访谈

	@Override
	public String execute() {

		log.debug("高端访谈首页...");

		infoType = new InfoType();
		infoType.setId(4L);

		hotInfos = infoService.getHotInfo(8);

		List<Info> observeInfos = infoService.getInfoByInfoType(InfoType.INFO_TYPE_HIGH_VISITATION, 17);
		if (observeInfos != null) {
			int size = observeInfos.size();
			if (size > 0) {
				currentObserveMainInfo = observeInfos.get(0);
				Long infoId = currentObserveMainInfo.getId();
				List<InfoImg> infoImgs = infoImgService.getInfoImgByInfoId(infoId);
				currentObserveMainInfo.setInfoImgs(infoImgs);

			}

			if (size > 1 && size <= 5)
				currentObserveSubInfos = observeInfos.subList(1, size);
			else if (size > 5) {
				currentObserveSubInfos = observeInfos.subList(1, 5);
				historyInfos = observeInfos.subList(5, size);
			}
		}

		return SUCCESS;
	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public List<Info> getHistoryInfos() {
		return historyInfos;
	}

	public void setHistoryInfos(List<Info> historyInfos) {
		this.historyInfos = historyInfos;
	}

	public List<Info> getCurrentObserveSubInfos() {
		return currentObserveSubInfos;
	}

	public void setCurrentObserveSubInfos(List<Info> currentObserveSubInfos) {
		this.currentObserveSubInfos = currentObserveSubInfos;
	}

	public Info getCurrentObserveMainInfo() {
		return currentObserveMainInfo;
	}

	public void setCurrentObserveMainInfo(Info currentObserveMainInfo) {
		this.currentObserveMainInfo = currentObserveMainInfo;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
