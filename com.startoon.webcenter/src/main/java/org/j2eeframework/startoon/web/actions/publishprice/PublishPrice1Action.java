package org.j2eeframework.startoon.web.actions.publishprice;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.PublishPrice;
import org.j2eeframework.startoon.service.PublishPriceService;

public class PublishPrice1Action extends ServiceBaseManageAction<PublishPrice,Long>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2509231812400983795L;
	
	@Resource
	private PublishPriceService publishPriceService;
	private PublishPrice publishPrice;

	@Override
	public IGenericService<PublishPrice, Long> getGenericService() {
		return publishPriceService;
	}

	@Override
	public PublishPrice getModel() {
		return publishPrice;
	}

	@Override
	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0)
		{
			publishPrice = new PublishPrice();
		} else
		{
			publishPrice = publishPriceService.getEntityById(getRequestId());
		}
	}

	@Override
	@Action(results = { @Result(name = "success", location = "/enterprise/publishprice/publish-price-list.action", type="redirect")})
	public String delete() {
		super.delete();
		return SUCCESS;
	}


}
