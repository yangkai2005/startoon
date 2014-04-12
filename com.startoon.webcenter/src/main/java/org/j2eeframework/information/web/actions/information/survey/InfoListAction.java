package org.j2eeframework.information.web.actions.information.survey;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 4835657078822743871L;

	@Resource
	private InfoService infoService;
	@Resource
	private InfoTypeService infoTypeService;
	
	private InfoType infoType;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
	}

	@Override
	public String execute() {
		
		getPager().setPageSize(23);

		Long infoTypeId = getPager().getParamCondition().getLong("infoTypeId");
		infoType = infoTypeService.getEntityById(infoTypeId);
		
		if(infoType.getId()==22) {
			
			getPager().getParamCondition().remove("infoTypeId");
			
			String[] infoTypeIds = {"42", "43", "44"};
			getPager().getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
		}
		
		super.execute();
		
		if(infoType.getId()==22 || infoType.getInfoType().getId()==22) {
			return "survey";
		}
		
		return SUCCESS;
	}
	
	public InfoType getInfoType() {
		return infoType;
	}

	public void setInfoType(InfoType infoType) {
		this.infoType = infoType;
	}

}
