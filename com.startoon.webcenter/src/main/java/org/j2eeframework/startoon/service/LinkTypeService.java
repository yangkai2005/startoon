package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ILinkTypeDAO;
import org.j2eeframework.startoon.entity.LinkType;
import org.springframework.stereotype.Service;

@Service
public class LinkTypeService extends AbstractService<LinkType, Long, ILinkTypeDAO> {
	@Resource
	private ILinkTypeDAO linkTypeDAO;

	@Override
	public ILinkTypeDAO getGenericDAO() {
		return linkTypeDAO;
	}

	public List<LinkType> getChildren(Long pid) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("pid", pid + "");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 1000);
	}

	public List<LinkType> getLinkTypeByLvl(int lvl) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("lvl", lvl + "");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 1000);
	}

	public List<LinkType> getSortedLinkType() {
		return getGenericDAO().getEntitiesByParamCondition(new ParamCondition(), 0, 1000);
	}

}
