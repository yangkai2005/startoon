package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import java.util.Date;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.ResultConstants;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.startoon.service.CropService;

public class EntInfoCropAction extends ServiceBaseManageAction<Crop, Long> {
	private static final long serialVersionUID = 5533230879575309426L;
	@Resource
	private CropService cropService;
	private Crop crop;
	private boolean success;

	@Override
	public IGenericService<Crop, Long> getGenericService() {
		return cropService;
	}

	public Crop getModel() {
		return crop;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			crop = new Crop();
		} else {
			crop = cropService.getEntityById(getRequestId());
		}
	}

	@Override
	public String input() {
		return "input";
	}
	
	@Override
	//@Action(results ={@Result(name="forward", location="/enterprise/entinfo/ent-info-crop!input.action?success=${success}", type="redirect")})
	public String insert() {
		crop.setAudit(0);
		crop.setCreateTime(new Date());
		crop.setEnterprise(SysContext.getCurrentEnterpriserUser());
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
