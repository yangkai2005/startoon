package org.j2eeframework.information.web.actions.admin.information.infoimg;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.InfoImg;
import org.j2eeframework.information.service.InfoImgService;


public class InfoImgListAction extends ServiceBasePaginationAction<InfoImg, Long> {

	private static final long serialVersionUID = 2821951224391042566L;

	@Resource
	private InfoImgService infoImgService;
	
	@Override
	public IGenericService<InfoImg, Long> getGenericService()	{
		return infoImgService;
	}

	@Override
	public void preExecute() {
		
	}

}
