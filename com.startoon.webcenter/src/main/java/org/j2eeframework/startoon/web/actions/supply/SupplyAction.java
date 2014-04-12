package org.j2eeframework.startoon.web.actions.supply;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.j2eeframework.startoon.service.SupplyService;

public class SupplyAction extends ServiceBaseManageAction<Supply, Long> {
	private static final long serialVersionUID = 6863743603931381278L;
	@Resource
	private SupplyService supplyService;
	private Supply supply;
	
	private List<SupplyParam> supplyParams;

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
	
	public String properties() {
		supplyParams = supply.getSupplyParams();
		return "properties";
	}

	public List<SupplyParam> getSupplyParams() {
		return supplyParams;
	}

	public void setSupplyParams(List<SupplyParam> supplyParams) {
		this.supplyParams = supplyParams;
	}

}
