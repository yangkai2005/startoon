package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.Pager;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.ICopartnershipDAO;
import org.j2eeframework.information.entity.Copartnership;
import org.springframework.stereotype.Service;

@Service
public class CopartnershipService extends AbstractService<Copartnership, Long, ICopartnershipDAO> {
	@Resource
	private ICopartnershipDAO copartnershipDAO;

	@Override
	public ICopartnershipDAO getGenericDAO() {
		return copartnershipDAO;
	}

	public List<Copartnership> getCopartnership(int size) {
		Pager<Copartnership> pager = new Pager<Copartnership>();
		pager.setPageSize(size);
		getEntitiesOfPagerByParamCondition(pager);
		return pager.getItems();
	}

	public List<Copartnership> getCopartnershipByPosition(int position, int size) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("position", position + "");
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

	public List<Copartnership> getCopartnershipByInfoTypeId(Long infoTypeId, int size) {
		ParamCondition condition = new ParamCondition();
		condition.addParameter("infoTypeId", infoTypeId + "");
		return getGenericDAO().getEntitiesByParamCondition(condition, 0, size);
	}

}
