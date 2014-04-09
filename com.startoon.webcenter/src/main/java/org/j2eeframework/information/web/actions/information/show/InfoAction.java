package org.j2eeframework.information.web.actions.information.show;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

/**
 * 创意SHOW详细
 * 
 * @author kai
 */
public class InfoAction extends ServiceBaseManageAction<Info, Long> {

	private static final long serialVersionUID = 3645030264704469368L;
	@Resource
	private InfoService infoService;
	private Info info;

	private List<Info> infos;

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
		Long id = getRequestId();
		info = infoService.getInfoWithImages(id);

		// 查询相同类别的另外10条数据
		Pager<Info> pager = new Pager<Info>();
		pager.getParamCondition().addParameter("infoTypeId", info.getInfoType().getId() + "");
		pager.setPageSize(10);
		infoService.getEntitiesOfPagerByParamCondition(pager);
		infos = pager.getItems();

		return ResultConstants.SHOW;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

}
