package org.j2eeframework.information.web.actions.admin.information.showaudit;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;

public class InfoAction extends ServiceBaseManageAction<Info, Long> {
	
	private static final long serialVersionUID = 4177403642298787216L;
	@Resource
	private InfoService infoService;
	private Info info;

	private List<Long> ids;
	
	private int status;

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

	public String audit() {

		for (Long id : ids) {
			Info info = infoService.getEntityById(id);
			info.setStatus(status);
			infoService.update(info);
		}

		return ResultConstants.LIST;

	}
	
	public String deleteAll() {
		for (Long id : ids) {
			infoService.deleteEntityById(id);
		}

		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
