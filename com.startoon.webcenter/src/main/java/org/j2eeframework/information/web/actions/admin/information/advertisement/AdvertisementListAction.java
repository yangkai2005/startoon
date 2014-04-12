package org.j2eeframework.information.web.actions.admin.information.advertisement;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Advertisement;
import org.j2eeframework.information.service.AdvertisementService;


public class AdvertisementListAction extends ServiceBasePaginationAction<Advertisement, Long> {

	private static final long serialVersionUID = -2246244039270885137L;

	@Resource
	private AdvertisementService advertisementService;
	
	@Override
	public IGenericService<Advertisement, Long> getGenericService()	{
		return advertisementService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(15);
	}

}
