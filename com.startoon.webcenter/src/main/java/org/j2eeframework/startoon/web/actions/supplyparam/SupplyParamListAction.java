package org.j2eeframework.startoon.web.actions.supplyparam;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.entity.SupplyParam;
import org.j2eeframework.startoon.service.AttrTypeService;
import org.j2eeframework.startoon.service.SupplyParamService;

public class SupplyParamListAction extends
		ServiceBasePaginationAction<SupplyParam, Long> {

	private static final long serialVersionUID = 5091722141709043121L;

	@Resource
	private SupplyParamService supplyParamService;
	@Resource
	private AttrTypeService attrTypeService;
	
	private List<AttrType> attrTypes;

	@Override
	public IGenericService<SupplyParam, Long> getGenericService() {
		return supplyParamService;
	}

	@Override
	public void preExecute() {
		attrTypes = attrTypeService.getAttrType();
	}
/*
	@Override
	public String execute() {
		super.execute();
		
		Pager<SupplyParam> pager = getPager();
		
		List<SupplyParam> items = pager.getItems();
		List<Supply> supplies = new ArrayList<Supply>();
		for(SupplyParam sp : items) {
			Supply s = sp.getSupply();
			supplies.add(s);
		}
		
		return SUCCESS;
	}
*/

	public List<AttrType> getAttrTypes() {
		return attrTypes;
	}

	public void setAttrTypes(List<AttrType> attrTypes) {
		this.attrTypes = attrTypes;
	}
}
