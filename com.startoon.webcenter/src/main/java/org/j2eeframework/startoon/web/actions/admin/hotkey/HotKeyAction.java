package org.j2eeframework.startoon.web.actions.admin.hotkey;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.HotKey;
import org.j2eeframework.startoon.service.HotKeyService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class HotKeyAction extends ServiceBaseManageAction<HotKey,Long>
{
	private static final long serialVersionUID = -7705977855956142277L;
	@Resource
	private HotKeyService hotKeyService;
	private HotKey hotKey;
	@Override
	public IGenericService<HotKey, Long> getGenericService()
	{
		return hotKeyService;
	}

	public HotKey getModel()
	{
		return hotKey;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			hotKey = new HotKey();
		} else
		{
			hotKey = hotKeyService.getEntityById(getRequestId());
		}
	}

}
