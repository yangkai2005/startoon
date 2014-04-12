package org.j2eeframework.startoon.web.actions.admin.supply;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.PTags;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;
import org.j2eeframework.startoon.util.Struts2Utils;

public class SupplyAction extends ServiceBaseManageAction<Supply, Long> {
	private static final long serialVersionUID = -5467387871868822707L;
	@Resource
	private SupplyService supplyService;

	private Supply supply;
	private Integer status;
	private List<Long> ids;
	private String auditDesc;

	@Override
	public IGenericService<Supply, Long> getGenericService() {
		return supplyService;
	}

	public Supply getModel() {
		return supply;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			supply = new Supply();
		} else {
			supply = supplyService.getEntityById(getRequestId());
		}
	}

	public String audit() {
		supply.setStatus(status);
		supplyService.update(supply);
		return ResultConstants.LIST;
	}

	public String auditAll() {
		for (Long id : ids) {
			Supply s = supplyService.getEntityById(id);
			s.setStatus(status);
			s.setAuditDesc(auditDesc);
			supplyService.update(s);
		}
		return ResultConstants.LIST;
	}

	public String setTag() {
		String tagId = Struts2Utils.getParameter("tagId");
		for (Long id : ids) {
			Supply s = supplyService.getEntityById(id);
			PTags tag = new PTags();
			tag.setId(new Long(tagId));
			s.setPtags(tag);

			supplyService.update(s);
		}
		return ResultConstants.LIST;
	}

	public Supply getSupply() {
		return supply;
	}

	public void setSupply(Supply supply) {
		this.supply = supply;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

}
