package org.j2eeframework.information.web.actions.admin.information.survey;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.entity.InfoType;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.information.service.InfoTypeService;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -880301781765366209L;

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
		Pager<Info> pager = getPager();
		String tno = "000204";
		
//		String tid = pager.getParamCondition().getParameter("tid");
//		
//		if("49".equals(tid)) { //展会调查
//			pager.getParamCondition().addParameter("infoTypeId", "49");
//			
//		} else 
		
		if(tno!=null) {
			List<InfoType> infoTypes = infoTypeService.getInfoTypeByNo(tno);
			int size = infoTypes.size();
			String[] infoTypeIds = new String[size];
			int i = 0;
			for(InfoType infoType : infoTypes) {
				infoTypeIds[i] = infoType.getId() + "";
				i++;
			}
			pager.getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
			pager.getParamCondition().addParameter("status", "-1");
		}
	}

}
