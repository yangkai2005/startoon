package org.j2eeframework.startoon.web.actions.admin.industry;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Industry;
import org.j2eeframework.startoon.service.IndustryService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class IndustryAction extends ServiceBaseManageAction<Industry,Long>
{
	private static final long serialVersionUID = -5258616072367233145L;
	@Resource
	private IndustryService industryService;
	private Industry industry;
	@Override
	public IGenericService<Industry, Long> getGenericService()
	{
		return industryService;
	}

	public Industry getModel()
	{
		return industry;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			industry = new Industry();
		} else
		{
			industry = industryService.getEntityById(getRequestId());
		}
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

}
