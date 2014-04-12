package org.j2eeframework.startoon.web.actions.admin.enterprisekeyword;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.EnterpriseKeyword;
import org.j2eeframework.startoon.service.EnterpriseKeywordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class EnterpriseKeywordAction extends ServiceBaseManageAction<EnterpriseKeyword,Long>
{
	private static final long serialVersionUID = -4984178074304585485L;
	@Resource
	private EnterpriseKeywordService enterpriseKeywordService;
	private EnterpriseKeyword enterpriseKeyword;
	@Override
	public IGenericService<EnterpriseKeyword, Long> getGenericService()
	{
		return enterpriseKeywordService;
	}

	public EnterpriseKeyword getModel()
	{
		return enterpriseKeyword;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			enterpriseKeyword = new EnterpriseKeyword();
		} else
		{
			enterpriseKeyword = enterpriseKeywordService.getEntityById(getRequestId());
		}
	}

}
