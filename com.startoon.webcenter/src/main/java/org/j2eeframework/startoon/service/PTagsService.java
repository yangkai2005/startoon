package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IPTagsDAO;
import org.j2eeframework.startoon.entity.PTags;
import org.springframework.stereotype.Service;

@Service
public class PTagsService extends AbstractService<PTags, Long, IPTagsDAO> {

	@Resource
	private IPTagsDAO pTagsDAO;

	@Override
	public IPTagsDAO getGenericDAO() {
		return pTagsDAO;
	}

	public String[] getPassPTagsIds() {
		List<PTags> tags = getPassPTags();
		if (tags != null && !tags.isEmpty()) {
			int size = tags.size();
			String[] ids = new String[size];
			for (int i = 0; i < size; i++) {
				ids[i] = tags.get(i).getId() + "";
			}

			return ids;
		}

		return null;
	}

	public List<PTags> getPassPTags() {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("pass", "true");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 1000);
	}

	public List<PTags> getUnpassPTags() {
		ParamCondition cond = new ParamCondition();
		cond.addParameter("pass", "false");
		return getGenericDAO().getEntitiesByParamCondition(cond, 0, 1000);
	}
}
