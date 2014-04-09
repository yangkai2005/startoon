package org.j2eeframework.information.web.actions.admin.information.talent;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Talent;
import org.j2eeframework.information.service.TalentService;


public class TalentListAction extends ServiceBasePaginationAction<Talent, Long> {

	private static final long serialVersionUID = 8821138268809292851L;

	@Resource
	private TalentService talentService;
	
	@Override
	public IGenericService<Talent, Long> getGenericService()	{
		return talentService;
	}

	@Override
	public void preExecute() {
		
	}

}
