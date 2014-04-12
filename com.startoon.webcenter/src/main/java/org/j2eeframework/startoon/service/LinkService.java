package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.ILinkDAO;
import org.j2eeframework.startoon.entity.Link;
import org.springframework.stereotype.Service;

@Service
public class LinkService extends AbstractService<Link, Long, ILinkDAO> {
	@Resource
	private ILinkDAO linkDAO;

	@Override
	public ILinkDAO getGenericDAO() {
		return linkDAO;
	}

	public List<Link> getLinks(int size) {
		ParamCondition cond = new ParamCondition();
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
	}

	public List<Link> getLinksByType(Long linkTypeId, int size) {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("linkTypeId", linkTypeId + "");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, size);
	}

}
