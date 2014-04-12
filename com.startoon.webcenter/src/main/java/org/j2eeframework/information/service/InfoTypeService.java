package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IInfoTypeDAO;
import org.j2eeframework.information.entity.InfoType;
import org.springframework.stereotype.Service;

@Service
public class InfoTypeService extends AbstractService<InfoType, Long, IInfoTypeDAO>
{
	@Resource
	private IInfoTypeDAO infoTypeDAO;

	@Override
	public IInfoTypeDAO getGenericDAO()
	{
		return infoTypeDAO;
	}
	
	
	public List<InfoType> getInfoTypeByFatherId(Long fatherId) {
		return infoTypeDAO.getInfoTypeByFatherId(fatherId);
	}


	public List<InfoType> getInfoTypeByNo(String typeNo) {

		Pager<InfoType> pager = new Pager<InfoType>();
		ParamCondition paramCondition = pager.getParamCondition();
		paramCondition.addParameter("typeNo", typeNo);
		pager.setPageSize(100);
		
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}
}
