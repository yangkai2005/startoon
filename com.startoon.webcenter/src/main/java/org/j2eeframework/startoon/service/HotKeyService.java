package org.j2eeframework.startoon.service;

import java.util.List;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.impl.AbstractService;
import org.j2eeframework.startoon.dao.IHotKeyDAO;
import org.j2eeframework.startoon.entity.HotKey;
import org.springframework.stereotype.Service;

@Service
public class HotKeyService extends AbstractService<HotKey, Long, IHotKeyDAO> {
	@Resource
	private IHotKeyDAO hotKeyDAO;

	@Override
	public IHotKeyDAO getGenericDAO() {
		return hotKeyDAO;
	}

	public List<HotKey> getHotKey(int size) {
		return getHotKey(size, 0);
	}

	public List<HotKey> getHotKey(int size, int status) {

		ParamCondition cond = new ParamCondition();
		cond.addParameter("status", status + "");
		List<HotKey> hotKeys = getGenericDAO().getEntitiesByParamCondition(cond, 0, size);

		return hotKeys;

	}
}
