package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Dynamic;
import org.j2eeframework.startoon.service.DynamicService;

public class EntInfoDynamicAction extends ServiceBaseManageAction<Dynamic, Long> {
	private static final long serialVersionUID = 5533230879575309426L;
	@Resource
	private DynamicService dynamicService;
	private Dynamic dynamic;
	private boolean success;

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

	@Override
	public String input() {
		return "input";
	}
	
	@Override
	//@Action(results ={@Result(name="forward", location="/enterprise/entinfo/ent-info-dynamic!input.action?success=${success}", type="redirect")})
	public String insert() {
		dynamic.setAudit(0);
		dynamic.setCreateTime(new Date());
		dynamic.setEnterprise(SysContext.getCurrentEnterpriserUser());
		super.insert();
		success = true;
		return "input";
	}
	/**删除数据
	 * @return
	 */
	 public String delete()
	 {
		 getGenericService().delete(getModel());
		 return  "detele"; 
	 }
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
