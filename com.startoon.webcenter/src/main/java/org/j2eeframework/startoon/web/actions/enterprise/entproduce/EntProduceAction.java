package org.j2eeframework.startoon.web.actions.enterprise.entproduce;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.EntProduce;
import org.j2eeframework.startoon.service.EntProduceService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class EntProduceAction extends ServiceBaseManageAction<EntProduce,Long>
{
	private static final long serialVersionUID = -1666164375158725567L;
	@Resource
	private EntProduceService entProduceService;
	private EntProduce entProduce;
	@Override
	public IGenericService<EntProduce, Long> getGenericService()
	{
		return entProduceService;
	}

	public EntProduce getModel()
	{
		return entProduce;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			entProduce = new EntProduce();
		} else
		{
			entProduce = entProduceService.getEntityById(getRequestId());
		}
	}

}
