package org.j2eeframework.startoon.web.actions.enterprise.cooperation;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	private static final long serialVersionUID = 5114518675611020038L;
	@Resource
	private InfoService infoService;
	private Info info;
	
	private List<Long> ids;

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
	public String insert() {

		Long eid = SysContext.getCurrentEnterpriserUser().getId();

		info.setCreator(eid);
		info.setCreatorType(Info.CREATOR_TYPE_ENTERPRISE);
		info.setStatus(Info.STATUS_UNAUDIT);

		super.insert();

		return ResultConstants.LIST;
		
	}
	
	public String deleteAll() {
		
		Long creatorId = SysContext.getCurrentEnterpriserUser().getId();
		
		if(ids!=null && !ids.isEmpty()) {
			for(Long id : ids) {
				infoService.deleteById(id, creatorId);
			}
		}
		
		return ResultConstants.LIST;
	}
	
	@Override
	public String update() {
		super.update();
		return ResultConstants.LIST;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
