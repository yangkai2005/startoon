package org.j2eeframework.startoon.web.actions.enterprise.entinfo;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.startoon.service.CropService;

public class EntCropListAction extends ServiceBasePaginationAction<Crop, Long> {

	private static final long serialVersionUID = 328796864663716318L;

	@Resource
	private CropService cropService;

	@Override
	public IGenericService<Crop, Long> getGenericService() {
		return cropService;
	}

	@Override
	public void preExecute() {
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", enterpriseId + "");
	}
	 
}
