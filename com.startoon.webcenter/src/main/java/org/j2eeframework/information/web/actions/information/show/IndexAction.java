package org.j2eeframework.information.web.actions.information.show;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.information.entity.Copartnership;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.CopartnershipService;
import org.j2eeframework.information.service.InfoService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 创意Show首页
 * 
 * @author kai
 */
public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4800184269663547273L;

	private static final Log log = LogFactory.getLog(IndexAction.class);

	@Resource
	private InfoService infoService;
	@Resource
	private CopartnershipService copartnershipService;

	private InfoType infoType;

	private List<Info> infos;// 创意资讯
	private List<Info> teamInfos;// 团队作品
	private List<Info> personInfos;// 个人作品
	private List<Info> imgInfos;// 切换图片
	private List<Copartnership> copartnerships;

	@Override
	public String execute() {

		log.debug(">>>创意show主页...");

		infoType = new InfoType();
		infoType.setId(7L);

		copartnerships = copartnershipService.getCopartnershipByPosition(1, 9);// 合作单位

		// 切换图片
		Pager<Info> pager = new Pager<Info>();
		pager.setPageSize(4);
		ParamCondition paramCondition = pager.getParamCondition();
		paramCondition.addParameter("isImgInfo", "true");
		String[] ids = { "7" };
		paramCondition.addParameterValues("infoTypeIds", ids);
		infoService.getEntitiesOfPagerByParamCondition(pager);
		imgInfos = pager.getItems();

		// 创意资讯
		infos = infoService.getInfoByInfoType(InfoType.INFO_TYPE_ORIGINALITY_SHOW, 8);

		// 团队作品
		teamInfos = infoService.getInfoByInfoType(23L, 6);

		// 个人作品
		personInfos = infoService.getInfoByInfoType(24L, 6);

		return SUCCESS;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

	public List<Info> getTeamInfos() {
		return teamInfos;
	}

	public void setTeamInfos(List<Info> teamInfos) {
		this.teamInfos = teamInfos;
	}

	public List<Info> getPersonInfos() {
		return personInfos;
	}

	public void setPersonInfos(List<Info> personInfos) {
		this.personInfos = personInfos;
	}

	public List<Info> getImgInfos() {
		return imgInfos;
	}

	public void setImgInfos(List<Info> imgInfos) {
		this.imgInfos = imgInfos;
	}

	public List<Copartnership> getCopartnerships() {
		return copartnerships;
	}

	public void setCopartnerships(List<Copartnership> copartnerships) {
		this.copartnerships = copartnerships;
	}

	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
