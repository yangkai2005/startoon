package org.j2eeframework.information.web.actions.information.info;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Comments;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

/**
 * 新闻详细
 * 
 * @author kai
 */
public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	
	private static final long serialVersionUID = -6751970563359588062L;
	
	@Resource
	private InfoService infoService;

	private Info info;
	private List<Info> hotInfos;
	private List<Info> recommendInfos;
	private List<Comments> infoComments;

	private Info preInfo;
	private Info nextInfo;

	private boolean flag; // 发表评论的提示标志

	@Override
	public IGenericService<Info, Long> getGenericService() {
		return infoService;
	}

	public Info getModel() {
		return info;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			info = new Info();
		} else {
			info = infoService.getEntityById(getRequestId());
		}
	}

	@Override
	public String show() {

		// 点击数添加1
		int hits = info.getHits() == null ? 0 : info.getHits() + 1;
		info.setHits(hits);
		infoService.update(info);

		preInfo = infoService.getPreInfo(info); // 上一条
		nextInfo = infoService.getNextInfo(info); // 下一条

		return super.show();

	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Info> getHotInfos() {
		return hotInfos;
	}

	public void setHotInfos(List<Info> hotInfos) {
		this.hotInfos = hotInfos;
	}

	public List<Info> getRecommendInfos() {
		return recommendInfos;
	}

	public void setRecommendInfos(List<Info> recommendInfos) {
		this.recommendInfos = recommendInfos;
	}

	public Info getPreInfo() {
		return preInfo;
	}

	public void setPreInfo(Info preInfo) {
		this.preInfo = preInfo;
	}

	public Info getNextInfo() {
		return nextInfo;
	}

	public void setNextInfo(Info nextInfo) {
		this.nextInfo = nextInfo;
	}

	public List<Comments> getInfoComments() {
		return infoComments;
	}

	public void setInfoComments(List<Comments> infoComments) {
		this.infoComments = infoComments;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
