package org.j2eeframework.startoon.web.actions.member.askprice;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.AskPrice;
import org.j2eeframework.startoon.service.AskPriceService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class AskPriceAction extends ServiceBaseManageAction<AskPrice,Long>
{
	private static final long serialVersionUID = -3616805208360086355L;
	@Resource
	private AskPriceService askPriceService;
	private AskPrice askPrice;
	@Override
	public IGenericService<AskPrice, Long> getGenericService()
	{
		return askPriceService;
	}

	public AskPrice getModel()
	{
		return askPrice;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			askPrice = new AskPrice();
		} else
		{
			askPrice = askPriceService.getEntityById(getRequestId());
		}
	}

}
