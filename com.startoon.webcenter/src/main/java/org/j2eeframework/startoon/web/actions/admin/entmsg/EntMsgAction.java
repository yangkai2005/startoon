package org.j2eeframework.startoon.web.actions.admin.entmsg;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.service.EntMsgService;

public class EntMsgAction extends ServiceBaseManageAction<EntMsg, Long> {
	private static final long serialVersionUID = -1203480067885169503L;
	@Resource
	private EntMsgService entMsgService;
	private EntMsg entMsg;
	private List<Long> ids;
	private Integer status;

	@Override
	public IGenericService<EntMsg, Long> getGenericService() {
		return entMsgService;
	}

	public EntMsg getModel() {
		return entMsg;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			entMsg = new EntMsg();
		} else {
			entMsg = entMsgService.getEntityById(getRequestId());
		}
	}

	public String check() {

		System.out.println(">>>>>>>>>>>>>>>>>audit");

		for (Long id : ids) {
			EntMsg msg = getGenericService().getEntityById(id);
			msg.setStatus(status);
			entMsgService.update(msg);
		}

		return ResultConstants.LIST;
	}
	
	public String delete() {

		System.out.println(">>>>>>>>>>>>>>>>>delete");

		for (Long id : ids) {
			EntMsg msg = getGenericService().getEntityById(id);
			entMsgService.delete(msg);
		}

		return ResultConstants.LIST;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
