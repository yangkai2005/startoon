package org.j2eeframework.startoon.web.actions.admin.attrtype;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.AttrType;
import org.j2eeframework.startoon.service.AttrTypeService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class AttrTypeAction extends ServiceBaseManageAction<AttrType,Long>
{
	private static final long serialVersionUID = 8171871970787403095L;
	@Resource
	private AttrTypeService attrTypeService;
	private AttrType attrType;
	@Override
	public IGenericService<AttrType, Long> getGenericService()
	{
		return attrTypeService;
	}

	public AttrType getModel()
	{
		return attrType;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			attrType = new AttrType();
		} else
		{
			attrType = attrTypeService.getEntityById(getRequestId());
		}
	}

}
