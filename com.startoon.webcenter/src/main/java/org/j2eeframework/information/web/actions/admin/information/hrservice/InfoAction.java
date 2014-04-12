package org.j2eeframework.information.web.actions.admin.information.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.AdminUser;

public class InfoAction extends ServiceBaseManageAction<Info,Long>
{
	private static final long serialVersionUID = -7077733055748828291L;
	@Resource
	private InfoService infoService;
	private Info info;
	@Override
	public IGenericService<Info, Long> getGenericService()
	{
		return infoService;
	}

	public Info getModel()
	{
		return info;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			info = new Info();
		} else
		{
			info = infoService.getEntityById(getRequestId());
		}
	}
	
	public String insert() {
		
		AdminUser user = SysContext.getCurrentAdminUser();

		info.setCreator(user.getId());
		info.setCreatorName(user.getName());
		info.setCreatorType(Info.CREATOR_TYPE_ADMIN);
		info.setStatus(6);
		
		return super.insert();
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
}
