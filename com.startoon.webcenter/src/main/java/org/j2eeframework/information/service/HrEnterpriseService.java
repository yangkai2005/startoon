package org.j2eeframework.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.information.dao.IHrEnterpriseDAO;
import org.j2eeframework.information.entity.HrEnterprise;
import org.springframework.stereotype.Service;

@Service
public class HrEnterpriseService extends AbstractService<HrEnterprise, Long, IHrEnterpriseDAO> {
	@Resource
	private IHrEnterpriseDAO hrEnterpriseDAO;

	@Override
	public IHrEnterpriseDAO getGenericDAO() {
		return hrEnterpriseDAO;
	}

	public List<HrEnterprise> getHrEnterpriseBySize(int size) {

		ParamCondition condition = new ParamCondition();
		condition.addParameter("type", "0");

		return hrEnterpriseDAO.getEntitiesByParamCondition(condition, 0, size);

	}
}
