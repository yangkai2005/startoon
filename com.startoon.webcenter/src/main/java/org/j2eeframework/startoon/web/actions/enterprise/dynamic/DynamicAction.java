package org.j2eeframework.startoon.web.actions.enterprise.dynamic;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Dynamic;
import org.j2eeframework.startoon.service.DynamicService;

public class DynamicAction extends ServiceBaseManageAction<Dynamic, Long> {
	private static final long serialVersionUID = 8900141454299341331L;
	@Resource
	private DynamicService dynamicService;
	private Dynamic dynamic;
	private boolean flag;
	private List<Long> ids;

	@Override
	public IGenericService<Dynamic, Long> getGenericService() {
		return dynamicService;
	}

	public Dynamic getModel() {
		return dynamic;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			dynamic = new Dynamic();
		} else {
			dynamic = dynamicService.getEntityById(getRequestId());
		}
	}

	public String insert() {

		dynamic.setEnterprise(SysContext.getCurrentEnterpriserUser());

		super.insert();

		return ResultConstants.LIST;
	}
	
	public String deleteAll() {
		
		if(ids!=null && !ids.isEmpty()) {
			for(Long id : ids) {
				dynamicService.deleteEntityById(id);
			}
		}
		
		return ResultConstants.LIST;
	}

	public Dynamic getDynamic() {
		return dynamic;
	}

	public void setDynamic(Dynamic dynamic) {
		this.dynamic = dynamic;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
