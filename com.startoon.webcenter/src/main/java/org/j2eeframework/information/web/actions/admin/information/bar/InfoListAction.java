package org.j2eeframework.information.web.actions.admin.information.bar;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -3440596706281808495L;

	@Resource
	private InfoService infoService;
	
	@Resource
	private InfoTypeService infoTypeService;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
		List<InfoType> infoTypes = infoTypeService.getInfoTypeByFatherId(5L);
		
		String[] infoTypeIds = new String[infoTypes.size()];
		int i = 0;
		for(InfoType it : infoTypes) {
			Long id = it.getId();
			infoTypeIds[i++] = id + "";
		}
		
		
		getPager().getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
	}

}
