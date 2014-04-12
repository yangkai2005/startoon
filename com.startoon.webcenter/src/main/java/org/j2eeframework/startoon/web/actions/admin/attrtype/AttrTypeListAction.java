package org.j2eeframework.startoon.web.actions.admin.attrtype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.service.AttrTypeService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class AttrTypeListAction extends ServiceBasePaginationAction<AttrType, Long> {

	private static final long serialVersionUID = -4685467712614348937L;

	@Resource
	private AttrTypeService attrTypeService;
	
	@Override
	public IGenericService<AttrType, Long> getGenericService()	{
		return attrTypeService;
	}

	@Override
	public void preExecute() {
		
	}

}
