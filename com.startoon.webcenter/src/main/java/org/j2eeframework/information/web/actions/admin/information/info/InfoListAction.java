package org.j2eeframework.information.web.actions.admin.information.info;

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

	private static final long serialVersionUID = -3819423734986407113L;

	@Resource
	private InfoService infoService;
	
	@Resource
	private InfoTypeService infoTypeService;
	
	private Long tid;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
		Pager<Info> pager = getPager();
		String tno = pager.getParamCondition().getParameter("typeNo");
		
		if(tid!=null && tid==3) {
			pager.getParamCondition().remove("infoTypeIds");
			String[] infoTypeIds = {"19", "20", "21"};
			pager.getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
			
		} else if(tno!=null) {
			List<InfoType> infoTypes = infoTypeService.getInfoTypeByNo(tno);
			int size = infoTypes.size();
			String[] infoTypeIds = new String[size];
			int i = 0;
			for(InfoType infoType : infoTypes) {
				infoTypeIds[i] = infoType.getId() + "";
				i++;
			}
			pager.getParamCondition().addParameterValues("infoTypeIds", infoTypeIds);
			
		}
		
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

}
