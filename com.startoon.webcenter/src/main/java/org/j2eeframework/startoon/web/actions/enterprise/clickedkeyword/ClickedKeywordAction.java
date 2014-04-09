package org.j2eeframework.startoon.web.actions.enterprise.clickedkeyword;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.ClickedKeyword;
import org.j2eeframework.startoon.service.ClickedKeywordService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class ClickedKeywordAction extends ServiceBaseManageAction<ClickedKeyword,Long>
{
	private static final long serialVersionUID = 4146075511775457934L;
	@Resource
	private ClickedKeywordService clickedKeywordService;
	private ClickedKeyword clickedKeyword;
	@Override
	public IGenericService<ClickedKeyword, Long> getGenericService()
	{
		return clickedKeywordService;
	}

	public ClickedKeyword getModel()
	{
		return clickedKeyword;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			clickedKeyword = new ClickedKeyword();
		} else
		{
			clickedKeyword = clickedKeywordService.getEntityById(getRequestId());
		}
	}

}
